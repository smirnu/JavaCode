//Given an input of a list of days of the week, output the shortest representation of the list.
//
//        Each day of the week will be defined as a two character string, Su (Sunday), Mo (Monday), etc.
//
//        The input may not necessarily be in sorted order but there will be a maximum of one occurrence per day.
//
//        You must sort the input (Sunday is to be considered the start of the week) and then reduce the abbreviations down to one letter, e.g.
//
//        [Su, Mo, Tu, We] => SMTW
//        [Fr, Th, Sa] => TFS
public class CompressDays {
    public static String compressDays(String[] input) {
        // Your code goes here
        String[] weekDays = new String[7];
        for (int i = 0; i < input.length; i++) {
            switch(input[i]) {
                case "Su":
                    weekDays[0] = "S";
                    break;
                case "Mo":
                    weekDays[1] = "M";
                    break;
                case "Tu":
                    weekDays[2] = "T";
                    break;
                case "We":
                    weekDays[3] = "W";
                    break;
                case "Th":
                    weekDays[4] = "T";
                    break;
                case "Fr":
                    weekDays[5] = "F";
                    break;
                case "St":
                    weekDays[6] = "S";
                    break;
            }
        }
        String result = "";
        for (String str: weekDays) {
            if (str != null) result += str;
        }

        return result;
    }
}
