Main.class: Game.class Player.class Solver.class TwoPlayer.class Main.java
	javac Main.java
TwoPlayer.class: Player.class TwoPlayer.java
	javac TwoPlayer.java
Player.class: Game.class Row.java Player.java
	javac Player.java
Solver.class: Row.class Solver.java Game.class
	javac Solver.java
Game.class: Row.class Game.java
	javac Game.java
Row.class: Row.java
	javac Row.java
run:
	java Main
clean:
	rm *.class
