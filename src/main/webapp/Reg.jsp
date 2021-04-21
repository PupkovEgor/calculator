<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор расчета площади прямоугольника.</title>
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
<br><label class="text" for="login" >Логин: </label>
<input class="combo" type="text" name="login" id="login" value="${login}" required title="Число больше нуля, дробная часть отделяется точкой">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br><label class="text" for="pass">Пароль: </label>
<input class="combo" type="text" name="pass" id="pass" value="${pass}" required  title="Число больше нуля, дробная часть отделяется точкой">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br><input class="combo" type="submit" name="sign" value="Регистрация"></br>
<br><input class="combo" type="button" name="gtlog" value="Уже зарегистрирован" onclick="location.href='LogIn.jsp'"></br>
<p class="text">${result}</p>
</form>
</div>
</body>
</html>
