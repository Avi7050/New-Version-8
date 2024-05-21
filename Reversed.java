public class Reversed {

    /** First we need to make a reverseString() that will swap the letters in a string and then return it.
     * 
     * Next we need to create reverseWord() and store the words in a String arraya using split() and then create StringBuffer or String Builder Object and then perform iteration through for-each loop and reverse every word and at the same time append the reversed word in the created object and finally return the object and convert it into String.
     */
    public static void main(String[] args) {
        String str = "IQGATEWAY INDIA";
        String reversed = reversedWord(str);
        System.out.println(reversed);
    }
    public static String reverseString(String str){
        char[] ch = str.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }
    public static String reversedWord(String str){
        StringBuffer sb = new StringBuffer();
        String[] words = str.split(" ");
        for(String word : words){
            String revWord = reverseString(word);
            sb.append(revWord + " ");
        }
        return new String(sb.toString());
    }
}

















// public static String reverseString(String str){
//     char[] ch = str.toCharArray();
//     int start = 0;
//     int end = ch.length - 1;
//     while(start < end){
//         char temp = ch[start];
//         ch[start] = ch[end];
//         ch[end] = temp;
//         start++;
//         end--;
//     }
//     return new String(ch);
// }
// public static String reversedWord(String str){
//     StringBuffer sb = new StringBuffer();
//     String[] words = str.split(" ");
//     for(String word : words){
//         String reverseWord = reverseString(word);
//         sb.append(reverseWord + " ");
//     }
//     return new String(sb.toString().trim());
// }



























// public static String reversed(String str){
//     StringBuilder sb = new StringBuilder();

//     String[] words = str.split(" ");
//     for(String word : words){
//         String revString = reverseString(word);
//         sb.append(revString + " ");
//     }
//     return sb.toString().trim();
// }
// public static String reverseString(String str) {
//     char[] ch = str.toCharArray();
//     int start = 0;
//     int end = ch.length - 1;
//     while (start < end) {
//         char temp = ch[start];
//         ch[start] = ch[end];
//         ch[end] = temp;
//         start++;
//         end--;
//     }
//     return new String(ch);
// }