/*
 * https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
 * github@AndreBetz.de
 */
package cpusim;

/**
 *
 * @author github@andrebetz.de
 */
public class InstructionDecoder {
    private DataLine8Bit instruction;
    private DataLine1Bit LDR;
    private DataLine1Bit STR;
    private DataLine1Bit MR1R2;
    private DataLine1Bit JPZ;
    private DataLine1Bit AND;
    private DataLine1Bit OR;
    private DataLine1Bit ADD;
    private DataLine1Bit SUB;
    private not not1 = new not();
    private not not2 = new not();
    private not not3 = new not();
    private not not4 = new not();
    private not not5 = new not();
    private not not6 = new not();
    private not not7 = new not();
    private not not8 = new not();
    private not not9 = new not();
    private not not10 = new not();
    private not not11 = new not();
    private not not12 = new not();
    private And3x and1 = new And3x();
    private And3x and2 = new And3x();
    private And3x and3 = new And3x();
    private And3x and4 = new And3x();
    private And3x and5 = new And3x();
    private And3x and6 = new And3x();
    private And3x and7 = new And3x();
    private And3x and8 = new And3x();
    public InstructionDecoder(
            DataLine8Bit instructionLine,
            DataLine1Bit LDRLine,
            DataLine1Bit STRLine,
            DataLine1Bit MR1R2Line,
            DataLine1Bit JPZLine,
            DataLine1Bit ANDLine,
            DataLine1Bit ORLine,
            DataLine1Bit ADDLine,
            DataLine1Bit SUBLine ) {
        instruction = instructionLine;
        LDR = LDRLine;
        STR = STRLine;
        MR1R2 = MR1R2Line;
        JPZ = JPZLine;
        AND = ANDLine;
        OR = ORLine;
        ADD = ADDLine;
        SUB = SUBLine;
    }
    public void calc() {
        //LDR
        not1.setInput(instruction.getPin(0), instruction.getPin(0));
        not1.calc();
        not2.setInput(instruction.getPin(1), instruction.getPin(1));
        not2.calc();
        not3.setInput(instruction.getPin(2), instruction.getPin(2));
        not3.calc();
        and1.setInput(not1.getOutput(), not2.getOutput(), not3.getOutput());
        and1.calc();
        LDR.setPin(0, and1.getOutput());
        //STR
        not4.setInput(instruction.getPin(1), instruction.getPin(1));
        not4.calc();
        not5.setInput(instruction.getPin(2), instruction.getPin(2));
        not5.calc();        
        and2.setInput(instruction.getPin(0), not4.getOutput(), not5.getOutput());
        and2.calc();
        STR.setPin(0, and2.getOutput());
        //MR1R2
        not6.setInput(instruction.getPin(0), instruction.getPin(0));
        not6.calc();        
        not7.setInput(instruction.getPin(2), instruction.getPin(2));
        not7.calc();
        and3.setInput(not6.getOutput(), instruction.getPin(1), not7.getOutput());
        and3.calc();
        MR1R2.setPin(0, and3.getOutput());
        //JPZ
        not8.setInput(instruction.getPin(2), instruction.getPin(2));
        not8.calc();
        and4.setInput(instruction.getPin(0), instruction.getPin(1), not8.getOutput());
        and4.calc();
        JPZ.setPin(0, and4.getOutput());
        //AND
        not9.setInput(instruction.getPin(0), instruction.getPin(0));
        not9.calc();
        not10.setInput(instruction.getPin(1), instruction.getPin(1));
        not10.calc();
        and5.setInput(not9.getOutput(),not10.getOutput(), instruction.getPin(2));
        and5.calc();
        AND.setPin(0, and5.getOutput());
        //OR
        not11.setInput(instruction.getPin(1), instruction.getPin(1));
        not11.calc();
        and6.setInput(instruction.getPin(0),not11.getOutput(), instruction.getPin(2));
        and6.calc();
        OR.setPin(0, and6.getOutput());
        //ADD
        not12.setInput(instruction.getPin(0), instruction.getPin(0));
        not12.calc();
        and7.setInput(not12.getOutput(),instruction.getPin(1), instruction.getPin(2));
        and7.calc();
        ADD.setPin(0, and7.getOutput());
        //SUB
        and8.setInput(instruction.getPin(0),instruction.getPin(1), instruction.getPin(2));
        and8.calc();
        SUB.setPin(0, and8.getOutput());       
    }
}
