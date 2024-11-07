    <?php
    session_start();
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Primer número</title>
</head>
<body>
    <form action="Pagina2.php" method="post">
        <label for="numero1">Introduce el primer número:</label>
        <input type="text" name="numero1" id="numero1">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>