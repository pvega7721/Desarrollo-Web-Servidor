<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio4</title>
</head>
<body>
    <?php
    $num1 = 10;
    $num2 = 7;
    $suma = $num1 + $num2;
    $resta = $num1 - $num2;
    $multiplicacion = $num1*$num2;
    $division = $num1/$num2;
    $modulo = $num1%$num2;

    echo"
    La suma de $num1 y $num2 es $suma;<br>
    La resta de $num1 y $num2 es $resta;<br>
    La multiplicación de $num1 y $num2 es $multiplicacion;<br>
    La división entre $num1 y $num2 es $division;<br>
    El módulo de $num1 y $num2 es $modulo;<br>
    ";
    ?>
</body>
</html>