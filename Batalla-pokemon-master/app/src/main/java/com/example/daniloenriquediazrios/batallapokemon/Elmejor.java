package com.example.daniloenriquediazrios.batallapokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Elmejor extends AppCompatActivity {

    String Nombre1 = "",
            url1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elmejor);

       TextView mTxtDisplay;




        Bundle bundle = getIntent().getExtras();

        Nombre1 = bundle.getString("name");

        url1 = bundle.getString("url1");


        new DowloadTask((ImageView) findViewById(R.id.imagenpokemon1))
                .execute(url1);
        mTxtDisplay = (TextView) findViewById(R.id.pokemonName1);
        mTxtDisplay.setText(Nombre1);


    }
}
