/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@AndreBetz.de
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
    private DataLine1Bit or6mux2_5 = new DataLine1Bit();
    private DataLine1Bit or1mux3 = new DataLine1Bit();
    private DataLine1Bit and1or1 = new DataLine1Bit();
    private DataLine1Bit or81mux6 = new DataLine1Bit();
    private DataLine1Bit or7or2mux8_10 = new DataLine1Bit();
    private DataLine1Bit or2mux7 = new DataLine1Bit();
    private DataLine1Bit or3mux13 = new DataLine1Bit();
    private DataLine1Bit or4mux11 = new DataLine1Bit();
    private DataLine1Bit or5mux12 = new DataLine1Bit();
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
            DataLine1Bit zFlag,
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
        // connect logic gates
        and1 = new And2x(zFlag, JPZ, and1or1);
        or1 = new Or2x(STR, and1or1 , or1mux3);
        or7 = new Or4x(AND, OR, ADD, SUB, or7or2mux8_10);
        or2 = new Or2x(MR1R2, or7or2mux8_10, or2mux7);
        or3 = new Or2x(LDR, STR, or3mux13);
        or4 = new Or2x(OR, SUB, or4mux11);
        or5 = new Or2x(ADD, SUB, or5mux12);
        or6 = new Or3x(LDR, STR, JPZ, or6mux2_5);
        or8 = new Or5x(MR1R2, AND, OR, ADD, SUB, or81mux6);
        mux1  = new mux1Bit4x(zero, zero,          JPZ,      zero, PCSelect,                  muxLine);
        mux2  = new mux1Bit4x(one,  or6mux2_5,     zero,     zero, PCLoad,                    muxLine);
        mux3  = new mux1Bit4x(zero, zero,          or1mux3,  zero, Write,                     muxLine);
        mux4  = new mux1Bit4x(one,  zero,          zero,     zero, InstructionLoad,           muxLine);
        mux5  = new mux1Bit4x(zero, or6mux2_5,     zero,     zero, ImmediateLoad,             muxLine);
        mux6  = new mux1Bit4x(zero, or81mux6,      LDR,      zero, RegisterWrite,             muxLine);
        mux7  = new mux1Bit4x(zero, or2mux7,       zero,     zero, regSel.getDataLine(0),     muxLine);
        mux8  = new mux1Bit4x(zero, or7or2mux8_10, LDR,      zero, regSel.getDataLine(1),     muxLine);
        mux9  = new mux1Bit4x(zero, MR1R2,         zero,     zero, dRegSel,                   muxLine);
        mux10 = new mux1Bit4x(zero, or7or2mux8_10, zero,     zero, sRegSel,                   muxLine);
        mux11 = new mux1Bit4x(zero, or4mux11,      zero,     zero, opSel.getDataLine(0),      muxLine);
        mux12 = new mux1Bit4x(zero, or5mux12,      zero,     zero, opSel.getDataLine(1),      muxLine);
        mux13 = new mux1Bit4x(zero, zero,          or3mux13, zero, addressSel.getDataLine(0), muxLine);
    }
    public void calc() {
        and1.calc();
        or3.calc();
        or4.calc();
        or5.calc();
        or6.calc();
        or7.calc();
        or8.calc();
        // order is impoprtant
        or1.calc();
        or2.calc();
        mux1.calc();
        mux2.calc();
        mux3.calc();
        mux4.calc();
        mux5.calc();
        mux6.calc();
        mux7.calc();
        mux8.calc();
        mux9.calc();
        mux10.calc();
        mux11.calc();
        mux12.calc();
        mux13.calc();                
    }
}
