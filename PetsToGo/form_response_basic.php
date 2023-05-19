
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>contact form response</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--author: Lily Ellison
	date: December 2, 2022-->
    <meta name="description" content="Contact Form Response Page for Pets To Go.">
    <meta name="keywords" content="Pets To Go, WDV101, Final Presentation, Lily Ellison, Contact, Form Reponse, PHP, Non-profit">

    <link rel="stylesheet" href="css/main_stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Carter+One&family=Gelasio&family=Lato&family=Lemonada:wght@300;400&family=Noto+Sans+Thai&family=Oregano:ital@0;1&family=Overpass&display=swap" rel="stylesheet"> 

    

    
    
<style type="text/css">
#container  {
			width: 1000px;
			border: 1px solid black;
			padding: 10px;
			margin: 10px auto;
			}
.colorRed {
	color: #F00;
}
.fieldset {
   border-radius: 5px;
   background-color: #b5facf;
   margin: 10px;
   padding: 10px;
   border: hidden;
}

</style>
</head>

<body>
<div class="header">
  <h1 style="text-shadow: 2px 2px 5px rgb(82, 82, 207);">Contact Pets To Go</h1>
  <img src="images/pets.jpg" alt="Pets" width="100%">
</div>

<div>
    <nav>
      <ul class="row">
        <li><a href="index.html">Home</a></li>
        <li><a href="about.html">About PTG</a></li>
        <li><a href="our_pets.html">Our Pets</a></li>
        <li><a href="gallery.html">Gallery of Current Pets</a></li>
        <li class="active"><a class="active" href="contact.html">Contact Us</a></li>
      </ul> 
    </nav>
</div>



<div id="container" class="fieldset">
<h2>WDV101 Intro HTML and CSS</h2>
<h3> Form Response Porcessor</h3>

<p>This process will process the 'name = value' pairs for all the elements of your contact form. It will format and respond by sending an html page containing a table with the information you entered in the form.
</p>


<hr>
<p>&nbsp;</p>

<?php

echo "<p class='colorRed'>This page was created by PHP on the server and sent back to your browser. </p>";

//It will create a table and display one set of name value pairs per row
	echo "<table border='1'>";
	echo "<tr><th>Field Name</th><th>Value of field</th></tr>";
	foreach($_POST as $key => $value)
	{
		echo '<tr class=colorRow>';
		echo '<td>',$key,'</td>';
		echo '<td>',$value,'</td>';
		echo "</tr>";
	} 
	echo "</table>";
	echo "<p>&nbsp;</p>";

?>

</body>
</html>
