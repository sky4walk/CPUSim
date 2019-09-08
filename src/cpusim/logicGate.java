/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
