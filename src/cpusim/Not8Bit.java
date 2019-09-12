/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
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
            notArr[i].setInput(aIn.getPin(i), aIn.getPin(i));
            notArr[i].calc();
            cOut.setPin(i, notArr[i].getOutput());
        } 
    }
}
