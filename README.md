# German Cryptography Machine
## Based on the WWII Enigma machine

Enigma simulates the German cryptography machine used in WWII using Java to mimic the Enigma reciprocal substitution cipher algorithm to code and decode messages. 
The device consists of a simple mechanical system of rotors which are wired together internally so as to effect a permutation of signals coming in from one side onto the contacts on the other (and the inverse permutation when going in the reverse direction). To the left of the rotors, there is a reflector with contacts on their right sides only, and wired to connect half of those contacts to the other half. A signal starting from the rightmost rotor enters through one of the 26 possible contacts, flows through wires in the rotors, "bounces" off the reflector, and then comes back through the same rotors (in reverse) by a different route, always ending up being permuted to a letter position different from where it started. Each rotor and each reflector implements a different permutation, and the overall effect depends on their configuration: which rotors and reflector are used, what order they are placed in the machine, and which rotational position they are initially set to. This configuration is the first part of the secret key used to encrypt or decrypt a message. 

>The following are descriptions of the files:
- Alphabet.java
  - Provides a mapping from characters to and from indices into the alphabet.
- EnigmaException.java
  - A general-purpose error-reporting exception for this package.
- FixedRotor.java
  - Represents a rotor that has no ratchet and does not advance.
- Machine.java
  - Represents the complete machine.
- Main.java
  - Entry point to program. This handles program options and takes in a text file to return the coded or decoded output based on the specified rotor and reflector settings.
- MovingRotor.java
  - Represents a rotor that has a ratchet and can advance.
- MovingRotorTest.java
  -  The suite of all JUnit tests for the MovingRotor class.
- Permutation.java
  - Represents a permutation of a range of integers starting at 0 corresponding to the characters of an alphabet.
- PermutationTest.java
  - The suite of all JUnit tests for the Permutation class.
- Reflector.java
  - Represents a reflector in the enigma.
- Rotor.java
  - Superclass that represents a rotor in the enigma machine.
- TestUtils.java
  - Utility definitions for use in unit tests.
- UnitTest.java
  - The suite of all JUnit tests for the enigma package.
