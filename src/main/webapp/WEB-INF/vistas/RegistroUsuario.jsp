<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<%@ include file="common/Header.jspf" %>
	</head>
	
	<body>
		<%@ include file="common/NavigatorCommon.jspf" %>
			<div class="container-fluid">
				<div class="container">
					<div class="p-2 mb-2 bg-light border rounded-3" style="width: 100%">
						<div class="container-fluid py-1">
							<div>
								<br>
								<h1 style="text-align: center;">CREACION DE USUARIO</h1>
								<hr>
								<div class="row align-items-md-stretch">
								<c:if test="${param.pass != null}">
									<div class="row align-items-md-stretch">
							            <div class="d-flex justify-content-center" style="text-align: center;">
							               	<h3 class="w-auto  m-2 py-1 px-3 bg-danger border rounded-3">Las contraseñas no coinciden</h3>	
							            </div>
							        </div>
								</c:if>
									<div class="col-md-8">
										<form:form action="alta_usuario" method="post" modelAttribute="usuario">
											
											<div class="row align-items-md-stretch">
												<div class="form-group col-md-4">
													<label style="float: left">Nombre</label>
													<form:input class="form-control" path="nombre" placeholder="Ingrese nombre" required="required"/>
												</div>
												<div class="form-group col-md-4">
													<label style="float: left">Apellido</label>
													<form:input class="form-control" path="apellido" placeholder="Ingrese apellido" required="required"/>
												</div>
												<div class="form-group col-md-4">
													<label style="float: left">DNI</label>
													<form:input class="form-control" type="number" path="dni" placeholder="Ingrese DNI" required="required"  min="1" max="99999999" />
												</div>
											</div>
											
											<br>

											<div class="row align-items-md-stretch">
												<div class="form-group col-md-4">
													<label style="float: left">Fecha de Nacimiento</label>
													<form:input class="form-control" type="date" path="nacimiento" required="required" />
												</div>
												<div class="form-group col-md-4">
													<label style="float: left">Correo Electronico</label>
													<form:input class="form-control" type="email" path="correo" placeholder="Ingrese correo electronico" required="required" />
												</div>
												<div class="form-group col-md-4">
													<label style="float: left">Numero de Telefono</label>
													<form:input class="form-control" type="number" path="telefono" placeholder="Ingrese numero de telefono" required="required" />
												</div>
											</div>

											<hr>
											
											<div class="row align-items-md-stretch">
												<div class="form-group col-md-8">
													<label style="float: left">Usuario</label>
													<form:input class="form-control" path="username" placeholder="Ingrese usuario" required="required" />
												</div>
												<div class="form-group col-md-4">
													<label style="float: left">Seleccione rol</label>
													<form:select class="form-select" path="rol">
														<option value=USUARIO>USUARIO</option>
														<option value=CLIENTE>CLIENTE</option>
														<option value=ADMIN>ADMIN</option>
													</form:select>
												</div>
											</div>
											<br>
											<div class="row align-items-md-stretch">
												<div class="form-group col-md-6">
													<label style="float: left">Contraseña</label>
													<form:password class="form-control" path="password" placeholder="Ingrese contraseña" required="required" min="6"/>
												</div>
												<div class="form-group col-md-6">
													<label style="float: left">Repita la contraseña</label>
													<input class="form-control" name="passwordConfirm" type="password" placeholder="Re-Ingrese su contraseña" required="required" min="6">
												</div>
											</div>

											<hr>

											<div class="d-flex justify-content-center">
												<input type="submit" class="btn w-25 btn-primary" name="btnAceptar"
													value="Aceptar">
											</div>
										</form:form>
									</div>

									<div class="col-md-4" style="text-align: center;">
										<form id="home" method="post">
											<img class="img-responsive p-3" style="width: 50%;" src="<c:url value="/assets/images/register.png" />"/>
											<h1>¡Oye!</h1>
											<p>¿Ya tienes una cuenta? Haz click en el boton de abajo
												para iniciar sesión.</p>
											<input type="submit" class="btn btn-success mr-1" value="INICIAR SESION"
												name="btnRedirigir">
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</body>

	</html>