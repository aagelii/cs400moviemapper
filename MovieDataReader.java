// --== CS400 File Header Information ==--
// Name: Axel Agelii
// Email: agelii@wisc.edu
// Team: GD Blue
// Role: Data Wrangler
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * This class implements the MovieDataReaderInterface in order to read in the data from a Reader,
 * then create a List<MovieInterface> of Movie objects out of the data.
 *
 * @author Axel
 */
public class MovieDataReader implements MovieDataReaderInterface {
  /**
   * The list returned by the readDataSet method contains all of the movie objects read in from the
   * data file. The method will throw an exception when the specified file is not found
   * (FileNotFoundException), or a more general IOException when the file cannot be opened for
   * reading or there is some error while reading the file. Finally, a DataFormatException will be
   * thrown when there is an error because the file does not have the correct format.
   */
  @Override
  public List<MovieInterface> readDataSet(Reader inputFileReader)
                throws IOException, DataFormatException {
    try {
      List<MovieInterface> x = new ArrayList<MovieInterface>(); // list to be returned
      BufferedReader csvFile = new BufferedReader(inputFileReader); // reading the input
      String row; // string for each row
      csvFile.readLine(); // flush first
      int counter=0;
      int lastIndex=0;
      while((row = csvFile.readLine())!=null){ // one line at a time
        List<String>[] lists = (List<String>[]) new List[20]; // array of lists 0-12 index for each column
        counter=0;
        for(int i = 0; i<row.length()-1;i++){ // go thru one line
          if(row.substring(i,i+1).equals("\"")){ // first quotation, takes care of quotation
            for(int j=i+1; j<row.length()-2;j++){ // find second quotation
              if(row.substring(j,j+2).equals("\"\"")){ // if double quotation, skip
                j=j+2;
              }
              else if(row.substring(j,j+1).equals("\"")) { // second quotation
                List<String> temp = new ArrayList<String>(); // temp arraylist
                String tempString = row.substring(i + 1, j); // take substring beginning to comma
                temp.add(tempString); // add to temp
                lists[counter] = temp; // add temp to lists
                //System.out.println("COUNTER:" +counter +" String: "+tempString); testing
                //System.out.println("i:"+i+" j:" +j +" "+tempString); testing
                counter++; // increment counter
                i=j+1; // skip quotation mark
                lastIndex=j;
                break; // exit loop
              }
            }
          }
          else{
              for(int j=i; j<row.length()-1;j++){ // no quotations
                if(row.substring(j,j+1).equals(",")) { // next comma
                  List<String> temp = new ArrayList<String>(); // temp arraylist
                  String tempString = row.substring(i, j); // take substring beginning to comma
                  temp.add(tempString); // add to temp
                  lists[counter] = temp; // add temp to lists
                  //System.out.println("COUNTER:" +counter +" String: "+tempString);
                  //System.out.println("i:"+i+" j:" +j +" "+tempString);
                  counter++; // increment counter
                  i=j; // set i to j
                  lastIndex=j;
                  break; // exit loop
                }
              }
          }
        }
        if(counter!=12){ // if counter isn't 12, then incorrect amount of columns
          throw new DataFormatException("ERROR: File does not have correct format.");
        }
        List<String> temp = new ArrayList<String>(); // temp arraylist
        if(row.substring(lastIndex,lastIndex+1).equals("\"")){ // if last index has quotation
          String tempString= row.substring(lastIndex+2); // skip the quotation and comma
          temp.add(tempString); // add to temp
          lists[counter]=temp; // add temp to list
        }
        else{ // if last index has no quotation
          String tempString= row.substring(lastIndex+1); // skip comma
          temp.add(tempString); // add to temp
          lists[counter]=temp; // add temp to list
        }
        String[] genres=lists[3].get(0).split(","); // split genres at each comma
        List<String> tempGenre= new ArrayList<String>(); // temp genre list
        tempGenre.addAll(Arrays.asList(genres)); // add from array to list
        Movie movie= new Movie(); // new movie object
        movie.setTitle(lists[0].get(0)); // set title from column 1
        movie.setYear(Integer.parseInt(lists[2].get(0))); // set year from column 3
        movie.setGenres(tempGenre); // set genre from column 4
        movie.setDirector(lists[7].get(0)); // set director from column 8
        movie.setDescription(lists[11].get(0)); // set description from column 12
        movie.setAvgVote(Float.parseFloat(lists[12].get(0))); // set avg votes from column 13
        x.add(movie); // add this movie object to list to be returned
      }
      csvFile.close(); // close the reader
      return x; // return list
    } catch(IOException f){ // if there is a IO problem, exception will be thrown
      throw new IOException("ERROR: File cannot be opened.");
    }
  }
}
/*
 Columns that contain one or more commas have quotation marks around them (example: the genres of
 movies in the above sample). The data file will be expected to contain at least the properties
 “title”, “year”, “genre”, “director”, “description”, and  “avg_vote”.
    0       2        3         7            11                 12
 DON'T CARE ABOUT "ORIGINAL TITLE" "DURATION" "COUNTRY" "LANGUAGE"  "WRITER" "PRODUCTION" "ACTORS"
                          1            4          5          6         8         9         10
 */