API methods:
  * int 0..4 getState()
  * int 0..1 enter() // 1 if ok
  * int 0..1 confirm() // 1 if ok

## State 0 ##

Init.

Events
  * player enter -> 1

## State 1 ##

1 Player Entered.

Events
  * player enter -> 2
  * timeout -> 0

## State 2 ##

2 Players Entered

Events
  * timeout -> 1
  * confirm -> 3

## State 3 ##

1 Player Confirmed

Events
  * timeout -> 1
  * confirm -> 4

## State 4 ##

2 Players Confirmed

Events
  * timeout -> 1
  * game finished -> 1 (kick out lost player)