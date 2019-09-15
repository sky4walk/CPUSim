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
public class mux8Bit16x {
    private DataLine8Bit In[];
    private DataLine8Bit Out;
    private DataLine4Bit S;
    private mux8Bit4x mux[];
    private DataLine2Bit S1 = new DataLine2Bit();
    private DataLine2Bit S2 = new DataLine2Bit();
    public mux8Bit16x(
            DataLine8Bit InLine[],
            DataLine8Bit OutLine,
            DataLine4Bit SLine ) {
        In = InLine;
        Out = OutLine;
        S = SLine;
        S1.setDataLine(0, S.getDataLine(0));
        S1.setDataLine(1, S.getDataLine(1));
        S2.setDataLine(0, S.getDataLine(2));
        S2.setDataLine(1, S.getDataLine(3));
        
    }
}
