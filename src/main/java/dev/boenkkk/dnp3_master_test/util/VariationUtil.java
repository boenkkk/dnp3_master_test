package dev.boenkkk.dnp3_master_test.util;

import io.stepfunc.dnp3.Variation;

public class VariationUtil {

    public static Variation getVariationByValue(int value) {
        for (Variation variation : Variation.values()) {
            if (variation.ordinal() == value) {
                return variation;
            }
        }

        throw new IllegalArgumentException("No Variation found for value: " + value);
    }
}
