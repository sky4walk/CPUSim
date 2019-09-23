/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class xor implements logicGate{
    private nand nand1 = new nand();
    private nand nand2 = new nand();
    private nand nand3 = new nand();
    private nand nand4 = new nand();
    @Override
    public void setInput(boolean a, boolean b) {
        nand1.setInput(a, b);
        nand1.calc();
        
        nand2.setInput(a, nand1.getOutput());
        nand2.calc();
        
        nand3.setInput(b, nand1.getOutput());
        nand3.calc();
        
        nand4.setInput(nand2.getOutput(), nand3.getOutput());        
    }

    @Override
    public void calc() {
        nand4.calc();
    }

    @Override
    public boolean getOutput() {
        return nand4.getOutput();
    }
    
}
