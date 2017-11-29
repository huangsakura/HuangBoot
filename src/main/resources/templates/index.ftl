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
            console.log(data);
        });
    });
</script>
</html>