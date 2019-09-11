$(function() {

    // get data

    // set up targeting variables
    let selectNoOfGuests = $('#selectNoOfGuests');
    let showRoomTypesButton =   $('#showRoomTypesButton');
    let roomContainer =         $('#roomContainer');
    let userInfoContainer =     $('#userInfoContainer');
    let confirmBookingButton =  $('#confirmBookingButton');

    // values
    let startDate =             $('#start-date').val();
    let endDate =               $('#end-date').val();
    let noOfGuests =            $('').val();
    let selectedRoomType =      $('').val();

    selectNoOfGuests.on('click', 'a', function() {
        showAvailableRoomTypes();
    });

    //set up event listeners
    showRoomTypesButton.on('click', () => {
        roomTypes = getAllRoomTypes();

        console.log(getRoomsWithinDatesForNoOfGuests("2019-09-10", "2019-09-20", 3, 5));
/*
        console.log(roomTypes);
*/
        //showAvailableRoomTypes(roomTypes);
    })








})