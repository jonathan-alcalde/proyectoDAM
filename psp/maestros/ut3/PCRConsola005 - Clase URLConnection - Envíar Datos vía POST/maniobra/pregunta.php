<html>
	<head>
		<title>Prueba de PHP</title>
	</head>
	<body>
		<?php echo '<p>Pregunta</p>'; ?>
		<form action="respuesta.php" method="post">
		<p>Su nombre: <input type="text" name="nombre" /></p>
		<p>Sus apellidos: <input type="text" name="apellidos" /></p>
		<p><input type="submit" /></p>
		</form>
	</body>
</html>

