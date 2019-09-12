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
    
    demux1Bit2x() {        
    }
    
    public void setInput(boolean a, boolean S) {
        not1.setInput(S, S);
        not1.calc();
        
        and1.setInput(a, not1.getOutput());        
        and2.setInput(a, S);
    }
    
    public void calc() {
        and1.calc();
        and2.calc();        
    }
    
    public boolean getOutputA() {
        return and1.getOutput();
    }
    
    public boolean getOutputB() {
        return and2.getOutput();
    }
}
