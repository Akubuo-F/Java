# Goal:
Sink all the computer's Startups in the fewest number of guesses. You're given a rating based on how well you perform.

# Setup:
When the game program is launched, the computer places three Startups, randomly, on the virtual 7x7 grid. when that's
complete, the game asks for your first guess.

# How to play:
The computer will prompt you to enter a guess(a cell), which you'll type at the command line (as "A3", "C5", etc.). In
response to your guess, you'll see a result at the command line, either "hit", "miss", or "You sunk poniez" (or
whatever the lucky Startup of the day is). When you've sunk all three Startups, the game ends by printing out your
rating.

# The grid:
A |     |     |     |     |     |     |     |
B |     |     |  c  |     |     |     |     |
C |     |     |  c  |     |     |  p  |     |
D |     |     |  c  |  h  |     |  p  |     |
E |     |     |     |  h  |     |  p  |     |
F |     |     |     |  h  |     |     |     |
G |     |     |     |     |     |     |     |
H |     |     |     |     |     |     |     |
     0     1     2     3     4     5     6

# Output:
Enter a guess c2
Hit
Enter a guess c3
Miss
Enter a guess c1
Miss
Enter a guess d2
Hit
Enter a guess e2
Miss
Enter a guess b2
Ouch!, You sunk Cabista :(
Enter a guess c5
Hit
Enter a guess c6
Miss
Enter a guess b5
Miss
Enter a guess c4
Miss
Enter a guess d5
Hit
Enter a guess e5
Ouch!, You sunk Poniez :(
Enter a guess f2
Miss
Enter a guess f5
Miss
Enter a guess c0
Miss
Enter a guess f0
Miss
Enter a guess c1
Miss
Enter a guess f1
Miss
Enter a guess c3
Miss
Enter a guess f3
Hit
Enter a guess g3
Miss
Enter a guess e3
Hit
Enter a guess d3
Ouch!, You sunk Hacqi :(
All startups are dead!, Your Stock is now worthless
Need to be quicker than that. 23 guesses.