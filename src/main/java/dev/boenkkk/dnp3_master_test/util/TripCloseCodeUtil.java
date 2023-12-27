package dev.boenkkk.dnp3_master_test.util;

import io.stepfunc.dnp3.TripCloseCode;

public class TripCloseCodeUtil {

    public static TripCloseCode getTripCloseCodeByValue(int value) {
        for (TripCloseCode tripCloseCode : TripCloseCode.values()) {
            if (tripCloseCode.ordinal() == value) {
                return tripCloseCode;
            }
        }

        throw new IllegalArgumentException("No Trip Close Code found for value: " + value);
    }
}
