<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cervecería</title>
    
    <style>
        h1{
            color: blue;
        }
        form{
            border: 1px solid;
            padding: 5px;
            margin-right: 40%;
            width: 80%;
        }
        .titulo{
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Inserción de Cervezas</h1>
    <p>Introduzca los datos de la Cerveza:</p>

    <form action="mostrarDatos.php" method="post" enctype="multipart/form-data">

        <label for="denominacion" class=titulo>Denominación cerveza:</label>
        <input type="text" id="denominacion" name ="denominacion"><br><br>

        <label for="marca" class="titulo" >Marca:</label>
        <select name="marca" id="marca">
            <option value="Heiniken">Heiniken</option>
            <option value="Mahou">Mahou</option>
            <option value="DAM">DAM</option>
            <option value="Estrella Galicia">Estrella Galicia</option>
            <option value="Alhambra">Alhambra</option>
            <option value="Cruzcampo">Cruzcampo</option>
            <option value="Artesana">Artesana</option>
        </select>

        <br><br>        
        
        <label for="tipo" class="titulo">Tipo de cerveza:</label>

        <input type="radio" name="tipo" id="larger" value="larger">
        <label for="larger">LARGER</label>

        <input type="radio" name="tipo" id="paleale" value="paleale">
        <label for="paleale">PALE ALE</label>
        
        <input type="radio" name="tipo" id="cerveza_negra" value="cerveza_negra">
        <label for="cerveza_negra">CERVEZA NEGRA</label>
        
        <input type="radio" name="tipo" id="abadia" value="abadia">
        <label for="abadia">ABADIA</label>
        
        <input type="radio" name="tipo" id="rubia" value="rubia">
        <label for="rubia">RUBIA</label>

        <br><br>

        <label for="formato" class="titulo">Formato:</label>
        <select name="formato" id="formato">
            <option value="Lata">Lata</option>
            <option value="Botella">Botella</option>
            <option value="Pack">Pack</option>
        </select>
        
        <br><br>
        
        <label for="embase" class="titulo">Tamaño: </label>
        <select name="embase" id="embase">
            <option value="botellin">Botellín</option>
            <option value="tercio">Tercio</option>
            <option value="medioLitro">Media</option>
            <option value="Litro">Litrona</option>
            <option value="Lata">Pack</option>
        </select>
        
        <br><br>

        <label for="alergenos[]" class="titulo" name="alergenos[]">Alérgenos:</label>
        <input type="checkbox" name="alergenos[]" id="Gluten" value="Gluten">
        <label for="Gluten">Gluten</label>

        <input type="checkbox" name="alergenos[]" id="Huevo" value="Huevo">
        <label for="Huevo">Huevo</label>

        <input type="checkbox" name="alergenos[]" id="Cacahuete" value="Cacahuete">
        <label for="Cacahuete">Cacahuete</label>

        <input type="checkbox" name="alergenos[]" id="Soja" value="Soja">
        <label for="Soja">Soja</label>

        <input type="checkbox" name="alergenos[]" id="Lacteo" value="Lacteo">
        <label for="Lacteo">Lacteo</label>

        <input type="checkbox" name="alergenos[]" id="Sulfitos" value="Sulfitos">
        <label for="Sulfitos">Sulfitos</label>

        <input type="checkbox" name="alergenos[]" id="Sin Alergenos" value="Sin Alergenos">
        <label for="Sin Alergenos">Sin Alergenos</label>
        <br><br>
        
        <label for="fechaConsumo" class="titulo" name="fechaConsumo">Fecha Consumo: </label>
        <input type="date" name="fechaConsumo" id="fechaConsumo">
        <br><br>
        
        <label for="Imagen" id="Imagen" class="titulo" name="Imagen">Fotos</label>
        <input type="file" name="Imagen"/>
        <br><br>

        <label for="precio" class="titulo">Precio: </label>
        <input type="text">€
        
        <br><br>

        <label for="Observaciones" class="titulo" name="Observaciones">Observaciones</label>
        <textarea rows="4" cols="50" name="Observaciones"></textarea>
        <br><br>   


        <input type="submit" value="Insertar Cerveza">
    </form>
</body>
</html>