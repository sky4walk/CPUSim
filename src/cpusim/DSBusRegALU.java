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
    private DataLine8Bit aluMux = new DataLine8Bit();
    public DSBusRegALU(
            DataLine8Bit Immediat,
            DataLine8Bit DataIn,
            DataLine8Bit DataBus,
            DataLine8Bit sBusOut,
            DataLine8Bit dBusOut,
            DataLine2Bit RegSel,
            DataLine1Bit sRegSel,
            DataLine1Bit dRegSel,
            DataLine2Bit opSel,
            DataLine1Bit RegWrite,
            DataLine1Bit flagZero,
            DataLine1Bit flagNeg ) {
        mux = new mux8Bit4x(
                Immediat, sBusOut, DataIn, aluMux, DataBus, RegSel);
        dsBus = new DSBusRegister(
                DataBus, 
                sBusOut, 
                dBusOut, 
                RegWrite, 
                dRegSel, 
                sRegSel, 
                flagZero, 
                flagNeg);
        alu = new ALU8Bit(dBusOut, sBusOut, aluMux, opSel);        
    }
    public void clkCycle() {
        mux.calc();
        dsBus.clkCycle();
        alu.calc();
    }
    public DataLine8Bit getDebugAluOut() {
        return alu.getDebugAluOut();
    }
}
