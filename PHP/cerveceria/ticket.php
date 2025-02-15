<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gracias por su compra!</title>
</head>

<body>
    <a href="seleccionUser.php">Volver al menú</a>
    <a href="carrito.php">Volver al carrito</a>

    <h1>Ticket de compra</h1>
    <p>Estos son los productos que ha comprado:</p>

    <?php
    if (isset($_SESSION['carrito']) && !empty($_SESSION['carrito'])) {
        echo "<table border='1'>";
        echo "<thead>";
        echo "<tr>";
        echo "<th>Producto</th>";
        echo "<th>Cantidad</th>";
        echo "<th>Precio unitario</th>";
        echo "<th>Precio total</th>";
        echo "</tr>";
        echo "</thead>";
        echo "<tbody>";
        $precioTotalTicket = 0;

        foreach ($_SESSION['carrito'] as $cervezaTicket) {
            echo "<tr>";
            echo "<td>" . $cervezaTicket['Denominacion_Cerveza'] . "</td>";
            echo "<td>" . $cervezaTicket['cantidad'] . "</td>";
            echo "<td>" . $cervezaTicket['Precio'] . "€</td>";
            $subtotal = $cervezaTicket['cantidad'] * $cervezaTicket['Precio'];
            echo "<td>" . $subtotal . "€</td>";
            echo "</tr>";
            $precioTotalTicket += $subtotal;
        }
        echo "</tbody>";
        echo "</table>";

        echo "<p>Precio total de la compra: " . $precioTotalTicket . "€</p>";
    } else {
        echo "<p>El carrito está vacío</p>";
    }
    ?>
    <p>Gracias por su compra!</p>
</body>

</html>