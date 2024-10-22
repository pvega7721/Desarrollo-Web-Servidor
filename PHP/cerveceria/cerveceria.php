<!DOCTYPE html>
<html lang="en">
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
        }
        .titulo{
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Inserción de Cervezas</h1>
    <p>Introduzca los datos de las Cervecerías</p>

    <form action="mostrarDatos.php" method="post">
        <label for="tipoCerveza" id="titulo" >Tipo de Cerveza:</label>
        <select name="tipoCerveza" id="tipoCerveza">
            <option value="Lager">Lager</option>
            <option value="Pale Lager">Pale Lager</option>
            <option value="Marzen">Marzen</option>
            <option value="Bock">Bock</option>
            <option value="American Lager">American Lager</option>
            <option value="Ale">Ale</option>
            <option value="Pale Ale">Pale Ale</option>
            <option value="IPA">IPA</option>
            <option value="Bitter">Bitter</option>
            <option value="Brown Ale">Brown Ale</option>
            <option value="Porter">Porter</option>
            <option value="Stout">Stout</option>
            <option value="Trapenses">Trapenses</option>
            <option value="Abadia">Abadia</option>
            <option value="Weisbier">Weisbier</option>
            <option value="Witbier">Witbier</option>
        </select>
        <br><br>
        <label for="Denominación"id="titulo">Denominación del alimento:</label>
        <select name="Denominación" id="Denominación">
            <option value="Lata 33cl">Lata 33cl</option>
            <option value="Tercio">Tercio</option>
            <option value="Botellin">Botellin</option>
            <option value="Medio Litro">Medio Litro</option>
            <option value="Litro">Litro</option>
        </select>
        <br><br>

        <label id="titulo">Tipo de Embase: </label> 
        <input type="radio" name="embase" id="botellin" value="botellin">
        <label for="botellin">botellin</label>

        <input type="radio" name="embase" id="tercio" value="tercio">
        <label for="tercio">tercio</label>

        <input type="radio" name="embase" id="medioLitro" value="medioLitro">
        <label for="medioLitro">1/2 Litro</label>
        
        <input type="radio" name="embase" id="Litro" value="Litro">
        <label for="Litro">Litro</label>

        <input type="radio" name="embase" id="Lata" value="Lata">
        <label for="Lata">Lata</label>
        <br><br>

        <label for="CantidadNeta" id="titulo">Cantidad neta:</label>
        <select name="CantidadNeta" id="Denominación">
            <option value="25cl">25cl</option>
            <option value="33cl">33cl</option>
            <option value="1 Litro">1 Litro</option>
            <option value="1/2 Litro">1/2 Litro</option>
            <option value="2 Litros">2 Litros</option>
            <option value="Barril 25 Litros">Barril 25 Litros</option>
        </select>
        <br><br>

        <label for="marcaProducto" id="titulo">Marca del Producto:</label>
        <input type="text" id="marcaProducto" name="marcaProducto">
        <br><br>

        <label for="abusoConsumo" id="titulo" name="abusoConsumo">Advertencia sobre el abuso en el consumo de alcohol:</label>
        <input type="text" id="abusoConsumo" name="abusoConsumo">
        <br><br>
        
        <label for="fechaConsumo" id="titulo" name="fechaConsumo">Fecha de Consumo Preferente:</label>
        <input type="date" name="fechaConsumo" id="fechaConsumo">
        <br><br>

        <label for="alergenos" id="titulo" name="alergeno">Indicar sustancias que pueden causar alergias:</label>
        <input type="checkbox" name="alergeno" id="Gluten" value="Gluten">
        <label for="Gluten">Gluten</label>

        <input type="checkbox" name="alergeno" id="Huevo" value="Huevo">
        <label for="Huevo" name="alergeno">Huevo</label>

        <input type="checkbox" name="alergeno" id="Cacahuete" value="Cacahuete">
        <label for="Cacahuete" name="alergeno">Cacahuete</label>

        <input type="checkbox" name="alergeno" id="Soja" value="Soja">
        <label for="Soja" name="alergeno">Soja</label>

        <input type="checkbox" name="alergeno" id="Lacteo" value="Lacteo">
        <label for="Lacteo" name="alergeno">Lacteo</label>

        <input type="checkbox" name="alergeno" id="Sulfitos" value="Sulfitos">
        <label for="Sulfitos" name="alergeno">Sulfitos</label>

        <input type="checkbox" name="alergeno" id="Frutos Con Cascara" value="Frutos Con Cascara">
        <label for="Frutos Con Cascara " name="alergeno">Frutos Con Cascara</label>

        <input type="checkbox" name="alergeno" id="Sin Alergenos" value="Sin Alergenos">
        <label for="Sin Alergenos" name="alergeno">Sin Alergenos</label>
        <br><br>

        <label for="Observaciones" id="titulo" name="Observaciones">Observaciones</label>
        <textarea rows="4" cols="50" name="Observaciones"></textarea>
        <br><br>   

        <label for="Imagen" id="Imagen" name="Imagen">Inserta una imagen</label>
        <input type="file" name="Imagen"/>
        <br><br>   

        <input type="submit" value="Insertar Cerveza">
    </form>
</body>
</html>