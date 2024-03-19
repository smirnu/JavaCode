import java.util.HashSet;

public class GetRecipient {
    public static String getRecipient(String message, int position) {
        // Your code goes here
        // set of possible characters for usernames
        String strValues = "abcdefghijklmnopqrstuvwxyz0123456789_-";
        HashSet<Character> charUsername = new HashSet<>();
        for (char charValue: strValues.toCharArray()) {
            charUsername.add(charValue);
        }

        // point in msg we start look for @username
        int index = 0;
        for (int i = 0; i < position; i++) {
            index = message.indexOf('@', index);
            if (index == -1) return "";
            index += 1;
        }
        // cut out the username from the msg
        StringBuilder username = new StringBuilder();
        while (index < message.length()) {
            char charToCheck = message.charAt(index);
            if (charUsername.contains(Character.toLowerCase(charToCheck))) {
                username.append(charToCheck);
                index++;
            } else break;
        }

        return username.toString();
    }
}
