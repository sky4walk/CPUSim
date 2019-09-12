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
public class Or8Bit {
    private DataLine8Bit aIn;
    private DataLine8Bit bIn;
    private DataLine8Bit cOut;
    private or orArr[] = new or[8];
    public Or8Bit(        
            DataLine8Bit aInLine, 
            DataLine8Bit bInLine,
            DataLine8Bit cOutLine) {
        aIn = aInLine;
        bIn = bInLine;
        cOut = cOutLine;
        for ( int i = 0; i < orArr.length; i++ ) {
            orArr[i] = new or();
        } 
    }
    public void calc() {
        for ( int i = 0; i < orArr.length; i++ ) {
            orArr[i].setInput(aIn.getPin(i), bIn.getPin(i));
            orArr[i].calc();
            cOut.setPin(i, orArr[i].getOutput());
        } 
    }
}
