    <?php
    session_start();
    /*Verifica que el método del formulario de la página1 sea Post
    isset comprueba que el formulario tenga datos
    */
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero1'])){
        $_SESSION['numero1'] = $_POST['numero1'];
    }
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Segundo número</title>
</head>
<body>
    <form action="Pagina3.php" method="post">
        <label for="numero2">Introduce el segundo número:</label>
        <input type="text" name="numero2">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>