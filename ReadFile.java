import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
    File text = new File("Maze1.txt");
    Scanner inf = new Scanner(text);
    int height = 0;
    while(inf.hasNextLine()){
      height = height + 1;
    }
    int length = inf.nextLine().length();
    char[][] bijuu = new char[height][length];
    for(int i = 0; i < height; i  )
  }
}
