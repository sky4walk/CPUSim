/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class RAM8Bit {
    private mux8Bit256x mux;
    private demux1Bit256x demux;
    private Register8Bit regs[] = new Register8Bit[256];
    public RAM8Bit(
        DataLine8Bit DataInLine,
        DataLine8Bit DataOutLine,
        DataLine8Bit AdressLine,
        DataLine1Bit rwLine ) {
        for ( int i = 0; i < regs.length; i++ ) {
            regs[i] = new Register8Bit(DataInLine, DataOutLine, rwLine);
        }
    }
    public void clkCycle() {
        
    }
}
