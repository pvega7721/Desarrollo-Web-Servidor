<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cálculos</title>
</head>
<body>
    <h1>En esta página se mostrará el máximo, mínimo y el número de primos introducidos</h1>
    <?php
    session_start();
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero6'])){
        $_SESSION['numero6'] = $_POST['numero6'];
    }
    $primerNumero = (int) $_SESSION['numero1'];
    $segundoNumero = (int) $_SESSION['numero2'];
    $tercerNumero = (int) $_SESSION['numero3'];
    $cuartoNumero = (int) $_SESSION['numero4'];
    $quintoNumero = (int) $_SESSION['numero5'];
    $sextoNumero = (int) $_SESSION['numero6'];
    $arrayNumeros = [$primerNumero, $segundoNumero,$tercerNumero,$cuartoNumero,$quintoNumero,$sextoNumero ];
    $max = 0;
    $cantidadPrimos = 0;
    foreach ($arrayNumeros as $valor) {
        $esPrimo = (2 > ($valor % ($valor ** 0.5))) || ($valor == 2);
        $min=$valor;
       if($valor>$max){
        $max = $valor;
       }elseif($valor<$min){
        $min = $valor;
       }
       if($esPrimo){
        $cantidadPrimos++;
       }
    }

    echo "Número más grande: ". $max;
    echo "<br>Número más pequeño: ". $min;
    echo "<br>Números primos introducidos: ". $cantidadPrimos;
    ?>
</body>
</html>