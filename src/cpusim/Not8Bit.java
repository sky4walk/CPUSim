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
public class Not8Bit {
    private DataLine8Bit aIn;
    private DataLine8Bit cOut;
    private not notArr[] = new not[8];
    public Not8Bit(        
            DataLine8Bit aInLine, 
            DataLine8Bit cOutLine) {
        aIn = aInLine;
        cOut = cOutLine;
        for ( int i = 0; i < notArr.length; i++ ) {
            notArr[i] = new not();
        } 
    }
    public void calc() {
        for ( int i = 0; i < notArr.length; i++ ) {
            notArr[i].setInput(aIn.getPin(0), aIn.getPin(0));
            notArr[i].calc();
            cOut.setPin(i, notArr[i].getOutput());
        } 
    }
}
