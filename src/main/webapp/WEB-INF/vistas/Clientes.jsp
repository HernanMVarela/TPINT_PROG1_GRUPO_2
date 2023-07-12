<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('#tabla_clientes').DataTable();
  });

</script>
<%@ include file="common/Header.jspf"%>
</head>
<body>
<%@ include file="common/NavigatorCommon.jspf"%>

<div class="container-fluid">
	<div class="p-3 bg-light text-dark border rounded-3" style="width: 100%">
		<form action="clientes.html" method="post">
			<div class="d-flex  align-content-center bd-highlight mb-3">
				<div class="me-auto p-2 bd-highlight align-self-center">
					<h1 >CLIENTES</h1>
				</div>
			</div>
	
		  <div class="row mx-2 d-flex flex-wrap align-middle justify-content-evenly">
			  <div class="col-md-auto table-responsive w-100">
                    <table id="tabla_clientes" class="table table-hover text-center">
                      <thead>
                        <tr class="table-secondary">
                          <th class="text-center" scope="col"> DNI </th>
                          <th class="text-center" scope="col"> Nombre </th>
                          <th class="text-center" scope="col"> Apellido </th>
                          <th class="text-center" scope="col"> Dirección </th>
                          <th class="text-center" scope="col"> CP </th>
                          <th class="text-center" scope="col"> Provincia </th>
                          <th class="text-center" scope="col"> Nacionalidad </th>
                          <th class="text-center" scope="col"> Fecha de nacimiento </th>
                          <th class="text-center" scope="col"> Email </th>
                          <th class="text-center" scope="col"> Telefono </th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${listaClientes}" var="item">                       
                          <tr class="table-success">
                            <td>${item.dni} </td>
                            <td>${item.nombre}</td>
                            <td>${item.apellido}</td>
                            <td>${item.direccion}</td>
                            <td>${item.codpostal}</td>
                            <td>${item.provincia}</td>
                            <td>${item.nacionalidad}</td>
                            <td>${item.nacimiento}</td>
                            <td>${item.correo}</td>
                            <td>${item.telefono}</td>
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