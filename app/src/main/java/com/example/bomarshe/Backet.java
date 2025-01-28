package com.example.bomarshe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Backet extends AppCompatActivity {

    ConstraintLayout check_promo, icon_home, icon_love, icon_person, icon_backet, minus_from_first, plus_from_first, minus_from_second, plus_from_second;
    TextView scoreItogo, scoreProductSecond, scoreProductFirst, scoreSummFirst, scoreSummSecond;
    EditText edit_text_promo;

    String elF, elS, type;

    Integer scoreFirst, scoreSecond, itogFirst, itogSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_backet);

        icon_backet = findViewById(R.id.icon_backet);
        icon_home = findViewById(R.id.icon_home);
        icon_love = findViewById(R.id.icon_love);
        icon_person = findViewById(R.id.icon_person);

        check_promo = findViewById(R.id.check_promo);

        scoreItogo = findViewById(R.id.scoreItogo);

        edit_text_promo = findViewById(R.id.edit_text_promo);

        scoreSummFirst = findViewById(R.id.scoreSummFirst);
        scoreSummSecond = findViewById(R.id.scoreSummSecond);

        minus_from_first = findViewById(R.id.minus_from_first);
        plus_from_first = findViewById(R.id.plus_from_first);

        minus_from_second = findViewById(R.id.minus_from_second);
        plus_from_second = findViewById(R.id.plus_from_second);

        scoreProductFirst = findViewById(R.id.scoreProductFirst);
        scoreProductSecond = findViewById(R.id.scoreProductSecond);


        SharedPreferences sharedPreferencesScoreF = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String restoredDataScoreF = sharedPreferencesScoreF.getString("saved_data", "0");

        SharedPreferences sharedPreferencesScoreS = getSharedPreferences("my_prefs_sec", Context.MODE_PRIVATE);
        String restoredDataScoreS = sharedPreferencesScoreS.getString("saved_data", "0");

        SharedPreferences sharedPreferencesSummItog = getSharedPreferences("my_prefs_itog", Context.MODE_PRIVATE);
        String restoredDataSummItog = sharedPreferencesSummItog.getString("saved_data", "0");

        SharedPreferences sharedPreferencesItogLast = getSharedPreferences("my_prefs_itogo", Context.MODE_PRIVATE);
        String restoredDataItogLast = sharedPreferencesItogLast.getString("saved_data", "0");

        SharedPreferences sharedPreferencesSails = getSharedPreferences("my_prefs_sails", Context.MODE_PRIVATE);
        String restoredDataSummSails = sharedPreferencesSails.getString("saved_data", "0");

        scoreProductFirst.setText(restoredDataScoreF);
        scoreProductSecond.setText(restoredDataScoreS);
        scoreSummFirst.setText(restoredDataSummItog);
        scoreItogo.setText(restoredDataItogLast);
        scoreSummSecond.setText(restoredDataSummSails);


        type = getIntent().getStringExtra("type");

        if (Objects.equals(type, "santa")){
            scoreProductFirst.setText(String.valueOf(Integer.valueOf(scoreProductFirst.getText().toString() + 1)));
//            Toast.makeText(this, "type-santa", Toast.LENGTH_SHORT).show();
        } else if (Objects.equals(type, "pryana")) {
            scoreProductSecond.setText(String.valueOf(Integer.valueOf(scoreProductSecond.getText().toString() + 1)));
//            Toast.makeText(this, "type-prynya", Toast.LENGTH_SHORT).show();
        }


        check_promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_text_promo.getText().toString().equals("111")){
                    if (Integer.valueOf(scoreSummFirst.getText().toString()) >= 1000){
                        scoreSummSecond.setText("1000");
                        String p22 = String.valueOf((Integer.valueOf(scoreSummFirst.getText().toString()) - 1000));
                        scoreItogo.setText(p22);
                    } else {
                        Toast.makeText(Backet.this, "Недостаточная сумма!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        minus_from_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                elF = scoreProductFirst.getText().toString(); //кол-во первого продукта
                elS = scoreProductSecond.getText().toString(); //кол-во второго продукта

                if (Integer.valueOf(elF) > 0){
                    scoreFirst = Integer.valueOf(elF) - 1; //действие над количеством первого продукта

                    itogFirst = 385; //цена первого элементаа

                    String p1 = String.valueOf((Integer.valueOf(scoreSummFirst.getText().toString()) - Integer.valueOf(itogFirst)));

                    scoreSummFirst.setText(p1);

                    scoreProductFirst.setText(scoreFirst.toString());

                    scoreItogo.setText(scoreSummFirst.getText().toString());
                }

//                scoreSummFirst.setText(itogFirst.toString());
            }
        });

        plus_from_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elF = scoreProductFirst.getText().toString();
                elS = scoreProductSecond.getText().toString();

                if (Integer.valueOf(elF) >= 0){
                    scoreFirst = Integer.valueOf(elF) + 1;

                    itogFirst = 385;

                    String p1 = String.valueOf((Integer.valueOf(scoreSummFirst.getText().toString()) + Integer.valueOf(itogFirst)));

                    scoreSummFirst.setText(p1);

                    scoreProductFirst.setText(scoreFirst.toString());

                    scoreItogo.setText(scoreSummFirst.getText().toString());
                }


            }
        });

        minus_from_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elF = scoreProductFirst.getText().toString();
                elS = scoreProductSecond.getText().toString();

                if (Integer.valueOf(elS) > 0){

                    scoreSecond = Integer.valueOf(elS) - 1;

                    itogSecond = 650;

                    String p1 = String.valueOf((Integer.valueOf(scoreSummFirst.getText().toString()) - Integer.valueOf(itogSecond)));

                    scoreSummFirst.setText(p1);

                    scoreProductSecond.setText(scoreSecond.toString());

                    scoreItogo.setText(scoreSummFirst.getText().toString());
                }


//                scoreProductSecond.setText(scoreSecond.toString());

            }
        });

        plus_from_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elF = scoreProductFirst.getText().toString();
                elS = scoreProductSecond.getText().toString();

                if (Integer.valueOf(elS) >= 0){

                    scoreSecond = Integer.valueOf(elS) + 1;

                    itogSecond = 650;

                    String p1 = String.valueOf((Integer.valueOf(scoreSummFirst.getText().toString()) + Integer.valueOf(itogSecond)));
                    scoreSummFirst.setText(p1);

                    scoreProductSecond.setText(scoreSecond.toString());

                    scoreItogo.setText(scoreSummFirst.getText().toString());
                }


//                scoreProductSecond.setText(scoreSecond.toString());
            }
        });

        icon_backet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(Backet.class);
            }
        });
        icon_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(MainActivity.class);
            }
        });
        icon_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(lovely_prod.class);
            }
        });
        icon_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(person.class);
            }
        });
    }

    private void intent(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent(MainActivity.class);

        // Сохраняем данные
        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("saved_data", scoreProductFirst.getText().toString());
        editor.apply();

        SharedPreferences sharedPreferencesSec = getSharedPreferences("my_prefs_sec", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorSec = sharedPreferencesSec.edit();
        editorSec.putString("saved_data", scoreProductFirst.getText().toString());
        editorSec.apply();

        SharedPreferences sharedPreferencesItog = getSharedPreferences("my_prefs_itog", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItog = sharedPreferencesItog.edit();
        editorItog.putString("saved_data", scoreSummFirst.getText().toString());
        editorItog.apply();

        SharedPreferences sharedPreferencesSails = getSharedPreferences("my_prefs_sails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorSails = sharedPreferencesSails.edit();
        editorSails.putString("saved_data", scoreSummSecond.getText().toString());
        editorSails.apply();

        SharedPreferences sharedPreferencesItogLast = getSharedPreferences("my_prefs_itogo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorLast = sharedPreferencesItogLast.edit();
        editorLast.putString("saved_data", scoreItogo.getText().toString());
        editorLast.apply();

    }

}