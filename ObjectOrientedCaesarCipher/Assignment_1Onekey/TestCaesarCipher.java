import edu.duke.*;
/**
 * Write a description of class TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipher
{
    // instance variables - replace the example below with your own
    public int[] countLetters(String message)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26]; 
        for (int k = 0; k < message.length(); k++ ) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            if(index != -1){
                counts[index] += 1;
            }
        }
       return counts;
    }

    public int maxIndex(int[] counts){
        int maxIndex = 0;
        for(int k =0;k < counts.length; k++){
            if(counts[k] > counts[maxIndex]){
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    public String breakCaesarCipher(String input){
        
        int [] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = 4 - maxDex;
        if(maxDex > 4){
            dkey = 26 - (maxDex-4);
        }
        CaesarCipher cc = new CaesarCipher(26-dkey);
        return cc.decrypt(input);
    }
    public void simpleTests(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(15); 
        String encryt = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("Encrypt with CaesarCipher object : "+encryt);
        System.out.println("Decrypt with CaesarCipher object : "+cc.decrypt(encryt));
        System.out.println("Decrypt breaking the CaesarCipher : "+breakCaesarCipher(encryt));
    }
}
