
$(function(){
    $("#selectCityId").change(function () {
        var cityId=$("#selectCityId").val();
        var url='/report/weather/?cityId='+cityId;
        window.location.href=url;
    })

});