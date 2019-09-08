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
public class CPUSim {

    public void testCircuit() {
        testgates tester = new testgates();
        if ( tester.testNand() ) System.out.println("nand OK");
        else System.out.println("nand NOK");
        if ( tester.testNot() ) System.out.println("not OK");
        else System.out.println("not NOK");
        if ( tester.testAnd() ) System.out.println("and OK");
        else System.out.println("and NOK");
        if ( tester.testOr() ) System.out.println("or OK");
        else System.out.println("or NOK");
        if ( tester.testXor() ) System.out.println("xor OK");
        else System.out.println("xor NOK");
        if ( tester.testAdd1Bit()) System.out.println("Add1Bit OK");
        else System.out.println("Add1Bit NOK");
        if ( tester.testMux1Bit2x()) System.out.println("Mux1Bit2x OK");
        else System.out.println("Mux1Bit2x NOK");
        if ( tester.testDeMux1Bit2x()) System.out.println("DeMux1Bit2x OK");
        else System.out.println("DeMux1Bit2x NOK");
        if ( tester.testDFlipFlop()) System.out.println("DFlipFlop OK");
        else System.out.println("DFlipFlop NOK");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CPUSim sim = new CPUSim();
       sim.testCircuit();
    }
    
}
