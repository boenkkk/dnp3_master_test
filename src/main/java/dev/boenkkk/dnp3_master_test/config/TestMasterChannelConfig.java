package dev.boenkkk.dnp3_master_test.config;

import io.stepfunc.dnp3.*;

import java.util.Scanner;

import static org.joou.Unsigned.ushort;

public class TestMasterChannelConfig {

    // ANCHOR: master_channel_config
    public static MasterChannelConfig getMasterChannelConfig() {
        System.out.println("input master addr: {1024}");
        Scanner scanner = new Scanner(System.in);
        String masterAddr = scanner.next();

        MasterChannelConfig config = new MasterChannelConfig(ushort(masterAddr));
        config.decodeLevel.application = AppDecodeLevel.OBJECT_VALUES;
        config.decodeLevel.transport = TransportDecodeLevel.NOTHING;
        config.decodeLevel.link = LinkDecodeLevel.NOTHING;
        config.decodeLevel.physical = PhysDecodeLevel.NOTHING;
        return config;
    }
    // ANCHOR_END: master_channel_config
}
