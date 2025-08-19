# NumQuest---Java
NumQuest is a simple yet dynamic number guessing game written in Java.
The program randomly selects a secret number within a user-defined range, and the player must guess it within a limited number of attempts.
Unlike static games, NumQuest calculates the maximum attempts dynamically based on the chosen range (using a binary search–style formula), making the game fair and adaptive.

(OOP) Concepts Applied

Class & Object → GuessingGame class defines the game, and an object is created to play.
Encapsulation → Game data (low, high, secret, attempts) and behavior (play) are bundled together.
Abstraction → Complexity of attempt calculation and random number generation is hidden from the player.
Reusability → The GuessingGame class can be reused in other projects or extended with more features.
