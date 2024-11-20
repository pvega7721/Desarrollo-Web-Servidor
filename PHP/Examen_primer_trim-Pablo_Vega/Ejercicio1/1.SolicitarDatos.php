<?php
    session_start(); //inicia Session para compartir datos entre las páginas
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Introducir datos</title>
</head>
<body>
    <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (FORMULARIO1)</h1>
    <p>Escriba un número (0 < números <= 20) y mostraré una tabla de una fila de este tamaño con casillas de verificación en cada celda</p>
    <form action="2.TablaCasillas.php" method="post">
        <label>Tamaño de la tabla:</label>
        <input type="number" name="tamanyo" step="1" min="1" max="20">
        <input type="submit" value="Mostrar">
        <input type="reset" value="Borrar">
    </form>
</body>
</html>