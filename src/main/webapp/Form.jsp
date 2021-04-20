<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
﻿<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Калькулятор</title>
<style>
body{
	background: #121212;
}
table {
    margin: auto;
   }
   td {
     background: #1c1c1c;
	 
   }
   input{
   	text-align: left;
   }

   p {
    font-size: 20pt; /* Размер шрифта в пунктах */ 
    background: #1c1c1c;
    text-align: left;

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
   #okno {
        width: auto; /* Ширина и высота окна*/
        height: auto;
        padding: 0px 10px;
        border: 2px solid #282828;
		display: none;
        background: #1c1c1c;
        position: absolute;
        top: auto;
		
        right: 34.5%;
        //bottom: 100%
        left: 0;
        margin: 10px;
      }
      #okno:target {display: block;}
      #dop {
        width: 310px; /* Ширина и высота окна*/
        height: 550px;
        text-align: left;
        padding: 15px;
        border: 2px solid #282828;
        border-radius: 10px;
        color: #1c1c1c;
        display: none;
        position: absolute;
        top: 12%;
        right: 17%;
        bottom: 100%
        left: 0;
        margin: 10px;
      }
      #dop:target {display: block;}
</style>
</head>
<body>
	<h1 style="font-size : 30pt; color: #b3b3b3; text-align:center; valign:top;" >Калькулятор расчета строительства частного дома<h1>
  <table width=auto height=auto cellspacing="0" cellpadding="5" cols = "4" >
  	<tr><td colspan="4" align="center" class="cent">Габариты:</td></tr>
	<tr><td colspan="2"><p align="left"  class="text">Длина:</p> </td><td colspan="2"><p align="left" class="text">Ширина:</p> </td></tr>
	<tr><td> <input type="text" name="length" value= "${length}" size="20" class="combo"></td><td> <p align="left"  class="text" style="font-size: 16pt;">м.</p></td><td><input type="text" name="width"  value= "${width}" size="20"class="combo"> </td><td><p align="left"  class="text" style="font-size: 16pt;">м.</p> </td></tr>
	<tr><td colspan="2"><p align="left" class="text">Высота:</p> </td><td colspan="2"><p align="left" class="text">Количество этажей:</p> </td></tr>
	<tr><td> <input type="text" name="height" value= "${height}" size="20"class="combo"></td><td><p align="left"  class="text" style="font-size: 16pt;">м.</p> </td><td><input type="text" name="floor"  value= "${floor}" size="20"class="combo"></td><td colspan="2"><p align="left"  class="text" style="font-size: 16pt;"></p> </td></tr>
	<tr><td colspan="2"><p align="left" class="text">Доп. работников: </p> </td><td colspan="2"> <p align="left" class="text">Внутренняя отделка:</p></td></tr>
	<tr><td><input type="text" name="worker"  value= "${worker}" size="20"class="combo" > </td><td><p align="left"  class="text" style="font-size: 16pt;">чел.</p> </td><td colspan="2"> <select name="otdelka" value= "${otdelka}" class="combo">
		<option value="1">Heт </option>
		<option value="2">Чepнoвaя</option>
		<option value="3">Под ключ</option>
		</select></td></tr>
	<tr><td colspan="2"><p align="left" class="text">Срочный заказ:<input type="checkbox"  name="order" value= "${order}"> </p> </td><td colspan="2"><p align="left" class="text"> Очистка участка: <input type="checkbox"  name="clearing" value= "${clearing}"> </p> </td></tr>
	<tr><td colspan="2"><p align="left" class="text">Промокод:</p> </td><td colspan="2"><p align="left" class="text">Готовые пресеты :</p> </td></tr>
	<tr><td colspan="2"><input type="text" name="promo" value= "${promo}" size="20"class="combo" > </td><td colspan="2"> <select name="preset"  value= "${preset}" class="combo">
		<option value="1">Персональный </option>
		<option value="2">Летний дом </option>
		<option value="3">Зимний дом </option>
		</select></td></tr>
	<tr><td colspan="2"><p align="left"> <input type="submit" name="calculation" value=" Расчет " class="combo" style="font-size : 13pt;" > </p> </td><td colspan="2"> <p align="left" > <input type="button" name="info" value=" Информация " class="combo" style="font-size : 13pt;" onclick="location.hash ='okno'" >
	 </p></td></tr>
	<tr><td colspan="2"> <p align="left"> <input type="button" name="settings" value=" Смена настроек " class="combo" style="font-size : 13pt;" onclick="location.hash ='dop'" ></р>	</td><td colspan="2"><p align="left"><input type="button" name="exit" value=" Выход из аккаунта" onclick="location.href='LogIn.jsp'" class="combo" style="font-size : 13pt;"> 	</td></tr>
  </table>

     <div id="okno" style=" color: #b3b3b3;">
	 <table class = "text" >
	 <tr><td><p style="background: #1c1c1c;font-weight: normal;font-size: 18pt;text-align :left"> Разработчики: </p></td>
		<td><div align="right"><a href="#" style="text-decoration: none;text-align: right; color:#b3b3b3;">&#215;</a></div></td></tr>
	 <tr><td style="text-align :left">
	  <p style="font-size: 16pt">Салихов Рашит Ниязович<br>
		Иутин Александр Сергеевич<br>
		Бесполитов Даниил Анатольевич</p> </td></tr>
	 </table>
     </div>

     <div id="dop" class="okno" style="font-size : 14pt; color: #b3b3b3 " >
     	 <tr><td><div align="right"><a href="#" style="text-decoration: none;text-align: right; color:#b3b3b3;">&#215;</a></div></td>
     	<td><p align="left" class="text">Вид дома для изменения:
		<br><select name="otdelka1" value= "${otdelka}" class="combo">
		<option value="1">Летний дом</option>
		<option value="2">Зимний зимний</option>
		</select></p></td></tr>
      <p align="left"  class="text">Длина:<br><input type="text" name="length" value= "${length}" size="20" class="combo"> </p>
      <p align="left" class="text">Ширина:<br><input type="text" name="width"  value= "${width}" size="20"class="combo"> </p>
      <p align="left" class="text">Высота:<br><input type="text" name="height" value= "${height}" size="20"class="combo"></p>
      <p align="left" class="text">Количество этажей:<br><input type="text" name="floor"  value= "${floor}" size="20"class="combo"></p>
      <p align="left" class="text">Внутренняя отделка:
		<br><select name="otdelka" value= "${otdelka}" class="combo">
		<option value="1">Heт </option>
		<option value="2">Чepнoвaя</option>
		<option value="3">Под ключ</option>
		</select></p>
		<tr><td><p align="left"> <input type="button" name="ready" value=" Применить настройки" class="combo" style="font-size : 13pt;"></р></td>
    </div>
</body>
</html>
