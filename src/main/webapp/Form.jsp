
﻿<!DOCTYPE HTML>
<html>
<head>
<meta content="text/html; charset=utf-8">
<title>Пример веб-страницы</title>
</head>
<body>

<p> габариты:</p>
<p>длина:
<input type="text" name="long" value= "${long}" size="20"> </p>

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
<option value="al">Heт </option>
<option value="a2">Чepнoвaя</option>
<option value="a3">Под ключ</option>
</select> </p>
  
<p> Срочный заказ: <input type="checkbox" name="order" value= "${order}" checked> </p>
<p> Очистка участка: <input type="checkbox" name="clearing" value= "${clearing}" checked> </p>
<p>промокод:
<input type="text" name="promo" value= "${promo}" size="20" > </p>

<p>готовые пресеты :
<select name="preset"  value= "${preset}" >
<option vаlue="г1">персональный </option>
<option vаlue="г2">летний дом </option>
<option vаlue="гЗ">зимний дом </option>
</select> </p>

<p> <input type="button" name="calculation" value=" Расчет "> </p>
<p> <input type="button" name="info" value=" Информация "> </p>
<p> <input type="button" name="exit" value=" Выход "> </р>
<p> <input type="button" name="settings" value=" Смена настроек "> </р>
</div>
</body>
</html>
