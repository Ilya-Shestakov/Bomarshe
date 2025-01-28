package com.example.bomarshe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout btn_cruas_1, btn_cruas_2, add_to_backet, icon_home, icon_love, icon_person, compl, img_data_prod_in_dial, icon_backet, btn_kat1, img_data_prod_in_dial_pryanya_in_list, img_data_prod_in_dial_santa_in_list;
    Dialog dialogAddToBacket, dialogOpenList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_cruas_1 = findViewById(R.id.btn_cruas_1);
        btn_cruas_2 = findViewById(R.id.btn_cruas_2);
        btn_kat1 = findViewById(R.id.btn_kat1);
        dialogAddToBacket = new Dialog(this);
        dialogOpenList = new Dialog(this);

        btn_kat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialProdList();
            }
        });

        icon_backet = findViewById(R.id.icon_backet);
        icon_home = findViewById(R.id.icon_home);
        icon_love = findViewById(R.id.icon_love);
        icon_person = findViewById(R.id.icon_person);


        icon_backet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("123", Backet.class);
            }
        });
        icon_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("123", MainActivity.class);
            }
        });
        icon_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("123", lovely_prod.class);
            }
        });
        icon_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("123", person.class);
            }
        });

        btn_cruas_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDial("Круасан санта");
            }
        });
        btn_cruas_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDial("Круасан пряня");
            }
        });



    }

    public void openDial(String prodName) {
        dialogAddToBacket.setContentView(R.layout.activity_add_to_backet);
        dialogAddToBacket.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        img_data_prod_in_dial = dialogAddToBacket.findViewById(R.id.img_data_prod_in_dial);

        if (prodName == "Круасан санта"){
            img_data_prod_in_dial.setBackground(getDrawable(R.drawable.desc_santa_out_back));
        } else{
            img_data_prod_in_dial.setBackground(getDrawable(R.drawable.desc_pryanya_out_back));
        }

        add_to_backet = dialogAddToBacket.findViewById(R.id.add_to_backet);

        dialogAddToBacket.show();

        add_to_backet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prodName == "Круасан санта"){
                    intent("santa", Backet.class);
                } else if (prodName == "Круасан пряня"){
                    intent("pryana", Backet.class);
                } else {
                    intent("123", Backet.class);
                }
            }
        });

    }

    public void openDialProdList() {
        dialogOpenList.setContentView(R.layout.activity_list_products);
        dialogOpenList.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialogOpenList.show();

        img_data_prod_in_dial_pryanya_in_list = dialogOpenList.findViewById(R.id.img_data_prod_in_dial_pryanya_in_list);
        img_data_prod_in_dial_santa_in_list = dialogOpenList.findViewById(R.id.img_data_prod_in_dial_santa_in_list);

        img_data_prod_in_dial_pryanya_in_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDial("Круасан пряня");
                dialogOpenList.cancel();
            }
        });

        img_data_prod_in_dial_santa_in_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDial("Круасан санта");
                dialogOpenList.cancel();
            }
        });

    }

    private void intent(String type, Class c) {
        Intent intent = new Intent(this, c);
        intent.putExtra("type", type);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferencesUtil.clearAllData(this,"my_prefs");
        SharedPreferencesUtil.clearAllData(this,"my_prefs_sec");
        SharedPreferencesUtil.clearAllData(this,"my_prefs_itog");
        SharedPreferencesUtil.clearAllData(this,"my_prefs_itogo");
        SharedPreferencesUtil.clearAllData(this,"my_prefs_sails");
        finishAffinity();
    }
}