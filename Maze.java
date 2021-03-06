import java.util.*;
import java.io.*;
public class Maze {
  private char[][] maze;
  private boolean animate; //False by default.
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
      row = row + 1;
    }
    animate = false;
    if (!valid()) {
      throw new IllegalStateException(); //The maze is invalid.
    }
  }
  private boolean valid() { //Checks to see if the maze is valid.
    int numS = 0; //Number of Ss.
    int numE = 0; //Number of Es.
    for (int i = 0; i < maze.length; i = i + 1) {
      for (int j = 0; j < maze[0].length; j = j + 1) {
        if (maze[i][j] == 'S') {
          numS = numS + 1;
        }
        if (maze[i][j] == 'E') {
          numE = numE + 1;
        }
      }
    }
    if (numS != 1 || numE != 1) { //Should have 1 S and 1 E.
      return false;
    } else {
      return true;
    }
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
    int x = 0;
    int y = 0;
    for (int i = 0; i < maze.length; i = i + 1) { //Finding S.
      for (int j = 0; j < maze[0].length; j = j + 1) {
        if (maze[i][j] == 'S') {
          x = j; //x-coordinate of S.
          y = i; //y-coordinate of S.
        }
      }
    }
    maze[y][x] = ' '; //Remove S.
    return solve(y, x, 0); //Call helper to begin solving.
  }
  private int solve(int row, int col, int level) {
    int[] vertical = {1,0,-1,0}; //Array containing all possible vertical movement.
    int[] horizontal = {0,-1,0,1}; //Array containing all possible horizontal movement.
    if (animate) {
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    if (maze[row][col] == 'E') { //Done with maze.
      return level;
    }
    for (int i = 0; i < 4; i = i + 1) {
      if ((maze[row + vertical[i]][col + horizontal[i]] == ' ') || (maze[row + vertical[i]][col + horizontal[i]] == 'E')) { //If the path can be marked.
        maze[row][col] = '@';
        int next = solve(row + vertical[i], col + horizontal[i], level + 1);
        if (next == -1) { //The maze is still unsolved.
          if (maze[row + vertical[i]][col + horizontal[i]] != '#') { //The spot is not a wall.
            maze[row + vertical[i]][col + horizontal[i]] = '.'; //Put a period.
          }
        } else {
          return next;
        }
      }
    }
    maze[row][col] = '.';
    return -1;
  }
}
