/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class AdressInstructionRAM {
    private ProgramCounter8Bit cnt;
    private RAM8Bit ram;
    private mux8Bit2x mux;
    private Register8Bit instReg;
    private Register8Bit immeReg;
    private DataLine8Bit cnt2mux = new DataLine8Bit();
    private DataLine8Bit adressBus = new DataLine8Bit();
    public AdressInstructionRAM(
            DataLine8Bit DataInBus,
            DataLine8Bit DataOutBus,
            DataLine8Bit Instruction,
            DataLine8Bit Immediate,
            DataLine1Bit AdressSelect,
            DataLine1Bit PCSelect,
            DataLine1Bit PCLoad,
            DataLine1Bit rw,
            DataLine1Bit instructionLoad,
            DataLine1Bit immediateLoad )  {
        cnt = new ProgramCounter8Bit(Immediate, cnt2mux, PCSelect, PCLoad);
        mux = new mux8Bit2x(cnt2mux, Immediate, adressBus, AdressSelect);
        ram = new RAM8Bit(DataInBus, DataOutBus, adressBus, rw);
        instReg = new Register8Bit(DataOutBus, Instruction, instructionLoad);
        immeReg = new Register8Bit(DataOutBus, Immediate, immediateLoad);
    }
    public void clkCycle() {
        cnt.clkCycle();
        mux.calc();
        ram.clkCycle();
        instReg.clkCycle();
        immeReg.clkCycle();
    }
    public DataLine8Bit getDebugCnt2Mux() {
        return cnt2mux;
    }
    public DataLine8Bit getDebugAdressBus() {
        return adressBus;
    }
    public void setDebugData(int nr, int val) {
        ram.write(nr, val);
    }
    public int  getDebugData(int nr) {
        return ram.read(nr);
    }
}
