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
public class TambalJoke extends Joke{

    public TambalJoke() {}
    
    public TambalJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retriveJoke() {
        try {
            String joke = given().get("http://tambal.azurewebsites.net/joke/random").path("joke");
            this.setJoke(joke);
            this.setReference("http://tambal.azurewebsites.net/joke/random");
            return this;
        } catch (Exception e) {
            return null;
        }
    }
    
}
