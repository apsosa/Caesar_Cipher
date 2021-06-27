import java.io.*;
import edu.duke.*;
/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    
    public boolean isVowel(char ch)
    {
        boolean lowerCase = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
        boolean upperCase = (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
        
        return (lowerCase || upperCase);
        
    }

    
    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder newPhrase = new StringBuilder("");
        for(int i=0; i < phrase.length(); i++){
            if(isVowel(phrase.charAt(i))){
                newPhrase.append(ch);
            }else{
                newPhrase.append(phrase.charAt(i));
            } 
        }
        return newPhrase.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder("");
        for(int i=0; i < phrase.length(); i++){
            if(phrase.charAt(i) == ch){
                if(i % 2 == 0){
                    newPhrase.append('*');
                }else{
                    newPhrase.append('+');
                }
                
            }else{
                newPhrase.append(phrase.charAt(i));
            } 
        }
        return newPhrase.toString();
    }
    
    public void test(){
        char test = 'F';
        System.out.println(test+"is a vowel? :-"+isVowel(test));
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
