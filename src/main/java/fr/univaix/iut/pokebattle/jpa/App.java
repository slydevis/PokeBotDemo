package fr.univaix.iut.pokebattle.jpa;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(App.class.getClassLoader().getResourceAsStream("pokemon.json")));

        //convert the json string back to object
        Pokemon obj = gson.fromJson(br, Pokemon.class);

        System.out.println(obj);
    }
}