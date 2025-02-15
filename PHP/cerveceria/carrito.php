<?php
session_start();
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['vaciarCarrito'])) {
    $_SESSION['carrito'] = [];
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito</title>
</head>

<body>
    <a href="seleccionUser.php">Volver al menú</a>
    <a href="catalogo.php">Volver al catálogo</a>
    <h1>Carrito</h1>

    <?php
    if (isset($_SESSION['carrito']) && !empty($_SESSION['carrito'])) {

        //aseguramos que cada cerveza tenga una cantidad (para evitar undefined array key)
        foreach ($_SESSION['carrito'] as $key => $cervezaEnCarrito) {
            if (!isset($_SESSION['carrito'][$key]['cantidad'])) {
                $_SESSION['carrito'][$key]['cantidad'] = 1;
            }

        }

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
                <th>Cantidad</th>
                <th>Total</th>
            </tr>
        ";

        $precioTotal = 0;
        foreach ($_SESSION['carrito'] as $cervezaEnCarrito) {
            echo "<tr>";
            print "<td>" . $cervezaEnCarrito['Denominacion_Cerveza'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Marca'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Tipo_Cerveza'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Formato'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Tamanyo'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Alergenos'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Fecha_Consumo'] . "</td>";
            print "<td><img src='" . $cervezaEnCarrito['Foto'] . "' width = '100'></td>";
            print "<td>" . $cervezaEnCarrito['Precio'] . "</td>";
            print "<td>" . $cervezaEnCarrito['Observaciones'] . "</td>";
            print "<td>" . $cervezaEnCarrito['cantidad'] . "</td>";
            $totalItem = $cervezaEnCarrito['cantidad'] * $cervezaEnCarrito['Precio'];
            print "<td>" . $totalItem . "€</td>";
            echo "</tr>";
            $precioTotal += $totalItem;
        }
        echo "<tr>";
        print "<td colspan='11'>Precio total:</td>";
        print "<td>" . $precioTotal . "€</td>";
        echo "</tr>";
        print "</table>";

        echo "<form action='' method='post'>
                <button type='submit' name='vaciarCarrito'>Vaciar carrito</button>
            </form>";

    } else {
        echo "El carrito está vacío";
    }
    echo "<a href='ticket.php'>Finalizar compra</a>";
    ?>

</body>

</html>