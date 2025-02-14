<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catálogo</title>
</head>
<body>
    <a href="seleccionAdmin.php">Volver al menú</a>
    <h1>Catalogo Admin</h1>

    <?php
    $servername = "127.0.0.1:3308";
    $username = "root";
    $password = "";
    $dbname = "cerveceria";

    $conn = new mysqli($servername, $username, $password, $dbname);

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

        $sql = "SELECT * FROM cervezas";
        $result = $conn->query($sql);
    if($result->num_rows > 0){
        echo "
        <table border='1' text-align='center'>
            <tr>
                <th>Id</th>
                <th>Denominación</th>
                <th>Marca</th>
                <th>Tipo</th>
                <th>Formato</th>
                <th>Tamaño</th>
                <th>Alergenos</th>
                <th>Fecha de Consumo</th>
                <th>Imagen</th>
                <th>Precio</th>
                <th>Observaciones</th>
                <th>Acciones</th>
            </tr>
        ";

        while($row = mysqli_fetch_array($result)) {
            echo "<tr>";
                print "<td>".$row['Id_Cerveza']."</td>";
                print "<td>".$row['Denominacion_Cerveza']."</td>";
                print "<td>".$row['Marca']."</td>";
                print "<td>".$row['Tipo_Cerveza']."</td>";
                print "<td>".$row['Formato']."</td>";
                print "<td>".$row['Tamanyo']."</td>";
                print "<td>".$row['Alergenos']."</td>";
                print "<td>".$row['Fecha_Consumo']."</td>";
                print "<td><img src='".$row['Foto']."' width = '100'></td>";
                print "<td>".$row['Precio']."</td>";
                print "<td>".$row['Observaciones']."</td>";
                print "<td> 
                        <form action='' method='post'>
                            <button type='submit' name='". $row['Id_Cerveza']. "'>Eliminar</button>
                        </form>
                        </br>
                        </br>
                        <form action='' method='get'>
                            <button type='submit' name='". $row['Id_Cerveza']. "'>Modificar</button>
                        </form>
                        </td>";
            echo "</tr>";
        }


        echo "</table>";
    } else{
        echo "No hay cervezas en el catálogo";
    }

    foreach ($_POST as $name => $content) {
        $sql = "DELETE FROM cervezas WHERE Id_Cerveza = $name";

        $result = $conn->query($sql);
        echo "Cerveza eliminada correctamente";
    }
    foreach ($_GET as $name => $content) {
        if(isset($_GET['submit'])) {
            $sql = "SELECT * FROM cervezas WHERE Id_Cerveza = $name";
            $result = $conn->query($sql);

            if($result->num_rows > 0){
                $row = mysqli_fetch_array($result);

                if(empty($_GET['denominacion'])){
                    $denominacion = $row['Denominacion_Cerveza'];
                }else{
                    $denominacion = $_GET['denominacion'];
                }

                if(empty($_GET['marca'])){
                    $marca = $row['Marca'];
                }else{
                    $marca = $_GET['marca'];
                }

                if(empty($_GET['tipo'])){
                    $tipo = $row['Tipo_Cerveza'];
                }else{
                    $tipo = $_GET['tipo'];
                }

                if(empty($_GET['formato'])){
                    $formato = $row['Formato'];
                }else{
                    $formato = $_GET['formato'];
                }

                if(empty($_GET['embase'])){
                    $embase = $row['Tamanyo'];
                }else{
                    $embase = $_GET['embase'];
                }

                if(empty($_GET['alergenos'])){
                    $alergenos = $row['Alergenos'];
                }else{
                    $alergenos = $_GET['alergenos'] ?? [];
                }

                if(empty($_GET['fechaConsumo'])){
                    $fechaConsumo = $row['Fecha_Consumo'];
                }else{
                    $fechaConsumo = $_GET['fechaConsumo'];
                }

                if(empty($_GET['precio'])){
                    $precio = $row['Precio'];
                }else{
                    $precio = $_GET['precio'];
                }

                if(empty($_GET['observaciones'])){
                    $observaciones = $row['Observaciones'];
                }else{
                    $observaciones = $_GET['observaciones'];
                }
                
            }else{
                echo "No se ha encontrado ninguna cerveza con ese id";
            }

            $denominacion = $_GET['denominacion'];
            $marca = $_GET['marca'];
            $tipo = $_GET['tipo'];
            $formato = $_GET['formato'];
            $embase = $_GET['embase'];
            $alergenos = $_GET['alergenos'] ?? []; //las ?? hace que si no hay nada en alergenos, se envíe un array vacío
            $fechaConsumo = $_GET['fechaConsumo'];
            $precio = $_GET['precio'];
            $observaciones = $_GET['Observaciones'] ?? ''; //las ?? hace que si no hay nada en observaciones, se envíe un string vacío
            
            $sql = "UPDATE `cervezas` SET 
                `Denominacion_Cerveza`='$denominacion',
                `Marca`='$marca',
                `Tipo_Cerveza`='$tipo',
                `Formato`='$formato',
                `Tamanyo`='$embase',
                `Alergenos`='$alergenos',
                `Fecha_Consumo`='$fechaConsumo',
                `Precio`='$precio',
                `Observaciones`='$observaciones' 
                WHERE `Id_Cerveza`='$name'";
                
            $result = $conn->query($sql);
            echo "Cerveza actualizada correctamente";
        }
    }
    
        $conn->close();
    
        /*MODIFICAR: MOSTRAR MISMO FORMULARIO QUE INSERTAR PERO SIN TENER QUE RELLENAR TODO, LOS CAMPOS INTRODUCIDOS SE ACTUALIZARÁN EN BBDD */
    ?>

    <div id="formularioModificar">
        <form action="" method="post" enctype="multipart/form-data">
            <div class="par">
                <label for="denominacion" class=titulo>Denominación cerveza:</label>
                <input type="text" id="denominacion" name ="denominacion"><br><br>
            </div>
            
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
            
            <br><br>
            
            <label for="fechaConsumo" class="titulo" name="fechaConsumo">Fecha Consumo: </label>
            <input type="date" name="fechaConsumo" id="fechaConsumo">
    
            <br><br>
            
            <label for="Imagen" id="Imagen" class="titulo" name="Imagen">Fotos</label>
            <input type="file" name="Imagen"/>
            <br><br>
    
            <label for="precio" class="titulo">Precio: </label>
            <input type="text" name="precio">€
            
            <?php if(isset($_GET['precio']) && !is_numeric($_GET['precio'])){
                echo "<p class='error'>¡El precio debe ser un valor numérico y no puede estar vacío!</p>";
            }
            ?>
            <br><br>
    
            <label for="Observaciones" class="titulo" name="Observaciones">Observaciones</label>
            <textarea rows="4" cols="50" name="Observaciones"></textarea>
            <br><br>   
    
            <input type="submit" name="submit" value="Modificar Cerveza">
        </form>
    </div>
</body>
</html>