/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class Add1Bit {
    private halfAdd ha1 = new halfAdd();
    private halfAdd ha2 = new halfAdd();
    private or or1 = new or();
    
    Add1Bit() {        
    }
    
    public void setInput(boolean a, boolean b, boolean U) {
        ha1.setInput(a, b);
        ha1.calc();
        
        ha2.setInput(U, ha1.getOutputA());
        ha2.calc();
        
        or1.setInput(ha1.getOutputU(), ha2.getOutputU());
    }
    
    public void calc() {
        or1.calc();
    }
    
    public boolean getOutputA() {
        return ha2.getOutputA();
    }
    
    public boolean getOutputU() {
        return or1.getOutput();
    }
}
