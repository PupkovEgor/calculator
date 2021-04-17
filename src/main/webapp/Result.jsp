<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Результат</title>
<style>
   .blok-center {
    float: left;
    text-align: left;
    width: 300px; /* Ширина блока /
    height: auto; / Высота блока /
    margin: auto; / Отступ от блока /
    background: #ffffe0; / Цвет фона блока /
    border: 1px solid #000; / Рамка блока /
    padding: 10px; / Отступ внутри блока */
   }
</style>
</head>
<body>
<div class="blok-center">
<p>Введенные габариты и результат:</p>
<p>длина: ${result_length} </p>

<p> ширина: ${result_width} </p>

<p>высота: ${result_height}</p>

<p> количество этажей: ${result_floor} </p>

<p>доп. работников: ${result_worker} </p>

<p>внутренняя отделка: ${result_otdelka} </p>

<p> Срочный заказ: ${result_order}</p>
<p> Очистка участка: ${result_clearing}</p>
<p>промокод: ${result_promo} </p>

<p>готовые пресеты: ${result_preset} </p>

<p>Результат: ${result} </p>

<p> <input type="button" name="exit" value="Назад" onclick="location.href='Form.jsp'"> </р>
</div>
</body>
</html>