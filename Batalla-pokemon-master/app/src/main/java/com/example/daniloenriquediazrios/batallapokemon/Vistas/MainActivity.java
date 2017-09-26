package com.example.daniloenriquediazrios.batallapokemon.Vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.daniloenriquediazrios.batallapokemon.DowloadTask;
import com.example.daniloenriquediazrios.batallapokemon.Singleton.MySingleton;
import com.example.daniloenriquediazrios.batallapokemon.Infopokemon.Pokemon;
import com.example.daniloenriquediazrios.batallapokemon.R;

import org.json.JSONObject;

public class MainActivity extends Activity {

    //se declaran las variales que vayamos a utilizar
    TextView mTxtDisplay,
            mTxtDisplay1;
    String nombre1,
            imagen1,
            nombre2,
            imagen2;
    Button botonRandom,
            botonPelear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.pokemonName1);
        mTxtDisplay1 = (TextView) findViewById(R.id.pokemonName2);

        //se crea un botonrandom que lo que hace es generar pokemones random
        //se le crea la funcionalidad al boton
        botonRandom = (Button) findViewById(R.id.botonRandom);
        botonRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //aqui se dice que traiga un pokemon random pero con un limite hasta 721 pokemon de la pokeapi
                int indicePokemon = (int) (Math.random() * 721);
                String url1 = ("https://pokeapi.co/api/v2/pokemon/" + indicePokemon);
                getJson1(url1);

                int indicePokemon2 = (int) (Math.random() * 721);
                String url2 = ("https://pokeapi.co/api/v2/pokemon/" + indicePokemon2);
                getJson2(url2);
            }
        });


        //se crea la funcionalidad del boton pelear
        //donde en esta funcionalidad muestra el nombre y la imagen en la vista de peleamaxima de la vista anterior del mainactivity
        //ademas que en este metodo se iria a la vista donde se hace la batalla de los pokemon
        botonPelear = (Button) findViewById(R.id.botonpelear);
        botonPelear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent FightActivityIntent = new Intent(MainActivity.this,peleamaxima.class);


                FightActivityIntent.putExtra("url1", imagen1);
                FightActivityIntent.putExtra("url2", imagen2);
                FightActivityIntent.putExtra("name", nombre1);
                FightActivityIntent.putExtra("name2", nombre2);
                startActivity(FightActivityIntent);


                startActivity(FightActivityIntent);
            }
        });

    }
        //en este metodo se esta jalando lo que es la imagen y el nombre de la pokeapi
        public void getJson1(String url) {
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            nombre1 = Pokemon.getID(response);
                            imagen1 = Pokemon.getImageFront(response);
                            mTxtDisplay.setText(nombre1);
                            new DowloadTask((ImageView) findViewById(R.id.imagenpokemon1))
                                    .execute(imagen1);

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub

                        }
                    });


            // Access the RequestQueue through your singleton class.
            MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
        }
    public void getJson2(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        nombre2 = Pokemon.getID(response);
                        imagen2 = Pokemon.getImageFront(response);
                        mTxtDisplay1.setText(nombre2);
                        new DowloadTask((ImageView) findViewById(R.id.imagenpokemon2))
                                .execute(imagen2);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }


}
