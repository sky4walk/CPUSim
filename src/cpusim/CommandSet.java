/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class CommandSet {
    private mux1Bit4x mux1;
    private mux1Bit4x mux2;
    private mux1Bit4x mux3;
    private mux1Bit4x mux4;
    private mux1Bit4x mux5;
    private mux1Bit4x mux6;
    private mux1Bit4x mux7;
    private mux1Bit4x mux8;
    private mux1Bit4x mux9;
    private mux1Bit4x mux10;
    private mux1Bit4x mux11;
    private mux1Bit4x mux12;
    private mux1Bit4x mux13;
    private Or2x or1;
    private Or2x or2;
    private Or2x or3;
    private Or2x or4;
    private Or2x or5;
    private Or3x or6;
    private Or4x or7;
    private Or5x or8;
    private And2x and1;
    private Not1x not1;
    private DataLine1Bit zero = new DataLine1Bit();
    private DataLine1Bit one = new DataLine1Bit();
    private DataLine2Bit muxLine = new DataLine2Bit();
    public CommandSet(
            DataLine8Bit cklCounter,
            DataLine1Bit LDR,
            DataLine1Bit STR,
            DataLine1Bit MR1R2,
            DataLine1Bit JPZ,
            DataLine1Bit AND,
            DataLine1Bit OR,
            DataLine1Bit ADD,
            DataLine1Bit SUB,
            DataLine1Bit PCSelect,
            DataLine1Bit PCLoad,
            DataLine1Bit Write,
            DataLine1Bit InstructionLoad,
            DataLine1Bit ImmediateLoad,
            DataLine1Bit RegisterWrite,
            DataLine1Bit dRegSel,
            DataLine1Bit sRegSel,
            DataLine2Bit regSel,
            DataLine2Bit opSel,
            DataLine2Bit addressSel) {
        // construct one bit line
        zero.reset();
        not1 = new Not1x(zero, one);
        not1.calc();
        //mux dataline in
        muxLine.setDataLine(0, cklCounter.getDataLine(0));
        muxLine.setDataLine(1, cklCounter.getDataLine(1));
        
        
    }
    public void calc() {
        
    }
}
