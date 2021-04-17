<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
﻿<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Пример веб-страницы</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Calculator" method="post">
<p> габариты:</p>
<p>длина:
<input type="text" name="length" value= "${length}" size="20"> </p>

<p> ширина:
<input type="text" name="width"  value= "${width}" size="20"> </p>

<p>высота:
<input type="text" name="height" value= "${height}" size="20" > </p>

<p> количество этажей:
<input type="text" name="floor"  value= "${floor}" size="20" > </p>

<p>доп. работников:
<input type="text" name="worker"  value= "${worker}" size="20" > </p>

<p>внутренняя отделка:
<select name="otdelka" value= "${otdelka}" >
<option value="Heт">Heт </option>
<option value="Чepнoвaя">Чepнoвaя</option>
<option value="Под ключ">Под ключ</option>
</select> </p>
  
<p> Срочный заказ: <input type="checkbox" checked="true" name="order" value= "${order}" > </p>
<p> Очистка участка: <input type="checkbox" checked="true" name="clearing" value= "${clearing}" > </p>
<p>промокод:
<input type="text" name="promo" value= "${promo}" size="20" > </p>

<p>готовые пресеты :
<select name="preset"  value= "${preset}" >
<option vаlue="персональный">персональный </option>
<option vаlue="летний дом">летний дом </option>
<option vаlue="зимний дом">зимний дом </option>
</select> </p>
<p> <input type="submit" name="calculation" value=" Расчет "> </p>
<p> <input type="button" name="info" value=" Информация "> </p>
<p> <input type="button" name="exit" value=" Выход "> </р>
<p> <input type="button" name="settings" value=" Смена настроек "> </р>
</form>
</div>
</body>
</html>
