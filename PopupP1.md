### Nickname ###
`[Form input text]`<sup>1</sup>

### Join Table ###
(Horizontal list of table with nicknames of other players)<sup>2</sup>

### or **Create a new Table**<sup>3</sup> ###


---


<sup>1</sup> Max length = 20, size = 12

<sup>2</sup> onclick:
```
s = getSession(nick, tableId)
goto page H2{sessionId: s}
```


<sup>3</sup> onclick:
```
s = getSession(nick, 0)
goto page H2{sessionId: s}
```