function initMap() {
    debugger;
    var currLocation; //= new google.maps.LatLng(position.coords.latitude,position.coords.longitude);

    if(navigator.geolocation) {
        var browserSupportFlag = true;
        navigator.geolocation.getCurrentPosition(function(position) {
            currLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
            map = new google.maps.Map(document.getElementById('map'), {
                center: currLocation,
                zoom: 15
            });
        }, function() {
            //handleNoGeolocation(browserSupportFlag);
        });
    }
}

function callback(results, status) {
    debugger;
    if (status == google.maps.places.PlacesServiceStatus.OK) {
        for (var i = 0; i < results.length; i++) {
            var place = results[i];
            addMarker(results[i]);
        }
    }
}

function addMarker(place) {
    debugger;
    var marker = new google.maps.Marker({
        map: map,
        position: place.geometry.location,
        place : place
        //icon: {
        //    url: 'http://maps.gstatic.com/mapfiles/circle.png',
        //    anchor: new google.maps.Point(10, 10),
        //    scaledSize: new google.maps.Size(10, 17)
        //}
    });

    //var initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);

    google.maps.event.addListener(marker, 'click', function() {
        service.getDetails(place, function(result, status) {
            if (status !== google.maps.places.PlacesServiceStatus.OK) {
                console.error(status);
                return;
            }
            infoWindow.setContent(result.name);
            infoWindow.open(map, marker);
        });
    });
    map.setCenter(place.geometry.location);
}