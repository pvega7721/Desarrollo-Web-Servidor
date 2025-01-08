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

    <form action="mostrarDatos.php" method="post" enctype="multipart/form-data">
        <label for="tipoCerveza" class="titulo">Tipo de Cerveza:</label>
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
        <label for="Denominación" class="titulo">Denominación del alimento:</label>
        <select name="Denominación" id="Denominación">
            <option value="Lata 33cl">Lata 33cl</option>
            <option value="Tercio">Tercio</option>
            <option value="Botellin">Botellin</option>
            <option value="Medio Litro">Medio Litro</option>
            <option value="Litro">Litro</option>
        </select>
        <br><br>

        <label class="titulo">Tipo de Embase: </label> 
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

        <label for="CantidadNeta" class="titulo">Cantidad neta:</label>
        <select name="CantidadNeta" id="Denominación">
            <option value="25cl">25cl</option>
            <option value="33cl">33cl</option>
            <option value="1 Litro">1 Litro</option>
            <option value="1/2 Litro">1/2 Litro</option>
            <option value="2 Litros">2 Litros</option>
            <option value="Barril 25 Litros">Barril 25 Litros</option>
        </select>
        <br><br>

        <label for="marcaProducto" class="titulo">Marca del Producto:</label>
        <input type="text" id="marcaProducto" name="marcaProducto">
        <br><br>

        <label for="abusoConsumo" class="titulo" name="abusoConsumo">Advertencia sobre el abuso en el consumo de alcohol:</label>
        <input type="text" id="abusoConsumo" name="abusoConsumo">
        <br><br>
        
        <label for="fechaConsumo" class="titulo" name="fechaConsumo">Fecha de Consumo Preferente:</label>
        <input type="date" name="fechaConsumo" id="fechaConsumo">
        <br><br>

        <label for="alergenos[]" class="titulo" name="alergenos[]">Indicar sustancias que pueden causar alergias:</label>
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

        <input type="checkbox" name="alergenos[]" id="Frutos Con Cascara" value="Frutos Con Cascara">
        <label for="Frutos Con Cascara">Frutos Con Cascara</label>

        <input type="checkbox" name="alergenos[]" id="Sin Alergenos" value="Sin Alergenos">
        <label for="Sin Alergenos">Sin Alergenos</label>
        <br><br>

        <label for="Observaciones" class="titulo" name="Observaciones">Observaciones</label>
        <textarea rows="4" cols="50" name="Observaciones"></textarea>
        <br><br>   

        <label for="Imagen" id="Imagen" name="Imagen">Inserta una imagen</label>
        <input type="file" name="Imagen"/>
        <br><br>   

        <input type="submit" value="Insertar Cerveza">
    </form>
</body>
</html>