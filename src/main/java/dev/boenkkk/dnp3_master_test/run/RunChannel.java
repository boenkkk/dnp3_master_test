package dev.boenkkk.dnp3_master_test.run;

import dev.boenkkk.dnp3_master_test.config.TestAssociationConfig;
import dev.boenkkk.dnp3_master_test.handler.TestAssociationHandler;
import dev.boenkkk.dnp3_master_test.handler.TestReadHandler;
import dev.boenkkk.dnp3_master_test.listener.TestAssociationInformation;
import io.stepfunc.dnp3.AssociationId;
import io.stepfunc.dnp3.MasterChannel;
import io.stepfunc.dnp3.PollId;
import io.stepfunc.dnp3.Request;

import java.time.Duration;
import java.util.Scanner;

import static org.joou.Unsigned.ushort;

public class RunChannel {

    public static void run(MasterChannel channel) {
        System.out.println("runChannel");

        TestReadHandler readHandler = new TestReadHandler();

        TestAssociationHandler testAssociationHandler = new TestAssociationHandler();

        TestAssociationInformation testAssociationInformation = new TestAssociationInformation();
        // Create the association
        // ANCHOR: association_create
        AssociationId association = channel.addAssociation(
                ushort(1),
                TestAssociationConfig.getAssociationConfig(),
                readHandler,
                testAssociationHandler,
                testAssociationInformation
        );
        // ANCHOR_END: association_create

        // Create a periodic poll
        // ANCHOR: add_poll
        PollId poll = channel.addPoll(
                association,
                Request.classRequest(false, true, true, true),
                Duration.ofSeconds(1)
        );
        // ANCHOR_END: add_poll

        // start communications
        // channel.enable(); // enable in RunOneCommand.run(command:c.on)

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("reference:");
                System.out.println("dev.boenkkk.dnp3_master_test.run.RunCommand.run()");
                System.out.println("input command:");
                String command = scanner.next();

                if(command.equals("x")) {
                    System.out.println("exiting");
                    return;
                }

                RunCommand.run(channel, association, poll, command);
            } catch (Exception e) {
                System.err.println("Error: " + e);
                e.printStackTrace();
            }
        }
    }
}
