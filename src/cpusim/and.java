/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */

package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class and implements logicGate{
    private nand nand1 = new nand();
    private not not1 = new not();
    
    @Override
    public void setInput(boolean a, boolean b) {
        nand1.setInput(a, b);
    }

    @Override
    public void calc() {
        nand1.calc();
        boolean outVal = nand1.getOutput();
        not1.setInput(outVal, false);
        not1.calc();
    }

    @Override
    public boolean getOutput() {
        return not1.getOutput();
    }
    
    
}
