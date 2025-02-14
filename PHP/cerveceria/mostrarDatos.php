<?php 
    session_start();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos recogidos</title>
</head>
<body>
    <a href="seleccionAdmin.php">Volver al menú</a>
    <p>DENOMINACIÓN CERVEZA: <?php echo $_SESSION["denominacion"] ?> </p>
    <p>MARCA : <?php echo $_SESSION["marca"] ?> </p>
    <p>TIPO CERVEZA: <?php echo $_SESSION["tipo"] ?> </p>
    <p>FORMATO: <?php echo $_SESSION["formato"] ?> </p>
    <p>TAMAÑO: <?php echo $_SESSION["embase"] ?> </p>
    <p>
        ALERGENOS: 
        <?php
        print("<ul>");
        if(!empty($_SESSION['alergenos'])){
            foreach ($_SESSION['alergenos'] as $alergeno){
                print("<li>".$alergeno."</li>");
                }
        print("</ul>");
        }else{
            print "No has seleccionado alérgenos";
        }        
        ?>
    </p>
    <p>FECHA CONSUMO: <?php echo $_SESSION["fechaConsumo"] ?> </p>
    <p>PRECIO: <?php echo $_SESSION["precio"] ?> </p>
    <p>Imagen guardada correctamente:</p>
    <?php
    if(isset($_SESSION['imagen']) && !empty($_SESSION['imagen'])){
        echo '<img src="'.$_SESSION['imagen'].'" alt="Imagen subida" style="max-width: 300px;"/>';
    } else {
        echo "No se ha subido ninguna imagen.";
    }
    ?>
    <p>Observaciones: <?php echo $_SESSION["observaciones"] ?> </p>
    <form action="" method="post">
        <button type ="submit" name="confirmar">Confirmar e insertar</button>
    </form>
</body>
</html>

<?php 
    //si se pulsa el botón´, se insertan los datos en la bbdd
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['confirmar'])) {
    
    //Conexión a la base de datos
    $servername = "127.0.0.1:3308";
    $username = "root";
    $password = "";
    $dbname = "cerveceria";

    //variable con los datos de la conexión
    $conn = new mysqli($servername, $username, $password, $dbname);

    //si la conexión falla, se muestra un mensaje de error
    if($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

        $denominacion = $_SESSION["denominacion"];
        $marca = $_SESSION["marca"];
        $tipo = $_SESSION["tipo"];
        $formato = $_SESSION["formato"];
        $embase = $_SESSION["embase"];
        $fechaConsumo = $_SESSION["fechaConsumo"];
        $precio = $_SESSION["precio"];
        $observaciones = $_SESSION["observaciones"];
        $foto = $_SESSION["imagen"];

        // Para los alérgenos, comprobamos si se ha recibido un array y lo convertimos a cadena
        if (!empty($_SESSION["alergenos"]) && is_array($_SESSION["alergenos"])) {
            $alergenos = $conn->real_escape_string(implode(", ", $_SESSION["alergenos"]));
        } else {
            $alergenos = "";
        }

        $sql = "INSERT INTO `cervezas` 
        (`Id_Cerveza`, `Denominacion_Cerveza`, `Marca`, `Tipo_Cerveza`, `Formato`, `Tamanyo`, `Alergenos`, `Fecha_Consumo`, `Foto`, `Precio`, `Observaciones`) 
        VALUES (NULL, '$denominacion', '$marca', '$tipo', '$formato', '$embase', '$alergenos', '$fechaConsumo', '$foto', '$precio', '$observaciones')";
            $resultado  = $conn->query($sql);
            
            if($resultado === TRUE){
                echo "Datos insertados correctamente";
        }else{
            echo "Error: " . $sql . "<br>" . $conn->error;
        }

        unset($_SESSION['imagen']);
        
            $conn->close();
        }
            ?>