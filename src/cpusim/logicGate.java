/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
interface logicGate {
    public void setInput(boolean a, boolean b);
    public void calc();
    public boolean getOutput();
}
