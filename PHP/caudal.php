<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Caudal</title>
</head>
<body>
<form action="#">
      <p>
        Introduce la altura del cilindro: <input type="text" name="altura" method="post" />
      </p>
      <p>
        Introduce el radio del cilindro: <input type="text" name="radio" method="post" />
      </p>
      <p>
        Introduce el caudal de llenado <input type="text" name="caudal" method="post" />
      </p>
      <p><input type="submit" value="Calcular" /></p>
    </form>
    <?php
    error_reporting(error_level: 0);
    $pi = 3.1416;
    if(!isset($altura) || !isset($radio) || !isset($caudal)){
        $altura = $_REQUEST["altura"];
        $radio = $_REQUEST["radio"];
        $caudal = $_REQUEST["caudal"];
    }else{
        echo "Debes introducir todos los datos";
    }
    
    $volumen = $pi*($radio**2)*$altura;
echo $volumen;
    ?>
</body>
</html>