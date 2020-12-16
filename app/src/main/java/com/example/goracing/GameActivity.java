package com.example.goracing;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    public GameActivity() {
    }

    public void timerPC() {
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (state == 2) {
                        iv_pccar.setX(iv_pccar.getX() + 300);
                    }
                    if (iv_pccar.getX() >= iv_finish.getX()){
                        timerPC.cancel();
                        timerGame.cancel();
                        Toast.makeText(getApplicationContext(), "YOU LOSE!", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    };
    timerPC.scheduleAtFixedRate(timerTask, 0, 1000);
}

public void driveCarAction(View view) {
    if (state == 2) {
        iv_usercar.setX(iv_usercar.getX() + 30);
    }
    if (state == 1) {
        iv_usercar.setX(iv_usercar.getX() - 30);
    }
    if (iv_usercar.getX() >= iv_finish.getX()) {
        timerPC.cancel();;
        timerGame.cancel();
        Toast.makeText(getApplicationContext(), "YOU WIN", Toast.LENGTH_LONG).show();
    }
}
    public void timerGame() {
    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    state += 1;
                    if (state >2)
                        state = 1;
                    switch (state) {
                    case 1:
                        tv_semafore.setText("RED");
                        tv_semafore.setTextColor(Color.RED);
                        break;
                    case 2:
                        tv_semafore.setText("GREEN");
                        tv_semafore.setTextColor(Color.GREEN);
                         break;
                    }
                }
            });
        }
    };
    timerGame.scheduleAtFixedRate(timerTask,0,3000);
}
    private ImageView iv_usercar;
    private ImageView iv_finish;
    Timer timerGame = new Timer();
    Timer timerPC = new Timer();
    int state = 0;

    private ImageView iv_pccar;
    private TextView tv_timer, tv_semafore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv_pccar = (ImageView) findViewById(R.id.iv_pccar);
        iv_usercar = (ImageView) findViewById(R.id.iv_usercar);
        iv_finish = (ImageView) findViewById(R.id.iv_finish);
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        tv_semafore = (TextView) findViewById(R.id.tv_semafore);
    }

    public void startGameAction(View view) {

    }
}