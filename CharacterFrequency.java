import java.util.*;

public class CharacterFrequency {
    /** First I will use Map because it sotres key value pair and key is the character and here value is the number of counts of character. Then i will use forr loop and iterate through the String and store the char of the string in a variable and compare it using the Character class isLetter() and after that i convert it into lowerCase and the add(put) it in the map, the map will store two parameters, first is character and the second is the frequency, so by using map.getOrDefault((ch, 0) + 1) it means if no available character is available, then the default value will be 0a and if present, the count increases by 1 and after that we will print the char and its frequency using for-each loop */
    public static void main(String[] args) {
        String str = "India is my Country";
        frequencyCount(str);
        
    }
    public static void frequencyCount(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for(char c = 'a'; c <= 'z'; c++){
            if(map.containsKey(c)){
                System.out.print(c + ":" + map.get(c) + ", ");
            }
        }
    }
}