/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class demux1Bit16x {
    private demux1Bit4x dm1;
    private demux1Bit4x dm2;
    private demux1Bit4x dm3;
    private demux1Bit4x dm4;
    private demux1Bit4x dm5;
    private DataLine1Bit In;
    private DataLine4Bit S;
    private DataLine1Bit Out[];
    private DataLine1Bit outDm1[] = new DataLine1Bit[4];
    private DataLine1Bit outDm2[] = new DataLine1Bit[4];
    private DataLine1Bit outDm3[] = new DataLine1Bit[4];
    private DataLine1Bit outDm4[] = new DataLine1Bit[4];
    private DataLine1Bit outDm5[] = new DataLine1Bit[4];
    private DataLine2Bit S1 = new DataLine2Bit();
    private DataLine2Bit S2 = new DataLine2Bit();
    public demux1Bit16x(
            DataLine1Bit InLine,
            DataLine4Bit SLine,
            DataLine1Bit OutLine[]) {
        In = InLine;
        S = SLine;
        Out = OutLine;
        for ( int i = 0; i < outDm1.length; i++ ) {
            outDm1[i] = new DataLine1Bit();
            outDm2[i] = Out[i];
            outDm3[i] = Out[i+4];
            outDm4[i] = Out[i+8];
            outDm5[i] = Out[i+12];
        }
        S1.setDataLine(0, S.getDataLine(0));
        S1.setDataLine(1, S.getDataLine(1));
        S2.setDataLine(0, S.getDataLine(2));
        S2.setDataLine(1, S.getDataLine(3));
        dm1 = new demux1Bit4x(In, S2, outDm1);
        dm2 = new demux1Bit4x(outDm1[0], S1, outDm2);
        dm3 = new demux1Bit4x(outDm1[1], S1, outDm3);
        dm4 = new demux1Bit4x(outDm1[2], S1, outDm4);
        dm5 = new demux1Bit4x(outDm1[3], S1, outDm5);
    }
    public void calc() {
        dm1.calc();
        dm2.calc();
        dm3.calc();
        dm4.calc();
        dm5.calc();
    }
}
