<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/flibble.js"></script>
<title>The Flibble Test Page</title>
</head>
<body>
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

<div id='maindiv'>Loading...</div>

<div id='debugPanel'>
	<%@include file="debug.inc.jsp" %>
</div>
</body>
</html>
