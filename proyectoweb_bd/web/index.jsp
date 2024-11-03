<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Proyecto Final - Liga de Fútbol</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
           
            background-image: url('https://www.record.com.mx/sites/default/files/styles/v2-crop768x433/public/articulos/2024/05/08/ap24129748645386.jpeg?itok=5TBwHRFU&changed=20240508152110'); /* Reemplaza con la URL de tu imagen */
            background-size: cover; 
            background-position: center; 
            color: #ffffff;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .container {
            backdrop-filter: blur(10px);
            padding: 40px;
            border-radius: 10px;
            margin-top: 50px;
            background-color: rgba(0, 0, 0, 0.8);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
        }
        .btn {
            transition: transform 0.2s, box-shadow 0.2s;
            margin: 10px; 
            font-size: 1.2rem; 
            padding: 15px 30px; 
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838;
        }
        .btn-info {
            background-color: #17a2b8;
            border-color: #17a2b8;
        }
        .btn-info:hover {
            background-color: #138496;
        }
        h1 {
            font-size: 3rem;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div class="container text-center">
        <h1>Bienvenido a la Liga de Fútbol</h1>
        <p>Seleccione una opción para continuar:</p>
        <a href="index_equipos.jsp" class="btn btn-primary btn-lg">Ver Equipos</a>
        <a href="index_jugadores.jsp" class="btn btn-success btn-lg">Ver Jugadores</a>
        <a href="index_presidente.jsp" class="btn btn-info btn-lg mt-4">Ver Presidentes</a> <!-- Nuevo botón agregado -->
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
