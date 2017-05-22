# UNO
# UNO Game Simulation in JAVA

- Model
- UnoGame
  Consulted first the number of players.
  
  initialization:
  Creates a static table [108] with all the cards in the deck of the uno which
  share with random way the players and after it is erased (null).
  
  We have a repetition for each player. Within each repetition builds a table with
  the papers that deal every player.
  We create the object the player and the initialized.
  When finished the repetition initializes the stack draw and discard the paper that
  stuck.
  
  The game is played in step 1 (normal series) or -1 (reverse).
  In each round the player selects a paper, if the method of (match) returns true the card
  delisting cards the player and gets push the discard stack.
  
  In case a player is left with two cards must enable
  uno choice in this round and then act, if not the player gets two cards.
  
  When the table with the cards a player adiasei-ending the game and follow
  calculated winner's points.

- Player
  We create for each player a Player object that is stored in a table
  type Player.
  Each Player has a table with cards of who initializes the
  creation of a player.
  With the methods of class manage (delete and insert) the card table.
  Furthermore methods are 
  a) A PlayerPoints method that calculates the total
  Points of cards
  b) The method ArraySort to place the cards of the players during the first places of the table.

- Card
  Abstract superclass Card has six subclasses are represented different
  paper type. In each subclass Amend appropriate method for each one.
  Each subclass contains the match method which checks if the card within a type
  fits with the card in DiscardPile.
  
- Pile
  The pile is abstract classes and two subclasses:
  draw pile (the stack of unused papers)
  discard pile (the stack with cards dropping).
  The subclass inherits all the methods of Pile where MATERIALIZED basic steps for
  the stack (push, pop, peek ...)
  In subclasses Discard pile situated a method of adding layers of observers
  in a list. Furthermore it has a routine to keep all observers after
  Any change of the stack.
