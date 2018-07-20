package utils;

public class Util {
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        else if (str.trim().length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
