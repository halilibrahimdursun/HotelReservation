/*  ---------------------------------------------------
    Template Name: molveno
    Description: molveno Hotel Html Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Offcanvas Menu
    $(".canvas-open").on('click', function () {
        $(".offcanvas-menu-wrapper").addClass("show-offcanvas-menu-wrapper");
        $(".offcanvas-menu-overlay").addClass("active");
    });

    $(".canvas-close, .offcanvas-menu-overlay").on('click', function () {
        $(".offcanvas-menu-wrapper").removeClass("show-offcanvas-menu-wrapper");
        $(".offcanvas-menu-overlay").removeClass("active");
    });

    // Search model
    $('.search-switch').on('click', function () {
        $('.search-model').fadeIn(400);
    });

    $('.search-close-switch').on('click', function () {
        $('.search-model').fadeOut(400, function () {
            $('#search-input').val('');
        });
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
        Hero Slider
    --------------------*/
   $(".hero-slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: true,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        mouseDrag: false
    });

    /*------------------------
		Testimonial Slider
    ----------------------- */
    $(".testimonial-slider").owlCarousel({
        items: 1,
        dots: false,
        autoplay: true,
        loop: true,
        smartSpeed: 1200,
        nav: true,
        navText: ["<i class='arrow_left'></i>", "<i class='arrow_right'></i>"]
    });

    /*------------------
        Magnific Popup
    --------------------*/
    $('.video-popup').magnificPopup({
        type: 'iframe'
    });

    /*------------------
		Date Picker Check-in
	--------------------*/
    $(".date-input").datepicker({
        minDate: 0,
        dateFormat: 'dd MM, yy',
        changeMonth: true,
        changeYear: true
    });

/*------------------
		Date Picker
	--------------------*/

/*------------------
		Date Picker Check-in - Check-out
	--------------------*/

$(document).ready(function() {
    // Получаем текущую дату и следующий день
    var currentDate = new Date();
    var nextDay = new Date(currentDate.getTime() + 24 * 60 * 60 * 1000);

    // Вычисляем дату, ограничивающую период
    var maxDate = new Date(currentDate.getFullYear(), currentDate.getMonth() + 6, currentDate.getDate() + 1);

    // Форматируем даты в формат "yyyy-mm-dd"
    var formattedCurrentDate = currentDate.toISOString().split('T')[0];
    var formattedNextDay = nextDay.toISOString().split('T')[0];
    var formattedMaxDate = maxDate.toISOString().split('T')[0];

    // Устанавливаем значения и настройки datepicker для полей "date-in" и "date-out"
    $("#date-in").val(formattedCurrentDate).datepicker({
        minDate: 0,
        maxDate: formattedMaxDate,
        dateFormat: 'yy-mm-dd',
        onSelect: function(selectedDate) {
            var checkInDate = $(this).datepicker('getDate');
            var nextDay = new Date(checkInDate.getTime() + 24 * 60 * 60 * 1000);
            $("#date-out").datepicker("option", "minDate", nextDay);
        }
    });

    $("#date-out").val(formattedNextDay).datepicker({
        minDate: 1,
        maxDate: formattedMaxDate,
        dateFormat: 'yy-mm-dd'
    });
});



//$(document).ready(function() {
//    var checkInDate = null;
//
//    $("#date-in").datepicker({
//        minDate: 0,
//        dateFormat: 'yy-mm-dd',
//        onSelect: function(selectedDate) {
//            checkInDate = $(this).datepicker('getDate');
//            checkInDate.setDate(checkInDate.getDate() + 1);
//
//            var maxDate = new Date(checkInDate);
//            maxDate.setMonth(maxDate.getMonth() + 6);
//
//            $("#date-out").datepicker("option", "minDate", checkInDate);
//            $("#date-out").datepicker("option", "maxDate", maxDate);
//        }
//    });
//
//    $("#date-out").datepicker({
//        dateFormat: 'yy-mm-dd'
//    });
//});


/*------------------
 		END of Date Picker Check-in - Check-out
 	--------------------*/


    /*------------------
		Nice Select
	--------------------*/
    $("select").niceSelect();

})(jQuery);