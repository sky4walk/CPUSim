/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class not implements logicGate{
    private nand nand1 = new nand();
    @Override
    public void setInput(boolean a, boolean b) {
        nand1.setInput(a, a);
    }

    @Override
    public void calc() {
        nand1.calc();
    }

    @Override
    public boolean getOutput() {
        return nand1.getOutput();
    }
    
}
