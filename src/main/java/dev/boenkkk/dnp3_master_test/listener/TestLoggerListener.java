package dev.boenkkk.dnp3_master_test.listener;

import io.stepfunc.dnp3.LogLevel;
import io.stepfunc.dnp3.Logger;

public class TestLoggerListener implements Logger {

    @Override
    public void onMessage(LogLevel logLevel, String message) {
        System.out.print("TestLoggerListener.onMessage() logLevel|message: "+logLevel+"|"+message);
    }
}
