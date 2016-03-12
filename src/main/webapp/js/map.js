var map;
var markers = [];

function initMap() {
    debugger;
    var currLocation; //= new google.maps.LatLng(position.coords.latitude,position.coords.longitude);

    if(navigator.geolocation) {
        var browserSupportFlag = true;
        navigator.geolocation.getCurrentPosition(function(position) {
            currLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
            map = new google.maps.Map(document.getElementById('map'), {
                center: currLocation,
                zoom: 10
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
    });

    markers.push(marker);

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
    map.setZoom(15);
}

// Sets the map on all markers in the array.
function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}