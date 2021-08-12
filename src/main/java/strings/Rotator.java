package strings;

/*
1 <= s.length <= 105
s[i] is a printable ascii character.
 */
public class Rotator {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
