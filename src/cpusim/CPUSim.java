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
        if ( tester.testDataLine8Bit()) System.out.println("OK DataLine8Bit");
        else System.out.println("NOK DataLine8Bit");
        if ( tester.testAdd8Bit()) System.out.println("OK Add8Bit");
        else System.out.println("NOK Add8Bit");
        if ( tester.testRegister8Bit()) System.out.println("OK Register8Bit");
        else System.out.println("NOK Register8Bit");
        if ( tester.testOr8x()) System.out.println("OK Or8x");
        else System.out.println("NOK Or8x");
        if ( tester.testAnd3x()) System.out.println("OK And3x");
        else System.out.println("NOK And3x");
        if ( tester.testMux8Bit2x()) System.out.println("OK Mux8Bit2x");
        else System.out.println("NOK Mux8Bit2x");
        if ( tester.testProgramCounter8Bit()) System.out.println("OK ProgramCounter8Bit");
        else System.out.println("NOK ProgramCounter8Bit");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CPUSim sim = new CPUSim();
       sim.testCircuit();
    }
    
}
