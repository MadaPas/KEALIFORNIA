$(function() {

    // get data

    // set up targeting variables
    let selectNoOfGuests = $('#selectNoOfGuests');
    let showRoomTypesButton =   $('#showRoomTypesButton');
    let roomContainer =         $('#roomContainer');
    let userInfoContainer =     $('#userInfoContainer');
    let confirmBookingButton =  $('#confirmBookingButton');

    // values
    let startDate =             moment($('#start-date').innerHTML).format("YYYY-MM-DD");
    let endDate =               moment($('#end-date').innerHTML).format("YYYY-MM-DD");
    let noOfGuests;
    let roomTypes = [];
    let selectedRoomType =      $('').val();

    selectNoOfGuests.on('click', 'a', function() {

        noOfGuests = this.innerHTML;
        roomTypes = getRoomsWithinDatesWithNoOfGuests(startDate, endDate, noOfGuests);
        console.log('noOFGuest', noOfGuests);

        //TODO: This is where problem is
        let parsedData = JSON.parse(JSON.stringify(roomTypes));
        console.log(parsedData[0]);
        showAvailableRoomTypes(roomTypes.responseJSON);

    });


});