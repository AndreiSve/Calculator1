package org.example;

public class Converter {
    static String [] romanArray = new String[]{"0","I","II","III","IV","V","VI","VII","IIX","IX"};

    public static boolean isRoman (String value){
        for (int i = 0; i < romanArray.length; i++) {
            if (value.equals(romanArray[i])){
                return true;
            }
        }
        return false;
    }
    public static String convertToRoman (int arabian) {
        return romanArray[arabian];
    }
    public static int convertToArabian (String roman){
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])){
                return i;

            }

        }return -1;
    }
}
