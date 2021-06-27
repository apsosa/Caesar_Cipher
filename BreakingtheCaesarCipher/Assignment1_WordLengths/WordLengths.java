import edu.duke.*;
/**
 * Write a description of class WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordLengths
{
    public int longWithoutChar(String word){
        if(word.length() == 0){
            return 0;
        }
        
        if(word.length() == 1){
            return 1;
        }
        char beg = word.charAt(0);
        char end = word.charAt(word.length()-1);
        if(!Character.isLetter(beg)){
            if(!Character.isLetter(end)){
                return word.length()-2;
            }else{
                return word.length()-1;
            }   
        }else{
            if(!Character.isLetter(end)){
                return word.length()-1;
            }
        }
        return word.length();
    }
    public void printArray(int[] array){
        for(int k=0;k <array.length; k++){
            if(array[k] != 0){
                System.out.println("There are "+array[k]+" words with length " + k);
            }
        }
    }
    
    public void countWordLengths(FileResource resource, int[] counts)
    {
       for(String s : resource.words()){    
           int index =  longWithoutChar(s);
           if(index > counts.length-1){
               counts[counts.length-1] += 1;
           }else{
               counts[index] += 1;
           }
       }
    }
    
    public int indexOfMax(int[] counts){
        if(counts.length == 0){
            return -1;
        }
        if(counts.length == 1){
            return 0;
        }
        int max = counts[0];
        int maxIndex = 0;
        for(int k =1;k < counts.length; k++){
            if(counts[k]> max){
                max = counts[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    public void test(){
        FileResource resource = new FileResource("../data/manywords.txt");
        int[] counts = new int[31];
        countWordLengths(resource,counts);
        printArray(counts);
        System.out.println("The most common word length is:"+ indexOfMax(counts));
    }

}
