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
    
        $sql = "SELECT * FROM cervezas";
        $result = $conn->query($sql);
    if($result->num_rows > 0){
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

        while($row = mysqli_fetch_array($result)) {
            echo "<tr>";
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
                print "<td><input type='button' value='Añadir al carrito'></td>";
            echo "</tr>";
        }

        echo "</table>";
    } else{
        echo "No hay cervezas en el catálogo";
    }

        $conn->close();
    
    ?>
</body>
</html>