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
    <style type="text/css">
        body {
            padding-top: 50px;
        }
        #map {
            height: 500px;
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
                <a class="navbar-brand" href="#">Project name</a>
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

        <div class="row">
            <div class="col-lg-12">
                <h2>Hotel booking lookup</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form" title="Lookup form">
                    <div class="form-group">
                        <label for="hotelLookup" class="col-sm-2 control-label">City</label>
                        <div class="col-sm-10">
                            <input id="hotelLookup" type="search" class="form-control" placeholder="search for a place..." value="${booking.city}" onchange="doSearch()" />
                        </div>
                    </div>
                </form>
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

    %{--<link rel="javascript" href="${resource(dir: 'js', file: 'map.js')}" type="text/javascript">--}%
    %{--<link rel="javascript" href="${resource(dir: 'js', file: 'jquery.js')}" type="text/javascript">--}%
    <link rel="javascript" href="${resource(dir: 'js', file: 'bootstrap.min.js')}" type="text/javascript">
    <script type="text/javascript">
        function doSearch() {
            debugger;
            var searchStr = $("#hotelLookup").val();
            if (searchStr != null && searchStr != "") {
                initMap(searchStr);
            }
        }
    </script>
</body>
</html>