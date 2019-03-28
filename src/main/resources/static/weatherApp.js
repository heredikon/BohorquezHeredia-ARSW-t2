var cityInfo;
var weatherApp = (function () {
    return {
        searchButton: function () {
            console.log("testing this s out");
            var city = $("#city").val();
            console.log(city);
            $.get('/cities/' + city, function (cityInfo) {
                console.log(cityInfo);
                var obj = JSON.parse(cityInfo);
                console.log(obj);
                $("#tabla").find('tbody').append(cityInfo);

            });

        }
    }
})();
var getWeather;