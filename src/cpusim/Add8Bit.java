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
    private DataLine8Bit aIn;
    private DataLine8Bit bIn;
    private DataLine8Bit cOut;
    private DataLine1Bit uIn;
    private DataLine1Bit uOut;
    private Add1Bit adder[] = new Add1Bit[8];
    public Add8Bit(        
            DataLine8Bit aInLine, 
            DataLine8Bit bInLine,
            DataLine8Bit cOutLine,
            DataLine1Bit uInLine,
            DataLine1Bit uOutLine) {
        this.aIn  = aInLine;
        this.bIn  = bInLine;
        this.cOut = cOutLine;
        this.uIn  = uInLine;
        this.uOut = uOutLine;
        for ( int i = 0; i < adder.length; i++ ) {
            adder[i] = new Add1Bit();
        }  
    }
    public void calc() {
        adder[0].setInput(aIn.getPin(0), bIn.getPin(0), uIn.getPin(0));
        adder[0].calc();
        cOut.setPin(0, adder[0].getOutputA() );
        for ( int i = 1; i < adder.length; i++ ) {
            adder[i].setInput(aIn.getPin(i), bIn.getPin(i), adder[i-1].getOutputU());
            adder[i].calc();            
            cOut.setPin(i, adder[i].getOutputA() );
        }
        uOut.setPin(0, adder[adder.length-1].getOutputU());
    }
}
