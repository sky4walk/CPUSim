/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 * 			LDR Adr			SDR				MR1R2                           ADD				OR				SUB				AND				JPZ		
 * cycle		0	1	2	0	1	2		0	1	2		0	1	2		0	1	2		0	1	2		0	1	2		0	1	2
 *
 * PCSel		0	0	0	0	0	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	1
 * PCLoad		0	1	1	0	1	1		0	1	0		0	0	1		0	0	1		0	0	1		0	0	1		0	1	1 / 0 zFlag
 * AdrSel		0	0	1	0	0	1		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0
 * ramWrite		0	0	0	0	0	1		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0
 * InstructionLoad	1	0	0	1	0	0		1	0	0		1	0	0		1	0	0		1	0	0		1	0	0		1	0	0
 * ImmediateLoad	0	1	0	0	1	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0		0	1	0
 * regWrite		0	0	1	0	0	0		0	1	0		0	0	0		0	0	0		0	0	0		0	0	0		0	0	0
 * regSel		0	0	2	0	0	0		0	1	0		0	0	3		0	0	3		0	0	3		0	0	3		0	0	0
 * dRegSel		0	0	0	0	0	0		0	1	0		0	0	1		0	0	1		0	0	1		0	0	1		0	0	0
 * sRegSel		0	0	0	0	0	0		0	0	0		0	1	0		0	1	0		0	1	0		0	1	0		0	0	0
 * opSel		0	0	0	0	0	0		0	0	0		0	0	0		0	3	0		0	1	0		0	2	0		0	0	0
 * @author github@AndreBetz.de
 **/
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
    private Not1x not1;
    private Or4x orPCLd2;
    private Or8xLines orPCLd3;
    private Or2x orAdrSel;
    private Or4x oreImm;
    private Or5x orReg1;
    private Or4x orReg2;
    private Or2x orOP1;
    private Or2x orOP2;
    private DataLine1Bit zero = new DataLine1Bit();
    private DataLine1Bit one  = new DataLine1Bit();
    private DataLine1Bit m12 = new DataLine1Bit();
    private DataLine1Bit m13 = new DataLine1Bit();
    private DataLine1Bit m22 = new DataLine1Bit();
    private DataLine1Bit m23 = new DataLine1Bit();
    private DataLine1Bit m3 = new DataLine1Bit();
    private DataLine1Bit m6 = new DataLine1Bit();
    private DataLine1Bit m9 = new DataLine1Bit();
    private DataLine1Bit m10m11m12 = new DataLine1Bit();
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
            DataLine1Bit zFlag,
            DataLine1Bit PCSelect,
            DataLine1Bit PCLoad,
            DataLine1Bit Write,
            DataLine1Bit InstructionLoad,
            DataLine1Bit ImmediateLoad,
            DataLine1Bit RegisterWrite,
            DataLine1Bit dRegSel,
            DataLine1Bit sRegSel,
            DataLine1Bit addressSel,
            DataLine2Bit regSel,
            DataLine2Bit opSel ) {
        // construct one bit line
        zero.reset();
        not1 = new Not1x(zero, one);
        not1.calc();
        //mux dataline in
        muxLine.setDataLine(0, cklCounter.getDataLine(0));
        muxLine.setDataLine(1, cklCounter.getDataLine(1));

        orPCLd2  = new Or4x(LDR, STR, MR1R2, JPZ, m22);
        orPCLd3  = new Or8xLines(LDR, STR, ADD, SUB, AND, OR, zFlag, zero, m23);
        orAdrSel = new Or2x(LDR, STR, m3);
        oreImm   = new Or4x(LDR, STR, JPZ, zero, m6);
        orReg1   = new Or5x(LDR, ADD, OR,  SUB, AND, m9);
        orReg2   = new Or4x(ADD, OR,  SUB, AND, m10m11m12);
        orOP1    = new Or2x(SUB, AND, m12);
        orOP2    = new Or2x( OR, AND, m13);
        
        mux1  = new mux1Bit4x(zero, zero,      JPZ,           zero, PCSelect,                muxLine);
        mux2  = new mux1Bit4x(zero, m22,       m23,           zero, PCLoad,                  muxLine);
        mux3  = new mux1Bit4x(zero, zero,      m3,            zero, addressSel,              muxLine);
        mux4  = new mux1Bit4x(zero, zero,      STR,           zero, Write,                   muxLine);
        mux5  = new mux1Bit4x(one,  zero,      zero,          zero, InstructionLoad,         muxLine);
        mux6  = new mux1Bit4x(zero, m6,        zero,          zero, ImmediateLoad,           muxLine);
        mux7  = new mux1Bit4x(zero, MR1R2,     LDR,           zero, RegisterWrite,           muxLine);        
        mux8  = new mux1Bit4x(zero, MR1R2,     m10m11m12,     zero, regSel.getDataLine(0),   muxLine);
        mux9  = new mux1Bit4x(zero, zero,      m9,            zero, regSel.getDataLine(1),   muxLine);        
        mux10 = new mux1Bit4x(zero, MR1R2,     m10m11m12,     zero, dRegSel,                 muxLine);        
        mux11 = new mux1Bit4x(zero, m10m11m12, zero,          zero, sRegSel,                 muxLine);
        mux12 = new mux1Bit4x(zero, m12,       zero,          zero, opSel.getDataLine(0),    muxLine);
        mux13 = new mux1Bit4x(zero, m13,       zero,          zero, opSel.getDataLine(1),    muxLine);
    }
    public void calc() {
        orPCLd2.calc();
        orPCLd3.calc();
        orAdrSel.calc();
        oreImm.calc();
        orReg1.calc();
        orReg2.calc();
        orOP1.calc();
        orOP2.calc();
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
