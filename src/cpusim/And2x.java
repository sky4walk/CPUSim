/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class And2x {
    private and and1 = new and();
    private DataLine1Bit x1 = new DataLine1Bit();
    private DataLine1Bit x2 = new DataLine1Bit();
    private DataLine1Bit out = new DataLine1Bit();
    public And2x(
        DataLine1Bit x1Line,
        DataLine1Bit x2Line,
        DataLine1Bit outLine ) {
        x1 = x1Line;
        x2 = x2Line;
        out = outLine;
    }
    public void calc() {
        and1.setInput(x1.getPin(0), x2.getPin(0));
        and1.calc();
        out.setPin(0, and1.getOutput());
    }    
}
