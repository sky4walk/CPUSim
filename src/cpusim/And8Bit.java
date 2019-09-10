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
public class And8Bit {
    private DataLine8Bit aIn;
    private DataLine8Bit bIn;
    private DataLine8Bit cOut;
    private and andArr[] = new and[8];
    public And8Bit(        
            DataLine8Bit aInLine, 
            DataLine8Bit bInLine,
            DataLine8Bit cOutLine) {
        aIn = aInLine;
        bIn = bInLine;
        cOut = cOutLine;
        for ( int i = 0; i < andArr.length; i++ ) {
            andArr[i] = new and();
        } 
    }
    public void calc() {
        for ( int i = 0; i < andArr.length; i++ ) {
            andArr[i].setInput(aIn.getPin(0), bIn.getPin(0));
            andArr[i].calc();
            cOut.setPin(i, andArr[i].getOutput());
        } 
    }
}    
