<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora IMC</title>
</head>
<style>
    .error{
        color: red;
    }
</style>
<body>
    <?php 
        //Creo las variables con los valores de peso y altura
        $peso = $_REQUEST["peso"];
        $altura=$_REQUEST["altura"];
        //variable que guarda las comprobaciones
        $todoCorrecto = false;
        //Si los valores no son números, imprime un mensaje de error
        if(!is_numeric($peso) || !is_numeric($altura)){
            $todoCorrecto = false;
            echo '<p class="error">Peso y altura deben ser números mayor a 0</p>';
        }else{
            //Si el número es menor o igual a 0, imprime el mensaje de error
            if($peso <= 0 || $altura <= 0){
                $todoCorrecto = false;
                echo '<p class="error">Peso y altura deben ser números mayor a 0</p>';
            }
            //Si ambos números son correctos, los pasamos a float y hacemos los cálculos
            $todoCorrecto = true;
            //Si es un número lo paso a float
            $peso = floatval($peso);
            $altura = floatval($altura);
            //paso la altura a metros
            $altura = $altura /100;
            $imc = $peso/ ($altura*$altura);
            if($imc < 18.5){
                echo "Tu imc es de: ". round($imc,2). ". Tienes bajo peso";
            }elseif($imc >= 18.5 && $imc<= 24.9){
                echo "Tu imc es de: ". round($imc,2). ". Tu peso es normal";
            }elseif($imc >= 25 && $imc<= 29.9){
                echo "Tu imc es de: ". round($imc,2). ". Tienes sobrepeso";
            }else{
                echo "Tu imc es de: ". round($imc,2). ". Tienes obesidad";
            }
        }
    ?>
</body>
</html>