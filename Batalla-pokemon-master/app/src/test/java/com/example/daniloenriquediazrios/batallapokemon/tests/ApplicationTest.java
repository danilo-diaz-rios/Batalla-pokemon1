package com.example.daniloenriquediazrios.batallapokemon.tests;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by daniloenriquediazrios on 4/10/17.
 */

public class ApplicationTest extends ApplicationTestCase<Application> {

   public ApplicationTest() { super(Application.class);}

   public void test_esto_siempre_pasa(){

       assertTrue(5 > 1);

   }


}