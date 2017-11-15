<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola</title>
</head>
<body>


<h1><@spring.message "Saludo" /></h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th><@spring.message "username" /></th>
        <th><@spring.message "password" /></th>
        <th><@spring.message "rol" /></th>
    </tr>
    </thead>
    <tbody>


        <td>${usuario.username}</td>
        <td>${usuario.nombre}</td>
        <td>${usuario.apellido}</td>

    </tr>


    </tbody>
</table>


</body>
</html>