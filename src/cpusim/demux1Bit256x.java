/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class demux1Bit256x {
    private DataLine1Bit In;
    private DataLine8Bit S;
    private DataLine1Bit Out[];
    private demux1Bit16x dm[] = new demux1Bit16x[17];
    private DataLine1Bit outDm0[] = new DataLine1Bit[16];
    private DataLine1Bit outDm1[] = new DataLine1Bit[16];
    private DataLine1Bit outDm2[] = new DataLine1Bit[16];
    private DataLine1Bit outDm3[] = new DataLine1Bit[16];
    private DataLine1Bit outDm4[] = new DataLine1Bit[16];
    private DataLine1Bit outDm5[] = new DataLine1Bit[16];
    private DataLine1Bit outDm6[] = new DataLine1Bit[16];
    private DataLine1Bit outDm7[] = new DataLine1Bit[16];
    private DataLine1Bit outDm8[] = new DataLine1Bit[16];
    private DataLine1Bit outDm9[] = new DataLine1Bit[16];
    private DataLine1Bit outDm10[] = new DataLine1Bit[16];
    private DataLine1Bit outDm11[] = new DataLine1Bit[16];
    private DataLine1Bit outDm12[] = new DataLine1Bit[16];
    private DataLine1Bit outDm13[] = new DataLine1Bit[16];
    private DataLine1Bit outDm14[] = new DataLine1Bit[16];
    private DataLine1Bit outDm15[] = new DataLine1Bit[16];
    private DataLine1Bit outDm16[] = new DataLine1Bit[16];
    private DataLine4Bit S1 = new DataLine4Bit();
    private DataLine4Bit S2 = new DataLine4Bit();
    public demux1Bit256x(
            DataLine1Bit InLine,
            DataLine8Bit SLine,
            DataLine1Bit OutLine[]) {
        In = InLine;
        S = SLine;
        Out = OutLine;
        for ( int i = 0; i < outDm1.length; i++ ) {
            outDm0[i]  = new DataLine1Bit();
            
            outDm1[i]  = Out[i+outDm1.length*0];  //   0 -  15
            outDm2[i]  = Out[i+outDm1.length*1];  //  16 -  31
            outDm3[i]  = Out[i+outDm1.length*2];  //  32 -  47
            outDm4[i]  = Out[i+outDm1.length*3];  //  48 -  63
            
            outDm5[i]  = Out[i+outDm1.length*4];  //  64 -  79
            outDm6[i]  = Out[i+outDm1.length*5];  //  80 -  95
            outDm7[i]  = Out[i+outDm1.length*6];  //  96 - 111
            outDm8[i]  = Out[i+outDm1.length*7];  // 112 - 127
            
            outDm9[i]  = Out[i+outDm1.length*8];  // 128 - 143
            outDm10[i] = Out[i+outDm1.length*9];  // 144 - 159
            outDm11[i] = Out[i+outDm1.length*10]; // 160 - 175
            outDm12[i] = Out[i+outDm1.length*11]; // 176 - 191
            
            outDm13[i] = Out[i+outDm1.length*12]; // 192 - 207
            outDm14[i] = Out[i+outDm1.length*13]; // 208 - 223
            outDm15[i] = Out[i+outDm1.length*14]; // 224 - 239
            outDm16[i] = Out[i+outDm1.length*15]; // 240 - 255
        }
        
        S1.setDataLine(0, S.getDataLine(0));
        S1.setDataLine(1, S.getDataLine(1));
        S1.setDataLine(2, S.getDataLine(2));
        S1.setDataLine(3, S.getDataLine(3));
        
        S2.setDataLine(0, S.getDataLine(4));
        S2.setDataLine(1, S.getDataLine(5));
        S2.setDataLine(2, S.getDataLine(6));
        S2.setDataLine(3, S.getDataLine(7));

        dm[0]  = new demux1Bit16x(In, S2, outDm0);

        dm[1]  = new demux1Bit16x(outDm0[0],  S1, outDm1);
        dm[2]  = new demux1Bit16x(outDm0[1],  S1, outDm2);
        dm[3]  = new demux1Bit16x(outDm0[2],  S1, outDm3);
        dm[4]  = new demux1Bit16x(outDm0[3],  S1, outDm4);

        dm[5]  = new demux1Bit16x(outDm0[4],  S1, outDm5);
        dm[6]  = new demux1Bit16x(outDm0[5],  S1, outDm6);
        dm[7]  = new demux1Bit16x(outDm0[6],  S1, outDm7);
        dm[8]  = new demux1Bit16x(outDm0[7],  S1, outDm8);

        dm[9]  = new demux1Bit16x(outDm0[8],  S1, outDm9);
        dm[10] = new demux1Bit16x(outDm0[9],  S1, outDm10);
        dm[11] = new demux1Bit16x(outDm0[10], S1, outDm11);
        dm[12] = new demux1Bit16x(outDm0[11], S1, outDm12);

        dm[13] = new demux1Bit16x(outDm0[12], S1, outDm13);
        dm[14] = new demux1Bit16x(outDm0[13], S1, outDm14);
        dm[15] = new demux1Bit16x(outDm0[14], S1, outDm15);
        dm[16] = new demux1Bit16x(outDm0[15], S1, outDm16);
    }
    public void calc() {
        for ( int i = 0; i < dm.length; i++ ) {
            dm[i].calc();            
        }
    }
}
