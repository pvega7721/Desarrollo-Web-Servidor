<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario básico</title>
</head>
<body>
    <form action="mostrarDatos.php" method="post">
        <label>Nombre</label>
        <input type="text"  name="nombre"><br><br>
        <label>Edad</label>
        <input type="text" name="edad"><br><br>
        <label>E-mail</label>
        <input type="email" name="correo"><br><br>
        <input type="submit" value="Enviar">
        <input type="reset" value="Limpiar">
    </form>
</body>
</html>