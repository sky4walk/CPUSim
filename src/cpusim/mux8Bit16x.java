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
    private mux8Bit4x mux[] = new mux8Bit4x[5];
    private DataLine2Bit S1 = new DataLine2Bit();
    private DataLine2Bit S2 = new DataLine2Bit();
    private DataLine8Bit m1m5 = new DataLine8Bit();
    private DataLine8Bit m2m5 = new DataLine8Bit();
    private DataLine8Bit m3m5 = new DataLine8Bit();
    private DataLine8Bit m4m5 = new DataLine8Bit();
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
        mux[0] = new mux8Bit4x(In[0],  In[1],  In[2],  In[3],  m1m5, S1);
        mux[1] = new mux8Bit4x(In[4],  In[5],  In[6],  In[7],  m2m5, S1);
        mux[2] = new mux8Bit4x(In[8],  In[9],  In[10], In[11], m3m5, S1);
        mux[3] = new mux8Bit4x(In[12], In[13], In[14], In[15], m4m5, S1);
        mux[4] = new mux8Bit4x(m1m5, m2m5, m3m5, m4m5, Out, S2);
    }
    public void calc() {
        for ( int i = 0; i < mux.length; i++ ) {
            mux[i].calc();
        }
    }
}
