/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */

package cpusim;

/**
 *
 * @author github@andrebetz.de
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
            DataLine1Bit enableLine) {
        this.in     = inLine;
        this.out    = outLine;
        this.enable = enableLine;
        for ( int i = 0; i < flipFlop.length; i++ ) {
            flipFlop[i] = new DFlipFlop();
            out.setPin(i, flipFlop[i].getOutput());
        }  
    }
    public void clkCycle() {
        for ( int i = 0; i < flipFlop.length; i++ ) {
            flipFlop[i].setIput(in.getPin(i), enable.getPin(0));
            flipFlop[i].clkCycle();
            out.setPin(i, flipFlop[i].getOutput());
        }
    }
    public void write(int dat) {
        DataLine8Bit input = new DataLine8Bit();
        input.setBitsInt(dat);
        for ( int i = 0; i < flipFlop.length; i++ ) {
            flipFlop[i].setIput(input.getPin(i), true);
            flipFlop[i].clkCycle();
            out.setPin(i, flipFlop[i].getOutput());
        }
    }
    public int read() {
        return out.getBitsInt();
    }
}
