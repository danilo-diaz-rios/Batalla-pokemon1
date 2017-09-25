package com.example.daniloenriquediazrios.batallapokemon;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by daniloenriquediazrios on 19/09/17.
 */

public class Pokemon {

    private static String name,front_image_url,back_image_url;
    private static JSONObject infoSprites = null;
    private static JSONObject image = null;


    public static String getID(JSONObject info){
        try {
            name = info.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return name;
    }
    public static JSONObject getSprites(JSONObject info){
        infoSprites = null;
        try {
            infoSprites = info.getJSONObject("sprites");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return infoSprites;
    }
    public static String getImageFront(JSONObject info){
        image = null;
        image = Pokemon.getSprites(info);
        try {
            front_image_url = image.getString("front_default");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return front_image_url;
    }
    public static String getImageBack(JSONObject info){
        image = null;
        image = Pokemon.getSprites(info);
        try {
            back_image_url = image.getString("back_default");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return back_image_url;
    }

    }



