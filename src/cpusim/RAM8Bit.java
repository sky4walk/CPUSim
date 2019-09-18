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
    private DataLine8Bit DataIn;
    private DataLine8Bit DataOut;
    private DataLine8Bit Adress;
    private DataLine1Bit rwIn;
    private Register8Bit regs[] = new Register8Bit[256];
    private DataLine8Bit Out[] = new DataLine8Bit[256];
    private DataLine1Bit rw[] = new DataLine1Bit[256];
    public RAM8Bit(
        DataLine8Bit DataInLine,
        DataLine8Bit DataOutLine,
        DataLine8Bit AdressLine,
        DataLine1Bit rwLine ) {
        DataIn = DataInLine;
        DataOut = DataOutLine;
        Adress = AdressLine;
        rwIn = rwLine;
        for ( int i = 0; i < rw.length; i++ ) {
            rw[i] = new DataLine1Bit();
        }        
        demux = new demux1Bit256x(rwIn, Adress, rw);
        for ( int i = 0; i < regs.length; i++ ) {
            Out[i] = new DataLine8Bit();
            regs[i] = new Register8Bit(DataIn, Out[i], rw[i]);            
        }
        mux = new mux8Bit256x(Out, DataOut, Adress);
    }
    public void clkCycle() {
        demux.calc();
        for ( int i = 0; i < regs.length; i++ ) {
            regs[i].clkCycle();
        }
        mux.calc();        
    }
    public void write(int adr, int dat) {
        if ( adr < regs.length ) {
            regs[adr].write(dat);
        }
    }
    public int read(int adr) {
        if ( adr < regs.length ) {
            return regs[adr].read();
        }
        return 0;
    }
}
