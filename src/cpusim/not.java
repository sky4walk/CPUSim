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
public class not implements logicGate{
    private nand nand1 = new nand();
    @Override
    public void setInput(boolean a, boolean b) {
        nand1.setInput(a, a);
    }

    @Override
    public void calc() {
        nand1.calc();
    }

    @Override
    public boolean getOutput() {
        return nand1.getOutput();
    }
    
}
