package com.example.bomarshe;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class person extends AppCompatActivity {

    ConstraintLayout icon_home, icon_love, icon_person, icon_backet;
    TextView about_comp;

    Dialog dial_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person);



        icon_backet = findViewById(R.id.icon_backet);
        icon_home = findViewById(R.id.icon_home);
        icon_love = findViewById(R.id.icon_love);
        icon_person = findViewById(R.id.icon_person);

        dial_about = new Dialog(this);

        about_comp = findViewById(R.id.about_comp);

        about_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial_about.setContentView(R.layout.activity_about_our);
                dial_about.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dial_about.show();
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
    }


}