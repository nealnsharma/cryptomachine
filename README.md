# Enigma
## Based on the WWII Enigma machine

Enigma simulates the German cryptography machine used in WWII using Java to mimic the Enigma reciprocal substitution cipher algorithm to code and decode messages.



>The following are descriptions of the files:

- Makefile          
  - A Makefile for compiling, style checking, testing, and cleaning up files in this directory.
- Main.java          
  - Entry point to program. This handles program options and sets up the necessary objects to play one or more games.
- Model.java
  - This class describes game state: the positions of centers and barriers. It contains the logic for adding and removing barriers, testing that constraints are satisfied, and testing for a solution.
- Place.java
  - Encapsulates a position on the puzzle board.
- Controller.java 
  - Contains the logic for controlling a game: responding to commands by updating the model as apppropriate.
- CommandSource.java
  - An interface that for classes that provide commands
 to the Controller.
- GUISource.java
  - A CommandSource that fetches inputs from a user's
 mouse actions.
- PuzzleSource.java 
  - An interface to classes that can provide puzzles.

- TestSource.java 
  - A CommandSource and PuzzleSource that fetches
 commands and puzzles from the standard input.

- PuzzleGenerator.java
  - A kind of PuzzleSource that randomly generates
 puzzles.

- View.java 
  - Interface to classes that can display a Model.
- GUI.java 
  - A View that represents the graphical display of the
 game state and receives mouse actions from the user.
- BoardWidget.java 
  - Used by GUI to represent the grid of squares and tiles.
- Utils.java
  - A collection of static utility methods.
- UnitTests.java 
  - Main unit-test file. This dispatches to other *Tests
 classes for unit testing.
- ModelTests.java 
  - Unit tests for class Model.
- PuzzleGeneratorTests.java
  - Unit tests for class PuzzleGenerator.
                    
