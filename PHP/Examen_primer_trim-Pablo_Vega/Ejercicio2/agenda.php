<?php
session_start();
//Array para guardar los contactos (con session para que se guarde al recargar)
if (!isset($_SESSION['agenda'])) {
    $_SESSION['agenda'] = array();
}
$agenda = $_SESSION['agenda'];//guarda en la variable local los datos de la sesión

$nombre = $_POST['nombre'];
$telefono = $_POST['telefono'];
    

//si faltan datos, se mostrará un mensaje indicándolo
if($nombre == "" && $telefono == ""){
    echo "<p class= 'error'>No ha introducido datos</p>";
    
}elseif($nombre == ""){
    echo "<p class= 'error'>Falta el nombre</p>";

}elseif(!isset($agenda[$nombre]) && $telefono != ""){
    //si el nombre introducido no estaba en la agenda e introduce un número, se añade a la agenda
    $agenda[$nombre] = $telefono;

}elseif(isset($agenda[$nombre]) && $telefono != ""){
    //si el nombre ya existe y se indica un teléfono, se actualiza el teléfono.
    $agenda[$nombre] = $telefono;

}elseif(isset($agenda[$nombre])&& $telefono == ""){
    //Si el nombre ya existe y no se indica número, se elimina.
    unset($agenda[$nombre]);

}
//hace falta para asegurar que los datos se guardan al recargar, sino se borrará la tabla cada vez que se recargue la página
$_SESSION['agenda'] = $agenda;

?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda</title>
    <style>
        /* Estilos para que la tabla se vea bien*/
        table {
            width: 50%;
            border-collapse: collapse; 
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <h1>Listín Telefónico:</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Teléfono</th>
        </tr>
        <?php
        //array para que la tabla se genere con los datos introducidos
        foreach ($agenda as $nombre => $telefono) {
            echo "<tr>";
            echo "<td>$nombre</td>";
            echo "<td>$telefono</td>";
            echo "</tr>";
        }
        ?>
    </table>

    <form action="#" method="post">
    <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br><br>

        <label for="telefono">Teléfono:</label>
        <input type="tel" id="telefono" name="telefono"><br><br>

        <button type="submit">Enviar</button>
    </form>
</body>
</html>
