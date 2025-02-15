<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catálogo</title>
</head>

<body>
    <a href="seleccionUser.php">Volver al menú</a>
    <a href="carrito.php">Ver carrito</a>
    <h1>Catalogo usuario</h1>
    <?php
    $servername = "127.0.0.1:3308";
    $username = "root";
    $password = "";
    $dbname = "cerveceria";

    $conn = new mysqli($servername, $username, $password, $dbname);

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    foreach ($_POST as $name => $value) {
        //$name es el id de la cerveza
        $consulta = "SELECT * FROM cervezas WHERE Id_Cerveza = $name";
        $resultado = $conn->query($consulta);

        if ($resultado->num_rows == 1) { //si encuentra una cerveza con ese id, guarda lo que devuelva la consulta en un array
            $cerveza = mysqli_fetch_array($resultado);
        }

        if (!isset($_SESSION['carrito'])) {
            $_SESSION['carrito'] = [];
        }

        //Si la cerveza ya está en el carrito, incremento la cantidad
        $cervezaEncontrada = false;
        foreach ($_SESSION['carrito'] as $key => $itemCarrito) {
            if ($itemCarrito['Id_Cerveza'] == $name) {
                $_SESSION['carrito'][$key]['cantidad']++;
                $cervezaEncontrada = true;
                break;
            }
        }
        //Si no hay ninguna cerveza con ese id en el carrito, añade la primera
        if (!$cervezaEncontrada) {
            $cerveza['cantidad'] = 1;
            $_SESSION['carrito'][] = $cerveza; //guardo la cerveza en el carrito
        }
        echo "Cerveza añadida al carrito";
    }



    $sql = "SELECT * FROM cervezas";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        echo "
        <table border='1'>
            <tr>
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

        while ($row = mysqli_fetch_array($result)) {
            echo "<tr>";
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
            print "<td>
                        <form action='' method='post'>
                            <button type='submit' name='" . $row['Id_Cerveza'] . "'>Añadir al carrito</button>
                        </form>
                    </td>";
            echo "</tr>";
        }

        echo "</table>";
    } else {
        echo "No hay cervezas en el catálogo";
    }

    $conn->close();

    ?>
</body>

</html>