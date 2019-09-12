/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class testgates {
    public boolean testNand() {
        nand nandTest = new nand();

        nandTest.setInput(false, false);
        nandTest.calc();
        if ( true != nandTest.getOutput() ) return false;
        
        nandTest.setInput(false, true);
        nandTest.calc();
        if ( true != nandTest.getOutput() ) return false;

        nandTest.setInput(true, false);
        nandTest.calc();
        if ( true != nandTest.getOutput() ) return false;

        nandTest.setInput(true, true);
        nandTest.calc();
        if ( false != nandTest.getOutput() ) return false;
        
        return true;
    }
    public boolean testNot() {
        not notTest = new not();

        notTest.setInput(false, false);
        notTest.calc();
        if ( true != notTest.getOutput() ) return false;
        
        notTest.setInput(true, false);
        notTest.calc();
        if ( false != notTest.getOutput() ) return false;
        
        return true;
    }
    public boolean testAnd() {
        and andTest = new and();

        andTest.setInput(false, false);
        andTest.calc();
        if ( false != andTest.getOutput() ) return false;
        
        andTest.setInput(true, false);
        andTest.calc();
        if ( false != andTest.getOutput() ) return false;
        
        andTest.setInput(false, true);
        andTest.calc();
        if ( false != andTest.getOutput() ) return false;

        andTest.setInput(true, true);
        andTest.calc();
        if ( true != andTest.getOutput() ) return false;

        return true;
    }
    public boolean testOr() {
        or orTest = new or();

        orTest.setInput(false, false);
        orTest.calc();
        if ( false != orTest.getOutput() ) return false;
        
        orTest.setInput(false, true);
        orTest.calc();
        if ( true != orTest.getOutput() ) return false;

        orTest.setInput(true, false);
        orTest.calc();
        if ( true != orTest.getOutput() ) return false;

        orTest.setInput(true, true);
        orTest.calc();
        if ( true != orTest.getOutput() ) return false;

        return true;
    }
    public boolean testXor() {
        xor xorTest = new xor();

        xorTest.setInput(false, false);
        xorTest.calc();
        if ( false != xorTest.getOutput() ) return false;
        
        xorTest.setInput(false, true);
        xorTest.calc();
        if ( true != xorTest.getOutput() ) return false;

        xorTest.setInput(true, false);
        xorTest.calc();
        if ( true != xorTest.getOutput() ) return false;

        xorTest.setInput(true, true);
        xorTest.calc();
        if ( false != xorTest.getOutput() ) return false;

        return true;
    }
    
    public boolean testAdd1Bit() {
        Add1Bit a1 = new Add1Bit();
        
        a1.setInput(false, false, false); //000
        a1.calc();
        if ( false != a1.getOutputA() && false != a1.getOutputU() ) return false;
        
        a1.setInput(false, false, true);//001
        a1.calc();
        if ( true != a1.getOutputA() && false != a1.getOutputU() ) return false;
        
        a1.setInput(false, true, false);//010
        a1.calc();
        if ( true != a1.getOutputA() && false != a1.getOutputU() ) return false;
        
        a1.setInput(true, false, false);//100
        a1.calc();
        if ( true != a1.getOutputA() && false != a1.getOutputU() ) return false;

        a1.setInput(true, true, false);//110
        a1.calc();
        if ( false != a1.getOutputA() && true != a1.getOutputU() ) return false;

        a1.setInput(true, false, true);//101
        a1.calc();
        if ( false != a1.getOutputA() && true != a1.getOutputU() ) return false;

        a1.setInput(false, true, true);//011
        a1.calc();
        if ( false != a1.getOutputA() && true != a1.getOutputU() ) return false;

        a1.setInput(true, true, true);//111
        a1.calc();
        if ( true != a1.getOutputA() && true != a1.getOutputU() ) return false;

        return true;
    }
    public boolean testMux1Bit2x() {
        DataLine1Bit aIn = new DataLine1Bit();
        DataLine1Bit bIn = new DataLine1Bit();
        DataLine1Bit Out = new DataLine1Bit();
        DataLine1Bit S = new DataLine1Bit();

        mux1Bit2x mux = new mux1Bit2x(aIn, bIn, Out, S);
        aIn.setPin(0, false);
        bIn.setPin(0, false);
        S.setPin(0, false);
        mux.calc();
        if ( false != Out.getPin(0) ) return false;

        aIn.setPin(0, true);
        bIn.setPin(0, false);
        S.setPin(0, false);
        mux.calc();
        if ( false != Out.getPin(0) ) return false;
        
        aIn.setPin(0, false);
        bIn.setPin(0, true);
        S.setPin(0, false);
        mux.calc();
        if ( true != Out.getPin(0) ) return false;

        aIn.setPin(0, true);
        bIn.setPin(0, true);
        S.setPin(0, false);
        mux.calc();
        if ( true != Out.getPin(0) ) return false;

        aIn.setPin(0, true);
        bIn.setPin(0, false);
        S.setPin(0, true);
        mux.calc();
        if ( true != Out.getPin(0) ) return false;

        aIn.setPin(0, false);
        bIn.setPin(0, true);
        S.setPin(0, true);
        mux.calc();
        if ( false != Out.getPin(0) ) return false;
        
        aIn.setPin(0, true);
        bIn.setPin(0, true);
        S.setPin(0, true);
        mux.calc();
        if ( true != Out.getPin(0) ) return false;

        return true;
    }
    public boolean testDeMux1Bit2x() {
        DataLine1Bit In = new DataLine1Bit();
        DataLine1Bit aOut = new DataLine1Bit();
        DataLine1Bit bOut = new DataLine1Bit();
        DataLine1Bit S = new DataLine1Bit();
        
        demux1Bit2x dm = new demux1Bit2x(In, aOut, bOut, S);

        In.setPin(0, false);
        S.setPin(0, false);
        dm.calc();
        if ( false != aOut.getPin(0) && false != bOut.getPin(0) ) return false;
        
        In.setPin(0, false);
        S.setPin(0, true);
        dm.calc();
        if ( false != aOut.getPin(0) && false != bOut.getPin(0) ) return false;

        In.setPin(0, true);
        S.setPin(0, false);
        dm.calc();
        if ( true != aOut.getPin(0) && false != bOut.getPin(0) ) return false;
        
        In.setPin(0, true);
        S.setPin(0, true);
        dm.calc();
        if ( false != aOut.getPin(0) && true != bOut.getPin(0) ) return false;

        return true;
    }
    public boolean testDFlipFlop() {
        DFlipFlop dff = new DFlipFlop();
        
        if ( false != dff.getOutput() ) return false;

        dff.setIput(false,true);
        dff.clkCycle();
        if ( false != dff.getOutput() ) return false;

        dff.setIput(true,true);
        dff.clkCycle();
        if ( true != dff.getOutput() ) return false;
        dff.clkCycle();
        if ( true != dff.getOutput() ) return false;

        dff.setIput(false,false);
        dff.clkCycle();
        if ( true != dff.getOutput() ) return false;
        

        return true;
    }
    public boolean testDataLine8Bit() {
        DataLine8Bit line = new DataLine8Bit();
        String testStr = "01111011";
        line.setBitsString(testStr);
        if ( testStr.compareTo( line.getBitsString() ) != 0 ) return false;
        if ( 123 != line.getBitsInt() ) return false;
        
        line.setBitsInt(123);
        if ( testStr.compareTo( line.getBitsString() ) != 0 ) return false;
        if ( 123 != line.getBitsInt() ) return false;
        
        return true;
    }
    public boolean testAdd8Bit() {
        DataLine8Bit aIn  = new DataLine8Bit();
        DataLine8Bit bIn  = new DataLine8Bit();
        DataLine8Bit cOut = new DataLine8Bit();
        DataLine1Bit uIn  = new DataLine1Bit();
        DataLine1Bit uOut = new DataLine1Bit();
        
        aIn.setBitsInt(103);
        bIn.setBitsInt(87);
        Add8Bit adder = new Add8Bit(aIn, bIn, cOut, uIn, uOut);
        adder.calc();
        if ( 190 != cOut.getBitsInt() ) return false;
        if ( false != uOut.getPin(0) ) return false;

        aIn.setBitsInt(199);
        bIn.setBitsInt(44);
        adder.calc();
        if ( 243 != cOut.getBitsInt() ) return false;
        if ( false != uOut.getPin(0) ) return false;
        
        aIn.setBitsInt(67);
        bIn.setBitsInt(188);
        adder.calc();
        if ( 255 != cOut.getBitsInt() ) return false;
        if ( false != uOut.getPin(0) ) return false;

        aIn.setBitsInt(67);
        bIn.setBitsInt(189);
        adder.calc();
        if ( 0 != cOut.getBitsInt() ) return false;
        if ( true != uOut.getPin(0) ) return false;

        aIn.setBitsInt(67);
        bIn.setBitsInt(188);
        uIn.setPin(0, true);
        adder.calc();
        if ( 0 != cOut.getBitsInt() ) return false;
        if ( true != uOut.getPin(0) ) return false;
        
        return true;
    }
    public boolean testRegister8Bit() {
        DataLine8Bit in  = new DataLine8Bit();
        DataLine8Bit out = new DataLine8Bit();
        DataLine1Bit enable = new DataLine1Bit();
        Register8Bit reg = new Register8Bit(in, out, enable);
        in.setBitsInt(200);
        enable.setPin(0, true);        
        if ( 0 != out.getBitsInt() ) return false;

        reg.clkCycle();
        if ( 200 != out.getBitsInt() ) return false;

        reg.clkCycle();
        int ret = out.getBitsInt();
        if ( 200 != out.getBitsInt() ) return false;

        enable.setPin(0, false);        
        reg.clkCycle();
        reg.clkCycle();
        reg.clkCycle();
        if ( 200 != out.getBitsInt() ) return false;

        
        return true;
    }
    public boolean testOr8x() {
        DataLine8Bit in  = new DataLine8Bit();
        DataLine1Bit out = new DataLine1Bit();
        Or8x or = new Or8x(in, out);
        in.setBitsInt(0);
        or.calc();
        if ( false != out.getPin(0) ) return false;
        
        for ( int i = 1; i < 256; i++ ) {
            in.setBitsInt(i);
            or.calc();
            if ( true != out.getPin(0) ) return false;
        }
        return true;
    }
    public boolean testNot1Bit() {
        DataLine1Bit In = new DataLine1Bit();
        DataLine1Bit Out = new DataLine1Bit();
        Not1Bit not1 = new Not1Bit(In, Out);
        
        In.setPin(0, false);
        not1.calc();
        if ( true != Out.getPin(0) ) return false;
        
        In.setPin(0, true);
        not1.calc();
        if ( false != Out.getPin(0) ) return false;

        return true;
    }
    public boolean testAnd3x() {
        And3x and = new And3x();
        
        and.setInput(false, false, false);
        if ( false != and.getOutput() ) return false;
        and.setInput(false, false, true);
        if ( false != and.getOutput() ) return false;
        and.setInput(false, true, false);
        if ( false != and.getOutput() ) return false;
        and.setInput(false, true, true);
        if ( false != and.getOutput() ) return false;
        and.setInput(true, false, false);
        if ( false != and.getOutput() ) return false;
        and.setInput(true, false, true);
        if ( false != and.getOutput() ) return false;
        and.setInput(true, true, false);
        if ( false != and.getOutput() ) return false;
        and.setInput(true, true, true);
        if ( true != and.getOutput() ) return false;
        
        return true;
    }
    public boolean testMux8Bit2x() {
        DataLine8Bit in1Line = new DataLine8Bit();
        DataLine8Bit in2Line = new DataLine8Bit();
        DataLine8Bit outLine = new DataLine8Bit();
        DataLine1Bit sLine = new DataLine1Bit();
        mux8Bit2x mux = new mux8Bit2x(in1Line, in2Line, outLine, sLine);
        
        in1Line.setBitsInt(123);
        in2Line.setBitsInt(231);
        
        sLine.setPin(0, false);
        mux.calc();
        if ( 231 != outLine.getBitsInt() ) return false;
        
        sLine.setPin(0, true);
        mux.calc();
        if ( 123 != outLine.getBitsInt() ) return false;
        
        return true;        
    }
    public boolean testProgramCounter8Bit() {
        DataLine8Bit PCinLine = new DataLine8Bit();
        DataLine8Bit PCoutLine = new DataLine8Bit();
        DataLine1Bit PCselectLine = new DataLine1Bit();
        DataLine1Bit PCloadLine = new DataLine1Bit();
        
        ProgramCounter8Bit cnt = new ProgramCounter8Bit(
                PCinLine, PCoutLine, PCselectLine, PCloadLine);
        
        PCinLine.setBitsInt(123);
        //enable store count state
        PCloadLine.setPin(0, true);
        //use counter
        PCselectLine.setPin(0, false);
        cnt.clkCycle();
        cnt.clkCycle();
        cnt.clkCycle();
        cnt.clkCycle();
        if ( 4 != PCoutLine.getBitsInt() ) return false;
        PCloadLine.setPin(0, false);
        cnt.clkCycle();
        cnt.clkCycle();
        if ( 4 != PCoutLine.getBitsInt() ) return false;
        PCselectLine.setPin(0, true);
        cnt.clkCycle();
        int ret = PCoutLine.getBitsInt() ;
        if ( 4 != PCoutLine.getBitsInt() ) return false;
        PCloadLine.setPin(0, true);
        cnt.clkCycle();
        ret = PCoutLine.getBitsInt() ;
        if ( 123 != PCoutLine.getBitsInt() ) return false;
        
        return true;
    }
    public boolean testALU8Bit() {
        DataLine8Bit inALine = new DataLine8Bit();
        DataLine8Bit inBLine = new DataLine8Bit();
        DataLine8Bit outLine = new DataLine8Bit();
        DataLine2Bit opSelectLine = new DataLine2Bit();
        ALU8Bit alu = new ALU8Bit(inALine, inBLine, outLine, opSelectLine);

        //or
        inALine.setBitsString("11001100");
        inBLine.setBitsString("10000101");
        opSelectLine.setBitsInt(0);
        alu.calc();
        if ( outLine.getBitsString().compareTo("11001101") != 0 ) return false;
        //and
        opSelectLine.setBitsInt(1);
        alu.calc();
        if ( outLine.getBitsString().compareTo("10000100") != 0 ) return false;
        // sub
        inALine.setBitsInt(123);
        inBLine.setBitsInt(57);
        opSelectLine.setBitsInt(2);
        alu.calc();
        if ( 66 != outLine.getBitsInt() ) return false;                
        // add
        opSelectLine.setBitsInt(3);
        alu.calc();
        if ( 180 != outLine.getBitsInt() ) return false;
        
        return true;
    }
    public boolean testDSBusRegister() {
        DataLine8Bit dataInLine = new DataLine8Bit();
        DataLine8Bit sBusOutLine = new DataLine8Bit();
        DataLine8Bit dBusOutLine = new DataLine8Bit();
        DataLine1Bit rwLine = new DataLine1Bit();
        DataLine1Bit regDstSelLine = new DataLine1Bit();
        DataLine1Bit regSrcSelLine = new DataLine1Bit();
        DataLine1Bit zeroFlagLine = new DataLine1Bit();
        DataLine1Bit negativFlagLine = new DataLine1Bit();
        DSBusRegister dsBus = new DSBusRegister(
                dataInLine, sBusOutLine, dBusOutLine, rwLine, 
                regDstSelLine, regSrcSelLine, zeroFlagLine, negativFlagLine);
        
        return true;
    }
}
