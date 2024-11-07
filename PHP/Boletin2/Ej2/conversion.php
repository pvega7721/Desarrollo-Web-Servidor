<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversión de variables</title>
</head>
<style>
    #contenedor{
        display:flex;
        justify-content: space-around;
        margin-top: 5%
    }
</style>
<body>
    <div id="contenedor">

        <div class="php">
            <?php 
            $var = null;
            $varTrue = !$var; //Pasa var a true
            echo "Null pasada a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "Null pasada a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "Null pasada a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "Null pasada a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "Null pasada a String: " . $varString;
            ?>
        </div>

        <div class="php">
            <?php 
            $var = true;
            $varTrue = !$var; //Pasa var a true
            echo "True pasada a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "True pasada a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "True pasada a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "True pasada a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "True pasada a String: " . $varString;
            ?>
        </div>

        <div class="php">
            <?php 
            $var = false;
            $varTrue = !$var; //Pasa var a true
            echo "False pasado a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "False pasado a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "False pasado a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "False pasado a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "False pasado a String: " . $varString;
            ?>
        </div>
        <div class="php">
            <?php 
            $var = 0;
            $varTrue = !$var; //Pasa var a true
            echo "Entero pasado a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "Entero pasado a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "Entero pasado a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "Entero pasado a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "Entero pasado a String: " . $varString;
            ?>
        </div>
        <div class="php">
            <?php 
            $var = 3.8;
            $varTrue = !$var; //Pasa var a true
            echo "Float pasado a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "Float pasado a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "Float pasado a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "Float pasado a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "Float pasado a String: " . $varString;
            ?>
        </div>
        <div class="php">
            <?php 
            $var = '6 metros';
            $varTrue = !$var; //Pasa var a true
            echo "String pasado a true: " . $varTrue . "<br>";

            $varFalse = !!$var;//Pasa var a false
            echo "String pasado a false: " . $varFalse . "<br>";    

            $varInt = (int) $var;//Pasa var a int
            echo "String pasado a entero: " . $varInt . "<br>";

            $varFloat = (float) $var;//Pasa var a float
            echo "String pasado a float: " . $varFloat . "<br>";
            
            $varString = (string) $var;//Pasa var a String
            echo "String pasado a String: " . $varString;
            ?>
        </div>

    </div>
    

</body>
</html>