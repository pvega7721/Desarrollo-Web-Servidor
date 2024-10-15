<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Precio medio</title>
  </head>
  <body>
    <h2>Introduce el precio de las tres tiendas</h2>
    <form action="#">
      <p>
        Introduza el precio del producto en el establecimiento número 1, en
        euros: <input type="text" name="Tienda_1" method="post" />
      </p>
      <p>
        Introduza el precio del producto en el establecimiento número 2, en
        euros: <input type="text" name="Tienda_2" method="post" />
      </p>
      <p>
        Introduza el precio del producto en el establecimiento número 3, en
        euros: <input type="text" name="Tienda_3" method="post" />
      </p>
      <p><input type="submit" value="Calcular" /></p>
    </form>

    <?php
    error_reporting(error_level: 0);
    $tienda1 = $_REQUEST["Tienda_1"];
    $tienda2 = $_REQUEST["Tienda_2"];
    $tienda3 = $_REQUEST["Tienda_3"];
    $precioMedio = ($tienda1 + $tienda2 + $tienda3) /3;
    echo $precioMedio
    ?>
  </body>
</html>
