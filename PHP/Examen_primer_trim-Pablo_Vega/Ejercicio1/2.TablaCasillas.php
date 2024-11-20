<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla con casillas</title>
</head>
<body>
    <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (FORMULARIO2)</h1>
    <p>Marque las casillas de verificación que quiera y contaré cuantas ha marcado</p>
    <form action="3.MostrarDatos.php" method="post">
        <table>
            <tr>

        <?php
            session_start(); //Recupera la sesión que creamos en el primer php
            //guardamos el tamaño de la tabla en la sesión y en la variable local
            $_SESSION["tamanyo"] = $_POST["tamanyo"]; 
            $tamanyo = $_SESSION["tamanyo"];

            //bucle que crea los checkboxes
            for ($i = 1; $i <= $tamanyo; $i++) {
                echo "<td><input type='checkbox' name='checkboxes[]' value='$i'> $i</td>";
            }
        ?>
            </tr>
        </table>
        <input type="submit" value="Contar">
        <input type="reset" value="Borrar"><br>
        <a href="1.SolicitarDatos.php">Volver al formulario</a>
    </form>
</body>
</html>