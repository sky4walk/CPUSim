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
    private DataLine8Bit AdressBus = new DataLine8Bit();
    private DataLine8Bit Immediate = new DataLine8Bit();
    private DataLine8Bit DataBusInOut = new DataLine8Bit();
    private DataLine8Bit DataInReg = new DataLine8Bit();
    private DataLine8Bit dBus = new DataLine8Bit();
    private DataLine8Bit sBus = new DataLine8Bit();
    public DataPath(
            DataLine8Bit Instruction,
            DataLine1Bit zFlag,
            DataLine1Bit PCSel,
            DataLine1Bit AdrSel,
            DataLine1Bit PCLoad,
            DataLine1Bit ramWrite,
            DataLine1Bit InstructionLoad,
            DataLine1Bit ImmediateLoad,
            DataLine1Bit regWrite,
            DataLine1Bit dRegSel,
            DataLine1Bit sRegSel,
            DataLine2Bit opSel,
            DataLine2Bit regSel ) {
        aluBus = new DSBusRegALU(
                Immediate, 
                DataBusInOut, 
                DataInReg, 
                sBus, 
                dBus, 
                regSel, 
                sRegSel, 
                dRegSel, 
                opSel, 
                regWrite, 
                zFlag, 
                new DataLine1Bit());
        adrRam = new AdressInstructionRAM(
                dBus, DataBusInOut, Instruction, Immediate, AdrSel, 
                PCSel, PCLoad, ramWrite, InstructionLoad, ImmediateLoad);
    }
    public void clkCycle() {
        adrRam.clkCycle();
        aluBus.clkCycle();
    }
    public DataLine8Bit getDebugAdressBus() {
        return AdressBus;
    }
    public DataLine8Bit getDebugImmediate() {
        return Immediate;
    }
    public DataLine8Bit getDebugDataBus() {
        return DataInReg;
    }
    public DataLine8Bit getDebugDBus() {
        return dBus;
    }
    public DataLine8Bit getDebugSBus() {
        return sBus;
    }
    public int getDebugReadRam(int Nr) {
        return adrRam.getDebugData(Nr);
    }
    public void getDebugWriteRam(int Nr, int val) {
        adrRam.setDebugData(Nr,val);
    }
}
