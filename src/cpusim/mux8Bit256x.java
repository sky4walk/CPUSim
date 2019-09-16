/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class mux8Bit256x {
    private DataLine8Bit In[];
    private DataLine8Bit Out;
    private DataLine8Bit S;
    private mux8Bit16x mux[] = new mux8Bit16x[17];
    private DataLine4Bit S1 = new DataLine4Bit();
    private DataLine4Bit S2 = new DataLine4Bit();
    
    public mux8Bit256x(
            DataLine8Bit InLine[],
            DataLine8Bit OutLine,
            DataLine8Bit SLine ) {
        In = InLine;
        Out = OutLine;
        S = SLine;
        
        S1.setDataLine(0, S.getDataLine(0));
        S1.setDataLine(1, S.getDataLine(1));
        S1.setDataLine(2, S.getDataLine(2));
        S1.setDataLine(3, S.getDataLine(3));
        
        S2.setDataLine(0, S.getDataLine(4));
        S2.setDataLine(1, S.getDataLine(5));
        S2.setDataLine(2, S.getDataLine(6));
        S2.setDataLine(3, S.getDataLine(7));
    }
    public void calc() {
        
    }
}
