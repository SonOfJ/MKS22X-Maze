import java.util.*;
import java.io.*;
public class Maze {
  private char[][] maze;
  private boolean animate; //false by default
  public Maze(String filename) throws FileNotFoundException {
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int height = 0;
    int length = 0;
    while (inf.hasNextLine()) { //Builds up the height of the maze.
      String line = inf.nextLine();
      length = line.length();
      height = height + 1;
    }
    inf = new Scanner(text);
    maze = new char[height][length]; //Initialize.
    int row = 0; //Counter for rows.
    while (inf.hasNextLine()) { //Add the stuff.
      String line = inf.nextLine();
      for (int i = 0; i < line.length(); i = i + 1) {
        maze[row][i] = line.charAt(i);
      }
      row + row + 1;
    }
    animate = false;
  }
  private void wait(int millis) {
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
  public void setAnimate(boolean b) {
    animate = b;
  }
  public void clearTerminal() {
    System.out.println("\033[2J\033[1;1H");
  }
  public String toString() {
    String display = "";
    for (int i = 0; i < maze.length; i = i + 1) {
      for (int j = 0; j < maze[i].length; j = j + 1) {
        display = display + maze[i][j];
      }
      display = display + "\n";
    }
    return display;
  }
  public int solve() {
    for (int i = 0; i < maze.length; i = i + 1) { //Finding S.
      for (int j = 0; j < maze[0].length; j = j + 1) {
        if (maze[i][j] == 'S') {
          int x = j; //x-coordinate of S.
          int y = i; //y-coordinate of S.
        }
      }
    }
    maze[y][x] = ' '; //Remove S.
    return solve(y, x, 0); //Call helper to begin solving.
  }
}
