<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos CV</title>
</head>
<body>
    <h1>Curriculum Vitae</h1>
    <p>Nombre: <?php echo $_REQUEST["nombre"] ?> </p>
    <p>Apllidos: <?php echo $_REQUEST["apellidos"] ?> </p>
    <p>Sexo: <?php echo $_REQUEST["sexo"] ?> </p>
    <p>Correo electrónico: <?php echo $_REQUEST["correo"] ?> </p>
    <p>Número de contacto: <?php echo $_REQUEST["contacto"] ?> </p>
    <p>Experiencia laboral: <?php echo $_POST["experiencia"] ?> </p>
    <p>Estudios: <?php echo $_REQUEST["Estudios"] ?> </p>
    <p>Jornada laboral: <?php echo $_REQUEST["jornada"] ?> </p>
    <p>Idiomas: 
        <?php
        print("<ul>");
        if(!empty($_REQUEST['idiomas'])){
            foreach ($_REQUEST['idiomas'] as $idioma){
                print("<li>".$idioma."</li>");
                }
        print("</ul>");
        }else{
            print "No has seleccionado alérgenos";
        }        
        ?>
    </p>
</body>
</html>