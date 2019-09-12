/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class DataLine1Bit {
    private boolean pins[] = new boolean[1];
    public DataLine1Bit() {
        reset();
    }
    public void reset() {
        for ( int i = 0; i < pins.length; i++ ) {
            setPin(i,false);
        }        
    }
    public void setPin(int nr,boolean val) {
        if ( nr < pins.length ) {
            pins[nr] = val;
        }
    }
    public boolean getPin(int nr) {
        if ( nr < pins.length ) {
            return pins[nr];
        }
        return false;
    }
}
