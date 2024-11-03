

<%@page import="modelo.Presidente"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presidente</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        
         <style>
            body {
                background-image: url('https://www.planetarealmadrid.com/uploads/s1/24/03/7/15684801472602_4_1000x563.jpeg'); 
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>
        
       
        <div class="text-center text-black mt-5">
                    <h1>Formulario Presidentes</h1>

               </div>   
        <div class="container"> 
           
        <form action="sr_presidente" method="post" class="form-group">
                <label for="lbl_codigo_presi" style="color: black;"><b>Código</b></label>
                <input type="text" name="txt_codigo_presi" id="txt_codigo_presi" class="form-control" value="0" readonly>

                
                <label for="lbl_dpi" style="color: black;">DPI</label>
                <input type="text" name="txt_dpi" id="txt_dpi" class="form-control" placeholder="Ejemplo: Nombre de Jugador" >
                
                <label for="lbl_nombre1" style="color: black;">Primer nombre:</label>
                <input type="text" name="txt_nombre1" id="txt_nombre1" class="form-control" placeholder="Ejemplo: Nombre de Jugador" >

                <label for="lbl_nombre2"style="color: black;">Segundo nombre:</label>
                <input type="text" name="txt_nombre2" id="txt_nombre2" class="form-control" placeholder="Ejemplo: Nombre de Jugador" >

                <label for="lbl_nombre3" style="color: black;">Tercer nombre:</label>
                <input type="text" name="txt_nombre3" id="txt_nombre3" class="form-control" placeholder="Ejemplo: Nombre de Jugador" >

                <label for="lbl_apellido1" style="color: black;">Primer Apellido:</label>
                <input type="text" name="txt_apellido1" id="txt_apellido1" class="form-control" placeholder="Ejemplo: Apellido de Jugador" >

                <label for="lbl_apellido2"style="color: black;">Segundo Apellido:</label>
                <input type="text" name="txt_apellido2" id="txt_apellido2" class="form-control" placeholder="Ejemplo: Apellido de Jugador" >

                <label for="lbl_fechan"style="color: black;">Fecha de nacimiento:</label>
                <input type="date" name="txt_fechanac" id="txt_fechanac" class="form-control">
                
                <label for="lbl_correo"style="color: black;">Correo electrónico:</label>
                <input type="text" name="txt_correo" id="txt_correo" class="form-control" placeholder="Ejemplo: Correo electrónico" >

                <label for="lbl_ciudad"style="color: black;">Ciudad</label>
                <input type="text" name="txt_ciudad" id="txt_ciudad" class="form-control" placeholder="Ejemplo: Ciudad" >

                <label for="lbl_fechan"style="color: black;">Año de eleccion</label>
                <input type="date" name="txt_fechaeleccion" id="txt_fechaeleccion" class="form-control">

                <label for="lbl_presi"style="color: black;"><b>Presidente de equipo</b></label>
                <select name="drop_presi" id="drop_presi" class="form-control">
                    <option value="">Seleccione equipo</option>
                    <%
                         Presidente presidente = new Presidente();
                        HashMap<String, String> droposicion = presidente.drop_presi();
                        if (droposicion.isEmpty()) {
                            out.println("<option value=''>No hay presidentes  disponibles</option>");
                        } else {
                            for (String i : droposicion.keySet()) {
                                out.println("<option value='" + i + "'>" + droposicion.get(i) + "</option>");
                            }
                        }
                    %>
                    
                    
                    
                    
                </select>
                <br>
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-primary btn-lg">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar"  value="eliminar" class="btn btn-primary btn-lg">Eliminar</button>
		
            </form>
      
         
                    
      <table class="table">
    <thead>
      <tr>
        <th>DPI</th>
        <th>Primer Nombre</th>
         <th>Segundo Nombre</th>
         <th>Tercer Nombre</th>
         <th>Primer Apellido</th>
         <th>Segundo Apellido</th>
         <th>Fecha de Nacimiento</th>
         <th>Correo electronico</th>
         <th>Ciudad</th>
         <th>Año de elecion</th>
         <th>Equipo</th>
      </tr>
    </thead>
    
    
    
        
        
      
  
                    
        <tbody id="tbl_presidente">

    <% 
        
     
        DefaultTableModel tabla = presidente.leer(); 
        for (int t = 0; t < tabla.getRowCount(); t++) {
            out.println("<tr data-id='" + tabla.getValueAt(t, 0) + "' " + 
                        "data-id-eq='" + tabla.getValueAt(t, 11) + "'>"); 

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
            out.println("<td>" + tabla.getValueAt(t, 12) + "</td>"); 
            out.println("</tr>");
        }
    
    %>

</tbody>

            
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script> 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> 


<script type="text/javascript">
    function limpiar(){
        $("#txt_codigo_presi").val(0);
        $("#txt_dpi").val('');
        $("#txt_nombre1").val('');
        $("#txt_nombre2").val('');
        $("#txt_nombre3").val('');
        $("#txt_apellido1").val('');
        $("#txt_apellido2").val('');
        $("#txt_fechanac").val('');
        $("#txt_correo").val('');
        $("#txt_ciudad").val('');
        $("#txt_fechaeleccion").val('');
        $("#drop_presi").val(1); // Cambia esto al ID correcto de tu dropdown para presidentes
    }
    
    $('#tbl_presidente').on('click', 'tr td', function(evt){
        var target = $(event.target);
        
        var id = target.parent().data('id'); // id_presi
        var dpi = target.parent("tr").find("td").eq(0).html(); // dpi
        var nombre1 = target.parent("tr").find("td").eq(1).html(); // nombre1
        var nombre2 = target.parent("tr").find("td").eq(2).html(); // nombre2
        var nombre3 = target.parent("tr").find("td").eq(3).html(); // nombre3
        var apellido1 = target.parent("tr").find("td").eq(4).html(); // apellido1
        var apellido2 = target.parent("tr").find("td").eq(5).html(); // apellido2
        var fecha_nacimiento = target.parent("tr").find("td").eq(6).html(); // fecha_nacimiento
        var correo = target.parent("tr").find("td").eq(7).html(); // correo_electronico
        var ciudad = target.parent("tr").find("td").eq(8).html(); // ciudad_residencia
        var anio_eleccion = target.parent("tr").find("td").eq(9).html(); // anio_eleccion
        
        // Asignar los valores a los campos del modal
        $("#txt_codigo_presi").val(id);
        $("#txt_dpi").val(dpi);
        $("#txt_nombre1").val(nombre1);
        $("#txt_nombre2").val(nombre2);
        $("#txt_nombre3").val(nombre3);
        $("#txt_apellido1").val(apellido1);
        $("#txt_apellido2").val(apellido2);
        $("#txt_fechanac").val(fecha_nacimiento);
        $("#txt_correo").val(correo);
        $("#txt_ciudad").val(ciudad);
        $("#txt_fechaeleccion").val(anio_eleccion);
        
        // Establecer el valor del dropdown de presidente
        $("#drop_presi").val(target.parent().data('id-eq')); // Cambia esto si es necesario

        // Mostrar el modal
        $("#modal_presidente").modal('show');
    });
</script>
        
  
    </body>
</html>