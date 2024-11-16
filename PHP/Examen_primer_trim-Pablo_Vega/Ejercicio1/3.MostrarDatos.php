
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mostrar Datos</title>
</head>
<body>
    <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (RESULTADO)</h1>
        <?php
        session_start();
        $tamanyo = $_SESSION["tamanyo"]; //Guarda en una variable el tamaño de la tabla 
        
        //Si hay casillas marcadas, las guarda en un array, si no, crea el array vacío
        if(isset($_POST["checkboxes"])){
            $checkboxesMarcados = $_POST["checkboxes"];
        } else{
            $checkboxesMarcados = [];
        }
        
        echo "Ha marcado " .count($checkboxesMarcados). " casillas de un total de " .$tamanyo. ": ". implode(", ", $checkboxesMarcados);

        

        ?>
    
</body>
</html>