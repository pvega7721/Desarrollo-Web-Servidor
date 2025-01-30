<?php
    session_start();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        .login-container {
            margin: 0 auto;
            display: flex;
            flex-direction: column;
            align-content: center;
            background: white;
            padding: 50px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .login-container h2 {
            margin-bottom: 20px;
        }
        .login-container input {
            align-self: center;
            width: 80%;
            padding: 10px;
            margin: 10px 10px 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;

        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Iniciar Sesión</h1>
        <form action="" method="post">
            <input type="text" name="usuario" placeholder="Usuario">
            <input type="password" name = "contraseña" placeholder="Contraseña">
            <button type="submit">Entrar</button>
        </form>
    </div>
</body>
</html>

<?php 
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "cerveceria";
    
    $conn = new mysqli($servername, $username, $password, $dbname);
    echo "ejemplo";

    if($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    if($_SERVER["REQUEST_METHOD"] == "POST") {
        $usuario = $_POST["usuario"];
        $contrasena = $_POST["contraseña"];

        if($_SERVER["REQUEST_METHOD"] == "POST") {
            $correo = $_POST["usuario"];
            $contrasena = $_POST["contraseña"];
        }
        if(($correo == '') || ($contrasena == '')){
            echo "Debes introducir todos los campos";
        }else{
            $sql = "SELECT `Correo`, `Password`, `Perfil` FROM `usuario` WHERE `Correo` LIKE '$correo' AND `Password` LIKE '$contrasena'";
            $resultado  = $conn->query($sql);
        }

        if($resultado -> num_rows > 0){
            $row = $resultado->fetch_assoc();

            if($row['Perfil'] == 'administrador'){
            $_SESSION ['admin'] = true;
            }else{
                $_SESSION ['admin'] = false;
            }
            header("Location: cerveceria.php");
        }else{
            echo "</br>No hay resultados";
        }
    }
    $conn->close();
        ?>