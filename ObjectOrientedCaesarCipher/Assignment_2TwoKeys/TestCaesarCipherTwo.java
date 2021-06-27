import edu.duke.*;
/**
 * Write a description of class TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo
{
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
    
    public String halfOfString(String message, int start){
        StringBuilder newString = new StringBuilder("");
        
        for(int k=start; k< message.length();k+=2){
            newString.append(message.charAt(k));

        }
        return newString.toString();
    }
    
    public String breakCaesarCipher(String input){
        String part1 = halfOfString(input,0);
        String part2 = halfOfString(input,1);
        int [] freqs1 = countLetters(part1);
        int [] freqs2 = countLetters(part2);
        int maxDex1 = maxIndex(freqs1);
        int maxDex2 = maxIndex(freqs2);
        int dkey1 = 4 - maxDex1;
        int dkey2 = 4 - maxDex2;
        if(maxDex1 > 4){
            dkey1 = 26 - (maxDex1-4);
        }
        if(maxDex2 > 4){
            dkey2 = 26 - (maxDex2-4);
        }
        CaesarCipherTwo cc = new CaesarCipherTwo(dkey1,dkey2);
        return cc.encrypt(input);
    }
    public void simpleTests(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24); 
        String encryt = cc.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy.");
        System.out.println("Encrypt with CaesarCipher object : "+encryt);
        System.out.println("Decrypt with CaesarCipher object : "+cc.decrypt(encryt));
        System.out.println("Decrypt breaking the CaesarCipher : "+ breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
    }
  
}
