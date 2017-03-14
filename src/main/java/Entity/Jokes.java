package Entity;

import Entity.Joke;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates a number of Joke's and a string value containing a time zone adjusted string indicating
 * when the jokes was fetched
 */
public class Jokes {

  private List<Joke> jokes = new ArrayList();
  private String timeString;
  
  public Jokes(List<Joke> jokes, String timeString) {
      this.jokes = jokes;
      this.timeString = timeString;
  }

  void addJoke(Joke joke) {
    jokes.add(joke);
  }

  public List<Joke> getJokes() {
    return jokes;
  }

  public void setTimeString(String timeString) {
    this.timeString = timeString;
  }

  public String getTimeString() {
    return timeString;
  }

}
