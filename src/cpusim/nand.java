/*
 */
package cpusim;

/**
 * @author andre
 */
public class nand implements logicGate {
    private static int instanceCounter = 0;
    private boolean inA;
    private boolean inB;
    private boolean outA;
    
    public nand() {
        instanceCounter++;
    }
    @Override
    public void setInput(boolean a, boolean b) {
        inA = a;
        inB = b;
    }
    @Override
    public void calc() {
        outA = !(inA & inB);
    }
    @Override
    public boolean getOutput() {
        return outA;
    }
    public static int getInstances() {
        return instanceCounter;
    }
    
    public static String getState(boolean in) {
        if (in) return "1";
        else    return "0";
    }
}
