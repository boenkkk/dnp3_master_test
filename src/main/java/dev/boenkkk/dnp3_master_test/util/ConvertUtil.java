package dev.boenkkk.dnp3_master_test.util;

public class ConvertUtil {

    public static boolean convertIntToBoolean(int value) {
        if (value == 0){
            return false;
        } else if (value == 1){
            return true;
        }

        throw new IllegalArgumentException("Input value only 0 or 1, value: "+value);
    }
}
