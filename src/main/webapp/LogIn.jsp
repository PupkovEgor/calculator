<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор расчета площади прямоугольника.</title>
<style>
   .blok-center {
    width: 500px; /* Ширина блока */
    height: auto; /* Высота блока */
    margin: auto; /* Отступ от блока */
    background: #ffffe0; /* Цвет фона блока */
    border: 1px solid #000; /* Рамка блока */
    padding: 10px; /* Отступ внутри блока */
   }
</style>
</head>
<body>
<div class="blok-center">
<h1>Вход в калькулятор расчета стоимости частного дома</h1>
<form action="${pageContext.request.contextPath}/LogCalc" method="post">
<input type="hidden" name="page" id="LogIn" value="LogIn"/>
<br><label for="login" >Логин: </label>
<input type="text" name="login" id="login" value="${login}" required title="Число больше нуля, дробная часть отделяется точкой">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br><label for="pass">Пароль: </label>
<input type="text" name="pass" id="pass" value="${pass}" required  title="Число больше нуля, дробная часть отделяется точкой">
<!--<strong>м</strong> pattern="(^[1-9](\d*)?([.]\d+)?)|(^0[.](\d*)?(?=[1-9])\d+)"-->
</br>
<br><input type="submit" name="sign" value="Вход"></br>
<br><input type="button" name="gtreg" value="Регистрация" onclick="location.href='Reg.jsp'"></br>
<p>${result}</p>
</form>
</div>
</body>
</html>
