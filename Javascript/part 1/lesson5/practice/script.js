// $("selector") == document.querySelectorAll("selector")
// $(dom)
// $("<tagname />") == document.createElement("tagname")

// $(function () {
//     let $tr = $('tr');

//     for (let i = 0; i < $tr.length; i++){
//         let tr = $tr[i];
//         let $td = $(tr).children().eq(i);
//         $td.css({ backgroundColor: "red" });
//     }

//     for (let i = 0; i < $tr.length; i++){
//         let tr = $tr[i];
//         let $td = $(tr).children().eq($tr.length-1-i);
//         $td.css({ backgroundColor: "red" });
//     }
// })

// $(function () {
//     let $box = $('.box');

//     console.log($box.html());
//     $box.html('<p>LoL</p>');
// })

$(function () {
    const directions = [
        'to right',
        'to left',
        'to bottom',
        'to top',
        'to right bottom',
        'to left bottom',
        'to right top',
        'to left top'];
    
    function getRandomDirection() {
      return Math.floor(Math.random() * directions.length);
        
    }

    function getRandomHexColor() {
        return Math.floor(Math.random() * 16777215).toString(16);
    }

    $(function () {
        const $body = $('body');
        const $direction = $('.direction');
        const $from = $(".from");
        const $to = $(".to");
        const $btn = $(".btn-change");

        $body.css({
            backgroundImage:`linear-gradient(${getRandomDirection()}),#${getRandomHexColor()},#${getRandomHexColor()}`
        })
    })

    
});

$(function () {

    const $weight = $('.weight');
    const $height = $('.height');
    const $calculate = $('.calculate');
    const $bmi = $('.bmi');
    function getBMI() {
        let bmi
    }
})



