/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusim;

/**
 *
 * @author andre
 */
public class DataLine8Bit {
    private boolean pins[] = new boolean[8];
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
    public void setPins(DataLine8Bit bits) {
        for ( int i = 0; i < pins.length; i++ ) {
            setPin(i,bits.getPin(i));
        }
    }
    public String getBitsString() {
        String bits = "";
        for ( int i = 0; i < pins.length; i++ ) {
            bits += pins[pins.length - 1 - i];
        }
        return bits;
    }
    public int getBitsInt() {
        int bits = 0;
        int cnt = 1;
        for ( int i = 0; i < pins.length; i++ ) {
            if ( true == pins[i] ) {
                bits += cnt;
            }
            cnt *= 2;
        }
        return bits;
    }
}
