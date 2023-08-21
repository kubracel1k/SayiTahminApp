package com.example.sayitahminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView textViewKalanHak,textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;
    private int rasgeleSayi;
    private  int sayac=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        textViewYardim=findViewById(R.id.textViewYardim);
        textViewKalanHak=findViewById(R.id.textViewKalanHak);
        editTextGirdi=findViewById(R.id.editTextGirdi);
        buttonTahmin=findViewById(R.id.buttonTahmin);

        Random random=new Random();
        rasgeleSayi=random.nextInt(101);//0-100
        Log.e("rasgele sayı ",String.valueOf(rasgeleSayi));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayac=sayac-1;
                int tahmin=Integer.parseInt(editTextGirdi.getText().toString());//edit text içerisindeki veriyi string olarak aldım
                if (tahmin==rasgeleSayi){
                    Intent intent=new Intent(TahminActivity.this,SonucActivity.class);
                    intent.putExtra("sonuc",true);
                    startActivity(intent);
                    finish();
                    return;
                }
                if (tahmin>rasgeleSayi) {
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak : "+sayac);
                    
                }
                if (tahmin<rasgeleSayi) {
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak : "+sayac);
                    
                }
                if (sayac==0) {
                    Intent intent=new Intent(TahminActivity.this,SonucActivity.class);
                    intent.putExtra("sonuc",false);
                    startActivity(intent);
                    finish();
                }
                editTextGirdi.setText(" ");
            }
        });
    }
}