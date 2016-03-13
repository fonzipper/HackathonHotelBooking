<g:each in="${roomGroups}" var="group">
    %{--<div class="row">--}%
        <br/>
        <div class="col-md-12 panel panel-default nopadding">
            <div class="panel-heading">Options for group 1</div>
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
                        <th>Mostly available</th>
                        %{--<th>Availability</th>--}%
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${group.roomTypes}" var="room">
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
    %{--</div>--}%
</g:each>