<?php
    session_start();
    /*Verifica que el método del formulario de la página1 sea Post
    isset comprueba que el formulario tenga datos
    */
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero4'])){
        $_SESSION['numero4'] = $_POST['numero4'];
    }
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quinto número</title>
</head>
<body>
    <form action="Pagina6.php" method="post">
        <label for="numero5">Introduce el quinto número:</label>
        <input type="text" name="numero5">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>