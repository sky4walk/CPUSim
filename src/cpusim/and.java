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
public class and implements logicGate{
    private nand nand1 = new nand();
    private not not1 = new not();
    
    @Override
    public void setInput(boolean a, boolean b) {
        nand1.setInput(a, b);
    }

    @Override
    public void calc() {
        nand1.calc();
        boolean outVal = nand1.getOutput();
        not1.setInput(outVal, false);
        not1.calc();
    }

    @Override
    public boolean getOutput() {
        return not1.getOutput();
    }
    
    
}
