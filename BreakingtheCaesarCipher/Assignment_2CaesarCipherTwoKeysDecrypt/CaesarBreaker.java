import edu.duke.*;
/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarBreaker
{

    public int[] countLetters(String message)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26]; 
        for (int k = 0; k < message.length(); k++ ) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            if(index != -1){
                counts[index] =+ 1;
            }
        }
       return counts;
    }
    public int countLetter(String message){
        int count = 0;
        for (int k = 0; k < message.length(); k++ ) {
            char ch = message.charAt(k);
            if(ch != ' '){
                count++;
            }
        }
        return  count;
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

    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int [] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = 4 - maxDex;
        if(maxDex > 4){
            dkey = 26 - (maxDex-4);
        }
        return cc.encrypt(encrypted,26-dkey);
    }
    public String StringWithoutSpace(String message){
        StringBuilder newString = new StringBuilder("");
         for(int k=0; k< message.length();k++){
                
                if(message.charAt(k) != ' '){
                    newString.append(message.charAt(k));
                }
         }
         return newString.toString();
    }
    public String halfOfString(String message, int start){
        StringBuilder newString = new StringBuilder("");
        
        for(int k=start; k< message.length();k+=2){
            newString.append(message.charAt(k));

        }
        return newString.toString();
    }
    
    public String  combString(String part1, String part2){
        StringBuilder newString = new StringBuilder("");
        int sumLeng = part1.length() + part2.length();
        int part1Leng = 0;
        int part2Leng = 0;
        for(int k=0; k<sumLeng ;k++){
            if(k % 2 == 0){
                newString.append(part1.charAt(part1Leng));
                part1Leng++;
                
            }else{
                newString.append(part2.charAt(part2Leng));
                part2Leng++;
            }
        }
        return newString.toString();
    }
    
    public int  getKey(String s){
        int[] freqs = countLetters(s);
        int index = maxIndex(freqs);
        return freqs[index];
    }
    
    public String decryptWithTwoKeys(String encrypted){
        String part1 = halfOfString(encrypted,0);
        String part2 = halfOfString(encrypted,1);
        CaesarCipher cc1 = new CaesarCipher();
        CaesarCipher cc2 = new CaesarCipher();
        int [] freqs1 = countLetters(part1);
        int [] freqs2 = countLetters(part2);
        int maxDex1 = maxIndex(freqs1);
        int maxDex2 = maxIndex(freqs2);
        int dkey1 = 4-maxDex1;
        int dkey2 = 4-maxDex2;
        if(maxDex1 > 4){
            dkey1 = 26 - (maxDex1-4);
        }
        if(maxDex2 > 4){
            dkey2 = 26 - (maxDex2-4);
        }
        System.out.println("key1: "+dkey1);
        System.out.println("key2: "+dkey2);
        String part1D = cc1.encrypt(part1,dkey1);
        String part2D = cc2.encrypt(part2,dkey2);
        return combString(part1D,part2D);
    }
    
    public void testDecrypt(){
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(decryptWithTwoKeys(message));
        /*
        String one = halfOfString("Hola Como estan?",0);
        String two = halfOfString("Hola Como estan?",1);
        System.out.println(one);
        System.out.println(two);
        System.out.println(combString(one,two));
        */
       //CaesarCipher cc1 = new CaesarCipher();
       //System.out.println(cc1.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",26-2,26-20));
       //System.out.println(decryptWithTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
    }
}
