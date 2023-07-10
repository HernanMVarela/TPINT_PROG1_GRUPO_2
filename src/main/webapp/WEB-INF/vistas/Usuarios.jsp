<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('#tabla_usuarios').DataTable();
  });

</script>
<%@ include file="common/Header.jspf"%>
</head>

<body>
	<%@ include file="common/NavigatorCommon.jspf"%>

<div class="container-fluid">
	<div class="p-5 bg-light text-dark border rounded-3" style="width: 100%">
		<form action="clientes.html" method="post">
			<div class="d-flex  align-content-center bd-highlight mb-3">
				<div class="me-auto p-2 bd-highlight align-self-center">
					<h1 >USUARIOS</h1>
				</div>
			</div>
	
		  <div class="row mx-2 d-flex flex-wrap align-middle justify-content-evenly">
			  <div class="col-md-auto table-responsive w-100">
                    <table id="tabla_usuarios" class="table table-hover text-center">
                      <thead>
                        <tr>
                          <th class="text-center" scope="col"> DNI </th>
                          <th class="text-center" scope="col"> Nombre </th>
                          <th class="text-center" scope="col"> Apellido </th>
                          <th class="text-center" scope="col"> Fecha de nacimiento </th>
                          <th class="text-center" scope="col"> Email </th>
                          <th class="text-center" scope="col"> Telefono </th>
                          <th class="text-center" scope="col"> Usuario </th>
                          <th class="text-center" scope="col"> Rol </th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${listaUsuarios}" var="item">
                          <c:if test="${item.enabled eq true}">                        
                          <tr class="table-info">
                          </c:if>
                          <c:if test="${item.enabled eq false}">                        
                          <tr class="table-danger">
                          </c:if>
                            <td>${item.dni} </td>
                            <td>${item.nombre}</td>
                            <td>${item.apellido}</td>
                            <td>${item.nacimiento}</td>
                            <td>${item.correo}</td>
                            <td>${item.telefono}</td>
                            <td>${item.username}</td>
                            <td>${item.rol}</td>
                          
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
		  	</div>		
		</form>
	</div>	
</div>

    
</body>
</html>