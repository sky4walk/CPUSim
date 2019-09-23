/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class Not1x {
    private not not1 = new not();
    private DataLine1Bit x1 = new DataLine1Bit();
    private DataLine1Bit out = new DataLine1Bit();
    public Not1x(
        DataLine1Bit x1Line,
        DataLine1Bit outLine ) {
        x1 = x1Line;
        out = outLine;
    }
    public void calc() {
        not1.setInput(x1.getPin(0), x1.getPin(0));
        not1.calc();
        out.setPin(0, not1.getOutput());
    }    
}
