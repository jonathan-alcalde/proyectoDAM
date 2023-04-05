<html>
	<head>
		<title>Prueba de PHP</title>
	</head>
	<body>
		Nombre: <?php echo htmlspecialchars($_POST['nombre']); ?> <br/>
		Apellidos: <?php echo htmlspecialchars($_POST['apellidos']); ?> 
	</body>
</html>

