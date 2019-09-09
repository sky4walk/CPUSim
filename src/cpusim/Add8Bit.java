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
public class Add8Bit {
    private DataLine8Bit InA;
    private DataLine8Bit InB;
    private DataLine8Bit Out;
    private boolean inC = false;
    private boolean outC = false;
    
    Add8Bit() {        
    }
    public void setInput(DataLine8Bit a, DataLine8Bit b) {
        InA = a;
        InB = b;
    }
}
