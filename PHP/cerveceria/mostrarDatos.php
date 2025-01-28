<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos recogidos</title>
</head>
<body>
    <p>DENOMINACIÓN CERVEZA: <?php echo $_REQUEST["tipoCerveza"] ?> </p>
    <p>MARCA : <?php echo $_REQUEST["Denominación"] ?> </p>
    <p>TIPO CERVEZA: <?php echo $_REQUEST["embase"] ?> </p>
    <p>FORMATO: <?php echo $_REQUEST["CantidadNeta"] ?> </p>
    <p>TAMAÑO: <?php echo $_REQUEST["marcaProducto"] ?> </p>
    <p>
        ALERGENOS: 
        <?php
        print("<ul>");
        if(!empty($_REQUEST['alergenos'])){
            foreach ($_REQUEST['alergenos'] as $alergeno){
                print("<li>".$alergeno."</li>");
                }
        print("</ul>");
        }else{
            print "No has seleccionado alérgenos";
        }        
        ?>
    </p>
    <p>FECHA CONSUMO: <?php echo $_REQUEST["fechaConsumo"] ?> </p>
    <p>PRECIO: <?php echo $_REQUEST["abusoConsumo"] ?> </p>
    <p>Imagen guardada correctamente: <br>
        <?php $archivo = $_FILES['Imagen']
       // echo '<img src="' . $ruta_destino . '" alt="Imagen subida" style="max-width: 300px;"/>';
        
        ?>
    
    </p>
    <p>Observaciones: <?php echo $_REQUEST["Observaciones"] ?> </p>
</body>
</html>