import java.io.*;
import edu.duke.*;
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    public char encryptChar(char ch, int key){
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower  = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetU = alphabetUpper.substring(key) + alphabetUpper.substring(0,key);
        String shiftedAlphabetL = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        if(Character.isLowerCase(ch)){
                int currIdex= alphabetLower.indexOf(ch);
                if(currIdex != -1){
                    char newChar = shiftedAlphabetL.charAt(currIdex);
                    return newChar;
                }
        }else{
                int currIdex= alphabetUpper.indexOf(ch);
                if(currIdex != -1){
                    char newChar = shiftedAlphabetU.charAt(currIdex);
                    return newChar;
                }
        }
        return ch;
    } 
    public String encrypt(String input, int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i < input.length(); i++){
            char currChar = input.charAt(i);
            char newChar = encryptChar(currChar,key);
            if(currChar != ' '){
                encrypted.setCharAt(i,newChar);
            }else{
                encrypted.setCharAt(i,currChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesar(){
        /*
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        */
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        //System.out.println( encrypt("First Legion", 23));
        //System.out.println( encrypt("First Legion", 17));
        System.out.println( encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i=0; i < input.length(); i++){
            char currChar = input.charAt(i);
            if(i % 2 == 0){
                char newChar = encryptChar(currChar,key1);
                if(newChar != ' '){ 
                    encrypted.setCharAt(i,newChar);
                }
            }else{
                char newChar = encryptChar(currChar,key2);
                if(newChar != ' '){
                    encrypted.setCharAt(i,newChar);
                }  
            }
        }    
        return encrypted.toString();
    }
    
}
