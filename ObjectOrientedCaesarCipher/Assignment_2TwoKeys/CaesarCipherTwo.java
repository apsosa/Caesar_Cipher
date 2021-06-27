
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{
    // instance variables - replace the example below with your own
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private String shiftedAlphabet3;
    private String shiftedAlphabet4;
    /**
     * Constructor for objects of class CaesarCipherTwo
     */
    public CaesarCipherTwo(int key1, int key2)
    {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        shiftedAlphabet3 = alphabet.substring(26-key1) + alphabet.substring(0,26-key1);
        shiftedAlphabet4 = alphabet.substring(26-key2) + alphabet.substring(0,26-key2);
    }
    
    public char encryptChar(char chr, int key){
        char ch = Character.toLowerCase(chr);
        int currIdex= alphabet.indexOf(ch);
        if(currIdex != -1){
            if(key == 1){
                char newChar = shiftedAlphabet1.charAt(currIdex);
                return newChar;
            }
            if(key == 2){
                char newChar = shiftedAlphabet2.charAt(currIdex);
                return newChar;
            }
            if(key == 3){
                char newChar = shiftedAlphabet3.charAt(currIdex);
                return newChar;
            }
            if(key == 4){
                char newChar = shiftedAlphabet4.charAt(currIdex);
                return newChar;
            }
        }
        return ch;
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i < input.length(); i++){
            char currChar = input.charAt(i);
            if(i % 2 == 0){
                char newChar = encryptChar(currChar,1);
                if(newChar != ' '){ 
                    encrypted.setCharAt(i,newChar);
                }
            }else{
                char newChar = encryptChar(currChar,2);
                if(newChar != ' '){
                    encrypted.setCharAt(i,newChar);
                }  
            }
        }    
        return encrypted.toString();
    }
    public String decrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i < input.length(); i++){
            char currChar = input.charAt(i);
            if(i % 2 == 0){
                char newChar = encryptChar(currChar,3);
                if(newChar != ' '){ 
                    encrypted.setCharAt(i,newChar);
                }
            }else{
                char newChar = encryptChar(currChar,4);
                if(newChar != ' '){
                    encrypted.setCharAt(i,newChar);
                }  
            }
        }    
        return encrypted.toString();
    }
}
