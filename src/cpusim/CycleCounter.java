/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
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
    private or or1 = new or();
    private DataLine8Bit one = new DataLine8Bit();
    private DataLine8Bit counter = new DataLine8Bit();
    private DataLine8Bit zero = new DataLine8Bit();
    private DataLine8Bit aluMux = new DataLine8Bit();
    private DataLine8Bit muxReg = new DataLine8Bit();
    private DataLine1Bit andMux = new DataLine1Bit();
    private DataLine1Bit orMux = new DataLine1Bit();
    private DataLine1Bit write = new DataLine1Bit();
    private DataLine1Bit reset;
    private DataLine1Bit cycle1;
    private DataLine1Bit cycle2;
    private DataLine1Bit cycle3;
    public CycleCounter(
            DataLine8Bit counterLine,
            DataLine1Bit resetLine,
            DataLine1Bit cycle1Line,
            DataLine1Bit cycle2Line,
            DataLine1Bit cycle3Line ) {
        counter = counterLine;
        reset = resetLine;
        cycle1 = cycle1Line;
        cycle2 = cycle2Line;
        cycle3 = cycle3Line;
        one.setBitsInt(1);
        zero.setBitsInt(0);
        write.setPin(0, true);
        add = new Add8Bit(counter, one, aluMux, new DataLine1Bit(), new DataLine1Bit());
        mux = new mux8Bit2x(aluMux, zero, muxReg, orMux);
        reg = new Register8Bit(muxReg, counter, write);
        calc();
    }
    private void calc() {
        notCyc1a.setInput(counter.getPin(0), counter.getPin(0));
        notCyc1a.calc();
        notCyc1b.setInput(counter.getPin(1), counter.getPin(1));
        notCyc1b.calc();
        
        notCyc2.setInput(counter.getPin(1), counter.getPin(1));
        notCyc2.calc();
        notCyc3.setInput(counter.getPin(0), counter.getPin(0));
        notCyc3.calc();
        
        andCyc1.setInput(notCyc1a.getOutput(), notCyc1b.getOutput());
        andCyc1.calc();
        andCyc2.setInput(counter.getPin(0), notCyc2.getOutput());
        andCyc2.calc();
        andCyc3.setInput(counter.getPin(1), notCyc3.getOutput());
        andCyc3.calc();
        
        cycle1.setPin(0, andCyc1.getOutput());
        cycle2.setPin(0, andCyc2.getOutput());
        cycle3.setPin(0, andCyc3.getOutput());
        
    }
    public void clkCycle() {
        or1.setInput(reset.getPin(0), andCyc3.getOutput());
        or1.calc();
        orMux.setPin(0, or1.getOutput());        

        add.calc();
        mux.calc();
        int r = muxReg.getBitsInt();
        reg.clkCycle();
        calc();
    }
    public DataLine8Bit getDebugCounter() {
        return counter;
    }
}
