/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@AndreBetz.de
 */
public class CPUSim {

    public void testCircuit() {
        testgates tester = new testgates();
        if ( !tester.testNand() )   System.out.println("NOK nand");
        if ( !tester.testNot() )    System.out.println("NOK not");
        if ( !tester.testAnd() )    System.out.println("NOK and");
        if ( !tester.testOr() )     System.out.println("NOK or");
        if ( !tester.testXor() )    System.out.println("NOK xor");
        if ( !tester.testAdd1Bit()) System.out.println("NOK Add1Bit");
        if ( !tester.testMux1Bit2x())   System.out.println("NOK Mux1Bit2x");
        if ( !tester.testDeMux1Bit2x()) System.out.println("NOK DeMux1Bit2x");
        if ( !tester.testDFlipFlop()) System.out.println("NOK DFlipFlop");
        if ( !tester.testDataLine8Bit()) System.out.println("NOK DataLine8Bit");
        if ( !tester.testAdd8Bit()) System.out.println("NOK Add8Bit");
        if ( !tester.testRegister8Bit()) System.out.println("NOK Register8Bit");
        if ( !tester.testOr8x()) System.out.println("NOK Or8x");
        if ( !tester.testNot1Bit()) System.out.println("NOK Not1Bit");
        if ( !tester.testAnd3x()) System.out.println("NOK And3x");
        if ( !tester.testMux8Bit2x()) System.out.println("NOK Mux8Bit2x");
        if ( !tester.testProgramCounter8Bit()) System.out.println("NOK ProgramCounter8Bit");
        if ( !tester.testALU8Bit()) System.out.println("NOK ALU8Bit");
        if ( !tester.testDSBusRegister()) System.out.println("NOK DSBusRegister");
        if ( !tester.testMux8Bit4x()) System.out.println("NOK Mux8Bit4x");
        if ( !tester.testDemux1Bit4x()) System.out.println("NOK Demux1Bit4x");
        if ( !tester.testDemux1Bit16x()) System.out.println("NOK Demux1Bit16x");
        if ( !tester.testDemux1Bit256x()) System.out.println("NOK Demux1Bit256x");
        if ( !tester.testMux1Bit16x()) System.out.println("NOK Mux1Bit16x");
        if ( !tester.testMux1Bit256x()) System.out.println("NOK Mux1Bit256x");
        if ( !tester.testRAM8Bit()) System.out.println("NOK RAM8Bit");
        if ( !tester.testCycleCounter()) System.out.println("NOK CycleCounter");
        if ( !tester.testInstructionDecoder()) System.out.println("NOK InstructionDecoder");
        if ( !tester.testMux1Bit4x()) System.out.println("NOK Mux1Bit4x");
        if ( !tester.testOr5x()) System.out.println("NOK Or5x");
        if ( !tester.testAnd2x()) System.out.println("NOK And2x");
        if ( !tester.testNot1x()) System.out.println("NOK Not1x");
        if ( !tester.testCommandSet()) System.out.println("NOK CommandSet");
        if ( !tester.testCPUController()) System.out.println("NOK CPUController");
        if ( !tester.testDSBusRegALU()) System.out.println("NOK DSBusRegALU");
        if ( !tester.testAdressInstructionRAM()) System.out.println("NOK AdressInstructionRAM");
        if ( !tester.testDataPath()) System.out.println("NOK DataPath");
        if ( !tester.testCPU()) System.out.println("NOK CPU");
        System.out.println("test end");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CPUSim sim = new CPUSim();
       sim.testCircuit();
    }
    
}
