package dev.boenkkk.dnp3_master_test.run;

import dev.boenkkk.dnp3_master_test.config.TestMasterChannelConfig;
import dev.boenkkk.dnp3_master_test.listener.TestClientStateListener;
import io.stepfunc.dnp3.*;
import io.stepfunc.dnp3.Runtime;

import java.time.Duration;
import java.util.Scanner;

public class RunTCP {

    public static void run(Runtime runtime) {
        System.out.println("runTcp");

        Scanner scanner = new Scanner(System.in);
        System.out.println("input endpoint ip with port: {127.0.0.1:20000}");
        String endpoint = scanner.next();
        EndpointList endpointList = new EndpointList(endpoint);

        ConnectStrategy connectStrategy = new ConnectStrategy();
        connectStrategy.withReconnectDelay(Duration.ofSeconds(10));

        TestClientStateListener clientStateListener = new TestClientStateListener();

        // ANCHOR: create_tcp_channel
        MasterChannel channel = MasterChannel.createTcpChannel(
                runtime,
                LinkErrorMode.CLOSE,
                TestMasterChannelConfig.getMasterChannelConfig(),
                endpointList,
                connectStrategy,
                clientStateListener
        );
        // ANCHOR_END: create_tcp_channel

        try {
            RunChannel.run(channel);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
