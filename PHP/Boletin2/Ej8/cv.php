<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Curriculum vitae</title>
</head>
<body>
    <form action="mostrarDatos.php" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br><br>

        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos"><br><br>

        <label for="sexo">Sexo:</label>
        <input type="radio" id="hombre" name="sexo" value="hombre" > Hombre
        <input type="radio" id="mujer" name="sexo" value="mujer" > Mujer <br><br>

        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" name="correo"><br><br>

        <label for="contacto">Número de contacto:</label>
        <input type="text" id="contacto" name="contacto"><br><br>

        <label>Experiencia laboral:</label>
        <textarea rows="6" cols="30" name="experiencia" id="experiencia"></textarea><br>

        <label for="estudios">Estudios:</label>
        <textarea rows="6" cols="30" name="Estudios"></textarea><br><br>

        <label for="jornada">Jornada laboral:</label>
        <select id="jornada" name="jornada">
            <option value="indiferente">Indiferente</option>
            <option value="mañana">Mañana</option>
            <option value="tarde">Tarde</option>
        </select><br><br>

        <label for="idiomas">Idiomas:</label>
        <input type="checkbox" id="ingles" name="idiomas[]" value="ingles">
        <label for="ingles">Inglés</label>
        <input type="checkbox" id="frances" name="idiomas[]" value="frances">
        <label for="frances">Francés</label>
        <input type="checkbox" id="aleman" name="idiomas[]" value="aleman">
        <label for="aleman">Alemán</label>
        <input type="checkbox" id="otro" name="idiomas[]" value="otro">
        <label for="otro">Otros</label><br><br>

        <button type="submit">Enviar</button>
        <button type="reset">Limpiar</button>
    </form>

    
</body>
</html>