/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class mux1Bit2x {
    private not not1 = new not();
    private and and1 = new and();
    private and and2 = new and();
    private or or1 = new or();
    private DataLine1Bit aIn;
    private DataLine1Bit bIn;
    private DataLine1Bit cOut;
    private DataLine1Bit S;

    public mux1Bit2x(
            DataLine1Bit aInLine,
            DataLine1Bit bInLine,
            DataLine1Bit cOutLine,
            DataLine1Bit SLine
    ) {
        aIn = aInLine;
        bIn = bInLine;
        cOut = cOutLine;
        S = SLine;
    }
    
    public void calc() {
        not1.setInput(S.getPin(0), S.getPin(0));
        not1.calc();
        
        and1.setInput(aIn.getPin(0), not1.getOutput());
        and1.calc();
        
        and2.setInput(bIn.getPin(0), S.getPin(0));
        and2.calc();                

        or1.setInput(and1.getOutput(), and2.getOutput());
        or1.calc();
        
        cOut.setPin(0, or1.getOutput());
    }
}
