<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>¿Qué quieres hacer?</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        .opciones {
            display: flex;
            gap: 30px;
        }
        .opciones a {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 18px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            color: #fff;
            background-color: #3498db;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        .opciones a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <a href="login.php">Volver al login</a>
    <h1>¿Qué quieres hacer?</h1>
    <div class="opciones">
        <a href="insertarCervezas.php">Insertar cerveza</a>
        <a href="catalogoAdmin.php">Modificar/Eliminar cerveza</a>
    </div>
</body>
</html>