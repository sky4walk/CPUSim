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
public class ALU8Bit {
    private DataLine8Bit inA;
    private DataLine8Bit inB;
    private DataLine8Bit out;
    private DataLine2Bit opSelect;
    private DataLine1Bit uOne;
    private DataLine1Bit uZero;
    private Add8Bit add1;
    private Add8Bit sub1;
    private Not8Bit not1;
    private And8Bit and1;
    private Or8Bit or1;
    private mux8Bit2x mux1;
    private mux8Bit2x mux2;
    private mux8Bit2x mux3;
    public ALU8Bit(
            DataLine8Bit inALine,
            DataLine8Bit inBLine,
            DataLine8Bit outLine,
            DataLine2Bit opSelectLine ) {
        inA = inALine;
        inB = inBLine;
        out = outLine;
        opSelect = opSelectLine;
    }
    public void calc() {
        
    }
}
