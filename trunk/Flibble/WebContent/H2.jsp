<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>H2</title>
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
    <script type="text/javascript" src="yui/build/container/container-min.js"></script>
    <script type="text/javascript" src="yui/build/dragdrop/dragdrop-min.js"></script>
    <script type="text/javascript" src="yui/build/json/json-min.js"></script>
    <!-- custom css -->
    <link rel="stylesheet" href="css/main.css" />
</head>
<body>

<div id='window-outer'>
<div id='window'>

    <!-- middle bar -->
    <div id="middlebar1" class="middlebar"></div>
    <div id="middlebar2" class="middlebar"></div>

    <!-- self part -->
    <div class="me">
        <div id="m1" class='square row1 col1'>test: drop into me</div>
        <div id="m2" class='square row1 col2'></div>
        <div id="m3" class='square row1 col3'></div>
        <div id="m4" class='square row2 col1'></div>
        <div id="m5" class='square row2 col2'></div>
        <div id="m6" class='square row2 col3'></div>
        <div id="m7" class='square row3 col1'></div>
        <div id="m8" class='square row3 col2'></div>
        <div id="m9" class='square row3 col3'></div>
        
        <div id="mq" class='square question'>test: drag me</div>
        
        <div id="mn" class='nick'>sile_waku</div>
        <div id="ms" class='score'>5</div>
        
        <div id="mh" class='hint'>Instructions or hint text</div>
    </div>
    
    <!-- enemy part -->
    <div class="you">
        <div id="y1" class='square row1 col1'></div>
        <div id="y2" class='square row1 col2'></div>
        <div id="y3" class='square row1 col3'></div>
        <div id="y4" class='square row2 col1'></div>
        <div id="y5" class='square row2 col2'></div>
        <div id="y6" class='square row2 col3'></div>
        <div id="y7" class='square row3 col1'></div>
        <div id="y8" class='square row3 col2'></div>
        <div id="y9" class='square row3 col3'></div>

        <div id="yq" class='square question'></div>

        <div id="yn" class='nick'>jere-yuku</div>
        <div id="ys" class='score'>17</div>

        <div id="yh" class='hint'>Instructions or hint text</div>
    </div>

</div>
</div>

<script type="text/javascript">

(function() {
    // make mq draggable
    var startPos = YAHOO.util.Dom.getXY('mq');
    var mqd = new YAHOO.util.DD('mq', 'm');
    mqd.onInvalidDrop = function(e) {
        new YAHOO.util.Motion(   
            this.id, {   
                points: {   
                    to: startPos  
                }  
            },   
            0.3,   
            YAHOO.util.Easing.easeOut   
        ).animate();
    };
    mqd.startDrag = function(e) {
        YAHOO.util.Dom.setStyle(this.id, 'opacity', 0.5);
    }
    mqd.endDrag = function(e) {
        YAHOO.util.Dom.setStyle(this.id, 'opacity', 1.0);
    }
    mqd.onDragDrop = function(e, id) {
        YAHOO.util.Dom.setXY(this.id, YAHOO.util.Dom.getXY(id), true);
    }
    
    // make m1 to m9 droppable
    for (var i = 1; i <= 9; i++) {
        new YAHOO.util.DDTarget('m'+i, 'm');
    } 
})();

</script>

</body>
</html>