<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos formulario</title>
</head>
<style>
    .error{
        color: red;
    }
</style>
<body>
    <?php
        $nombre = $_POST["nombre"];
        //Validación del nombre
        if(preg_match("/^[a-zA-Z\s]+$/", $nombre)) {
        echo "Nombre: " . htmlspecialchars($nombre). "<br>";
        } else {
        echo "<p class='error' > El campo nombre es incorrecto</p><br>";
        }
        //Validación de la edad
        $edad = $_POST["edad"];
        if (filter_var($edad, FILTER_VALIDATE_INT, ["options" => ["min_range" => 3, "max_range" => 130]])) {
            echo "Edad: " . $edad . "<br>";
        } else {
            echo "<p class='error'> El campo edad es incorrecto</p><br>";
        }
        //Validación del correo
        $correo = $_POST["correo"];
        if (filter_var($correo, FILTER_VALIDATE_EMAIL)) {
            echo "Correo electrónico: " . htmlspecialchars($correo) . "<br>";
        } else {
            echo "<p class='error'> El campo email es incorrecto</p><br>";
        }
    ?>
</body>
</html>