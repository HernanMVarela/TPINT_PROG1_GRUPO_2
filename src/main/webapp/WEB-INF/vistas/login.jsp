<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/Header.jspf" %>
</head>

<script type="text/javascript">

</script>

<body>
	<div class="container-fluid">
		<div class="row align-items-md-stretch"> 		
			<form action="login.html" method="post">
				<div class="container">
					<div class="p-2 mb-2 bg-light border rounded-3" style="width: 100%">
						<div class="container-fluid py-1">
							<div class="row align-items-md-stretch">
								
								<div class="col-md-8" style="text-align: center;">
									<div class="d-flex col col-12 mh-2 justify-content-center p-2">
										<div class="row w-auto justify-content-center">
											<img class="img-responsive p-2" style="width: 90%;" src="<c:url value="/assets/logo.jpg"/>"/>
											<input class="form-control mt-2" id="usernameLogin" name="usernameLogin" value="" placeholder="Ingrese usuario" >									
											<input class="form-control mt-2" id="passLogin" name="passLogin" type="password" value="" placeholder="Ingrese contraseña">
											<input type="submit" class="btn btn-primary mt-2" value="INGRESAR" name="btnRedirigir">
										</div>
									</div>								
								</div>
							</div>

						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
	</html>