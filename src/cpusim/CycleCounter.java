/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class CycleCounter {
    private Add8Bit add;
    private mux8Bit2x mux;
    private Register8Bit reg;
    private not notCyc1a = new not();
    private not notCyc1b = new not();
    private not notCyc2 = new not();
    private not notCyc3 = new not();
    private and andCyc1 = new and();
    private and andCyc2 = new and();
    private and andCyc3 = new and();
    private DataLine8Bit one = new DataLine8Bit();
    private DataLine8Bit zero = new DataLine8Bit();
    private DataLine8Bit regAlu = new DataLine8Bit();
    private DataLine8Bit aluMux = new DataLine8Bit();
    private DataLine8Bit muxReg = new DataLine8Bit();
    private DataLine1Bit andMux = new DataLine1Bit();
    private DataLine1Bit write = new DataLine1Bit();
    private DataLine1Bit cycle1;
    private DataLine1Bit cycle2;
    private DataLine1Bit cycle3;
    public CycleCounter(
            DataLine1Bit cycle1Line,
            DataLine1Bit cycle2Line,
            DataLine1Bit cycle3Line ) {
        cycle1 = cycle1Line;
        cycle2 = cycle2Line;
        cycle3 = cycle3Line;
        write.setPin(0, true);
        add = new Add8Bit(regAlu, one, aluMux, new DataLine1Bit(), new DataLine1Bit());
        mux = new mux8Bit2x(aluMux, zero, muxReg, cycle3);
        reg = new Register8Bit(muxReg, regAlu, write);
    }
    public void clkCycle() {
        add.calc();
        mux.calc();
        reg.clkCycle();
        
        notCyc1a.setInput(regAlu.getPin(0), regAlu.getPin(0));
        notCyc1b.setInput(regAlu.getPin(1), regAlu.getPin(1));
        
        notCyc2.setInput(regAlu.getPin(1), regAlu.getPin(1));
        notCyc3.setInput(regAlu.getPin(0), regAlu.getPin(0));
        
        andCyc1.setInput(notCyc1a.getOutput(), notCyc1b.getOutput());
        andCyc2.setInput(regAlu.getPin(0), notCyc2.getOutput());
        andCyc3.setInput(regAlu.getPin(1), notCyc3.getOutput());
        
        cycle1.setPin(0, andCyc1.getOutput());
        cycle2.setPin(0, andCyc2.getOutput());
        cycle3.setPin(0, andCyc3.getOutput());        
    }
    public DataLine8Bit getDebugCounter() {
        return regAlu;
    }
}
