function IsNumeric(sText){
    var ValidChars = "0123456789.";
    var IsNumber = true;
    var Char;
    for (i = 0; i < sText.length && IsNumber == true; i++) {
        Char = sText.charAt(i);
        if (ValidChars.indexOf(Char) == -1) {
            IsNumber = false;
        }
    }
    return IsNumber;
};
function calcProdSubTotal(){
    var prodSubTotal = 0;
    $(".row_input").each(function(){
        var valString = $(this).val() || 0;
        prodSubTotal += parseInt(valString);
    });
    $("#product_total").val(prodSubTotal);
};
function calcTotalPallets(){
    var totalPallets = 0;
    $(".num_input").each(function(){
        var thisValue = $(this).val();
        if ((IsNumeric(thisValue)) && (thisValue != '')) {
            totalPallets += parseInt(thisValue);
        };
            });
    $("#total_num").val(totalPallets);
};

function calcShippingTotal(){
    var totalPallets = $("#total_num").val() || 0;
    var shippingRate = $("#shipping_rate").text() || 0;
    var shippingTotal = totalPallets * shippingRate;
    $("#shipping_total").val(shippingTotal);
};

function calcOrderTotal(){
    var orderTotal = 0;
    var productSubtotal = $("#product_total").val() || 0;
    var shippingSubtotal = $("#shipping_total").val() || 0;
    var orderTotal = parseInt(productSubtotal) + parseInt(shippingSubtotal);
    var orderTotalNice = "$" + orderTotal;
    $("#order_total").val(orderTotalNice);
};


$("document").ready(function(){
    $('.num_input').blur(function(){
        var $this = $(this);
        var numPallets = $this.val();
        var multiplier = $this.parent().parent().find("td.danjia span").text();
        if ((IsNumeric(numPallets)) && (numPallets != '')) {
            var rowTotal = numPallets * multiplier;
            $this.css("background-color", "white").parent().parent().find("td.row_total input").val(rowTotal);
        }
        else {
            $this.css("background-color", "#ffdcdc");
        };
        calcProdSubTotal();
        calcTotalPallets();
        calcShippingTotal();
        calcOrderTotal();
    });
});
