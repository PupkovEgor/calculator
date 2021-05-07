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
  display: inline-table
  text-align: center;
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
    border-radius: 10px;
        right: 34.5%;
        margin: 10px;
      }
      #okno:target {display: block;}
          
</style>
</head>
<body>
  <form action="${pageContext.request.contextPath}/Calculator" method="post">
    <input type="hidden" name="lenghtwin" id="winter0" value="${winter0}"/>
    <input type="hidden" name="widthwin" id="winter1" value="${winter1}"/>
    <input type="hidden" name="heightwin" id="winter2" value="${winter2}"/>
    <input type="hidden" name="floorwin" id="winter3" value="${winter3}"/>
    <input type="hidden" name="otdelkawin" id="winter4" value="${winter4}"/>
    <input type="hidden" name="lenghtsum" id="summer0" value="${summer0}"/>
    <input type="hidden" name="widthsum" id="summer1" value="${summer1}"/>
    <input type="hidden" name="heightsum" id="summer2" value="${summer2}"/>
    <input type="hidden" name="floorsum" id="summer3" value="${summer3}"/>
    <input type="hidden" name="otdelkasum" id="summer4" value="${summer4}"/>
    <input type="hidden" name="fio" id="fio" value="${fio}"/>
    <p style="font-size : 15pt; color: #b3b3b3; background: #121212; text-align: right" >${fio}</p>

  <div style="position: relative; text-align:center;">
    <h1 style="font-size : 30pt; color: #b3b3b3; " >Калькулятор расчета строительства частного дома<h1>
  <div style="position: relative; align:center; display:inline-table;">

  <table width=auto height=auto cellspacing="0" cellpadding="5" cols = "4" style="display: inline-table;">
    <tr>
      <td colspan="4" align="center" class="cent">Габариты:</td>
    </tr>
    <tr>
      <td colspan="2"><p align="left"  class="text">Длина:</p></td>
      <td colspan="2"><p align="left" class="text">Ширина:</p></td>
    </tr>
    <tr>
      <td>
        <input type="number" autocomplete="off" required min="1" step="0.1" id = "length" name="length" value= "${length}" size="20" class="combo">
      </td>
      <td>
        <p align="left"  class="text" style="font-size: 16pt;">м.</p>
      </td>
      <td>
        <input type="number" autocomplete="off" required min="1" step="0.1" id = "width" name="width"  value= "${width}" size="20"class="combo"> 
      </td>
      <td>
        <p align="left"  class="text" style="font-size: 16pt;">м.</p>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p align="left" class="text">Высота:</p>
      </td>
      <td colspan="2">
        <p align="left" class="text">Количество этажей:</p>
      </td>
    </tr>
    <tr>
      <td> 
        <input type="number" autocomplete="off" required min="2" step="0.1" id = "height" name="height" value= "${height}" size="20"class="combo">
      </td>
      <td>
        <p align="left"  class="text" style="font-size: 16pt;">м.</p>
      </td>
      <td>
        <input type="number" autocomplete="off" required min="1" max="3" step="1" id = "floor" name="floor"  value= "${floor}" size="20"class="combo" style="width: 203px">
      </td>
      <td colspan="2">
        <p align="left"  class="text" style="font-size: 16pt;"></p>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p align="left" class="text">Доп. работников: </p>
      </td>
      <td colspan="2">
        <p align="left" class="text">Внутренняя отделка:</p>
      </td>
    </tr>
    <tr>
      <td>
        <input type="number" autocomplete="off" min="0" max="5" step="1" name="worker"  value= "${worker}" size="20"class="combo" style="width: 203px">
      </td>
      <td>
        <p align="left"  class="text" style="font-size: 16pt;">чел.</p>
      </td>
      <td colspan="2">
        <select id = "otdelka" name="otdelka" value= "${otdelka}" class="combo">
          <option value="1">Heт</option>
          <option value="2">Чepнoвaя</option>
          <option value="3">Под ключ</option>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p align="left" class="text">Срочный заказ:
          <input type="checkbox"  name="order" value= "${order}"></p>
      </td>
      <td colspan="2">
        <p align="left" class="text"> Очистка участка: <input type="checkbox"  name="clearing" value= "${clearing}"></p>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p align="left" class="text" placeholder="Промокод не задан">Промокод:</p>
      </td>
      <td colspan="2">
        <p align="left" class="text">Готовые пресеты:</p>
      </td>
    </tr>
    <tr> 
      <td colspan="2"> 
        <input type="text" name="promo" value= "${promo}" size="20"class="combo" >
      </td>
      <td colspan="2">
        <select name="preset" id="preset" value= "${preset}" class="combo">
          <option value="1">Персональный</option>
          <option value="2">Летний дом</option>
          <option value="3">Зимний дом</option>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p align="left"> <input type="submit" name="calculation" value="Расчет" class="combo" style="font-size : 13pt;" ></p>
      </td>
      <td colspan="2">
      <p align="left" >
      <!-- Открытие и закрытие окна с информацией на одну кнопку-->
      <input id="info" type="button" name="info" value="Информация " class="combo" onclick="document.getElementById('okno').style.display='block';
        document.getElementById('info').style.display='none'; document.getElementById('example_2_2').style.display='block'; "style=" font-size : 13pt;"  >
      <input type="button" value=" Информация " class="combo" id="example_2_2" onclick=" document.getElementById('okno').style.display='none'; 
      document.getElementById('example_2_2').style.display='none'; document.getElementById('info').style.display='block';" style=" font-size : 13pt; display:none;"></p>
      </td>
    </tr>
  </form>
  <tr> 
    <td colspan="4">
      <p align="left"><input type="button" name="exit" value="Выход из аккаунта" onclick="location.href='LogIn.jsp'" class="combo" style="font-size : 13pt;">
    </td>
  </tr>
</table>
</div>
</div>

<form action="${pageContext.request.contextPath}/Admin" method="post"> 
  <div id="okno" style=" color: #b3b3b3;">
    <table class = "text" >
      <tr>
        <td>
          <p style="background: #1c1c1c;font-weight: normal;font-size: 18pt;text-align :left">Разработчики: </p>
        </td>
      </tr>
  </div>
  <div align="right"><a href="#" style="text-decoration: none;text-align: right; color:#b3b3b3;">&#215;</a>
      <tr>
        <td style="text-align :left">
          <p style="font-size: 16pt">Салихов Рашит Ниязович<br>
                                     Иутин Александр Сергеевич<br>
                                     Бесполитов Даниил Анатольевич</p>
        </td>
      </tr>
    </table>
  </div>
</form>  
 <script>
     
     var s = document.getElementById('preset');
     s.addEventListener('change', setPre);

     function setPre(){
     var ch = s.value;
     if (ch==='1'){

     document.getElementById('length').readOnly = false;
     document.getElementById('width').readOnly = false;
     document.getElementById('height').readOnly = false;
     document.getElementById('floor').readOnly = false;
     document.getElementById('otdelka').readOnly = false;
     }
     if (ch==='3'){
     
     document.getElementById('length').value = document.getElementById('winter0').value;
     document.getElementById('length').readOnly = true;
     document.getElementById('width').value = document.getElementById('winter1').value;
     document.getElementById('width').readOnly = true;
     document.getElementById('height').value = document.getElementById('winter2').value;
     document.getElementById('height').readOnly = true;
     document.getElementById('floor').value = document.getElementById('winter3').value;
     document.getElementById('floor').readOnly = true;
     document.getElementById('otdelka').value = document.getElementById('winter4').value;;
     document.getElementById('otdelka').readOnly = true;
     }
     if (ch==='2'){
     document.getElementById('length').value = document.getElementById('summer0').value;
     document.getElementById('width').value = document.getElementById('summer1').value;
     document.getElementById('height').value = document.getElementById('summer2').value;
     document.getElementById('floor').value = document.getElementById('summer3').value;
     document.getElementById('otdelka').value = document.getElementById('summer4').value;
     document.getElementById('length').readOnly = true;
     document.getElementById('width').readOnly = true;
     document.getElementById('height').readOnly = true;
     document.getElementById('floor').readOnly = true;
     document.getElementById('otdelka').readOnly = true;
     }
     }
     </script>
</html> 
</body>

