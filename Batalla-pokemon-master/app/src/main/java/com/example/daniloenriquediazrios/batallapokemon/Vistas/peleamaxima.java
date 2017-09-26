package com.example.daniloenriquediazrios.batallapokemon.Vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.daniloenriquediazrios.batallapokemon.DowloadTask;
import com.example.daniloenriquediazrios.batallapokemon.R;

public class peleamaxima extends Activity {


    //se crean las variables

    String Nombre1 = "",
            Nombre2 = "",
            url1 = "",
            url2 = "";



    Button botonPelea1,
            botonPelea2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peleamaxima);

        TextView mTxtDisplay,
                mTxtDisplay1;



        Bundle bundle = getIntent().getExtras();

        //aqui muestra lo que es el nombre en la vista de pelea maxima generada en el main activity

        Nombre1 = bundle.getString("name");
        Nombre2 = bundle.getString("name2");


        //aqui muestra lo que es la imagen en la vista de pelea maxima generada en el main activity
        url1 = bundle.getString("url1");
        url2 = bundle.getString("url2");

        final ProgressBar vida1=(ProgressBar)findViewById(R.id.progressBar2);
        final ProgressBar vida2=(ProgressBar)findViewById(R.id.progressBar3);

        //aqui se esta diciendo que la barra de vida del pokemon es de 100
        vida1.setProgress(100);
        vida2.setProgress(100);

        new DowloadTask((ImageView) findViewById(R.id.imagenpokemon1))
                .execute(url1);
        mTxtDisplay = (TextView) findViewById(R.id.pokemonName1);
        mTxtDisplay.setText(Nombre1);

        new DowloadTask((ImageView) findViewById(R.id.imagenpokemon2))
                .execute(url2);
        mTxtDisplay1 = (TextView) findViewById(R.id.pokemonName2);
        mTxtDisplay1.setText(Nombre2);

        botonPelea1 = (Button) findViewById(R.id.botonPelea1);
        botonPelea2 = (Button) findViewById(R.id.botonPelea2);

        botonPelea2.setEnabled(false);

        //en este metodo se esta diciendo que al momento de que el pokemon 1 ataca el daño del ataque es de un maximo de 50 con un ramdon
        botonPelea1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int daño = (int) (Math.random() * 50);
                vida2.setProgress(vida2.getProgress()-daño);

                botonPelea2.setEnabled(true);
                botonPelea1.setEnabled(false);


                if(vida2.getProgress()<=0){


                    Intent ganador = new Intent(peleamaxima.this,Elmejor.class);


                    ganador.putExtra("url1", url1);
                    ganador.putExtra("name", Nombre1);

                    startActivity(ganador);





                    Log.d("vida","Pokemon2 perdio");
                }


            }
        });

        botonPelea2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int daño = (int) (Math.random() * 50);
                vida1.setProgress(vida1.getProgress()-daño);

                botonPelea2.setEnabled(false);
                botonPelea1.setEnabled(true);




                if(vida1.getProgress()<=0){

                    Intent ganador = new Intent(peleamaxima.this,Elmejor.class);


                    ganador.putExtra("url1", url1);
                    ganador.putExtra("name", Nombre1);

                    startActivity(ganador);

                    Log.d("vida","Pokemon1 perdio");
                }


            }
        });


    }




}
