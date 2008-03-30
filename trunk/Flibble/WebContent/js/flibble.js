//document.write('<script type="text/javascript" src="prototype.js"></script>');
var SvrCtrl = "/Flibble/GameController?";
var FbSUCCESS = "SUCCESS";
var FbFAILURE = "FAILURE";

function FbInit(){
	$('div_Login').show();
	$('div_GameRoom').hide();
	$('div_GamePanel').hide();
	$('div_CGame').hide();
}

//=============================
//=============================

function FbCGame(){
	var qryStr = $('form_div_CGame').serialize();
	qryStr += "&user=" + $('txt_form_div_Login').value;
	FbAjax(qryStr, FbSyncGameRoom);
}

function FbLogin(){
	var qryStr = $('form_div_Login').serialize();
	FbAjax(qryStr, FbShowWellCome);
}

function FbAjax(qryStr, fnct){
	new Ajax.Request(SvrCtrl + qryStr,
	  {
	    method:'get',
	    onSuccess: function(transport){
	    	ResponseEval(transport.responseText, fnct);
	    },
	    onFailure: function(){FbLogErr('FbLogin err');}
	  });
}

function FbSyncGameRoom(jsonObj){
	alert("here");
	alert("game count:" + jsonObj.Games.length);
	var retstr = "";
	for(var i=0; i<jsonObj.Games.length; i++){
		retstr += "<div>" +  jsonObj.Games[i].UserA
			+ " vs " + jsonObj.Games[i].UserB
			+ " on " + jsonObj.Games[i].GameName 
			+ " </div>";
	}
	$('div_GameRoom').update(retstr);
}

function FbShowWellCome(jsonObj){
	var wellcome = "Wellcome, " + jsonObj.UserId + "";
	$('div_Wellcome').update(wellcome);
   	$('div_Login').hide();
	$('div_GamePanel').show();
	$('div_GameRoom').show();
	$('div_CGame').show();
	FbSyncGameRoom(jsonObj);
}

function ResponseEval(msg, fnct){
	var jsonObj = msg.evalJSON();
	$('div_Console').update(msg);
	if(jsonObj.Status = FbSUCCESS){
		fnct(jsonObj);
	}
	else {
		FbLogErr('ResponseEval err')
	}
}

function FbLogErr(varCaller){
	$('div_Console').update(varCaller + " encountered error");
}