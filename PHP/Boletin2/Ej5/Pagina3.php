    <?php
    session_start();
    /*Verifica que el método del formulario de la página1 sea Post
    isset comprueba que el formulario tenga datos
    */
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero2'])){
        $_SESSION['numero2'] = $_POST['numero2'];
    }
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tercer número</title>
</head>
<body>
    <form action="Pagina4.php" method="post">
        <label for="numero3">Introduce el tercer número:</label>
        <input type="text" name="numero3">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>