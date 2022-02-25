import java.util.List;
import java.util.zip.DataFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public interface MovieDataReaderInterface {

  /**
   * The list returned by the readDataSet method contains all of the movie objects read in from the
   * data file. The method will throw an exception when the specified file is not found
   * (FileNotFoundException), or a more general IOException when the file cannot be opened for
   * reading or there is some error while reading the file. Finally, a DataFormatException will be
   * thrown when there is an error because the file does not have the correct format.
   */
  public List<MovieInterface> readDataSet(Reader inputFileReader) throws FileNotFoundException, IOException, DataFormatException;

}