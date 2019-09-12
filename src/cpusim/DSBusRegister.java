/*
* https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
* github@AndreBetz.de
*/
package cpusim;

/**
 *
 * @author betzan8u
 */
public class DSBusRegister {
    private Register8Bit reg1;
    private Register8Bit reg2;
    private demux1Bit2x demux;
    private mux8Bit2x muxDbus;
    private mux8Bit2x muxSbus;
    private Not1Bit not1;
    private Or8x or1;
    private DataLine8Bit dataIn;
    private DataLine8Bit sBusOut;
    private DataLine8Bit dBusOut;
    private DataLine1Bit rw;
    private DataLine1Bit regDstSel;
    private DataLine1Bit regSrcSel;
    private DataLine1Bit zeroFlag;
    private DataLine1Bit negativFlag;
    private DataLine1Bit dmReg1 = new DataLine1Bit();
    private DataLine1Bit dmReg2 = new DataLine1Bit();
    private DataLine1Bit orNot  = new DataLine1Bit();
    private DataLine8Bit reg1Mux = new DataLine8Bit();
    private DataLine8Bit reg2Mux = new DataLine8Bit();
    public DSBusRegister(
            DataLine8Bit dataInLine,
            DataLine8Bit sBusOutLine,
            DataLine8Bit dBusOutLine,
            DataLine1Bit rwLine,
            DataLine1Bit regDstSelLine,
            DataLine1Bit regSrcSelLine,
            DataLine1Bit zeroFlagLine,
            DataLine1Bit negativFlagLine ) {
        dataIn = dataInLine;
        sBusOut = sBusOutLine;
        dBusOut = dBusOutLine;
        rw = rwLine;
        regSrcSel = regSrcSelLine;
        regDstSel = regDstSelLine;
        zeroFlag = zeroFlagLine;
        negativFlag = negativFlagLine;
        demux = new demux1Bit2x(rw, dmReg1, dmReg2, regDstSel);
        reg1 = new Register8Bit(dataIn, reg1Mux, dmReg1);
        reg2 = new Register8Bit(dataIn, reg2Mux, dmReg2);
        muxDbus = new mux8Bit2x(reg1Mux, reg2Mux, dBusOut, regDstSel);
        muxSbus = new mux8Bit2x(reg1Mux, reg2Mux, sBusOut, regSrcSel);
        or1 = new Or8x(dBusOut, orNot);
        not1 = new Not1Bit(orNot, zeroFlag);
    }
    public void clkCycle() {
        demux.calc();       
        reg1.clkCycle();
        reg2.clkCycle();
        muxDbus.calc();
        muxSbus.calc();
        or1.calc();
        not1.calc();
        negativFlag.setPin(0, dBusOut.getPin(7));
    }
}
