<?php
    session_start();
    /*Verifica que el método del formulario de la página1 sea Post
    isset comprueba que el formulario tenga datos
    */
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero3'])){
        $_SESSION['numero3'] = $_POST['numero3'];
    }
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cuarto número</title>
</head>
<body>
    <form action="Pagina5.php" method="post">
        <label for="numero4">Introduce el cuarto número:</label>
        <input type="text" name="numero4">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>