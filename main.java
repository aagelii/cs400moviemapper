import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.zip.DataFormatException;

public class main {
  public static void main(String[] args) throws IOException, DataFormatException {
    Reader fileReader= new FileReader(new File( "C:\\Users\\Axel\\IdeaProjects\\Movie Mapper\\src\\movies.csv"));
    //Reader fileReader= new FileReader(new File( "C:\\Users\\Axel\\IdeaProjects\\Movie Mapper\\src\\newMovies.csv"));
    MovieDataReader movieDataReader= new MovieDataReader();
    List<MovieInterface> x=movieDataReader.readDataSet(fileReader);
    //System.out.println(x);
    //System.out.println(x.get(67).getAvgVote());
  }
}
