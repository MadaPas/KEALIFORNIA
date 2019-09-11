
$(function () {

    $.getJSON(`/api/hotels`)
        .done(function(hotels) {

                console.log(hotels);
                hotels.forEach(function (hotel){

                    $('ul').append( `<button class="list-group-item list-group-item-action" data-hotelid=${hotel.id}>` + `${hotel.name}` + `</button>` );
                // <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                 })
        })

    $('#hotelsTable').on('click','.list-group-item', function () {
        let row = $(this).closest('.list-group-item');
        let hotelID = row.attr('data-hotelid');
        // console.log(hotelID);
        localStorage.setItem("hotel",hotelID);
        console.log(localStorage);
    });

    // window.onload = function() {
    //     let getInput = prompt("whats up: ");
    //     localStorage.setItem("hotel",getInput);
    // }
});