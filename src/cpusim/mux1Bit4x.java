/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class mux1Bit4x {
    private mux1Bit2x mux1;
    private mux1Bit2x mux2;
    private mux1Bit2x mux3;
    private DataLine1Bit mux1Mux3 = new DataLine1Bit();
    private DataLine1Bit mux2Mux3 = new DataLine1Bit();
    public mux1Bit4x(
            DataLine1Bit x1,
            DataLine1Bit x2,
            DataLine1Bit x3,
            DataLine1Bit x4,
            DataLine1Bit out,
            DataLine2Bit S ) {
        mux1 = new mux1Bit2x(x1, x2, mux1Mux3, S.getDataLine(0));
        mux2 = new mux1Bit2x(x3, x4, mux2Mux3, S.getDataLine(0));
        mux3 = new mux1Bit2x(mux1Mux3, mux2Mux3, out, S.getDataLine(1));
    }
    public void calc() {
        mux1.calc();
        mux2.calc();
        mux3.calc();
    }
}
