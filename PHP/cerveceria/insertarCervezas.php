<?php
session_start();
$_SESSION["fallo"] = false;



if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (empty($_POST['denominacion']) || empty($_POST['tipo']) || empty($_POST['fechaConsumo']) || empty($_POST['precio']) || !is_numeric($_POST['precio'])) {
        $_SESSION["fallo"] = true;
    } else {
        $_SESSION['denominacion'] = $_POST['denominacion'];
        $_SESSION['marca'] = $_POST['marca'];
        $_SESSION['tipo'] = $_POST['tipo'];
        $_SESSION['formato'] = $_POST['formato'];
        $_SESSION['embase'] = $_POST['embase'];
        $_SESSION['alergenos'] = $_POST['alergenos'] ?? []; //las ?? hace que si no hay nada en alergenos, se envíe un array vacío
        $_SESSION['fechaConsumo'] = $_POST['fechaConsumo'];
        $_SESSION['precio'] = $_POST['precio'];
        $_SESSION['observaciones'] = $_POST['Observaciones'] ?? ''; //las ?? hace que si no hay nada en observaciones, se envíe un string vacío
        // Procesar la imagen
        /**
         * Verifica si se ha recibido un archivo en el campo "Imagen" y que no se haya producido ningún error durante la carga.
         * Si la carga fue exitosa (UPLOAD_ERR_OK), se genera la ruta de destino combinando el directorio "Imagenes/" 
         * y el nombre base del archivo subido, y se mueve el archivo desde su ubicación temporal al destino.
         * Luego, la ruta del archivo se almacena en la variable de sesión 'imagen' para su uso posterior.
         * En caso de que no se reciba el archivo o se produzca algún error, se asigna una cadena vacía a 'imagen'.
         */
        if (isset($_FILES['Imagen']) && $_FILES['Imagen']['error'] === UPLOAD_ERR_OK) {
            $destino = "Imagenes/" . basename($_FILES['Imagen']['name']);
            move_uploaded_file($_FILES['Imagen']['tmp_name'], $destino);
            $_SESSION['imagen'] = $destino;
        } else {
            $_SESSION['imagen'] = '';
        }
        header("Location: mostrarDatos.php");
        exit();
}
}
if($_SESSION["admin"]){
    echo "Bienvenido Administrador";
}else{
    echo "Bienvenido Usuario";
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cervecería</title>
    
    <style>
        h1{
            color: blue;
        }
        form{
            border: 1px solid;
            padding: 5px;
            margin-right: 40%;
            width: 80%;
        }
        .titulo{
            font-weight: bold;
        }
        .error{
            color: red;
        }
        .par{
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <h1>Inserción de Cervezas</h1>
    <p>Introduzca los datos de la Cerveza:</p>

    <form action="" method="post" enctype="multipart/form-data">
        <div class="par">
            <label for="denominacion" class=titulo>Denominación cerveza:</label>
            <input type="text" id="denominacion" name ="denominacion"><br><br>
        </div>

        <?php if(isset($_POST['denominacion']) && empty($_POST['denominacion'])){
            $_SESSION["fallo"] = true;
            echo "<p class='error'>¡Se requiere el nombre de la Cerveza!</p>";
        }
        ?>
        
        <label for="marca" class="titulo" >Marca:</label>
        <select name="marca" id="marca">
            <option value="Heiniken">Heiniken</option>
            <option value="Mahou">Mahou</option>
            <option value="DAM">DAM</option>
            <option value="Estrella Galicia">Estrella Galicia</option>
            <option value="Alhambra">Alhambra</option>
            <option value="Cruzcampo">Cruzcampo</option>
            <option value="Artesana">Artesana</option>
        </select>

        <br><br>        
        
        <label for="tipo" class="titulo">Tipo de cerveza:</label>

        <input type="radio" name="tipo" id="larger" value="larger">
        <label for="larger">LARGER</label>

        <input type="radio" name="tipo" id="paleale" value="paleale">
        <label for="paleale">PALE ALE</label>
        
        <input type="radio" name="tipo" id="cerveza_negra" value="cerveza_negra">
        <label for="cerveza_negra">CERVEZA NEGRA</label>
        
        <input type="radio" name="tipo" id="abadia" value="abadia">
        <label for="abadia">ABADIA</label>
        
        <input type="radio" name="tipo" id="rubia" value="rubia">
        <label for="rubia">RUBIA</label>
        <?php 
            if(isset($_POST['submit'])) { // Verifica si el formulario fue enviado
                if (!isset($_POST['tipo'])) { // Si no se ha seleccionado un tipo de cerveza
                    $_SESSION["fallo"] = true;
                    echo "<p class='error'>¡Has de elegir un tipo de cerveza!</p>";
                }   
            }
        ?>


        <br><br>

        <label for="formato" class="titulo">Formato:</label>
        <select name="formato" id="formato">
            <option value="Lata">Lata</option>
            <option value="Botella">Botella</option>
            <option value="Pack">Pack</option>
        </select>
        
        <br><br>
        
        <label for="embase" class="titulo">Tamaño: </label>
        <select name="embase" id="embase">
            <option value="botellin">Botellín</option>
            <option value="tercio">Tercio</option>
            <option value="medioLitro">Media</option>
            <option value="Litro">Litrona</option>
            <option value="Lata">Pack</option>
        </select>
        
        <br><br>

        <label for="alergenos[]" class="titulo" name="alergenos[]">Alérgenos:</label>
        <input type="checkbox" name="alergenos[]" id="Gluten" value="Gluten">
        <label for="Gluten">Gluten</label>

        <input type="checkbox" name="alergenos[]" id="Huevo" value="Huevo">
        <label for="Huevo">Huevo</label>

        <input type="checkbox" name="alergenos[]" id="Cacahuete" value="Cacahuete">
        <label for="Cacahuete">Cacahuete</label>

        <input type="checkbox" name="alergenos[]" id="Soja" value="Soja">
        <label for="Soja">Soja</label>

        <input type="checkbox" name="alergenos[]" id="Lacteo" value="Lacteo">
        <label for="Lacteo">Lacteo</label>

        <input type="checkbox" name="alergenos[]" id="Sulfitos" value="Sulfitos">
        <label for="Sulfitos">Sulfitos</label>

        <input type="checkbox" name="alergenos[]" id="Sin Alergenos" value="Sin Alergenos">
        <label for="Sin Alergenos">Sin Alergenos</label>
        
        <?php if(isset($_POST['alergenos[]']) && $_POST['alergenos[]'] == ""){
            $_SESSION["fallo"] = true;
            echo "<p class='error'>¡Has de elegir alérgenos!</p>";
        }
        ?>
        <br><br>
        
        <label for="fechaConsumo" class="titulo" name="fechaConsumo">Fecha Consumo: </label>
        <input type="date" name="fechaConsumo" id="fechaConsumo">
        <?php if(isset($_POST['fechaConsumo']) && empty($_POST['fechaConsumo'])){
            $_SESSION["fallo"] = true;
            echo "<p class='error'>¡Ha de tener una fecha de consumo máxima!</p>";
        }
        ?>
        <br><br>
        
        <label for="Imagen" id="Imagen" class="titulo" name="Imagen">Fotos</label>
        <input type="file" name="Imagen"/>
        <?php
            if ($_SERVER['REQUEST_METHOD'] == 'POST' && (!isset($_FILES['Imagen']) || $_FILES['Imagen']['error'] !== UPLOAD_ERR_OK)) {
            $_SESSION["fallo"] = true;
            echo "<p class='error'>¡Debes subir una imagen!</p>";
            }
        ?>
        <br><br>

        <label for="precio" class="titulo">Precio: </label>
        <input type="text" name="precio">€
        
        <?php if(isset($_POST['precio']) && (empty($_POST['precio']) || !is_numeric($_POST['precio']))){
            $_SESSION["fallo"] = true;
            echo "<p class='error'>¡El precio debe ser un valor numérico y no puede estar vacío!</p>";
        }
        ?>
        <br><br>

        <label for="Observaciones" class="titulo" name="Observaciones">Observaciones</label>
        <textarea rows="4" cols="50" name="Observaciones"></textarea>
        <br><br>   

        <input type="submit" name="submit" value="Insertar Cerveza">
    </form>
</body>
</html>
