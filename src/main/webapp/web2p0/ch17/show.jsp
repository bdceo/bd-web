<%@ page language="java"%>
<html>
	<head>
		<title>Album Show</title>
		<link rel="stylesheet" type="text/css" href="new.css">
		<script src="all.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="menu">
			<ul>
				<li>
					<a class="hide" onmouseover="getPictures('landscape')">Landscapes</a>
				</li>
				<li>
					<a class="hide" onmouseover="getPictures('tree')">Trees</a>
				</li>
				<li>
					<a class="hide" onmouseover="getPictures('bird')">Birds</a>
				</li>
				<li>
					<a class="hide" onclick="switchStyle('styles.css','new.css')">Switch
						Style</a>
				</li>
			</ul>
		</div>
		<div id="container"></div>
	</body>
</html>