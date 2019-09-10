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
public class Register8Bit {
    private DataLine8Bit in;
    private DataLine8Bit out;
    private DataLine1Bit clk;
    private DataLine1Bit enable;
    private DFlipFlop flipFlop[] = new DFlipFlop[8];
    public Register8Bit(        
            DataLine8Bit inLine, 
            DataLine8Bit outLine,
            DataLine1Bit clkLine,
            DataLine1Bit enableLine) {
        this.in     = inLine;
        this.out    = outLine;
        this.clk    = clkLine;
        this.enable = enableLine;
        for ( int i = 0; i < flipFlop.length; i++ ) {
            flipFlop[i] = new DFlipFlop();
            out.setPin(i, flipFlop[i].getOutput());
        }  
    }
    public void calc() {
        for ( int i = 0; i < flipFlop.length; i++ ) {
            flipFlop[i].setIput(in.getPin(i), clk.getPin(0), enable.getPin(0));
            flipFlop[i].calc();
            out.setPin(i, flipFlop[i].getOutput());
        }
    }
}
