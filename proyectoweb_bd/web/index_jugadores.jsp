<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Jugador"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Final</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        
        <style>
            body {
                background-image: url('https://www.thesun.co.uk/wp-content/uploads/2023/12/e697b7d6-6acb-4e53-9a64-21b8476742a1.jpg?strip=all&w=960'); 
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>
        <div class="text-center text-white mt-5">
            <h1 class="title">Listado de jugadores</h1>
        </div>        
        <div class="container">
            <form action="sr_jugadores" method="post" class="form-group">
                <label for="txt_codigo_jugador" style="color: white;"><b>Código de jugador:</b></label>
                <input type="text" name="txt_codigo_jugador" id="txt_codigo_jugador" class="form-control" value="0" readonly>

                <label for="txt_nombre1" style="color: white;">Primer nombre:</label>
                <input type="text" name="txt_nombre1" id="txt_nombre1" class="form-control" placeholder="Ejemplo: Nombre de Jugador">

                <label for="txt_nombre2" style="color: white;">Segundo nombre:</label>
                <input type="text" name="txt_nombre2" id="txt_nombre2" class="form-control" placeholder="Ejemplo: Nombre de Jugador">

                <label for="txt_nombre3" style="color: white;">Tercer nombre:</label>
                <input type="text" name="txt_nombre3" id="txt_nombre3" class="form-control" placeholder="Ejemplo: Nombre de Jugador">

                <label for="txt_apellido1" style="color: white;">Primer Apellido:</label>
                <input type="text" name="txt_apellido1" id="txt_apellido1" class="form-control" placeholder="Ejemplo: Apellido de Jugador">

                <label for="txt_apellido2" style="color: white;">Segundo Apellido:</label>
                <input type="text" name="txt_apellido2" id="txt_apellido2" class="form-control" placeholder="Ejemplo: Apellido de Jugador">

                <label for="txt_correo" style="color: white;">Correo electrónico:</label>
                <input type="text" name="txt_correo" id="txt_correo" class="form-control" placeholder="Ejemplo: Correo electrónico">

                <label for="txt_ciudad" style="color: white;">Ciudad del jugador:</label>
                <input type="text" name="txt_ciudad" id="txt_ciudad" class="form-control" placeholder="Ejemplo: Ciudad">

                <label for="txt_fechanac" style="color: white;">Fecha de nacimiento:</label>
                <input type="date" name="txt_fechanac" id="txt_fechanac" class="form-control">

                <label for="drop_posicion" style="color: white;"><b>Posición</b></label>
                <select name="drop_posicion" id="drop_posicion" class="form-control">
                    <option value="">Seleccione una posición</option>
                    <%
                        Jugador jugador = new Jugador();
                        HashMap<String, String> droposicion = jugador.drop_posicion();
                        if (droposicion.isEmpty()) {
                            out.println("<option value=''>No hay posiciones disponibles</option>");
                        } else {
                            for (String i : droposicion.keySet()) {
                                out.println("<option value='" + i + "'>" + droposicion.get(i) + "</option>");
                            }
                        }
                    %>
                </select>

                <label for="drop_equipo" style="color: white;"><b>Equipo</b></label>
                <select name="drop_equipo" id="drop_equipo" class="form-control">
                    <option value="">Seleccione un equipo</option>
                    <%
                        HashMap<String, String> drop_equipo = jugador.drop_equipo();
                        if (drop_equipo.isEmpty()) {
                            out.println("<option value=''>No hay equipos disponibles</option>");
                        } else {
                            for (String i : drop_equipo.keySet()) {
                                out.println("<option value='" + i + "'>" + drop_equipo.get(i) + "</option>");
                            }
                        }
                    %>
                </select>

                <br>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-primary">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-primary" onclick="return confirm('¿Desea eliminar?')">Eliminar</button>
            </form>

            <table class="table table-dark table-striped mt-4">
                <thead>
                    <tr>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                        <th>Tercer nombre</th>
                        <th>Primer apellido</th>
                        <th>Segundo apellido</th>
                        <th>Correo electrónico</th>
                        <th>Ciudad residencia</th>
                        <th>Fecha de nacimiento</th>
                        <th>Posición</th>
                        <th>Equipo</th>
                    </tr>
                </thead>
                <tbody id="tbl_jugador">
                    <%
                        DefaultTableModel tabla = jugador.leer();
                        for (int t = 0; t < tabla.getRowCount(); t++) {
                            out.println("<tr data-id='" + tabla.getValueAt(t, 0) + "' data-id-pos='" + tabla.getValueAt(t, 9) + "' data-id-eq='" + tabla.getValueAt(t, 10) + "'>");
                            out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 8) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 9) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 10) + "</td>");
                            out.println("</tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

        <script type="text/javascript">
            // Evento de clic en la tabla de jugadores
            $('#tbl_jugador').on('click', 'tr', function() {
                var id = $(this).data('id');
                var id_pos = $(this).data('id-pos');
                var id_eq = $(this).data('id-eq');

                $("#txt_codigo_jugador").val(id);
                $("#txt_nombre1").val($(this).find("td").eq(0).html());
                $("#txt_nombre2").val($(this).find("td").eq(1).html());
                $("#txt_nombre3").val($(this).find("td").eq(2).html());
                $("#txt_apellido1").val($(this).find("td").eq(3).html());
                $("#txt_apellido2").val($(this).find("td").eq(4).html());
                $("#txt_correo").val($(this).find("td").eq(5).html());
                $("#txt_ciudad").val($(this).find("td").eq(6).html());
                $("#txt_fechanac").val($(this).find("td").eq(7).html());
                $("#drop_posicion").val(id_pos);
                $("#drop_equipo").val(id_eq);
            });
        </script>
    </body>
</html>
