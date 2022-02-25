// --== CS400 File Header Information ==--
// Name: Axel Agelii
// Email: agelii@wisc.edu
// Team: GD Blue
// Role: Data Wrangler
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import java.util.List;

/**
 * This class represents a Movie object where all its traits are contained.
 *
 * @author Axel
 */
public class Movie implements MovieInterface {
  private String title;
  private int year;
  private List<String> genres;
  private String director;
  private String description;
  private Float avgVote;

  /**
   * This method returns the title of the Movie.
   *
   * @return the title of the Movie as a String
   */
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * This method returns the year the Movie was released
   *
   * @return the year the Movie was released as a 4 digit Integer
   */
  @Override
  public Integer getYear() {
    return year;
  }

  /**
   * This method returns the genres of the Movie.
   *
   * @return the genres of the Movie as List<String>
   */
  @Override
  public List<String> getGenres() {
    return genres;
  }

  /**
   * This method returns the director of the Movie.
   *
   * @return the director of the Movie as a String
   */
  @Override
  public String getDirector() {
    return director;
  }

  /**
   * This method returns the description of the Movie.
   *
   * @return the description of the Movie as a String
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * This method returns the average votes of the Movie.
   *
   * @return the average votes of the Movie as a Float
   */
  @Override
  public Float getAvgVote() {
    return avgVote;
  }

  /**
   * Compares Movies by average votes. Returns 0 if equals votes, -1 if this is greater than other,
   * 1 otherwise
   *
   * @param otherMovie Movie being compared
   * @return 0 if equals votes, -1 if this is greater than other, 1 otherwise
   */
  @Override
  public int compareTo(MovieInterface otherMovie) {
    if(this.getAvgVote().equals(otherMovie.getAvgVote())){
      return 0;
    }
    else if(this.getAvgVote()>otherMovie.getAvgVote()){
      return -1;
    }
    else{
      return 1;
    }
  }

  /**
   * This method overrides the toString() method to return a formatted String of the instance
   * variables.
   *
   * @return formatted String of the instance variables.
   */
  @Override
  public String toString(){
    return title +" "+year +" "+genres +" "+director +" "+description +" "+avgVote;
  }

  /**
   * This method sets the title of this movie.
   *
   * @param title title of this movie
   */
  public void setTitle(String title){
    this.title = title;
  }
  /**
   * This method sets the production year of this movie.
   *
   * @param year production year of this movie
   */
  public void setYear(int year){
    this.year = year;
  }

  /**
   * This method sets the genres of this movie.
   *
   * @param genres genres of this movie
   */
  public void setGenres( List<String> genres){
    this.genres = genres;
  }

  /**
   * This method sets the director of this movie.
   *
   * @param director director of this movie
   */
  public void setDirector(String director){
    this.director = director;
  }

  /**
   * This method sets the description of this movie.
   *
   * @param description description of this movie
   */
  public void setDescription(String description){
    this.description = description;
  }

  /**
   * This method sets the average votes of this movie.
   *
   * @param avgVote average votes of this movie
   */
  public void setAvgVote(Float avgVote){
    this.avgVote = avgVote;
  }
}
