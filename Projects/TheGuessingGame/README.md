# Summary:
The Guessing Game involves a game object and three player objects. The game generates a random number between 0 and 9,
and the three player objects try to guess it.

# Classes:
GuessGame.class, Player.class, GameLauncher.class

# The Logic:
1. the GameLauncher class is where the application starts; it has the main() method.
2. in the main() method, a GuessGame object is created, and its startGame() method is called.
3. The GuessGame object's startGame() method is where the entire game plays out. it creates three players and then 
    generates a random number (the target for the players to guess). It then asks each player to guess, checks the
    result, and either prints out information about the winning player(s) or asks them to guess again.

# Output after calling startGame():
_I'm thinking of a number between 0 and 9...
Number to guess is 3
I'm guessing 5
I'm guessing 8
I'm guessing 2
Player 1 guessed 5
Player 2 guessed 8
Player 3 guessed 2
Players will have to try again.
I'm guessing 5
I'm guessing 9
I'm guessing 3
Player 1 guessed 5
Player 2 guessed 9
Player 3 guessed 3
We have a winner!
Player 1 got it right? false
Player 2 got it right? false
Player 3 got it right? true
Game is over._