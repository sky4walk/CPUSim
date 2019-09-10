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
