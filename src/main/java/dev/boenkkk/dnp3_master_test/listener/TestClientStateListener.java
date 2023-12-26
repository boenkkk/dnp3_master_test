package dev.boenkkk.dnp3_master_test.listener;

import io.stepfunc.dnp3.ClientState;
import io.stepfunc.dnp3.ClientStateListener;

public class TestClientStateListener implements ClientStateListener {

    @Override
    public void onChange(ClientState state) {
        System.out.println("TestClientStateListener.onChange() state: "+state);
    }
}
