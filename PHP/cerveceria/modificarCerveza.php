<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Cerveza</title>
</head>

<body>
    <a href="seleccionAdmin.php">Volver al menú</a>
    <h1>Modificar cervezas</h1>
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
    if ($result->num_rows > 0) {
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
            </tr>
        ";

        while ($row = mysqli_fetch_array($result)) {
            echo "<tr>";
            print "<td>" . $row['Id_Cerveza'] . "</td>";
            print "<td>" . $row['Denominacion_Cerveza'] . "</td>";
            print "<td>" . $row['Marca'] . "</td>";
            print "<td>" . $row['Tipo_Cerveza'] . "</td>";
            print "<td>" . $row['Formato'] . "</td>";
            print "<td>" . $row['Tamanyo'] . "</td>";
            print "<td>" . $row['Alergenos'] . "</td>";
            print "<td>" . $row['Fecha_Consumo'] . "</td>";
            print "<td><img src='" . $row['Foto'] . "' width = '100'></td>";
            print "<td>" . $row['Precio'] . "</td>";
            print "<td>" . $row['Observaciones'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
    } else {
        echo "No hay cervezas en el catálogo";
    }
    ?>
    <form action="" method="POST" enctype="multipart/form-data">
        <h2>Datos de la cerveza a modificar</h2>
        <div class="par">
            <label for="id">Introduce el id de la cerveza a modificar: </label>
            <input type="text" name="id">
        </div>
        <div class="par">
            <label for="denominacion" class=titulo>Denominación cerveza:</label>
            <input type="text" id="denominacion" name="denominacion"><br><br>
        </div>

        <label for="marca" class="titulo">Marca:</label>
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
        <input type="file" name="Imagen" />
        <br><br>

        <label for="precio" class="titulo">Precio: </label>
        <input type="text" name="precio">€

        <?php if (isset($_GET['precio']) && !is_numeric($_GET['precio'])) {
            echo "<p class='error'>¡El precio debe ser un valor numérico y no puede estar vacío!</p>";
        }
        ?>
        <br><br>

        <label for="Observaciones" class="titulo" name="Observaciones">Observaciones</label>
        <textarea rows="4" cols="50" name="Observaciones"></textarea>
        <br><br>

        <input type="submit" name="submit" value="Modificar Cerveza">
    </form>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $idCerveza = $_POST["id"];
        $sql = "SELECT * FROM cervezas WHERE Id_Cerveza = $idCerveza";
        $result = $conn->query($sql);

        if ($result->num_rows == 0) {
            echo "No hay cervezas con ese id";

        } else {
            $row = mysqli_fetch_array($result);

            if (empty($_POST["denominacion"])) {
                $denominacion = $row["Denominacion_Cerveza"];
            } else {
                $denominacion = $_POST["denominacion"];
            }

            if (empty($_POST["marca"])) {
                $marca = $row["Marca"];
            } else {
                $marca = $_POST["marca"];
            }

            if (empty($_POST["tipo"])) {
                $tipo = $row["Tipo_Cerveza"];
            } else {
                $tipo = $_POST["tipo"];
            }

            if (empty($_POST["formato"])) {
                $formato = $row["Formato"];
            } else {
                $formato = $_POST["formato"];
            }

            if (empty($_POST["embase"])) {
                $embase = $row["Tamanyo"];
            } else {
                $embase = $_POST["embase"];
            }

            if (empty($_POST["alergenos"])) {
                $alergenos = $row["Alergenos"];

            } else {
                $alergenos = $conn->real_escape_string(implode(", ", $_POST["alergenos"]));
            }

            if (empty($_POST["fechaConsumo"])) {
                $fechaConsumo = $row["Fecha_Consumo"];
            } else {
                $fechaConsumo = $_POST["fechaConsumo"];
            }

            if (empty($_POST["precio"])) {
                $precio = $row["Precio"];
            } else {
                $precio = $_POST["precio"];
            }

            if (empty($_POST["Observaciones"])) {
                $observaciones = $row["Observaciones"];
            } else {
                $observaciones = $_POST["Observaciones"];
            }

            if (empty($_FILES["Imagen"]["name"])) {
                $foto = $row["Foto"];
            } else {
                $foto = $_FILES["Imagen"]["name"];
                $ruta = "imagenes/" . $foto;
                move_uploaded_file($_FILES["Imagen"]["tmp_name"], $ruta);
            }

            $sql = "UPDATE cervezas SET Denominacion_Cerveza = '$denominacion', Marca = '$marca', Tipo_Cerveza = '$tipo', Formato = '$formato', Tamanyo = '$embase', Alergenos = '$alergenos', Fecha_Consumo = '$fechaConsumo', Foto = '$foto', Precio = '$precio', Observaciones = '$observaciones' WHERE Id_Cerveza = $idCerveza";
            $conn->query($sql); //Ejecuta la consulta
    
            echo "Cerveza modificada correctamente";

        }
    }
    $conn->close();

    ?>
</body>

</html>