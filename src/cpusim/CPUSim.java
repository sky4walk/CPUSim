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
        if ( tester.testNand() ) System.out.println("OK nand");
        else System.out.println("NOK nand");
        if ( tester.testNot() ) System.out.println("OK not");
        else System.out.println("NOK not");
        if ( tester.testAnd() ) System.out.println("OK and");
        else System.out.println("NOK and");
        if ( tester.testOr() ) System.out.println("OK or");
        else System.out.println("NOK or");
        if ( tester.testXor() ) System.out.println("OK xor");
        else System.out.println("NOK xor");
        if ( tester.testAdd1Bit()) System.out.println("OK Add1Bit");
        else System.out.println("NOK Add1Bit");
        if ( tester.testMux1Bit2x()) System.out.println("OK Mux1Bit2x");
        else System.out.println("NOK Mux1Bit2x");
        if ( tester.testDeMux1Bit2x()) System.out.println("OK DeMux1Bit2x");
        else System.out.println("NOK DeMux1Bit2x");
        if ( tester.testDFlipFlop()) System.out.println("OK DFlipFlop");
        else System.out.println("NOK DFlipFlop");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CPUSim sim = new CPUSim();
       sim.testCircuit();
    }
    
}
