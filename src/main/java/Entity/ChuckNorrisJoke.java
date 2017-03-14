/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static com.jayway.restassured.RestAssured.given;

/**
 *
 * @author Dennis
 */
public class ChuckNorrisJoke extends Joke{
    
    public ChuckNorrisJoke() {}
    
    public ChuckNorrisJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retriveJoke() {
        try {
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            this.setJoke(joke);
            this.setReference("http://api.icndb.com/");
            return this;
        } catch (Exception e) {
            return null;
        }
    }
    
}
