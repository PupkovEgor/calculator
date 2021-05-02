<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
﻿<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Пример веб-страницы</title>
<style>
body{
	background: #121212;
}
table {
    margin: auto;
   }
   td {
    text-align: center;
     background: #1c1c1c;
   }
   p {
    font-size: 20pt; /* Размер шрифта в пунктах */ 
    background: #1c1c1c;
   }
   .cent{
    color: #b3b3b3;
	font-size: 25pt;
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
	<h1 style="font-size : 30pt; color: #b3b3b3; text-align:center; valign: top;">Калькулятор расчета строительства частного дома<h1>
<table width=auto height=auto cellspacing="0" cellpadding="8" cols = "2">
<tr><td colspan="2" align="center" class="cent">Ваши данные:</td></tr>
<tr><td><p align="left"  class="text">Длина: ${result_length} м.</p></td>
	<td><p align="left" class="text">Ширина: ${result_width} м.</p></td></tr>
<tr><td><p align="left" class="text">Высота: ${result_height} м.</p></td>
	<td><p align="left" class="text">Количество этажей: ${result_floor}</p></td></tr>
<tr><td><p align="left" class="text">Доп. работников: ${result_worker} чел.</p></td>
	<td><p align="left" class="text">Внутренняя отделка: ${result_otdelka} </p></td></tr>
<tr><td><p align="left" class="text">Срочный заказ: ${result_order}</p></td>
	<td><p align="left" class="text"> Очистка участка: ${result_clearing} </p></td></tr>
<tr><td><p align="left" class="text">Промокод: ${result_promo}</p></td>
	<td><p align="left" class="text">Готовые пресеты: ${result_preset}</p></td></tr>
	<tr><td colspan="2" align="left"><p class="text" align = "left">Результат: ${result}</p></td></tr>
	<tr><td><p align="left"> <input type="button" name="Cancel" value=" Назад" class="combo" onclick="history.back()" style="font-size : 13pt;"></р></td>
	<td><p align="left"> <input type="button" name="exit" value=" Выход из аккаунта" onclick="location.href='LogIn.jsp'" class="combo" style="font-size : 13pt;"> </р></td></tr>
  </table>
</body>
</html>
