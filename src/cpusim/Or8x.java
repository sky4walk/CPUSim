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
public class Or8x {
    private or or1 = new or();
    private or or2 = new or();
    private or or3 = new or();
    private or or4 = new or();
    private or or5 = new or();
    private or or6 = new or();
    private or or7 = new or();
    private DataLine8Bit in;
    private DataLine1Bit out;        
    public Or8x(
        DataLine8Bit inLine,
        DataLine1Bit outLine) {
        in = inLine;
        out = outLine;
    }
    public void calc() {
        or1.setInput(in.getPin(0), in.getPin(1));
        or2.setInput(in.getPin(2), in.getPin(3));
        or3.setInput(in.getPin(4), in.getPin(5));
        or4.setInput(in.getPin(6), in.getPin(7));
        or1.calc();
        or2.calc();
        or3.calc();
        or4.calc();
        or5.setInput(or1.getOutput(), or2.getOutput());
        or6.setInput(or3.getOutput(), or4.getOutput());
        or5.calc();
        or6.calc();
        or7.setInput(or5.getOutput(), or6.getOutput());        
        or7.calc();
    }
}
