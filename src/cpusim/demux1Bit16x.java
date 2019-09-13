/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class demux1Bit16x {
    private demux1Bit2x dm1;
    private demux1Bit2x dm2;
    private demux1Bit2x dm3;
    private demux1Bit2x dm4;
    private DataLine1Bit In;
    private DataLine4Bit S;
    public demux1Bit16x(
            DataLine1Bit InLine,
            DataLine4Bit SLine ) {
        In = InLine;
        S = SLine;
    }
}
