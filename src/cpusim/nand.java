/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
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
        if ( false == inA && false == inB ) outA = true;        
        if ( false == inA && true  == inB ) outA = true;
        if ( true  == inA && false == inB ) outA = true;
        if ( true  == inA && true  == inB ) outA = false;
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
