<g:each in="${roomGroups}" var="group">
    %{--<div class="row">--}%
        <div class="col-ms-12">
            <table class="table-striped">
                <thead>
                <tr>
                    %{--<th><span class="glyphicon glyphicon-stats"></span></th>--}%
                    <th>Hotel</th>
                    <th>Room Type</th>
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
                        <td>${room.roomHotelCode}</td>
                        <td>${room.roomCode}</td>
                        <td>${room.roomPrice}</td>
                        <td>${room.minFullAvailable}</td>
                        <td>${room.allotment}</td>
                        %{--<td>${room.roo}</td>--}%
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    %{--</div>--}%
</g:each>