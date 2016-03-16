<g:each in="${roomGroups}" var="group">
    %{--<div class="row">--}%
        <br/>
    <div class="col-md-12 panel panel-info nopadding">
        <div class="panel-heading">Options for group</div>
        <div class="panel-body">
            <div class="panel panel-info nopadding">
                <div class="panel-heading">Recommended all-time available</div>
                <div class="panel-body pre-scrollable nopadding">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            %{--<th><span class="glyphicon glyphicon-stats"></span></th>--}%
                            <th>Hotel</th>
                            <th>Room type</th>
                            <th>Board type</th>
                            <th>Price</th>
                            <th>Available now</th>
                            <th>Available most of the time</th>
                            %{--<th>Availability</th>--}%
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${group.groups4Option[0].roomTypes}" var="room">
                            <tr>
                                %{--<td>${room.rating}</td>--}%
                                <td>${room.hotelName}</td>
                                <td>${room.roomName}</td>
                                <td>${room.boardName}</td>
                                <td>${room.roomPrice}</td>
                                <td>${room.minFullAvailable}</td>
                                <td>${room.maxFullAvailable}</td>
                                %{--<td>${room.roo}</td>--}%
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
            <br/>
            <div class="panel panel-info nopadding">
                <div class="panel-heading">Recommended most of time available</div>
                <div class="panel-body pre-scrollable nopadding">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            %{--<th><span class="glyphicon glyphicon-stats"></span></th>--}%
                            <th>Hotel</th>
                            <th>Room type</th>
                            <th>Board type</th>
                            <th>Price</th>
                            <th>Available now</th>
                            <th>Available most of the time</th>
                            %{--<th>Availability</th>--}%
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${group.groups4Option[0].roomTypes}" var="room">
                            <tr>
                                %{--<td>${room.rating}</td>--}%
                                <td>Pervomayskay</td>
                                <td>Standard</td>
                                <td>ROOM ONLY</td>
                                <td>${room.roomPrice + 324}</td>
                                <td>${room.minFullAvailable}</td>
                                <td>${room.maxFullAvailable}</td>
                                %{--<td>${room.roo}</td>--}%
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
            <br/>
            <div class="panel panel-info nopadding">
                <div class="panel-heading">All options</div>
                <div class="panel-body pre-scrollable nopadding">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            %{--<th><span class="glyphicon glyphicon-stats"></span></th>--}%
                            <th>Hotel</th>
                            <th>Room type</th>
                            <th>Board type</th>
                            <th>Price</th>
                            <th>Available now</th>
                            <th>Available most of the time</th>
                            %{--<th>Availability</th>--}%
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${group.groups4Option[2].roomTypes}" var="room">
                            <tr>
                                %{--<td>${room.rating}</td>--}%
                                <td>${room.hotelName}</td>
                                <td>${room.roomName}</td>
                                <td>${room.boardName}</td>
                                <td>${room.roomPrice}</td>
                                <td>${room.minFullAvailable}</td>
                                <td>${room.maxFullAvailable}</td>
                                %{--<td>${room.roo}</td>--}%
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</g:each>