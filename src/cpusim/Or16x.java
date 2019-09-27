/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author andre
 */
public class Or16x {
    private Or4x or1;
    private Or4x or2;
    private Or4x or3;
    private Or4x or4;
    private Or4x or5;
    private DataLine1Bit or1or5 = new DataLine1Bit();
    private DataLine1Bit or2or5 = new DataLine1Bit();
    private DataLine1Bit or3or5 = new DataLine1Bit();
    private DataLine1Bit or4or5 = new DataLine1Bit();
    public Or16x(
        DataLine1Bit x1,
        DataLine1Bit x2,
        DataLine1Bit x3,
        DataLine1Bit x4,
        DataLine1Bit x5,
        DataLine1Bit x6,
        DataLine1Bit x7,
        DataLine1Bit x8,
        DataLine1Bit x9,
        DataLine1Bit x10,
        DataLine1Bit x11,
        DataLine1Bit x12,
        DataLine1Bit x13,
        DataLine1Bit x14,
        DataLine1Bit x15,
        DataLine1Bit x16,
        DataLine1Bit out ) {
        or1 = new Or4x( x1,  x2,  x3,  x4, or1or5);
        or2 = new Or4x( x5,  x6,  x7,  x8, or2or5);
        or3 = new Or4x( x9, x10, x11, x12, or3or5);
        or4 = new Or4x(x13, x14, x15, x16, or4or5);
        or5 = new Or4x(or1or5, or2or5, or3or5, or4or5, out);        
    }
    public void calc() {
        or1.calc();
        or2.calc();
        or3.calc();
        or4.calc();
        or5.calc();
    }
}
