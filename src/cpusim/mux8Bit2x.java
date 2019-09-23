/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */

package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class mux8Bit2x {
    private DataLine8Bit in1;
    private DataLine8Bit in2;
    private DataLine8Bit out;
    private DataLine1Bit S;
    private mux1Bit2x muxArr[] = new mux1Bit2x[8];
    public mux8Bit2x(
            DataLine8Bit in1Line,
            DataLine8Bit in2Line,
            DataLine8Bit outLine,
            DataLine1Bit sLine ) {
        in1 = in1Line;
        in2 = in2Line;
        out = outLine;
        S   = sLine;
        for ( int i = 0; i < muxArr.length; i++ ) {
            muxArr[i] = new mux1Bit2x(
                    in1.getDataLine(i), 
                    in2.getDataLine(i), 
                    out.getDataLine(i), 
                    S);
        }
    }
    public void calc() {
        for ( int i = 0; i < muxArr.length; i++ ) {
            muxArr[i].calc();
        }
    }
}
