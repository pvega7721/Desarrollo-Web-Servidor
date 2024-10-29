<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos recogidos</title>
</head>
<body>
    <p>Tipo de cerveza: <?php echo $_REQUEST["tipoCerveza"] ?> </p>
    <p>Denominación del alimento: <?php echo $_REQUEST["Denominación"] ?> </p>
    <p>Tipo de envase: <?php echo $_REQUEST["embase"] ?> </p>
    <p>Cantidad neta: <?php echo $_REQUEST["CantidadNeta"] ?> </p>
    <p>Marca del producto: <?php echo $_REQUEST["marcaProducto"] ?> </p>
    <p>Advertencia sobre el abuso en el consumo de alcohol: <?php echo $_REQUEST["abusoConsumo"] ?> </p>
    <p>Fecha de consumo preferente: <?php echo $_REQUEST["fechaConsumo"] ?> </p>
    <p>
        Sustancias que pueden causar alergias: 
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
    <p>Observaciones: <?php echo $_REQUEST["Observaciones"] ?> </p>
    <p>Imagen guardada correctamente: <br>
        <?php $archivo = $_FILES['Imagen']
       // echo '<img src="' . $ruta_destino . '" alt="Imagen subida" style="max-width: 300px;"/>';
        
        ?>
    
    </p>
</body>
</html>