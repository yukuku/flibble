<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>H1</title>
    <!-- yui css -->
    <link rel="stylesheet" type="text/css" href="yui/build/reset-fonts-grids/reset-fonts-grids.css">
    <link rel="stylesheet" type="text/css" href="yui/build/base/base-min.css">
    <link rel="stylesheet" type="text/css" href="yui/build/button/assets/skins/sam/button.css">
    <link rel="stylesheet" type="text/css" href="yui/build/container/assets/skins/sam/container.css">
    <!-- yui js -->
    <script type="text/javascript" src="yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="yui/build/animation/animation-min.js"></script>
    <script type="text/javascript" src="yui/build/element/element-beta-min.js"></script>
    <script type="text/javascript" src="yui/build/button/button-min.js"></script>
    <script type="text/javascript" src="yui/build/dragdrop/dragdrop-min.js"></script>
    <script type="text/javascript" src="yui/build/container/container-min.js"></script>
    <script type="text/javascript" src="yui/build/json/json-min.js"></script>
    <!-- custom css -->
    <link rel="stylesheet" href="css/main.css" />
    <!-- custom js -->
    <script type="text/javascript" src="js/prototype.js"></script>
</head>
<body class="yui-skin-sam">

<div id='window-outer'>
<div id='window' class='window-h1'>
	<div id="H1">
		<h1 id="mainTitle">Flibble</h1>
		
		<div id="startGameButton" onclick='void startGame();'>Start Game</div>
		
		<div id="instructionsButton" onclick='void instructions();'>Instructions</div>
	</div>
</div>
</div>

<div id="startGamePanel">
	<div class="hd">Start Game</div>
	<div class="bd">
		<div id="startGameBody">
			<form action="H2.jsp" method="post">
				<h2>Nickname:</h2>
				<p><input type="text" name="nick" class="startGameInput" id="nick" /></p>
				<h2>Select table:</h2>
				<div id="tableSelection">
					<div class="table" onclick="void submit($F('nick'), 123);">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
					<div class="table">
						table name
					</div>
				</div>
				<h2>or <a href="javascript: void submit($F('nick'), 0);">Create a new table</a></h2>
			</form>
		</div>
		
		<div class="closeButton" onclick="void panelStartGame.hide();">
			Close
		</div>
	</div>
	<div class="ft"></div>
</div>


<div id="instructionsPanel">
	<div class="hd">Instructions</div>
	<div class="bd">
		<div id="instructionsBody">
			<h1>Container Family: Examples</h1>
			
			<p>The Container Family of UI controls includes all content that floats above the main layer of the page: Tooltip, Panel, Dialog and SimpleDialog are the most commonly used Container controls. Module and Overlay are base classes useful in custom widget development.</p>
			
			<p>* The Module Control: The Module is a JavaScript representation of modular HTML content; all Container controls implement Module as a base class.</p>
			<p>* Creating and Positioning an Overlay: The Overlay class extends Module and creates a piece of modular content that floats above the page, outside of the page flow. In this example, we look at how to create and position an Overlay.</p>
		    <p>* Simple Tooltip Example: Creating and styling a simple Tooltip.</p>
		    <p>* One Tooltip, Many Context Elements: You can reuse the same Tooltip instance to provide Tooltip effects for many elements, conserving browser resources and improving performance along the way.</p>
		    <p>* Simple Panel Example: This example implements two simple Panels, one from markup and one purely from script, and shows how to configure options like draggability.</p>
		    <p>* Skinning a Panel with Custom CSS: Introduction: In this example, we explore simple techniques for using CSS to customize the look and feel of a Panel Control instance.</p>
		    <p>* Skinning a Panel with Custom CSS: Advanced: Building on the introductory skinning example, here we'll look at customizing mulitple Panel instances in the same document.</p>
		    <p>* Creating a Modal "Loading" Panel: This example shows how to use a Panel Control instance to display a modal "loading" or "please wait" message.</p>
		    <p>* Creating a Resizable Panel: In this example, we look at how Panel can be combined with the Resize utility to create resizable Panel Control instances.</p>
		    <p>* Dialog Quickstart Example: This example demonstrates the most common use-case for the Dialog control — collecting data from the user and sending it to the server using XMLHttpRequest (Ajax) via the YUI Connection Manager.</p>
		    <p>* SimpleDialog Quickstart Example: This example demonstrates the most common use-case for the SimpleDialog control — a control best used for simple ok/cancel or yes/no dialog forms.</p>
		    <p>* Using ContainerEffect Transitions: The ContainerEffect object allows you to implement built-in transitions to fade-in/out or slide-in/out your Containers as they show and hide.</p>
		    <p>* Using the Overlay Manager to Manage Multiple Panels: Overlay Manager makes it easy to manage the interaction of many Panels within the same window, giving focus to the window that is selected and keeping its z-index higher than that of its peers.</p>
		    <p>* Implementing Container Keyboard Shortcuts with KeyListener: The KeyListener class, included with the Event Utility, makes it easy to tie keyboard shortcuts to specific actions in your application.</p>
		</div>
		
		<div class="closeButton" onclick="void panelInstructions.hide();">
			Close
		</div>
	</div>
	<div class="ft"></div>
</div>

<script type="text/javascript">
var panelConfig = {
	width: "530px", 
	visible: false,
	fixedcenter: true,   
	draggable: true,
	close: true,
	modal: true,
	zindex: 4,
	constraintoviewport: true
};

var panelStartGame = new YAHOO.widget.Panel("startGamePanel", panelConfig);
panelStartGame.render();

var panelInstructions = new YAHOO.widget.Panel("instructionsPanel", panelConfig);
panelInstructions.render();

function startGame() {
	panelStartGame.show();
}

function instructions() {
	panelInstructions.show();
}

function submit(nick, table) {
	window.alert("nick=" + nick + "\ntable=" + table);
}

</script>

</body>
</html>