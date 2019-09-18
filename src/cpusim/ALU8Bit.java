/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class ALU8Bit {
    private DataLine8Bit inA;
    private DataLine8Bit inB;
    private DataLine8Bit out;
    private DataLine2Bit opSelect;
    private DataLine1Bit uOne = new DataLine1Bit();
    private DataLine1Bit uZero = new DataLine1Bit();
    private Add8Bit add1;
    private Add8Bit sub1;
    private Not8Bit not1;
    private And8Bit and1;
    private Or8Bit or1;
    private mux8Bit2x mux1;
    private mux8Bit2x mux2;
    private mux8Bit2x mux3;
    private DataLine8Bit lineAddMux1 = new DataLine8Bit();
    private DataLine8Bit lineSubMux1 = new DataLine8Bit();
    private DataLine8Bit lineAndMux2 = new DataLine8Bit();
    private DataLine8Bit lineOrMux2 = new DataLine8Bit();
    private DataLine8Bit lineMux1Mux3 = new DataLine8Bit();
    private DataLine8Bit lineMux2Mux3 = new DataLine8Bit();
    private DataLine8Bit lineNotSub = new DataLine8Bit();
    public ALU8Bit(
            DataLine8Bit inALine,
            DataLine8Bit inBLine,
            DataLine8Bit outLine,
            DataLine2Bit opSelectLine ) {
        inA = inALine;
        inB = inBLine;
        out = outLine;
        opSelect = opSelectLine;
        uZero.setPin(0, false);
        uOne.setPin(0, true);
        not1 = new Not8Bit(inB, lineNotSub);
        add1 = new Add8Bit(inA, inB, lineAddMux1, uZero, new DataLine1Bit());
        sub1 = new Add8Bit(inA, lineNotSub, lineSubMux1, uOne, new DataLine1Bit());
        and1 = new And8Bit(inA, inB, lineAndMux2);
        or1  = new Or8Bit(inA, inB, lineOrMux2);
        mux1 = new mux8Bit2x(lineAddMux1, lineSubMux1, lineMux1Mux3, opSelect.getDataLine(0));
        mux2 = new mux8Bit2x(lineAndMux2, lineOrMux2, lineMux2Mux3, opSelect.getDataLine(0));
        mux3 = new mux8Bit2x(lineMux1Mux3, lineMux2Mux3, out, opSelect.getDataLine(1));
    }
    public void calc() {
        not1.calc();
        add1.calc();
        sub1.calc();
        and1.calc();
        or1.calc();
        mux1.calc();
        mux2.calc();
        mux3.calc();
    }
    public DataLine8Bit getDebugAluOut() {
        return out;
    }
}
