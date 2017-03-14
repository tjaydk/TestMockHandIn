package Entity;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.ExtractableResponse;

/**
 *
 * @author Dennis
 */
public class EducationalProgrammingJoke extends Joke{

    public EducationalProgrammingJoke() {}
    
    public EducationalProgrammingJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retriveJoke() {
        try {
            ExtractableResponse res = given().get("http://jokes-plaul.rhcloud.com/api/joke").then().extract();
            this.setJoke(res.path("joke"));
            this.setReference(res.path("reference"));
            return this;
        } catch (Exception e) {
            return null;
        }
    }
    
}
