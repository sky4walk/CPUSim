/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class And3x {
    private and and1 = new and();
    private and and2 = new and();
    public And3x() {        
    }
    public void setInput(boolean a, boolean b, boolean c) {
        and1.setInput(a, b);
        and1.calc();
        and2.setInput(and1.getOutput(), c);
        and2.calc();
    }
    public boolean getOutput() {
        return and2.getOutput();
    }
}
