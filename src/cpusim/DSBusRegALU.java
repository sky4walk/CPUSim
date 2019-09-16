/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class DSBusRegALU {
    private ALU8Bit alu;
    private mux8Bit4x mux;
    private DSBusRegister dsBus;
    private DataLine8Bit muxReg = new DataLine8Bit();
    private DataLine8Bit regAluDbus = new DataLine8Bit();
    private DataLine8Bit regAluSBus = new DataLine8Bit();
    private DataLine8Bit aluMux = new DataLine8Bit();
    
    public DSBusRegALU(
            DataLine8Bit Immediat,
            DataLine8Bit DataIn,
            DataLine2Bit RegSel,
            DataLine1Bit sRegSel,
            DataLine1Bit dRegSel,
            DataLine2Bit opSel,
            DataLine1Bit RegWrite,
            DataLine1Bit flagZero,
            DataLine1Bit flagNeg ) {
        mux = new mux8Bit4x(
                Immediat, regAluDbus, DataIn, aluMux, muxReg, RegSel);
        dsBus = new DSBusRegister(
                muxReg, 
                regAluSBus, 
                regAluDbus, 
                RegWrite, 
                dRegSel, 
                sRegSel, 
                flagZero, 
                flagNeg);
        alu = new ALU8Bit(regAluDbus, regAluSBus, aluMux, opSel);        
    }
    public void clkCycle() {
        mux.calc();
        dsBus.clkCycle();
        alu.calc();
    }
}
