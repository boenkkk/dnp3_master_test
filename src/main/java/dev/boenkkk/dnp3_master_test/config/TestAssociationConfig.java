package dev.boenkkk.dnp3_master_test.config;

import io.stepfunc.dnp3.AssociationConfig;
import io.stepfunc.dnp3.AutoTimeSync;
import io.stepfunc.dnp3.Classes;
import io.stepfunc.dnp3.EventClasses;

import java.time.Duration;

public class TestAssociationConfig {

    // ANCHOR: association_config
    // change to public
    public static AssociationConfig getAssociationConfig() {
        AssociationConfig associationConfig = new AssociationConfig(
                // disable unsolicited first (Class 1/2/3)
                // EventClasses.all(),
                EventClasses.all(),
                // after the integrity poll, enable unsolicited (Class 1/2/3)
                // EventClasses.all(),
                EventClasses.all(),
                // perform startup integrity poll with Class 1/2/3/0
                // Classes.all(),
                Classes.all(),
                // don't automatically scan Class 1/2/3 when the corresponding IIN bit is asserted
                // EventClasses.none()
                EventClasses.none()
        )
                .withAutoTimeSync(AutoTimeSync.LAN)
                .withKeepAliveTimeout(Duration.ofSeconds(60));

        return associationConfig;
    }
    // ANCHOR_END: association_config
}
