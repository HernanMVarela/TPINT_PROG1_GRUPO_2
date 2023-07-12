<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/Header.jspf" %>
</head>

<body>
<%@ include file="common/NavigatorCommon.jspf" %>
	<div class="container-fluid">
		<div class="row align-items-md-stretch"> 		
			<div class="container">
				<c:if test="${param.error != null }">
					<div class="row align-items-md-stretch">
			            <div class="d-flex justify-content-center" style="text-align: center;">
			               	<h3 class="w-auto  m-2 py-1 px-3 bg-danger border rounded-3">Error al iniciar sesión</h3>	
			            </div>
			        </div>
				</c:if>
				<c:if test="${param.logout != null }">
					<div class="row align-items-md-stretch">
			            <div class="d-flex justify-content-center" style="text-align: center;">
			               	<h3 class="w-auto m-2 py-1 px-3 bg-success border rounded-3">Se ha cerrado sesión</h3>	
			            </div>
			        </div>
				</c:if>
				<c:if test="${param.newuser != null }">
					<div class="row align-items-md-stretch">
			            <div class="d-flex justify-content-center" style="text-align: center;">
			               	<h3 class="w-auto m-2 py-1 px-3 bg-primary border rounded-3">Se ha creado un nuevo usuario</h3>	
			            </div>
			        </div>
				</c:if>
				<div class="p-2 mb-2 bg-light border rounded-3" style="width: 100%">
					<div class="container-fluid py-1">
						<div class="row align-items-md-stretch">
							<div class="col-md-6" style="text-align: center;">
								<img class="img-responsive p-3" style="width: 50%;" src="<c:url value="/assets/images/logo.png" />"/>
								<h1>¡Hola!</h1>
								<p>
									Si aun no tienes cuenta, puedes registrarte haciendo click en el boton de abajo.
								</p>
								<form:form action="registro" method="post">
									<input type="submit" class="btn-p but mr-1" style="--clr2:#3fad3d; --clr:#3fad3d;" value="REGISTRARSE">
								</form:form>
							</div>
							<div class="col-md-6" style="text-align: center;">
								<div class="d-flex col col-12 mh-2 justify-content-center p-2">
									<div class="row w-auto justify-content-center">
										<img class="img-responsive p-2" style="width: 35%;" src="<c:url value="/assets/images/logo-candado.png" />"/>
										<form:form action="login" method="post">
											<div class="d-flex flex-column col w-auto align-items-center justify-content-center">
											    <input class="form-control mt-2 w-50" type="text" name="username" placeholder="Ingrese usuario">
											
											    <input class="form-control mt-2 w-50" type="password" name="password" placeholder="Ingrese contraseña">
											    <input type="submit" class="btn-p but mt-2 mr-1" style="--clr2:#1e9bff; --clr:#1e9bff;" value="INGRESAR">
											</div>

										</form:form>
									</div>
								</div>								
							</div>
						</div>

					</div>
				</div>
			</div>
			
		</div>
	</div>
		
</body>
</html>