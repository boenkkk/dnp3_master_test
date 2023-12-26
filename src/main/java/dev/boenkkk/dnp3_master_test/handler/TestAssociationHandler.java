package dev.boenkkk.dnp3_master_test.handler;

import io.stepfunc.dnp3.AssociationHandler;
import io.stepfunc.dnp3.UtcTimestamp;

import static org.joou.Unsigned.ulong;

// ANCHOR: association_handler
public class TestAssociationHandler implements AssociationHandler {

    @Override
    public UtcTimestamp getCurrentTime() {
        return UtcTimestamp.valid(ulong(System.currentTimeMillis()));
    }
}
// ANCHOR_END: association_handler