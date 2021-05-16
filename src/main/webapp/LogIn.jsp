<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
﻿<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Вход в калькулятор</title>
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
<h1 class="text">Вход в калькулятор</h1>
<form action="${pageContext.request.contextPath}/LogCalc" method="post">
<input type="hidden" name="page" id="LogIn" value="LogIn"/>
<input type="hidden" name="fio" id="fio" value=""/>
<br>
<input type="text" placeholder="Логин" class="combo" name="login" id="login" value="${login}" required title="Введите ваш логин">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br>
<input  class="combo" placeholder="Пароль" type="password" name="pass" id="pass" value="${pass}" required  title="Введите ваш пароль">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br><input  class="combo" type="submit" name="sign" value="Вход"></br>
<br><input class="combo" type="button" name="gtreg" value="Регистрация" onclick="location.href='Reg.jsp'"></br>
<p class="text">${result}</p>
</form>
</div>
</body>
</html>
