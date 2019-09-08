/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusim;

/**
 *
 * @author andre
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
