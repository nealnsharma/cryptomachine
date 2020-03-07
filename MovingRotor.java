package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a rotating rotor in the enigma machine.
 *  @author neal sharma
 */
class MovingRotor extends Rotor {

    /** A rotor named NAME whose permutation in its default setting is
     *  PERM, and whose notches are at the positions indicated in NOTCHES.
     *  The Rotor is initally in its 0 setting (first character of its
     *  alphabet).
     */
    MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);
        _permutation = perm;
        _notches = notches;
    }
    @Override
    boolean rotates() {
        return true;
    }
    @Override
    boolean atNotch() {
        for (int i =  0; i < _notches.length(); i++) {
            int notch = alphabet().toInt(_notches.charAt(i));
            if (notch == setting()) {
                return true;
            }
        }
        return false;
    }

    @Override
    void advance() {
        int next = _permutation.wrap(setting() + 1);
        set(next);
    }

    /** My permutation. */
    private Permutation _permutation;
    /** My notches. */
    private String _notches;


}
