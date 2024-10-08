<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 11</title>
</head>
<body>
<form action="#">
        <p>Nombre: <input type="text" name="Nombre" method="post"></p>
        <p><input type="submit" value="Enviar"></p>
    </form>
    <?php
    $nombre = $_REQUEST["Nombre"];
    echo "Hola ", $nombre;
    ?>
</body>
</html>