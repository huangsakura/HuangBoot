<!doctype html>
<html>
<head>

</head>
<body>

</body>
<script src="/webjars/jquery/1.12.0/jquery.min.js"></script>
<script>
    $(function () {
        $.get('https://restcountries.eu/rest/v2/all',function (data) {
            var length = data.length;
            console.log('/*');
            for (var i=0;i<length;++i) {
                var da = data[i];
                var x;
                if (da.region==='Asia') {
                    x = 'AS';
                } else if (da.region==='Europe') {
                    x = 'EU';
                } else if (da.region==='Africa') {
                    x = 'AF';
                } else if (da.region==='Africa') {
                    x = 'AF';
                } else if (da.region==='Americas') {
                    x = 'AM';
                } else if (da.region==='Oceania') {
                    x = 'OC';
                }
                console.log('*/insert into country(alpha2_Code,alpha3_Code,name,capital_Name,population,continent_Code,area,national_Flag,create_Time)'
                        +' values("'+da.alpha2Code+'","'+da.alpha3Code+'","'+da.name+'","'+da.capital+'",'+da.population+',"'+x+'",'+da.area+',"'+da.flag+'",now());/*');
                var borders = da.borders;
                for (var j=0;j<borders.length;j++) {
                    console.log('*/insert into country_border(host_Alpha3_Code,guest_Alpha3_Code,create_Time) values("'+da.alpha3Code+'","'+borders[j]+'",now());/*');
                }
            }
            console.log('*/');
        });
    });
</script>
</html>