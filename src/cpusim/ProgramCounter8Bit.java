/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class ProgramCounter8Bit {
    private DataLine8Bit PCin;
    private DataLine8Bit PCout;
    private DataLine1Bit PCselect;    
    private DataLine1Bit PCload;    
    private DataLine1Bit clk;    
    private DataLine8Bit addVal = new DataLine8Bit();
    private DataLine8Bit lineMuxAdd = new DataLine8Bit();    
    private DataLine8Bit lineRegMux = new DataLine8Bit();    
    private DataLine1Bit uVal = new DataLine1Bit();    
    private mux8Bit2x mux;
    private Add8Bit add;
    private Register8Bit reg;
    public ProgramCounter8Bit(
            DataLine8Bit PCinLine,
            DataLine8Bit PCoutLine,
            DataLine1Bit PCselectLine,            
            DataLine1Bit PCloadLine,       
            DataLine1Bit clkLine ) {
        PCin     = PCinLine;
        PCout    = PCoutLine;
        PCselect = PCselectLine;
        PCload   = PCloadLine;
        clk      = clkLine;
        addVal.setBitsInt(1);
        uVal.setPin(0, false);
        add = new Add8Bit(addVal, PCout, lineMuxAdd, uVal, new DataLine1Bit());
        mux = new mux8Bit2x(PCin, lineMuxAdd, lineRegMux, PCselect);
        reg = new Register8Bit(lineRegMux, PCout, clk, PCload);
    }
    public void calc() {
        add.calc();
        int ret = lineMuxAdd.getBitsInt();
        mux.calc();
        ret = lineRegMux.getBitsInt();
        reg.calc();
        ret = PCout.getBitsInt();
    }
}
