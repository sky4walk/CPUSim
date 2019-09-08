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
