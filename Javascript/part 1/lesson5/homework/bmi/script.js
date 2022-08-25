$(function () {
    const $weight = $('.weight');
    const $height = $('.height');
    const $bmi = $('.bmi');
    const $comment = $('.comment');
    const $calculate = $('.calculate');

    function calulation() {
        let weight = document.querySelector(".weight").value;
        let height = document.querySelector(".height").value;

        weight = parseFloat(weight);
        height = parseFloat(height);

        console.log(weight);
        console.log(typeof weight);
        console.log(height);
        console.log(typeof height);
        let comment;

        if (typeof weight == "number" && typeof height == "number" && !isNaN(weight) && !isNaN(height) && weight >0 && height>0) { 
            let bmi = (weight / (height * height)).toFixed(1);
           
            if (bmi < 18) {
              comment = "You're too thin, bro! Eat more";
            } else if (bmi <= 24.9) {
              comment = "You're in great shape, bro!";
            } else if (bmi <= 29.9) {
              comment = "You're a bit fat!";
            } else if (bmi <= 34.9) {
              comment = "You're too fat!";
            } else {
              comment = "You're fucking fat!";
            }
            $bmi.text(bmi);
            $comment.text(comment);

        } else {
            $bmi.text("");
            $comment.text("OOOPS! Check your input again.");
            
        }
    }
    calulation();

    $calculate.on('click', calulation);
    
})