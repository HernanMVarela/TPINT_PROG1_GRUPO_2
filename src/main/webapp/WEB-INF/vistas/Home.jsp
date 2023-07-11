<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/Header.jspf" %>
</head>

<body>
<%@ include file="common/NavigatorCommon.jspf" %>
	<div class="container-fluid">
		
		<c:if test="${param.error != null }">
			<div class="row align-items-md-stretch">
	            <div class="d-flex justify-content-center" style="text-align: center;">
	               	<h3 class="w-auto  m-2 py-1 px-3 bg-danger border rounded-3">Error al iniciar sesión</h3>	
	            </div>
	        </div>
		</c:if>

		<div class="container-fluid">
			<div class="p-2 mb-2 bg-dark border rounded-3" style="width: 100%">
				<div class="container-fluid py-1">
					<div class="d-flex row align-items-between">
						<div class="col p-2 m-3 bg-light border rounded-3 cuadro_uno" style="--clr:#fcbe21; text-align: center;">
							<img class="img-responsive p-3" style="width: 50%;" src="<c:url value="/assets/images/login.png" />"/>
							<h1>Panel de usuarios</h1>
							<p>Acceso de administrador al panel de control.</p>
							<p>Administración de usuarios.</p>
							<hr>
							<sec:authorize access="hasAnyAuthority('ADMIN')">
								<a href="usuarios" class="btn-p but mr-1" style="--clr2:#fcbe21">Usuarios</a>
							</sec:authorize>
							<sec:authorize access="hasAnyAuthority('CLIENTE','USUARIO')">
							    <input type="submit" class="btn-p mr-1" style="--clr2:#787878" disabled value="Usuarios">
							</sec:authorize>
						</div>
						<div class="col p-2 m-3 bg-light border rounded-3 cuadro_uno" style="--clr:#3fad3d; text-align: center;">
							<img class="img-responsive p-3" style="width: 50%;" src="<c:url value="/assets/images/clientes.png" />"/>
							<h1>Clientes</h1>
							<p>Acceso de usuario al panel de clientes.</p>
							<p>Administración de clientes.</p>
							<hr>
							<sec:authorize access="hasAnyAuthority('ADMIN','USUARIO')">
								<a href="clientes" class="btn-p but mr-1" style="--clr2:#3fad3d">Clientes</a>
							</sec:authorize>
							<sec:authorize access="hasAnyAuthority('CLIENTE')">
							    <input type="submit" class="btn-p mr-1" style="--clr2:#787878" disabled value="Clientes">
							</sec:authorize>
						</div>
						<div class="col p-2 m-3 bg-light border rounded-3 cuadro_uno" style="--clr:#1e9bff; text-align: center;">
							<img class="img-responsive p-3" style="width: 50%;" src="<c:url value="/assets/images/prestamos.png" />"/>
							<h1>Prestamos</h1>
							<p>Acceso de clientes al panel de prestamos.</p>
							<br>
							<hr>
							<sec:authorize access="hasAnyAuthority('ADMIN','CLIENTE')">
								<a href="prestamos" class="btn-p but mr-1" style="--clr2:#1e9bff">Prestamos</a>
							</sec:authorize>
							<sec:authorize access="hasAnyAuthority('USUARIO')">
							    <input type="submit" class="btn-p mr-1" style="--clr2:#787878" disabled value="Prestamos">
							</sec:authorize>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>
	</body>

	</html>