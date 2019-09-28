/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class CPU {
    private CPUController cc;
    private DataPath dp;
    private DataLine8Bit Instruction = new DataLine8Bit();
    private DataLine1Bit zFlag = new DataLine1Bit();
    private DataLine1Bit PCSelect = new DataLine1Bit();
    private DataLine1Bit PCLoad = new DataLine1Bit();
    private DataLine1Bit Write = new DataLine1Bit();
    private DataLine1Bit InstructionLoad = new DataLine1Bit();
    private DataLine1Bit ImmediateLoad = new DataLine1Bit();
    private DataLine1Bit RegisterWrite = new DataLine1Bit();
    private DataLine1Bit dRegSel = new DataLine1Bit();
    private DataLine1Bit sRegSel = new DataLine1Bit();
    private DataLine1Bit addressSel = new DataLine1Bit();
    private DataLine1Bit startLine = new DataLine1Bit();
    private DataLine2Bit regSel = new DataLine2Bit();
    private DataLine2Bit opSel = new DataLine2Bit();

    public CPU(){
        cc = new CPUController(
            Instruction, zFlag, PCSelect, PCLoad, Write, InstructionLoad, 
            ImmediateLoad, RegisterWrite, dRegSel, sRegSel, addressSel, 
            regSel, opSel, startLine);
        dp = new DataPath(
            Instruction, zFlag, PCSelect, addressSel, PCLoad, Write, 
            InstructionLoad, ImmediateLoad, RegisterWrite, dRegSel, 
            sRegSel, opSel, regSel);        
    }
    public void clkCycle() {
        cc.clkCycle();
        dp.clkCycle();
    }
    public void calc() {
        // three cycle counts for one command
        this.clkCycle();
        this.clkCycle();
        this.clkCycle();
    }    
    public void setDebugRamWrite(int adr, int val) {
        dp.setDebugRam(adr, val);
    }
    public int getDebugRamRead(int adr) {
        return dp.getDebugRam(adr);
    }
    public int getDebugPC() {
        return dp.getDebugPC().getBitsInt();
    }
    public int getDebugRegister1() {
        return dp.getDebugRegister1().getBitsInt();
    }
    public int getDebugRegister2() {
        return dp.getDebugRegister2().getBitsInt();
    }
    public int getDebugInstruction() {
        return Instruction.getBitsInt();
    }
    public boolean getDebugZFlag() {
        return zFlag.getPin(0);
    }
}
