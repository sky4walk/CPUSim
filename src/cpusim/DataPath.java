/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class DataPath {
    private AdressInstructionRAM adrRam;
    private DSBusRegALU aluBus;
    
    public DataPath(
            DataLine8Bit AdressBus,
            DataLine8Bit Instruction,
            DataLine8Bit Immediate,
            DataLine8Bit DataBus,
            DataLine8Bit dBus,
            DataLine8Bit sBus,
            DataLine1Bit PCSel,
            DataLine2Bit AdrSel,
            DataLine1Bit PCLoad,
            DataLine1Bit ramWrite,
            DataLine1Bit InstructionLoad,
            DataLine1Bit ImmediateLoad,
            DataLine1Bit regWrite,
            DataLine2Bit regSel,
            DataLine1Bit dRegSel,
            DataLine1Bit sRegSel,
            DataLine2Bit opSel,
            DataLine1Bit zFlag,
            DataLine1Bit nFlag
    ) {
        
    }
    public void clkCycle() {
        adrRam.clkCycle();
        aluBus.clkCycle();
    }
}
