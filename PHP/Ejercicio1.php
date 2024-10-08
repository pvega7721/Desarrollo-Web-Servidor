<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>
<body>
    <?php
    $nombre = "Pablo";
    $apellido1 = "Vega";
    $apellido2 = "Flores";
    $curso = "2ºDAW";
    $rutaDNI = "/imagenes/foto_dni.jpg";
    echo $nombre, " ", $apellido1, " ", $apellido2, " ", $curso;
    echo "<img src='$rutaDNI' alt='DNI de ejemplo'/>"
    ?>
</body>
</html>