package enigma;

import java.util.ArrayList;
import java.util.Collection;

/** Class that represents a complete enigma machine.
 *  @author neal sharma
 */
class Machine {

    /**
     * A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     * and 0 <= PAWLS < NUMROTORS pawls.  ALLROTORS contains all the
     * available rotors.
     */
    Machine(Alphabet alpha, int numRotors, int pawls,
            Collection<Rotor> allRotors) {
        _alphabet = alpha;
        _numRotors = numRotors;
        _pawls = pawls;
        _allRotors = new ArrayList<Rotor>(allRotors);
        _myRotors = new ArrayList<>();
    }

    /**
     * Return the number of rotor slots I have.
     */
    int numRotors() {
        return _numRotors;
    }

    /**
     * Return the number pawls (and thus rotating rotors) I have.
     */
    int numPawls() {
        return _pawls;
    }



    /**
     * Set my rotor slots to the rotors named ROTORS from my set of
     * available rotors (ROTORS[0] names the reflector).
     * Initially, all rotors are set at their 0 setting.
     */
    void insertRotors(String[] rotors) {
        _myRotors.clear();
        if (rotors.length != _numRotors) {
            throw new EnigmaException("Incorrect amount of rotors.");
        }
        for (int i = 0; i < rotors.length - 1; i++) {
            for (int j = i + 1; j < rotors.length; j++) {
                if (rotors[i].equals(rotors[j])) {
                    throw new EnigmaException("Duplicate rotor provided.");
                }
            }
        }
        for (String rotorName : rotors) {
            for (Rotor rotor : _allRotors) {
                if (rotorName.equals(rotor.name())) {
                    _myRotors.add(rotor);
                }
            }
        }
        if (!_myRotors.get(0).reflecting()) {
            throw new EnigmaException("The first rotor is not a reflector.");
        }
        for (int i = 1; i <= _numRotors - _pawls - 1; i++) {
            if (_myRotors.get(i).rotates()) {
                throw new EnigmaException("Improper rotor order.");
            }
        }
        for (int i = _numRotors - _pawls; i < _numRotors; i++) {
            if (!_myRotors.get(i).rotates()) {
                throw new EnigmaException("Improper rotor order.");
            }
        }

    }

    /**
     * Set my rotors according to SETTING, which must be a string of
     * numRotors()-1 characters in my alphabet. The first letter refers
     * to the leftmost rotor setting (not counting the reflector).
     */
    void setRotors(String setting) {
        if (setting.length() != numRotors() - 1) {
            throw new EnigmaException("Incorrect number of settings.");
        }
        for (int i = 0; i < setting.length(); i++) {
            if (!_alphabet.contains(setting.charAt(i))) {
                throw new EnigmaException("Mistyped setting string.");
            }
            _myRotors.get(i + 1).set(setting.charAt(i));
        }
    }

    /**
     * Set the plugboard to PLUGBOARD.
     */
    void setPlugboard(Permutation plugboard) {
        _plugboard = plugboard;
    }

    /**
     * Returns the result of converting the input character C (as an
     * index in the range 0..alphabet size - 1), after first advancing
     * the machine.
     */

    int convert(int c) {
        int result = _plugboard.permute(c);
        final int last = _numRotors - 1;

        boolean[] atNotch = new boolean[_numRotors];
        for (int i = 0; i <= last; i++) {
            atNotch[i] = _myRotors.get(i).atNotch();
        }
        if (!atNotch[last]) {
            _myRotors.get(last).advance();
        }
        for (int i = last; i > 0; i--) {
            if (atNotch[i]) {
                _myRotors.get(i).advance();
                if (!atNotch[i - 1]) {
                    _myRotors.get(i - 1).advance();
                }
            }
        }

        for (int i = last; i >= 0; i--) {
            result = _myRotors.get(i).convertForward(result);
        }
        for (int i = 1; i <= last; i++) {
            result = _myRotors.get(i).convertBackward(result);
        }
        result = _plugboard.permute(result);
        return result;
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        String result = "";
        for (int i = 0; i < msg.length(); i++) {
            int converted = convert(_alphabet.toInt(msg.charAt(i)));
            char encoded = _alphabet.toChar(converted);
            result += encoded;
        }
        return result;
    }

    /** Common alphabet of my rotors. */
    private final Alphabet _alphabet;

    /** The number of rotors. */
    private final int _numRotors;

    /** The number of pawls. */
    private final int _pawls;

    /** The list of all rotors that can be used. */
    private final ArrayList<Rotor> _allRotors;

    /** The ordered list of rotors used in the machine. */
    private final ArrayList<Rotor> _myRotors;

    /** The plugboard that is initialized. */
    private Permutation _plugboard;
}
