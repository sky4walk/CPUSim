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
