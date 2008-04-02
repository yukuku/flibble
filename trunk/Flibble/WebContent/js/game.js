
// constants
var SUCCESS = 'SUCCESS';
var FAILURE = 'FAILURE';

var Flibble = {};

	
Flibble.call = function(action, params, callback) {
	params.action = action;
	new Ajax.Request('GameController', {
		method: 'get',
		parameters: params,
		onSuccess: function (xml) {
			var obj = YAHOO.lang.JSON.parse(xml.responseText);
			callback(obj);
		}
	});
}

Flibble.getTables = function(callback) {
	Flibble.call('query', {user: ''+Math.random()}, callback);
}

Flibble.createGame = function(nick, callback) {
	Flibble.call('CGame', {user: nick}, callback);
}

Flibble.joinGame = function(nick, gameName, callback) {
	Flibble.call('JoinIn', {user: nick, gname: gameName}, callback);
}

Flibble.login = function(nick, callback) {
	Flibble.call('login', {user: nick}, callback);
}

//=============================
Flibble.checkGameStart = function(nick, gname) {
	Flibble.call('query', gamevars, function checkGameStatus(res) {
		if(res.Status == SUCCESS) {
				for(var i=0; i< res.Games.length; i++) {
					if (res.Games[i].GameName == gname) {
						if (res.Games[i].GStatus == 'PLAYING') {
								alert('loadini function call here');
								// to change this part to return
						}
						else {
							alert('game not started');
						}
					}
				}
		}
	}
	);
	return false
}
