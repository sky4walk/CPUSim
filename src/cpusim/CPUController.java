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
    public CPUController(
            DataLine8Bit Instruction,
            DataLine1Bit zFlag,
            DataLine1Bit PCSelect,
            DataLine1Bit PCLoad,
            DataLine1Bit Write,
            DataLine1Bit InstructionLoad,
            DataLine1Bit ImmediateLoad,
            DataLine1Bit RegisterWrite,
            DataLine2Bit regSel,
            DataLine1Bit dRegSel,
            DataLine1Bit sRegSel,
            DataLine2Bit opSel,
            DataLine2Bit addressSel ) {
        
    }
    public void clkcycle() {
        
    }
    public DataLine8Bit getDebugCycleCnt() {
        return cc.getDebugCounter();
    }
}
