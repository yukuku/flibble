
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

Flibble.query2 = function(user, gname, callback) {
	Flibble.call('query2', {user: user, gname: gname}, callback);
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

Flibble.loadInit = function(user, gname, callback) {
	Flibble.call('LoadInit', {user: user, gname: gname}, callback);
}
