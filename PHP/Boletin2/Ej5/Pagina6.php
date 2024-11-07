    <?php
    session_start();
    /*Verifica que el método del formulario de la página1 sea Post
    isset comprueba que el formulario tenga datos
    */
    if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['numero5'])){
        $_SESSION['numero5'] = $_POST['numero5'];
    }
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sexto número</title>
</head>
<body>
    <form action="MostrarDatos.php" method="post">
        <label for="numero6">Introduce el sexto número:</label>
        <input type="text" name="numero6">
        <input type="submit" value="Siguiente número">
    </form>
</body>
</html>