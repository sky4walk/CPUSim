/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class Or8xLines {
    private Or8x or1;
    private DataLine8Bit line = new DataLine8Bit();
    public Or8xLines(
        DataLine1Bit x1,
        DataLine1Bit x2,
        DataLine1Bit x3,
        DataLine1Bit x4,
        DataLine1Bit x5,
        DataLine1Bit x6,
        DataLine1Bit x7,
        DataLine1Bit x8, 
        DataLine1Bit Out) {
        line.setDataLine(0, x1);
        line.setDataLine(1, x2);
        line.setDataLine(2, x3);
        line.setDataLine(3, x4);
        line.setDataLine(4, x5);
        line.setDataLine(5, x6);
        line.setDataLine(6, x7);
        line.setDataLine(7, x8);
        or1 = new Or8x(line, Out);
    }
    public void calc() {
        or1.calc();
    }
}
