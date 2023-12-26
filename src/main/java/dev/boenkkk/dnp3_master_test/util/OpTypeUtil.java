package dev.boenkkk.dnp3_master_test.util;

import io.stepfunc.dnp3.OpType;

public class OpTypeUtil {

    public static OpType getOpTypeByValue(int value) {
        for (OpType opType : OpType.values()) {
            if (opType.ordinal() == value) {
                return opType;
            }
        }

        throw new IllegalArgumentException("No Operation Type found for value: " + value);
    }
}
