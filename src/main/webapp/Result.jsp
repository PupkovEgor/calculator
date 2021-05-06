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
<tr><td colspan="2" align="center" class="cent" id="fio">Ваши данные:</td></tr>
<tr><td><p align="left"  class="text"id="length">Длина: ${result_length} м.</p></td>
  <td><p align="left" class="text" id="width">Ширина: ${result_width} м.</p></td></tr>
<tr><td><p align="left" class="text" id="height">Высота: ${result_height} м.</p></td>
  <td><p align="left" class="text" id="floor">Количество этажей: ${result_floor}</p></td></tr>
<tr><td><p align="left" class="text" id="worker">Доп. работников: ${result_worker} чел.</p></td>
  <td><p align="left" class="text" id="otdelka">Внутренняя отделка: ${result_otdelka} </p></td></tr>
<tr><td><p align="left" class="text" id="order">Срочный заказ: ${result_order}</p></td>
  <td><p align="left" class="text"id="clearing"> Очистка участка: ${result_clearing} </p></td></tr>
<tr><td><p align="left" class="text" id="promo">Промокод: ${result_promo}</p></td>
  <td><p align="left" class="text" id="preset" id="preset">Готовые пресеты: ${result_preset}</p></td></tr>
  <tr><td colspan="2" align="left"><p class="text" align = "left" id="result">Результат: ${result}</p></td></tr>
  <tr><td><p align="left"> <input type="button" name="Cancel" value=" Назад" class="combo" onclick="history.back()" style="font-size : 13pt;"></р></td>
  <td></td></tr>
  <td><p align="left"> <input id="button"  type="submit" name="button" onclick="asd();" value="Скачать PDF" class="combo"  style="font-size : 13pt;"/> </р></td>
  <td><p align="left"> <input type="button" name="exit" value=" Выход из аккаунта" onclick="location.href='LogIn.jsp'" class="combo" style="font-size : 13pt;"> </р></td>
  </table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.71/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.71/vfs_fonts.js"></script>
<script>
  

function asd(){

var docDefinition = {
    info: {
        title: "Результат",
          },
    
pageSize:'A4',
pageOrientation:'portrait',
pageMargins:[50,50,30,60],

header:{

    text:'Итог расчетов:',
    fontSize: 17,
    bold: true,
    alignment:'left',
    margin:[50,30,10,50],
    
    }
,

content: [

  {
   
  text:[
  '\n',
  document.getElementById('fio').textContent, '\n',
  document.getElementById('length').textContent,'\n',
  document.getElementById('width').textContent,'\n',
  document.getElementById('height').textContent,'\n',
  document.getElementById('floor').textContent,'\n',
  document.getElementById('worker').textContent,'\n',
  document.getElementById('otdelka').textContent,'\n',
  document.getElementById('order').textContent,'\n',
  document.getElementById('clearing').textContent,'\n',
  document.getElementById('promo').textContent,'\n',
  document.getElementById('preset').textContent,'\n \n',
  document.getElementById('result').textContent
  ],
  style: 'bigger'
  }
],
styles: {
       
        bigger: {
            fontSize: 16,
        lineHeight: 1.2 
        }
    }
  }
pdfMake.createPdf(docDefinition).download('Результат.pdf');
}
</script>
</body>
</html>
