//Processors must deal with tasks of varying urgencies to function safely and correctly. To demonstrate this, we will create an announcement unit for a nuclear reactor.
//
//        Each step, the unit should read one character from the input and generate one character on the output. When no announcements are needed, the input will be a space and the output a space. When the input is a digit (from 0 to 9), this signifies an announcement is requested and the unit should immediately begin broadcasting the message on the output, one character at a time. Normally these units would be programmed to a range of messages from 9:"Reactor breach! Evacuate!" to 0:"Coffee machine milk level low". In our factory pre-set mode, it will spell out the number of the message, "zero", "one" etc. e.g:
//
//        input :   0        1       2
//        output:   zero     one     two
//
//        If a new message request arrives while a previous message is being announced, the behavior depends on the message priority. The message number determines the priority, 9 being the highest and 0 being the lowest. Should the new message have a higher priority to the current, the currently broadcast message will be interrupted, and the new message will begin being broadcast. Once the new message is complete, the broadcast of original message will commence where it left off. This interrupting broadcast may also be interrupted by an even higher priority request. e.g:
//
//        input :   0 1        27          13 6
//        output:   zeonero    tsevenwo    othsixreene
//
//        If the new message is of lower or equal priority, it will be announced once the previous higher (or equal) priority messages are completed.
//
//        input :   10         7  2        613          4 4
//        output:   onezero    seventwo    sixthreeone  fourfour
public class NumberPrediction {
    public static String numberPrediction(String input) {
        // Your code goes here
        StringBuilder collectingAnnounces = new StringBuilder();
        int prevAnnounce = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                // we should fill the gap with ' ' if it exists between current position in announces and the length of our collectingAnnounces
                if (i > collectingAnnounces.length()) {
                    for (int y = collectingAnnounces.length(); y < i; y++) {
                        collectingAnnounces.append(' ');
                    }
                }
                // it is first announce we should fill it with current announce
                if (prevAnnounce < 0) {
                    prevAnnounce = Character.getNumericValue(input.charAt(i));
                    collectingAnnounces.append(identifyAnnounce(prevAnnounce));
                } else {
                    String annToInsert = identifyAnnounce(Character.getNumericValue(input.charAt(i)));
                    if (prevAnnounce < Character.getNumericValue(input.charAt(i))) {

                        collectingAnnounces.insert(i, annToInsert);
                    } else {
                        collectingAnnounces.append(annToInsert);
                    }
                    prevAnnounce = Character.getNumericValue(input.charAt(i));
                }
            } else {
                if (i > collectingAnnounces.length()) {
                    for (int y = collectingAnnounces.length(); y < i; y++) {
                        collectingAnnounces.append(' ');
                    }
                }
                if (i == input.length() - 1) collectingAnnounces.append(' ');
            }
        }
        return collectingAnnounces.substring(0, input.length());
    }

    public static String identifyAnnounce(int numberAnnounce) {
        String strAnnounce = "";
        switch(numberAnnounce) {
            case 0:
                strAnnounce = "zero";
                break;
            case 1:
                strAnnounce = "one";
                break;
            case 2:
                strAnnounce = "two";
                break;
            case 3:
                strAnnounce = "three";
                break;
            case 4:
                strAnnounce = "four";
                break;
            case 5:
                strAnnounce = "five";
                break;
            case 6:
                strAnnounce = "six";
                break;
            case 7:
                strAnnounce = "seven";
                break;
            case 8:
                strAnnounce = "eight";
                break;
            case 9:
                strAnnounce = "nine";
                break;
        }
        return strAnnounce;
    }
}
