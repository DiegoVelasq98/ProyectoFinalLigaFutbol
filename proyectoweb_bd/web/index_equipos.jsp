<%-- 
    Document   : index
    Created on : 24/10/2024, 17:56:47
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "modelo.Equipo"%>
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
            background-image: url('https://image.ondacero.es/clipping/cmsimages02/2024/09/12/7EAB92F4-FE33-413F-91C3-2244ECF2F3B1/santiago-bernabeu-elegido-como-mejor-estadio-mundo_97.jpg?crop=1024,576,x0,y52&width=1600&height=900&optimize=high&format=webply'); /* Reemplaza con la URL de tu imagen */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
    </style>
        
    </head>
    <body>
<div class="text-center text-white mt-5">
        <h1 class="title">Liga de Futbol</h1>
    </div>        
        <div class="container">
            
            
                <!-- The Modal -->
  <div class="modal" id="modal_equipo">
    <div class="modal-dialog">
      <div class="modal-content">
      
       
            
             <!-- Modal body -->
        <div class="modal-body">
            
        
            <form action="sr_equipos" method="post" class="form-group">
                
                <label for="lbl_codigo" ><b>Codigo de equipo:</b></label>
                <input type="txt" name="txt_codigo_equipo" id="txt_codigo_equipo" class="form-control" value="0"readonly>

                  <label for="lbl_nombre_equipo">Nombre de equipo: </label>
                  <input type="text" name="txt_nombre_equipo" id="txt_nombre_equipo" class="form-control" placeholder="Ejemplo: Nombre de equipo" required>
                  
                   
                  <label for="lbl_nombre_estadio">Nombre de estadio: </label>
                  <input type="text" name="txt_nombre_estadio" id="txt_nombre_estadio" class="form-control" placeholder="Ejemplo: Nombre de estadio" required>
                  
                  
                  <label for="lbl_aforo">Aforo:</label>
                  <input type="text" name="txt_aforo" id="txt_aforo" class="form-control" placeholder="Ejemplo: 8405454" required>
                 
                  
                  <label for="lbl_fecha_fundacion">Fecha de fundacion: </label>
                  <input type="date" name="txt_fundacion" id="txt_fundacion" class="form-control"required>
                         
                         
                  <label for="lbl_ciudad_equipo">Ciudad del equipo:</label>
                  <input type="text" name="txt_ciudad_equipo" id="txt_ciudad_equipo" class="form-control" placeholder="Ejemplo: Ciudad" required>
        

                  
                  
                 <br>
                  <button name="btn_agregar" id= "btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                  
                  <button name="btn_modificar" id= "btn_modificar" value="modificar" class="btn btn-primary">Modificar</button>
                  
                  <button name="btn_eliminar" id= "btn_eliminar" value="eliminar" class="btn btn-primary" onclick="javascript:if(!confirm('¿Desea eliminar'))return false">Eliminar</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>



               
               
		
            </form>
            

            
            
            </div>
       
        
      </div>
    </div>
  </div>
            
            
            
            <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>Nombre equipo</th>
        <th>Nombre estadio</th>
        <th>Aforo</th>
        <th>Fundacion</th>
        <th>Ciudad equipo</th>

      </tr>
    </thead>
    <tbody id= "tbl_equipo">
      <%
          Equipo equipo = new Equipo();
                  DefaultTableModel tabla = new DefaultTableModel();
                  tabla= equipo.leer();
                  
for (int t=0; t<tabla.getRowCount();t++ ){

        out.println("<tr data-id="+tabla.getValueAt(t, 0)+">");
        
       
        out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
        out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
        out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
        out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
        out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
 
        out.println("</tr>");
          }

          %>
      
     
    </tbody>
  </table>
            
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_equipo" onclick ="limpiar()">Nuevo Equipo</button>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        



<script type= "text/javascript">
    
    function limpiar(){
    $("#txt_codigo_equipo").val(0);
        $("#txt_nombre_equipo").val('');
        $("#txt_nombre_estadio").val('');
        $("#txt_aforo").val('');
        $("#txt_fundacion").val('');
     
    }
    
    
        $('#tbl_equipo').on('click','tr td',function(evt){
        var target,id,nombre_equipo, nombre_estadio, aforo, fundacion, ciudad;
        target= $(event.target);
        
        
        id=target.parent().data('id');
        
        nombre_equipo=target.parent("tr").find("td").eq(0).html();
        nombre_estadio=target.parent("tr").find("td").eq(1).html();
        aforo=target.parent("tr").find("td").eq(2).html();
        fundacion=target.parent("tr").find("td").eq(3).html();
        ciudad=target.parent("tr").find("td").eq(4).html();
        
        
        $("#txt_codigo_equipo").val(id);
        $("#txt_nombre_equipo").val(nombre_equipo);
        $("#txt_nombre_estadio").val(nombre_estadio);
        $("#txt_aforo").val(aforo);
        $("#txt_fundacion").val(fundacion);
        $("#txt_ciudad_equipo").val(ciudad);
       


                $("#modal_equipo").modal('show');


        });
        
        
        
    </script>
    </body>
</html>
