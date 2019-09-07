$(function () {

    var now = new Date();

    $('#demo-calendar-mobile').mobiscroll().calendar({
        onInit: function (event, inst) {
            inst.setVal(now, true);
        }
    });

    $('#demo-calendar-desktop').mobiscroll().calendar({
        touchUi: false,
        onInit: function (event, inst) {
            inst.setVal(now, true);
        }
    });

    $('#demo-calendar-header').mobiscroll().calendar({
        headerText: '{value}',
        onInit: function (event, inst) {
            inst.setVal(now, true);
        }
    });

    $('#demo-calendar-non-form').mobiscroll().calendar({
        onInit: function (event, inst) {
            inst.setVal(now, true);
        }
    });

    var instance = $('#demo-calendar-date-external').mobiscroll().calendar({
        showOnTap: false,
        showOnFocus: false,
        onInit: function (event, inst) {
            inst.setVal(new Date(), true);
        }
    }).mobiscroll('getInst');;

    $('#show-demo-calendar-date-external').click(function () {
        instance.show();
        return false;
    });

});
