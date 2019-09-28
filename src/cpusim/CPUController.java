/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@AndreBetz.de
 */
public class CPUController {
    private CommandSet cs;
    private InstructionDecoder id;
    private CycleCounter cc;
    private DataLine1Bit cycle1Line = new DataLine1Bit();
    private DataLine1Bit cycle2Line = new DataLine1Bit();
    private DataLine1Bit cycle3Line = new DataLine1Bit();
    private DataLine8Bit counter = new DataLine8Bit();
    private DataLine1Bit LDA = new DataLine1Bit();
    private DataLine1Bit STR = new DataLine1Bit();
    private DataLine1Bit MR1R2 = new DataLine1Bit();
    private DataLine1Bit JPZ = new DataLine1Bit();
    private DataLine1Bit AND = new DataLine1Bit();
    private DataLine1Bit OR = new DataLine1Bit();
    private DataLine1Bit ADD = new DataLine1Bit();
    private DataLine1Bit SUB = new DataLine1Bit();
    public CPUController(
            DataLine8Bit Instruction,
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
            DataLine2Bit opSel,
            DataLine1Bit startCycle) {
        cc = new CycleCounter( 
                counter, startCycle, new DataLine1Bit(), 
                new DataLine1Bit(), new DataLine1Bit());
        id = new InstructionDecoder(
                Instruction, LDA, STR, MR1R2, JPZ, AND, OR, ADD, SUB);
        cs = new CommandSet(
                counter, LDA, STR, MR1R2, JPZ, AND, OR, ADD, SUB, 
                zFlag, PCSelect, PCLoad, Write, InstructionLoad, 
                ImmediateLoad, RegisterWrite, dRegSel, sRegSel, 
                addressSel, regSel, opSel);
    }
    public void clkCycle() {
        id.calc();
        cs.calc();
        cc.clkCycle();        
    }
    public DataLine8Bit getDebugCycleCnt() {
        return cc.getDebugCounter();
    }
}
