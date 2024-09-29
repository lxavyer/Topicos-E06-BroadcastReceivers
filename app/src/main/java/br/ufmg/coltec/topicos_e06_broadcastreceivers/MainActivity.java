package br.ufmg.coltec.topicos_e06_broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int CURRENT_THEME = R.style.Theme_TopicosE06BroadcastReceivers;

    private BattteryReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(CURRENT_THEME);
        setContentView(R.layout.activity_main);

        // Registrar o receiver
        batteryReceiver = new BattteryReceiver(this);
        registerReceiver(batteryReceiver, BattteryReceiver.getIntentFilter());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (batteryReceiver != null) {
            unregisterReceiver(batteryReceiver);
        }
    }

    public void switchActivityTheme(int themeId) {
        CURRENT_THEME = themeId;
        recreate();
    }
}