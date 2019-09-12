/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class halfAdd {
    private xor xor1 = new xor();
    private and and1 = new and();
    
    halfAdd() {        
    }
    
    public void setInput(boolean a, boolean b) {
        xor1.setInput(a, b);
        and1.setInput(a, b);
    }
    
    public void calc() {
        xor1.calc();
        and1.calc();
    }
    
    public boolean getOutputA() {
        return xor1.getOutput();
    }
    
    public boolean getOutputU() {
        return and1.getOutput();
    }
}
