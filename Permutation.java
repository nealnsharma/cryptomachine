package enigma;

import java.util.ArrayList;
import java.util.Arrays;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author neal
 */
class Permutation {

    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters in the
     *  alphabet that are not included in any cycle map to themselves.
     *  Whitespace is ignored. */
    Permutation(String cycles, Alphabet alphabet) {
        _alphabet = alphabet;
        String s = cycles.replace("(", "").replace(")", "");
        _cycles = new ArrayList<>(Arrays.asList(s.split(" ")));
    }

    /** Add the cycle c0->c1->...->cm->c0 to the permutation, where CYCLE is
     *  c0c1...cm. */
    private void addCycle(String cycle) {
        _cycles.add(cycle);
    }

    /** Return the value of P modulo the size of this permutation. */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /** Returns the size of the alphabet I permute. */
    int size() {
        return _alphabet.size();
    }

    /** Return the result of applying this permutation
     * to P modulo the alphabet size.
     * */
    int permute(int p) {
        int pWrap = wrap(p);
        char c = _alphabet.toChar(pWrap);
        int nextIndex;
        char result;
        for (String s: _cycles) {
            if (s.indexOf(c) != -1) {
                nextIndex = s.indexOf(c) + 1;
                if (nextIndex >= s.length()) {
                    nextIndex = 0;
                }
                result = s.charAt(nextIndex);
                return _alphabet.toInt(result);
            }
        }
        return pWrap;
    }

    /** Return the result of applying the inverse of this permutation
     *  to  C modulo the alphabet size. */
    int invert(int c) {
        int cWrap = wrap(c);
        char ch = _alphabet.toChar(cWrap);
        int nextIndex;
        char result;
        for (String s: _cycles) {
            if (s.indexOf(ch) != -1) {
                nextIndex = s.indexOf(ch) - 1;
                if (nextIndex == -1) {
                    nextIndex = s.length() - 1;
                }
                result = s.charAt(nextIndex);
                return _alphabet.toInt(result);
            }
        }
        return cWrap;
    }

    /** Return the result of applying this permutation to the index of P
     *  in ALPHABET, and converting the result to a character of ALPHABET. */
    char permute(char p) {
        int index = _alphabet.toInt(p);
        return _alphabet.toChar(permute(index));
    }

    /** Return the result of applying the inverse of this permutation to C. */
    char invert(char c) {
        int index = _alphabet.toInt(c);
        return _alphabet.toChar(invert(index));
    }

    /** Return the alphabet used to initialize this Permutation. */
    Alphabet alphabet() {
        return _alphabet;
    }

    /** Return true iff this permutation is a derangement (i.e., a
     *  permutation for which no value maps to itself). */
    boolean derangement() {
        for (String cycle: _cycles) {
            if (cycle.length() == 1) {
                return false;
            }
        }
        return true;
    }

    /** Alphabet of this permutation. */
    private Alphabet _alphabet;
    /** The cycles in an array list. */
    private ArrayList<String> _cycles;
}
