package com.example.colorgame;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int p_color = 0;
    int p_text = 0;
    int virno = 0;
    int all = 0;
    int random_color(){
        int random_color = (int) (Math.random() * 7);
        return random_color;
    }
    void crate_color(int color){
        TextView textView = findViewById(R.id.textView4);
        switch (color){
            case 0:
                textView.setTextColor(Color.RED);
                break;
            case 1:
                textView.setTextColor(Color.rgb(255, 165, 0));
                break;
            case 2:
                textView.setTextColor(Color.YELLOW);
                break;
            case 3:
                textView.setTextColor(Color.GREEN);
                break;
            case 4:
                textView.setTextColor(Color.BLUE);
                break;
            case 5:
                textView.setTextColor(Color.rgb(75, 0, 130));
                break;
            case 6:
                textView.setTextColor(Color.MAGENTA);
                break;
        }
    }
    int random_text(){
        int random_text = (int) (Math.random() * 7);
        return random_text;
    }
    void create_text (int rand_text){
        TextView textView = (TextView) findViewById(R.id.textView4);
        switch (rand_text) {
            case 0:
                textView.setText("Червоний");
                break;
            case 1:
                textView.setText("Оранежевий");
                break;
            case 2:
                textView.setText("Жовтий");
                break;
            case 3:
                textView.setText("Зелений");
                break;
            case 4:
                textView.setText("Голубий");
                break;
            case 5:
                textView.setText("Синій");
                break;
            case 6:
                textView.setText("Фіолетовий");
                break;
        }
    }
    public void no(View no) {
        TextView textView = (TextView) findViewById(R.id.textView5);
        if (p_color!=p_text){
            virno++;
            all++;
            textView.setText(virno+"/"+all);
            System.out.println(virno+"/"+all);
        }
        else {
            all++;
            textView.setText(virno+"/"+all);
        }
        int color = random_color();
        crate_color(color);
        int text = random_text();
        create_text(text);
        p_color = color;
        p_text = text;
    }
    public void yes(View yes) {
        TextView textView = (TextView) findViewById(R.id.textView5);
        if (p_color==p_text){
            virno++;
            all++;
            textView.setText(virno+"/"+all);
            System.out.println(virno+"/"+all);
        }
        else {
            all++;
            textView.setText(virno+"/"+all);
        }
        int color = random_color();
        crate_color(color);
        int text = random_text();
        create_text(text);
        p_color = color;
        p_text = text;
    }
    public void start(View view) {
        int color = random_color();
        crate_color(color);
        int text = random_text();
        create_text(text);
        p_color = color;
        p_text = text;
        System.out.println(p_color + " " + p_text);
        Button yes = (Button) findViewById(R.id.button2);
        yes.setVisibility(yes.VISIBLE);
        Button no = (Button) findViewById(R.id.button3);
        no.setVisibility(yes.VISIBLE);
        Button start = (Button) findViewById(R.id.buttonstart);
        start.setVisibility(start.INVISIBLE);

        new CountDownTimer(30000, 1000) {
            TextView textView = (TextView) findViewById(R.id.textView2);
            public void onTick(long millisUntilFinished) {
                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
            public void onFinish() {
                textView.setText("done!");
                Button yes = (Button) findViewById(R.id.button2);
                yes.setVisibility(yes.INVISIBLE);
                Button no = (Button) findViewById(R.id.button3);
                no.setVisibility(yes.INVISIBLE);
                Button start = (Button) findViewById(R.id.buttonstart);
                start.setVisibility(start.VISIBLE);
                virno = 0;
                all = 0;
            }
        }.start();
    }
}