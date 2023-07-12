<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('#tabla_prestamos').DataTable();
  });

</script>
<%@ include file="common/Header.jspf"%>
</head>
<body>
<%@ include file="common/NavigatorCommon.jspf"%>
          <div class="container-fluid">
              <div class="p-3 bg-light border rounded-3" style="width: 100%">
                <div class="d-flex align-content-center bd-highlight mb-3">
                  <div class="me-auto p-2 bd-highlight align-self-center">
                    <h1>PRESTAMOS</h1>
                  </div>
                </div>
                <div class="row mx-2 d-flex flex-wrap align-middle justify-content-evenly">
                  <div class="col-md-auto table-responsive w-100">
                    <table id="tabla_prestamos" class="table table-hover text-center">
                      <thead>
                        <tr class="table-secondary">
                          <th class="text-center" scope="col"> Numero </th>
                          <th class="text-center" scope="col"> Fecha </th>
                          <th class="text-center" scope="col"> DNI </th>
                          <th class="text-center" scope="col"> Nombre y apelldio </th>
                          <th class="text-center" scope="col"> Monto </th>
                          <th class="text-center" scope="col"> Cuotas </th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${listaPrestamos}" var="item">
                          <c:if test="${item.monto > 0}">                        
                          <tr class="table-primary">
                            <td>${item.numero} </td>
                            <td>${item.fecha}</td>
                            <td>${item.cliente.dni}</td>
                            <td>${item.cliente.nombre} ${item.cliente.apellido}</td>
                            <td>${item.monto}</td>
                            <td>${item.cuotas}</td>
                          </c:if>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
          </div>

      </body>

      </html>