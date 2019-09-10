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
public class DFlipFlop {
    private nand nand1 = new nand();
    private nand nand2 = new nand();
    private nand nand3 = new nand();
    private nand nand4 = new nand();
    private and and1 = new and();
    private or or1 = new or();
    private not not1 = new not();
    
    DFlipFlop() {
        this.setIput(false, true, true);
        this.calc();
        this.calc();
    }
    
    public void setIput(boolean D, boolean CLK, boolean enable) {
        and1.setInput(CLK, enable);
        and1.calc();
        
        not1.setInput(D, D);
        not1.calc();
        
        nand1.setInput(D, and1.getOutput());
        nand1.calc();
        
        nand2.setInput(not1.getOutput(), and1.getOutput());
        nand2.calc();                                
    }
    
    public void calc() {
        nand3.setInput(nand1.getOutput(), nand4.getOutput());
        nand3.calc();
        
        nand4.setInput(nand2.getOutput(), nand3.getOutput());
        nand4.calc();                
    }
    
    public boolean getOutput() {
        return nand3.getOutput();
    }
}
