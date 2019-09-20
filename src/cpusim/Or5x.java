/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class Or5x {
    private Or4x or1;
    private Or2x or2;
    private DataLine1Bit or1or2 = new DataLine1Bit();
    public Or5x(
        DataLine1Bit x1,
        DataLine1Bit x2,
        DataLine1Bit x3,
        DataLine1Bit x4,
        DataLine1Bit x5,
        DataLine1Bit out ) {
        or1 = new Or4x(x1, x2, x3, x4, or1or2);
        or2 = new Or2x(or1or2, x5, out);
    }
    public void calc() {
        or1.calc();
        or2.calc();
    }

}
