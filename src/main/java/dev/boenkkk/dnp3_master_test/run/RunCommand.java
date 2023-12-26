package dev.boenkkk.dnp3_master_test.run;

import dev.boenkkk.dnp3_master_test.util.ExecutorUtil;
import dev.boenkkk.dnp3_master_test.util.OpTypeUtil;
import dev.boenkkk.dnp3_master_test.util.VariationUtil;
import io.stepfunc.dnp3.*;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.joou.Unsigned.ushort;

public class RunCommand {

    public static void run(MasterChannel channel, AssociationId association, PollId poll, String command) throws Exception {
        switch (command) {
            case "c.on" -> {
                System.out.println("===============channel.enable()===============");
                channel.enable();
            }
            case "c.off" -> {
                System.out.println("===============channel.disable()===============");
                channel.disable();
            }
            case "r.gv" -> {
                System.out.println("==============="+command+"===============");

                Scanner scanner = new Scanner(System.in);
                System.out.println("reference:");
                System.out.println("io.stepfunc.dnp3.Variation");
                System.out.println("https://docs.stepfunc.io/dnp3/1.5.0/java/io/stepfunc/dnp3/Variation.html");
                System.out.println("input Variation value:");
                int groupVarValue = scanner.nextInt();

                // Start a thread for user input
                ExecutorService executor = Executors.newFixedThreadPool(1);
                ExecutorUtil.handleUserInput(executor);

                while (!executor.isShutdown()) {
                    try {
                        // Variation variation = Variation.GROUP30_VAR6;
                        Variation variation = VariationUtil.getVariationByValue(groupVarValue);

                        System.out.println("===============read "+variation+"|"+variation.ordinal()+"===============");
                        Request request = new Request();
                        request.addAllObjectsHeader(variation);

                        System.out.println("===============channel.enable()===============");
                        channel.enable();

                        System.out.println("===============channel.read()===============");
                        channel.read(association, request).toCompletableFuture().get();
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    } finally {
                        System.out.println("===============channel.disable()===============");
                        channel.disable();

                        System.out.println("===============sleep===============");
                        Thread.sleep(5_000);

                        System.out.println("===============end "+command+"===============");
                    }
                }
            }
            case "o.boc.do" -> {
                System.out.println("==============="+command+"===============");
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("input BO index: (int)");
                    int inBoIndex = scanner.nextInt();

                    System.out.println("reference:");
                    System.out.println("io.stepfunc.dnp3.OpType");
                    System.out.println("https://docs.stepfunc.io/dnp3/1.5.1/java/io/stepfunc/dnp3/OpType.html");
                    System.out.println("input Operation Type value:");
                    int inOpType = scanner.nextInt();

                    System.out.println("===============channel.enable()===============");
                    channel.enable();

                    Variation variation = Variation.GROUP10_VAR0;
                    Request request = new Request();
                    request.addAllObjectsHeader(variation);
                    System.out.println("===============before operate===============");
                    channel.read(association, request).toCompletableFuture().get();

                    System.out.println("===============set command===============");
                    OpType opType = OpTypeUtil.getOpTypeByValue(inOpType);
                    Group12Var1 control = Group12Var1.fromCode(ControlCode.fromOpType(opType));
                    CommandSet commands = new CommandSet();
                    commands.addG12V1U16(ushort(inBoIndex), control);

                    System.out.println("===============channel.operate "+inBoIndex+"|"+opType+"|"+opType.ordinal()+"===============");
                    channel.operate(association, CommandMode.DIRECT_OPERATE, commands)
                            .toCompletableFuture()
                            .get();

                    System.out.println("===============after operate===============");
                    channel.read(association, request).toCompletableFuture().get();
                } catch (ExecutionException e) {
                    System.err.println("Error: "+e.getMessage());
                    e.printStackTrace();
                } finally {
                    System.out.println("===============channel.disable()===============");
                    channel.disable();

                    System.out.println("===============end "+command+"===============");
                }
            }
            default -> System.out.println("Unknown command");
        }
    }
}
