/*
* https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
* github@AndreBetz.de
*/
package cpusim;

/**
 *
 * @author betzan8u
 */
public class Not1Bit {
    private DataLine1Bit In;
    private DataLine1Bit Out;
    private not not1 = new not();
    public Not1Bit(
            DataLine1Bit InLine,
            DataLine1Bit OutLine ) {
        In = InLine;
        Out = OutLine;
    }
    public void calc() {
        not1.setInput(In.getPin(0), In.getPin(0));
        not1.calc();
        Out.setPin(0, not1.getOutput());
    }
}
