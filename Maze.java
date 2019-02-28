import java.util.*;
import java.io.*;
public class Maze {
  private char[][] maze;
  private boolean animate;
  public Maze(String filename) throws FileNotFoundException {
    File text = new File("Maze1.txt");
    Scanner inf = new Scanner(text);
    int length = inf.nextLine().length();
    int height = 1;
    while(inf.hasNextLine()){
      height = height + 1;
    }
    maze = new char[height][length];
    int numE = 0; //Keeps track of the number of Es.
    int numS = 0; //Keeps track of the number of Ss.
    for (int i = 0; i < height; i = i + 1) { //Transfers the maze to a 2D array.
      String line = inf.nextLine();
      for (int j = 0; j < length; j = j + 1) {
        maze[i][j] = line.charAt(j);
      }
    }
    for (int i = 0; i < maze.length; i = i + 1) { //Seeks for the number of Es and Ss.
      for (int j = 0; j < maze[0].length; j = j + 1) {
        if (maze[i][j] == 'E') {
          numE = numE + 1;
        }
        if (maze[i][j] == 'S') {
          numS = numS + 1;
        }
      }
    }
    if (numE != 1 || numS != 1) { //If there isn't exactly 1 E and 1 S.
      throw new IllegalStateException("Invalid maze.");
    }
    animate = false;
  }
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }





   /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
    public String toString(){
            return "WRITE THIS METHOD";
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S.

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}
