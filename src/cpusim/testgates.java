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
        mux1Bit2x mux = new mux1Bit2x();
        
        mux.setInput(false, false, false);
        mux.calc();
        if ( false != mux.getOutput() ) return false;

        mux.setInput(true, false, false);
        mux.calc();
        if ( false != mux.getOutput() ) return false;
        
        mux.setInput(false, true, false);
        mux.calc();
        if ( true != mux.getOutput() ) return false;

        mux.setInput(true, true, false);
        mux.calc();
        if ( true != mux.getOutput() ) return false;

        mux.setInput(true, false, true);
        mux.calc();
        if ( true != mux.getOutput() ) return false;
        
        mux.setInput(false, true, true);
        mux.calc();
        if ( false != mux.getOutput() ) return false;

        mux.setInput(true, true, true);
        mux.calc();
        if ( true != mux.getOutput() ) return false;

        return true;
    }
    public boolean testDeMux1Bit2x() {
        demux1Bit2x dm = new demux1Bit2x();
        
        dm.setInput(false, false);
        dm.calc();
        if ( false != dm.getOutputA() && false != dm.getOutputB() ) return false;

        dm.setInput(false, true);
        dm.calc();
        if ( false != dm.getOutputA() && false != dm.getOutputB() ) return false;

        dm.setInput(true, false);
        dm.calc();
        if (  true != dm.getOutputA() && false != dm.getOutputB() ) return false;

        dm.setInput(true, true);
        dm.calc();
        if (  false != dm.getOutputA() && true != dm.getOutputB() ) return false;

        return true;
    }
    public boolean testDFlipFlop() {
        return true;
    }
}
