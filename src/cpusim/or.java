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
public class or implements logicGate{
    private nand nand1 = new nand();
    private not not1 = new not();
    private not not2 = new not();

    @Override
    public void setInput(boolean a, boolean b) {
        not1.setInput(a, a);
        not2.setInput(b, b);
    }

    @Override
    public void calc() {
        not1.calc();
        not2.calc();
        nand1.setInput(not1.getOutput(), not2.getOutput());
        nand1.calc();                
    }

    @Override
    public boolean getOutput() {
        return nand1.getOutput();
    }
    
}
