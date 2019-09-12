/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class demux1Bit2x {
    private not not1 = new not();
    private and and1 = new and();
    private and and2 = new and();
    private DataLine1Bit In;
    private DataLine1Bit aOut;
    private DataLine1Bit bOut;
    private DataLine1Bit S;
    public demux1Bit2x(
            DataLine1Bit InLine,
            DataLine1Bit aOutLine,
            DataLine1Bit bOutLine,
            DataLine1Bit SLine ) {
        In = InLine;
        aOut = aOutLine;
        bOut = bOutLine;
        S = SLine;
    }
    public void calc() {
        not1.setInput(S.getPin(0), S.getPin(0));
        not1.calc();
        
        and1.setInput(In.getPin(0), not1.getOutput());        
        and2.setInput(In.getPin(0), S.getPin(0));
        
        and1.calc();
        and2.calc();
        
        aOut.setPin(0, and1.getOutput());
        bOut.setPin(0, and2.getOutput());
    }
}
