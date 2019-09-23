/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class or implements logicGate{
    private nand nand1 = new nand();
    private not not1 = new not();
    private not not2 = new not();

    @Override
    public void setInput(boolean a, boolean b) {
        not1.setInput(a, a);
        not2.setInput(b, b);
    }

    @Override
    public void calc() {
        not1.calc();
        not2.calc();
        nand1.setInput(not1.getOutput(), not2.getOutput());
        nand1.calc();                
    }

    @Override
    public boolean getOutput() {
        return nand1.getOutput();
    }
    
}
