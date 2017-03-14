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
public class YoMommaJoke extends Joke{

    public YoMommaJoke(){}
    
    public YoMommaJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retriveJoke() {
        try {
            //API does not set response type to JSON, so we have to force the response to read as so
            String joke = given().get("http://api.yomomma.info/").andReturn().jsonPath().getString("joke");
            this.setJoke(joke);
            this.setReference("http://api.yomomma.info/");
            return this;
        } catch (Exception e) {
            return null;
        }
    }
    
}
