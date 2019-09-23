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
        cc = new CycleCounter( 
                counter, new DataLine1Bit(), new DataLine1Bit(), 
                new DataLine1Bit(), new DataLine1Bit());
        
    }
    public void clkcycle() {
        
    }
    public DataLine8Bit getDebugCycleCnt() {
        return cc.getDebugCounter();
    }
}
