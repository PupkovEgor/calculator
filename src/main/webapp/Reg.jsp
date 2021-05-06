<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
﻿<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Регистрация</title>
<style>
body{
	background: #121212;
}
   .blok-center {
    width: 500px; /* Ширина блока */
    height: auto; /* Высота блока */
    margin: auto; /* Отступ от блока */
     /* Цвет фона блока */
   background: #1c1c1c;
    padding: 10px; /* Отступ внутри блока */
   }
   .text{
   color: #b3b3b3;
   }
   .combo{
   background-color: #282828;
   color: #b3b3b3;
   font-size : 12pt;
   }
</style>
</head>
<body>
<div class="blok-center">
<h1 class="text">Регистрация пользователя</h1>
<form action="${pageContext.request.contextPath}/LogCalc" method="post">
<input type="hidden" name="page" id="Reg" value="Reg"/>
<br>
<input class="combo" placeholder="Фамилия И.О." type="text" name="fio" id="fio" value="${fio}" required  title="Введите ваши ФИО"><nobr class="text"> Эти данные будут использованы в результате</nobr>
</br>
<br>
<input class="combo" placeholder="Логин" type="text" name="login" id="login" value="${login}" required title="Введите логин">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br>
<input class="combo" placeholder="Пароль" type="password" name="pass" id="pass" value="${pass}" required  title="Введите пароль">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br>
<input class="combo" placeholder="Повторите пароль" type="password" name="pass1" id="pass1" required  title="Повторно введите пароль" oninput="passR()">
</br>
<br><input class="combo" type="submit" name="sign" id="sign" value="Регистрация" disabled="true"></br>
<br><input class="combo" type="button" name="gtlog" value="Уже зарегистрирован" onclick="location.href='LogIn.jsp'"></br>
<p class="text" id="result" >${result}</p>
<script>
function passR(){
var pass = document.getElementById('pass').value;
var pass1 = document.getElementById('pass1').value;
if(pass!==pass1){
	document.getElementById('result').innerHTML = 'Пароли не совпадают';
	document.getElementById('sign').disabled = true;
}
else{
	document.getElementById('result').innerHTML = '';
	document.getElementById('sign').disabled = false;
}
}
</script>
</form>
</div>
</body>
</html>
