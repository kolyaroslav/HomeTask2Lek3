<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Questionnaire project</title>
</head>
<body>
<form action="/output" method="POST">
    1. Do you like Java?? <br>
    <input type="radio" value="YES" name="ques1">YES<br>
    <input type="radio" value="NO" name="ques1">NO<br>

    2. Do you like Python?? <br>
    <input type="radio" value="YES" name="ques2">YES<br>
    <input type="radio" value="NO" name="ques2">NO<br>



    <input type="submit"/><br>
</form>
</body>
</html>