/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
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
            andArr[i].setInput(aIn.getPin(i), bIn.getPin(i));
            andArr[i].calc();
            cOut.setPin(i, andArr[i].getOutput());
        } 
    }
}    
