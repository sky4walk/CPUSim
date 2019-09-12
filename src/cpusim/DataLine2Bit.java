/*
https://itzwieseltal.wordpress.com/2018/01/23/do-it-yourself-cpu-4-prozessor/
github@AndreBetz.de
*/

package cpusim;

/**
 *
 * @author andre
 */
public class DataLine2Bit {
    private DataLine1Bit lines[] = new DataLine1Bit[2];
    public DataLine2Bit() {
        for ( int i = 0; i < lines.length; i++ ) {
            lines[i] = new DataLine1Bit();
        }
        reset();
    }
    public void reset() {
        for ( int i = 0; i < lines.length; i++ ) {
            lines[i].reset();
        }        
    }
    public void setPin(int nr,boolean val) {
        if ( nr < lines.length ) {
            lines[nr].setPin(0, val);
        }
    }
    public boolean getPin(int nr) {
        if ( nr < lines.length ) {
            return lines[nr].getPin(0);
        }
        return false;
    }
    public DataLine1Bit getDataLine(int nr) {
        if ( nr < lines.length ) {
            return lines[nr];
        }
        return null;        
    }
    public void setPins(DataLine1Bit bits) {
        for ( int i = 0; i < lines.length; i++ ) {
            setPin(i,bits.getPin(i));
        }
    }
    public String getBitsString() {
        String bits = "";
        for ( int i = 0; i < lines.length; i++ ) {
            if ( getPin(lines.length - 1 - i) ) {
                bits += "1";
            } else {
                bits += "0";
            }
        }
        return bits;
    }
    public int getBitsInt() {
        int bits = 0;
        int cnt = 1;
        for ( int i = 0; i < lines.length; i++ ) {
            if ( true == getPin(i) ) {
                bits += cnt;
            }
            cnt *= 2;
        }
        return bits;
    }
    public void setBitsString(String val) {
        reset();
        if ( val.length() == lines.length ) {
            for ( int i = 0; i < lines.length; i++ ) {
                if ( '1' == val.charAt(i) ) {
                    setPin(lines.length - 1 - i, true);
                } 
            }
        }
    }
    public void setBitsInt(int val) {
        reset();
        int tmp = val;
        int exp = 1;
        int i = 0;
        while ( 0 != tmp && i < lines.length ) {
            if ( 1 == tmp % 2 ) {
                setPin(i, true);
            } 
            i++;
            tmp /= 2;
            exp *= 2;
        }
        if ( exp <= val ) reset();
    } 
}
