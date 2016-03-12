<%--
  Created by IntelliJ IDEA.
  User: NS
  Date: 07/03/16
  Time: 20:26
--%>

<%@ page import="hackathonhotelbooking.BookingLookUp" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Booking lookup</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
    <g:javascript library="jquery" />
    <style type="text/css">
        body {
            padding-top: 50px;
        }
        #map {
            height: 500px;
        }
        .hidden {
            display: none;
            /*visibility: hidden;*/
        }
    </style>
</head>

<body>
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Booking for groups</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
    <div class="container">
<br/>
        %{--<div class="row">--}%
            %{--<div class="col-lg-12">--}%
                %{--<h2>Hotel booking lookup</h2>--}%
            %{--</div>--}%
        %{--</div>--}%
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form" title="Location lookup form" action="#">
                    <div id="locationLat" class="hidden"></div>
                    <div id="locationLng" class="hidden"></div>
                    <legend>Location</legend>
                    <div class="form-group">
                        <label for="cityLookup" class="col-sm-5 control-label">City/Country</label>
                        <div class="col-sm-7">
                            <input id="cityLookup" type="text" class="form-control" placeholder="search for a city..."
                                   value="${booking.city}" onchange="doCitySearch()"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="locationLookup" class="col-sm-5 control-label">Location</label>
                        <div class="col-sm-7">
                            <input id="locationLookup" type="text" class="form-control" placeholder="search for a place..."
                                   value="${booking.location}" onchange="doSearch()"/>
                        </div>
                    </div>
                </form>

                <form class="form-horizontal" role="form" title="Search criteria form" id="criteriaForm">
                    <div class="form-group">
                        <label for="lookupRadius" class="col-sm-5 control-label">Radius</label>
                        <div class="col-sm-7">
                            <div class="input-group">
                                %{--<input type="text" class="form-control">--}%
                                <input id="lookupRadius" type="text" class="form-control"
                                       placeholder="search for a place..." value="${booking.radius}"/>
                                <span class="input-group-addon">km</span>
                            </div>
                        </div>
                    </div>
                    <legend>Full-time accommodation</legend>
                    <div class="form-group">
                        <label class="col-sm-5 control-label" for="ftCheckIn">Check in</label>
                        <div class="col-sm-7">
                            <input id="ftCheckIn" type="date" class="form-control" value="${booking.fulltimeCheckIn}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-5 control-label" for="ftCheckOut">Check out</label>
                        <div class="col-sm-7">
                            <input id="ftCheckOut" type="date" class="form-control" value="${booking.fulltimeCheckOut}">
                        </div>
                    </div>
                    <button type="button" class="btn btn-default" onclick="addGroup()">Add group</button>
                    <g:each in="${booking.groupSettings}" var="setting">
                        <div class="hidden" id="groupsettings${setting.innerId}">
                            <legend>Group ${setting.innerId} settings</legend>
                            <div class="form-group">
                                <label for="groupSize${setting.innerId}" class="col-md-5 control-label">Group size</label>
                                <div class="col-md-7">
                                    <input class="form-control" id="groupSize${setting.innerId}" type="number" value="${setting.groupSize}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="accommodationType${setting.innerId}" class="col-md-5 control-label">AccommodationType</label>
                                <div class="col-md-7">
                                    <select class="form-control" id="accommodationType${setting.innerId}" value="${setting.accommodationType}">
                                        <option>Single</option>
                                        <option>Family</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="accommodationSize${setting.innerId}" class="col-md-5 control-label">Accommodation/Children</label>
                                <div class="col-md-7">
                                    <input class="form-control" id="accommodationSize${setting.innerId}" type="number" value="${setting.accommodationSize}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="stars${setting.innerId}" class="col-md-5 control-label">Hotel, stars</label>
                                <div class="col-md-7">
                                    <input class="form-control" id="stars${setting.innerId}" type="number" value="${setting.stars}">
                                </div>
                            </div>
                        </div>
                    </g:each>

                    <legend>Part-time accommodation</legend>
                    <div class="form-group">
                        <label class="col-sm-5 control-label" for="executivesCount">Executive members</label>
                        <div class="col-sm-7">
                            <input id="executivesCount" type="number" class="form-control" value="${booking.vipSuitNumber}">
                        </div>
                    </div>
                </form>
                <button class="button button-default" onclick="roomsSearch(); return false;">Search</button>
            </div>
            <div class="col-md-6">
                <div id="map"></div>
            </div>
        </div>

    </div><!-- /.container -->
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbBdqhK286kQ6l1W5C28tqF2n8LcNqAAI&libraries=places&callback=initMap">
    </script>
    <script src="/static/js/map.js" type="text/javascript"></script>
    <script src="/static/js/jquery.js" type="text/javascript"></script>
    <link rel="javascript" href="${resource(dir: 'js', file: 'bootstrap.min.js')}" type="text/javascript">
    <script type="text/javascript">
        var visibleGroups = 0;

        function doSearch() {
            debugger;

            setMapOnAll(null);
            var searchStr = $("#locationLookup").val();
            if (searchStr != null && searchStr != "") {

                var currLocation = map.getCenter();

                var request = {
                    location: currLocation,
                    radius: '50',
                    units : 'km',
                    query: searchStr
                };

                service = new google.maps.places.PlacesService(map);
                service.textSearch(request, callback);
            }
        }

        function doCitySearch() {
            setMapOnAll(null);
            var searchStr = $("#cityLookup").val();
            if (searchStr != null && searchStr != "") {

//                var currLocation = map.getCenter();

                var request = {
                    query: searchStr
                };

                service = new google.maps.places.PlacesService(map);
                service.textSearch(request, callback);
            }
        }


        function addGroup(){
            if (visibleGroups < 5) visibleGroups++;
            $("#groupsettings"+visibleGroups).removeClass("hidden");
        }

        function roomsSearch(){
            params = {
                lattitude : $('#locationLat').text(),
                longitude : $('#locationLng').text(),
                checkin : $('#ftCheckIn').val(),
                checkout : $('#ftCheckOut').val(),
                radius : $('#lookupRadius').val(),
                groups : {
                    group1 : {
                        size : $('#groupSize1').val(),
                        type : $('#accommodationType1').val(),
                        accSize : $('#accommodationSize1').val(),
                        stars : $('#stars1').val()
                    },
                    group2 : {
                        size : $('#groupSize2').val(),
                        type : $('#accommodationType2').val(),
                        accSize : $('#accommodationSize2').val(),
                        stars : $('#stars2').val()
                    },
                    group3 : {
                        size : $('#groupSize3').val(),
                        type : $('#accommodationType3').val(),
                        accSize : $('#accommodationSize3').val(),
                        stars : $('#stars3').val()
                    },
                    group4 : {
                        size : $('#groupSize4').val(),
                        type : $('#accommodationType4').val(),
                        accSize : $('#accommodationSize4').val(),
                        stars : $('#stars4').val()
                    },
                    group5 : {
                        size : $('#groupSize5').val(),
                        type : $('#accommodationType5').val(),
                        accSize : $('#accommodationSize5').val(),
                        stars : $('#stars5').val()
                    }
                }
            }


            $.ajax({
                url : '/restClient/sendHotelsLook',
                data : {params : JSON.stringify(params)}
            })

        }

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
            $('#locationLng').text = place.geometry.location.lng();
            $('#locationLat').text = place.geometry.location.lat();
        }

        // Sets the map on all markers in the array.
        function setMapOnAll(map) {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(map);
            }
        }
    </script>
</body>
</html>