
$(function () {

    localStorage.clear();

    $.getJSON(`/api/hotels`)
        .done(function(hotels) {

                console.log(hotels);
                hotels.forEach(function (data){

                    let hotel = {
                        "id":data.id,
                        "name":data.name
                    };

                    $('ul').append( `<a href="/home" class="list-group-item list-group-item-action" data-hotelid=${hotel.id}>` + `${hotel.name}` + `</a>` );
                // <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>

                 })
        })

    $('#hotelsTable').on('click','.list-group-item', function () {
        let row = $(this).closest('.list-group-item');
        let hotelID = row.attr('data-hotelid');
        let hotelName = row.valueOf().text();

        localStorage.setItem("hotelID",hotelID);
        localStorage.setItem("hotelName", hotelName);

        // // localStorage.setItem("hotelName",hotelName);
        console.log(localStorage);
    });

    // window.onload = function() {
    //     let getInput = prompt("whats up: ");
    //     localStorage.setItem("hotel",getInput);
    // }
});