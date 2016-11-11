package com.novoda.tpbot.human;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.novoda.tpbot.human.socket.io.HumanSocketIOTpService;

public class HumanActivity extends AppCompatActivity implements HumanView {

    private HumanPresenter humanPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        humanPresenter = new HumanPresenter(HumanSocketIOTpService.getInstance(), this);
    }

    @Override
    protected void onResume() {
        super.onStart();
        humanPresenter.startPresenting();
    }

    @Override
    protected void onPause() {
        super.onPause();
        humanPresenter.stopPresenting();
    }

    @Override
    public void onConnect(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisconnect() {
        Toast.makeText(this, "disconnected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
