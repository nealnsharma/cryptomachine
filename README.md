# Enigma
## Based on the WWII Enigma machine

Enigma simulates the German cryptography machine used in WWII using Java to mimic the Enigma reciprocal substitution cipher algorithm to code and decode messages. 
The device consists of a simple mechanical system of rotors which are wired together internally so as to effect a permutation of signals coming in from one side onto the contacts on the other (and the inverse permutation when going in the reverse direction). To the left of the rotors, there is a reflector with contacts on their right sides only, and wired to connect half of those contacts to the other half. A signal starting from the rightmost rotor enters through one of the 26 possible contacts, flows through wires in the rotors, "bounces" off the reflector, and then comes back through the same rotors (in reverse) by a different route, always ending up being permuted to a letter position different from where it started. Each rotor and each reflector implements a different permutation, and the overall effect depends on their configuration: which rotors and reflector are used, what order they are placed in the machine, and which rotational position they are initially set to. This configuration is the first part of the secret key used to encrypt or decrypt a message. 

>The following are descriptions of the files:
- Alphabet.java
  - asdf
- EnigmaException.java
- FixedRotor.java
- Machine.java
- Main.java
  - Entry point to program. This handles program options and takes in a text file to return the coded or decoded output based on the specified rotor and reflector settings.
- MovingRotor.java
- MovingRotorTest.java
- Permutation.java
- PermutationTest.java
- Reflector.java
- Rotor.java
- TestUtils.java
- UnitTest.java
