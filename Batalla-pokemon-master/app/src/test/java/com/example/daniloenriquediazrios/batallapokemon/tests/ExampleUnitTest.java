package com.example.daniloenriquediazrios.batallapokemon.tests;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        assertEquals(4, 2 + 2);
    }
    
    public void programacion2() throws Exception{
        
        Pokemon p = new Pokemon();
        
        assertEquals("https://pokeapi.co/api/v2/pokemon/4",p.validacion_url(4));


    }
}
