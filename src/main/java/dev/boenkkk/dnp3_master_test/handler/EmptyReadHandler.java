package dev.boenkkk.dnp3_master_test.handler;

import io.stepfunc.dnp3.ReadHandler;
import io.stepfunc.dnp3.ReadType;
import io.stepfunc.dnp3.ResponseHeader;

public class EmptyReadHandler implements ReadHandler {

    @Override
    public void beginFragment(ReadType readType, ResponseHeader header) {
        System.out.println("===============Beginning fragment (broadcast: " + header.iin.iin1.broadcast + ")===============");
    }

    @Override
    public void endFragment(ReadType readType, ResponseHeader header) {
        System.out.println("===============End fragment===============");
    }
}
