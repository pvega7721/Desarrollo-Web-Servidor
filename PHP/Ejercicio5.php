<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio5</title>
</head>
<body>
    <?php
    $num = 8;
    $suma = $num+2;
    $resta = $suma-2;
    $multiplicacion = $resta*5;
    $division = $multiplicacion/3;
    $division1 = $division+1;
    $division2 = $division1 -1;

    echo"
    Numero = $num<br>
    Suma 2 = $suma<br>
    Resta 2 = $resta<br>
    Multiplica por 5 el ultimo valor = $multiplicacion<br>
    Divide por 3 el último valor = $division<br>
    Incrementa en 1 el resultado = $division1<br>
    Decrementa el resultado en 1 = $division2<br>
    ";

    ?>
</body>
</html>