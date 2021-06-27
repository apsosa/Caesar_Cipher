
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    // instance variables - replace the example below with your own
    private String  alphabet;
    private String  shiftedAlphabet;
    private int mainKey;
    /**
     * Constructor for objects of class CaesarCipher
     */
    public CaesarCipher(int key)
    {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    public char encryptChar(char chr){
        char ch = Character.toLowerCase(chr);
        int currIdex= alphabet.indexOf(ch);
        if(currIdex != -1){
             char newChar = shiftedAlphabet.charAt(currIdex);
             return newChar;
        }
       
        return ch;
    }
    
    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i < input.length(); i++){
            char currChar = input.charAt(i);
            char newChar = encryptChar(currChar);
            if(currChar != ' '){
                encrypted.setCharAt(i,newChar);
            }else{
                encrypted.setCharAt(i,currChar);
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(encrypted);
    }

}
