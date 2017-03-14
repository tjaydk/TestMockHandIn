package testex;

import Entity.ChuckNorrisJoke;
import Entity.Joke;
import Entity.Jokes;
import Enum.JokeTypes;
import Exceptions.InvalidTimeZoneException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class JokeFetcherTest {
    
    
    @Test
    public void testGetJokes() throws InvalidTimeZoneException {
        // mock the fetcher class
        JokeFetcher fetcher = mock(JokeFetcher.class);
        
        // create a joke list with a pseudo joke
        ArrayList<Joke> jokeList = new ArrayList(); 
        jokeList.add(new ChuckNorrisJoke("Hej", "Hej"));
        
        //tell the mock object to call the real method
        when(fetcher.getJokes(new JokeTypes[]{JokeTypes.CHUCKNORRIS}, "Europe/Copenhagen")).thenCallRealMethod();
        
        //mock the generateJokesList to return the psudo list from abowe
        when(fetcher.generateJokesList(new JokeTypes[]{JokeTypes.CHUCKNORRIS}))
                .thenReturn(jokeList);
        
        //assert that the jokes returned containes the same joke as from the mocked object
        assertThat(fetcher.getJokes(new JokeTypes[]{JokeTypes.CHUCKNORRIS}, "Europe/Copenhagen").getJokes().get(0))
                .isSameAs(jokeList.get(0));
    }
}
