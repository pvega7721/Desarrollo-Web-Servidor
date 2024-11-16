<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora IMC</title>
</head>
<body>
    <h1>Índice de masa corporal (Formulario)</h1>
    <p>Escriba su peso en kilogramos y su altura en centímetros para calcular su índice de masa corporal.</p>
    <form action="MostrarDatos.php" method="post">
        <label for="peso">Peso:</label>
        <input type="number" step="0.1" name="peso"> kg <br><br>
        <label for="altura">Altura:</label> 
        <input type="number" step="0.1" name="altura"> cm <br> <br>
        <input type="submit" value="Calcular">
        <input type="reset" value="Borrar">
    </form>
</body>
</html>