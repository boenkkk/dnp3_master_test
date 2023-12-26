package dev.boenkkk.dnp3_master_test;

import dev.boenkkk.dnp3_master_test.config.TestRuntimeConfig;
import dev.boenkkk.dnp3_master_test.listener.TestLoggerListener;
import dev.boenkkk.dnp3_master_test.run.RunTCP;
import io.stepfunc.dnp3.Logging;
import io.stepfunc.dnp3.LoggingConfig;
import io.stepfunc.dnp3.Runtime;

import java.util.Scanner;

public class MasterRun {

    public static void main(String[] args) {
    // public static void run(){
        // Initialize logging with the default configuration
        // This may only be called once during program initialization
        // ANCHOR: logging_init
        Logging.configure(new LoggingConfig(), new TestLoggerListener());
        // ANCHOR_END: logging_init

        // ANCHOR: runtime
        Runtime runtime = new Runtime(TestRuntimeConfig.getRuntimeConfig());
        // ANCHOR_END: runtime

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("select type: {tcp}");
            String type = scanner.next();

            switch (type) {
                case "tcp" -> RunTCP.run(runtime);
                default -> System.err.printf("Unknown transport: %s%n", type);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        } finally {
            // ANCHOR: runtime_shutdown
            runtime.shutdown();
            // ANCHOR_END: runtime_shutdown
        }
    }
}
