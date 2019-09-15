/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
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
    private DataLine1Bit Out[];
    public demux1Bit4x(
            DataLine1Bit InLine,
            DataLine2Bit SLine,
            DataLine1Bit OutLine[] ) {
        In = InLine;
        S = SLine;
        Out = OutLine;
        dm1 = new demux1Bit2x(In, dm1dm2, dm1dm3, S.getDataLine(1));
        dm2 = new demux1Bit2x(dm1dm2, Out[0], Out[1], S.getDataLine(0));
        dm3 = new demux1Bit2x(dm1dm3, Out[2], Out[3], S.getDataLine(0));
    }
    public void calc() {
        dm1.calc();
        dm2.calc();
        dm3.calc();
    }
}
