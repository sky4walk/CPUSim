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
public class mux1Bit2x {
    private not not1 = new not();
    private and and1 = new and();
    private and and2 = new and();
    private or or1 = new or();

    mux1Bit2x() {
        
    }
    
    public void setInput(boolean a, boolean b, boolean S) {
        not1.setInput(S, S);
        not1.calc();
        
        and1.setInput(a, S);
        and1.calc();
        
        and2.setInput(b, not1.getOutput());
        and2.calc();                
    }
    
    public void calc() {
        or1.setInput(and1.getOutput(), and2.getOutput());
        or1.calc();
    }
    
    public boolean getOutput() {
        return or1.getOutput();
    }
}
