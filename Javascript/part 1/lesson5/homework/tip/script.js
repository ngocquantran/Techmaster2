$(function () {
    const $billAmount = $('.amount-input');
    const $guestNumber = $('.guests-input');
    const $quality = $('.selected-quality');
    const $tip = $('.tip');
    const $calculate = $('.calculate');
    const $result = $('.result');
    const $selection = $('.selection');
    const $warn = $('.warn');

    function getTip() {
        let billAmount = document.querySelector(".amount-input").value;
        let guestNumber = document.querySelector(".guests-input").value;
        // let percentage = document.querySelector(".selected-quality").value;
        let percentage = document.querySelector(".selection").value;

        $warn.hide();
      
        billAmount = parseFloat(billAmount);
        guestNumber = parseFloat(guestNumber);
        percentage = parseFloat(percentage) / 100;
        
        if (!isNaN(billAmount) && !isNaN(guestNumber)) {
          if (isNaN(percentage)) {
            $result.hide();
            $warn.text("Please select service quality");
            $warn.show();
          } else { 
              if (
                Number.isInteger(guestNumber) &&
                guestNumber > 0 &&
                billAmount > 0
              ) {
                let tip;
                tip = ((billAmount * percentage) / guestNumber).toFixed(2);
                $result.show();
                $tip.text("$" + tip);
                console.log(tip);
              } else {
                $result.hide();
                $warn.text("Invalid input. Try again");
                $warn.show();
              }

          }
           
        }    
        
    }
    getTip();

    $calculate.on('click', getTip);

})