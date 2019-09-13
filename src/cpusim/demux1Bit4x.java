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
public class demux1Bit4x {
    private demux1Bit2x dm1;
    private demux1Bit2x dm2;
    private demux1Bit2x dm3;
    private DataLine1Bit In;
    private DataLine2Bit S;
    private DataLine1Bit dm1dm2 = new DataLine1Bit();
    private DataLine1Bit dm1dm3 = new DataLine1Bit();
    private DataLine1Bit Out[] = new DataLine1Bit[4];
    public demux1Bit4x(
            DataLine1Bit InLine,
            DataLine2Bit SLine,
            DataLine1Bit Out1Line[] ) {
        In = InLine;
        S = SLine;
        Out = Out1Line;
        dm1 = new demux1Bit2x(In, dm1dm2, dm1dm3, S.getDataLine(0));
        dm2 = new demux1Bit2x(dm1dm2, Out[0], Out[1], S.getDataLine(1));
        dm3 = new demux1Bit2x(dm1dm3, Out[2], Out[3], S.getDataLine(1));
    }
    public void calc() {
        dm1.calc();
        dm2.calc();
        dm3.calc();
    }
}
