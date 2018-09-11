$(function () {
    if(footSelect == 'house'){
        $("#houseFootImg").attr("src","/res/image/houseSelect.png");
        $("#houseFootSpan").removeClass().addClass("btn2");
        $("#coinFootImg").attr("src","/res/image/coinNormal.png");
        $("#coinFootSpan").removeClass().addClass("btn1");
        $("#peopleFootImg").attr("src","/res/image/peopleNormal.png");
        $("#peopleFootSpan").removeClass().addClass("btn1");
    }else if(footSelect == 'coin'){
        $("#houseFootImg").attr("src","/res/image/houseNormal.png");
        $("#houseFootSpan").removeClass().addClass("btn1");
        $("#coinFootImg").attr("src","/res/image/coinSelect.png");
        $("#coinFootSpan").removeClass().addClass("btn2");
        $("#peopleFootImg").attr("src","/res/image/peopleNormal.png");
        $("#peopleFootSpan").removeClass().addClass("btn1");
    }else if(footSelect == 'people'){
        $("#houseFootImg").attr("src","/res/image/houseNormal.png");
        $("#houseFootSpan").removeClass().addClass("btn1");
        $("#coinFootImg").attr("src","/res/image/coinNormal.png");
        $("#coinFootSpan").removeClass().addClass("btn1");
        $("#peopleFootImg").attr("src","/res/image/peopleSelect.png");
        $("#peopleFootSpan").removeClass().addClass("btn2");
    }
});