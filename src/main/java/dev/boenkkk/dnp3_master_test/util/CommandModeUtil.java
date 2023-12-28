package dev.boenkkk.dnp3_master_test.util;

import io.stepfunc.dnp3.CommandMode;

public class CommandModeUtil {

    public static CommandMode getCommandModeByValue(int value) {
        for (CommandMode commandMode : CommandMode.values()) {
            if (commandMode.ordinal() == value) {
                return commandMode;
            }
        }

        throw new IllegalArgumentException("No Command Mode found for value: " + value);
    }
}
