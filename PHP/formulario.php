<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>
<body>
    <form action="#">
        <p>Nombre: <input type="text" name="Nombre" method="post"></p>
        <p>Apellidos: <input type="text" name="Apellidos" method="post"></p>
        
        <p><input type="submit" value="Enviar"></p>
    </form>
   
   <?php
    $nombre = $_REQUEST["Nombre"];
    $apellido = $_REQUEST["Apellidos"];
    echo $nombre, " ",$apellido;
    ?>
</body>
</html>