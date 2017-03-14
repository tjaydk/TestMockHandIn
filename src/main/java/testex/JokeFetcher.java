package testex;

import Entity.Jokes;
import Exceptions.JokeException;
import Entity.*;
import Exceptions.InvalidTimeZoneException;
import Entity.Joke;
import Enum.JokeTypes;
import static Enum.JokeTypes.*;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.ExtractableResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Class used to fetch jokes from a number of external joke API's
 */
public class JokeFetcher {

    /**
     * These are the valid types that can be used to indicate required jokes
     * eduprog: Contains joke related to programming and education. API only
     * returns a new value each hour chucknorris: Fetch a chucknorris joke. Not
     * always political correct ;-) moma: Fetch a "MOMA" joke. Defenitely never
     * political correct ;-) tambal: Just random jokes
     */
    

    /**
     * Fetch jokes from external API's as given in the input string -
     * jokesToFetch
     *
     * @param jokesToFetch A comma separated string with values (contained in
     * availableTypes) indicating the jokes to fetch. Example:
     * "eduprog,chucknorris,chucknorris,moma,tambal" will return five jokes (two
     * chucknorris)
     * @param timeZone. Must be a valid timeZone string as returned by:
     * TimeZone.getAvailableIDs()
     * @return A Jokes instance with the requested jokes + time zone adjusted
     * string representing fetch time (the jokes list can contain null values,
     * if a server did not respond correctly)
     * @throws JokeException. Thrown if either of the two input arguments
     * contains illegal values
     */
    public Jokes getJokes(JokeTypes[] jokesToFetch, String timeZone) throws InvalidTimeZoneException {
        return new Jokes(generateJokesList(jokesToFetch), localeDateString(timeZone));
    }
    
    /**
     * Generates a list of jokes from a enum list with types
     * @param jokesToFetch
     * @return List<Joke>
     */
    public List<Joke> generateJokesList(JokeTypes[] jokesToFetch) {
        List<Joke> jokesList = new ArrayList();
        for (JokeTypes joke : jokesToFetch) {
            switch (joke) {
                case EDUPROG:
                    jokesList.add(new EducationalProgrammingJoke().retriveJoke());
                    break;
                case CHUCKNORRIS:
                    jokesList.add(new ChuckNorrisJoke().retriveJoke());
                    break;
                case MOMA:
                    jokesList.add(new YoMommaJoke().retriveJoke());
                    break;
                case TAMBAL:
                    jokesList.add(new TambalJoke().retriveJoke());
                    break;
            }
        }
        return jokesList;
    }
    
    /**
     * Gets the current date and time
     * @return Date
     */
    public Date getDate() {
        return new Date();
    }
    
    /**
     * Returns a locale formatted date string from current date and time
     * @param timeZone
     * @return String
     * @throws InvalidTimeZoneException 
     */
    public String localeDateString(String timeZone) throws InvalidTimeZoneException {
        DateFormatter formatter = new DateFormatter(getDate(), new SimpleDateFormat("dd MMM yyyy hh:mm aa"));
        return formatter.getFormattedDate(timeZone);
    }

    /**
     * DO NOT TEST this function. It's included only to get a quick way of
     * executing the code
     *
     * @param args
     */
    public static void main(String[] args) throws JokeException, InvalidTimeZoneException {
        JokeFetcher jf = new JokeFetcher();
        JokeTypes[] jokesToFetch = new JokeTypes[] {
            JokeTypes.EDUPROG, 
            JokeTypes.CHUCKNORRIS,
            JokeTypes.MOMA,
            JokeTypes.TAMBAL
        };
        Jokes jokes = jf.getJokes(jokesToFetch, "Europe/Copenhagen");
        jokes.getJokes().forEach((joke) -> {
            System.out.println(joke);
        });
    }
}
