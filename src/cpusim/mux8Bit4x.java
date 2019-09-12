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
public class mux8Bit4x {
    private mux8Bit2x mux1;
    private mux8Bit2x mux2;
    private mux8Bit2x mux3;
    private DataLine8Bit In1;
    private DataLine8Bit In2;
    private DataLine8Bit In3;
    private DataLine8Bit In4;
    private DataLine8Bit Out;
    private DataLine2Bit S;
    private DataLine8Bit mux1mux3 = new DataLine8Bit();
    private DataLine8Bit mux2mux3 = new DataLine8Bit();
    public mux8Bit4x(
            DataLine8Bit In1Line,
            DataLine8Bit In2Line,
            DataLine8Bit In3Line,
            DataLine8Bit In4Line,
            DataLine8Bit OutLine,
            DataLine2Bit SLine ) {
        In1 = In1Line;
        In2 = In2Line;
        In3 = In3Line;
        In4 = In4Line;
        Out = OutLine;
        S = SLine;
        mux1 = new mux8Bit2x(In1Line, In2Line, mux1mux3, S.getDataLine(0));
        mux2 = new mux8Bit2x(In3Line, In4Line, mux2mux3, S.getDataLine(0));
        mux3 = new mux8Bit2x(mux1mux3, mux2mux3, OutLine, S.getDataLine(1));        
    }
    public void calc() {
        mux1.calc();
        mux2.calc();
        mux3.calc();
    }
}
