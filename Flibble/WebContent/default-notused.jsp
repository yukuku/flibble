<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/flibble.js"></script>
<link rel="stylesheet" href="css/welcome.css" />
<title>The Flibble Test Page</title>
</head>
<body background="image/bg_img.jpg">


<jsp:useBean id="applicationBean" class="sg.edu.ntu.Flibble.RoomBean" scope="application" />
<script type="text/javascript">
<!--
new Ajax.Request('/Flibble/FlibbleBridge',
  {
    method:'get',
    onSuccess: function(transport){
      var response = transport.responseXML || "no response text";
      alert("Success! \n\n" + response);
      printRspXml(response);
    },
    onFailure: function(){ alert('Something went wrong...') }
  });
  

function printRspXml(rsxml) {
	var items = rsxml.getElementsByTagName("photo");
	var dataTable = "<table id='rsps'>";
	for (var i=0; i<items.length; i++) {
		var photoId = items[i].getAttribute("id");
		var photoTitle = items[i].getAttribute("title");
		var photoTag = items[i].getAttribute("tags");
		var row = "<tr><td>" + photoId + "</td><td>" + photoTitle + "</td><td>" + photoTag + "</td></tr>";
		dataTable += row;
	}
	dataTable += "</table>";
	$('maindiv').update();
	$('maindiv').update(dataTable);
}

//-->
</script>

<div id="banner">
<img src="image/banner.jpg"/>
</div>

<div id="header">
Welcome to Flibble Mashup Game
</div> 

<div id="window">

<!-- ---------------- -->
<div id="div_Join">
<form id="form_div_Join" name="form_div_Join" method="get">
<input type="hidden" name="action" value="JoinIn" /> 
<input type="hidden" name="action" value="user" /> 
<input type="hidden" name="action" value="gname" /> 
</form>
</div>

<!-- ---------------- -->

<div id="div_Login">
<form id="form_div_Login" name="form_div_Login" method="get" onsubmit="FbLogin(); return false;">
<input type="hidden" name="action" value="login" /> 
User Name:&nbsp;<input id="txt_form_div_Login" name="user" type="text"/> 
<input type="button" id="btn_form_div_Login" value="Login"  onclick="FbLogin(); return false;"/>
<div id="err_div_Login"></div>
</form>
</div>

<!-- ---------------- -->


<div id="div_Wellcome" name="div_Wellcome">Loading...</div>
<!-- ---------------- -->

<div id="div_CGame">
<form id="form_div_CGame" name="form_div_CGame" method="get" onsubmit="FbCGame(); return false;">
<input type="hidden" name="action" value="CGame" /> 
Game Name:&nbsp;<input id="txt_form_div_CGame" name="gname" type="text"/> 
<input type="submit" id="btn_form_div_CGame" value="New Game" />
<div id="err_div_CGame"></div>
</form>
</div>

<!-- ---------------- -->

<div id="div_GameRoom" name="div_GameRoom">Loading...</div>
<div id="div_GamePanel" name="div_GamePanel">Loading...</div>

<!-- ---------------- -->
<hr/>
<div id="div_Console" name="div_Console">Debug Console</div>
<div id='maindiv'>Loading...</div>
<div id='debugPanel'>
	<%@include file="debug.inc.jsp" %>
</div>
</div>

<script type="text/javascript">
<!--
FbInit();
//-->
</script>

</body>
</html>
