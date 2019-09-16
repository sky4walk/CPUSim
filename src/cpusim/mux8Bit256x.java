/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author betzan8u
 */
public class mux8Bit256x {
    private DataLine8Bit In[];
    private DataLine8Bit Out;
    private DataLine8Bit S;
    private mux8Bit16x mux[] = new mux8Bit16x[17];
    private DataLine4Bit S1 = new DataLine4Bit();
    private DataLine4Bit S2 = new DataLine4Bit();
    
    private DataLine8Bit In1[] = new DataLine8Bit[16];
    private DataLine8Bit In2[] = new DataLine8Bit[16];
    private DataLine8Bit In3[] = new DataLine8Bit[16];
    private DataLine8Bit In4[] = new DataLine8Bit[16];
    private DataLine8Bit In5[] = new DataLine8Bit[16];
    private DataLine8Bit In6[] = new DataLine8Bit[16];
    private DataLine8Bit In7[] = new DataLine8Bit[16];
    private DataLine8Bit In8[] = new DataLine8Bit[16];
    private DataLine8Bit In9[] = new DataLine8Bit[16];
    private DataLine8Bit In10[] = new DataLine8Bit[16];
    private DataLine8Bit In11[] = new DataLine8Bit[16];
    private DataLine8Bit In12[] = new DataLine8Bit[16];
    private DataLine8Bit In13[] = new DataLine8Bit[16];
    private DataLine8Bit In14[] = new DataLine8Bit[16];
    private DataLine8Bit In15[] = new DataLine8Bit[16];
    private DataLine8Bit In16[] = new DataLine8Bit[16];
    
    private DataLine8Bit OutMux[] = new DataLine8Bit[16];
    
    
    public mux8Bit256x(
            DataLine8Bit InLine[],
            DataLine8Bit OutLine,
            DataLine8Bit SLine ) {
        In = InLine;
        Out = OutLine;
        S = SLine;
        
        S1.setDataLine(0, S.getDataLine(0));
        S1.setDataLine(1, S.getDataLine(1));
        S1.setDataLine(2, S.getDataLine(2));
        S1.setDataLine(3, S.getDataLine(3));
        
        S2.setDataLine(0, S.getDataLine(4));
        S2.setDataLine(1, S.getDataLine(5));
        S2.setDataLine(2, S.getDataLine(6));
        S2.setDataLine(3, S.getDataLine(7));
        
        for ( int i = 0; i < OutMux.length; i++ ) {
            OutMux[i] = new DataLine8Bit();
            In1[i]  = In[i];
            In2[i]  = In[i+OutMux.length];
            In3[i]  = In[i+OutMux.length*2];
            In4[i]  = In[i+OutMux.length*3];
            In5[i]  = In[i+OutMux.length*4];
            In6[i]  = In[i+OutMux.length*5];
            In7[i]  = In[i+OutMux.length*6];
            In8[i]  = In[i+OutMux.length*7];
            In9[i]  = In[i+OutMux.length*8];
            In10[i] = In[i+OutMux.length*9];
            In11[i] = In[i+OutMux.length*10];
            In12[i] = In[i+OutMux.length*11];
            In13[i] = In[i+OutMux.length*12];
            In14[i] = In[i+OutMux.length*13];
            In15[i] = In[i+OutMux.length*14];
            In16[i] = In[i+OutMux.length*15];
        }
        mux[0]  = new mux8Bit16x(In1,  OutMux[0],  S1);
        mux[1]  = new mux8Bit16x(In2,  OutMux[1],  S1);
        mux[2]  = new mux8Bit16x(In3,  OutMux[2],  S1);
        mux[3]  = new mux8Bit16x(In4,  OutMux[3],  S1);
        mux[4]  = new mux8Bit16x(In5,  OutMux[4],  S1);
        mux[5]  = new mux8Bit16x(In6,  OutMux[5],  S1);
        mux[6]  = new mux8Bit16x(In7,  OutMux[6],  S1);
        mux[7]  = new mux8Bit16x(In8,  OutMux[7],  S1);
        mux[8]  = new mux8Bit16x(In9,  OutMux[8],  S1);
        mux[9]  = new mux8Bit16x(In10, OutMux[9],  S1);
        mux[10] = new mux8Bit16x(In11, OutMux[10], S1);
        mux[11] = new mux8Bit16x(In12, OutMux[11], S1);
        mux[12] = new mux8Bit16x(In13, OutMux[12], S1);
        mux[13] = new mux8Bit16x(In14, OutMux[13], S1);
        mux[14] = new mux8Bit16x(In15, OutMux[14], S1);
        mux[15] = new mux8Bit16x(In16, OutMux[15], S1);

        mux[16] = new mux8Bit16x(OutMux, Out, S2);
    }
    public void calc() {
        for (mux8Bit16x mux1 : mux) {
            mux1.calc();
        }
    }
}
