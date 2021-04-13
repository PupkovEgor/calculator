<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат расчета площади прямоугольника</title>
<style>
   .blok-center {
    width: 500px; /* Ширина блока */
    height: 300px; /* Высота блока */
    margin: auto; /* Отступ от блока */
    background: #ffffe0; /* Цвет фона блока */
    border: 1px solid #000; /* Рамка блока */
    padding: 10px; /* Отступ внутри блока */
   }
</style>
</head>
<body>
<div class="blok-center">
<h1>Результат расчета площади прямоугольника</h1>
<h2>Ваши введеные данные:</h2>
<p><strong>Длина:</strong> ${first_result}<strong> см</strong></p>
<p><strong>Ширина:</strong> ${second_result}<strong> см</strong></p>
<p><strong>Результат:</strong> ${result}<strong> см²</strong></p>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input type="submit" name="sign" value="Назад">
    </form>
<div>
</body>
</html>