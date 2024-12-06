import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class main {
    public static void part1() {
        System.out.println("AoC Day 6 Part 1");
       
        ArrayList<ArrayList<Character>> map = new ArrayList<>();
        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
       
        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
 
        int lineNumber = 0;
        int[] startPosition = {-1,-1};
       
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            char[] chars = line.toCharArray();
            ArrayList<Character> l = new ArrayList<>();
            int col = 0;
            for (char c : chars) {
                l.add(c);
                if (c == '^') {
                                startPosition[0] = col;
                                startPosition[1] = lineNumber;
                }
                col++;
            }
            lineNumber++;
            map.add(l);
        }
       
        int[] nextPosition = {-1,-1};
       
        ArrayList<Integer>currentPosition = new ArrayList<Integer>(2);
        currentPosition.add(0, startPosition[0]);
        currentPosition.add(1, startPosition[1]);
        visited.add(currentPosition);
       
        System.out.println("Start Pos: " + startPosition[0] + ":" + startPosition[1]);
 
        // we move one up to start
        nextPosition[0] = startPosition[0];
                nextPosition[1] = startPosition[1]-1;
               
                int direction = 0; //up
                boolean blocker = false;
               
        while (true) {            
                try {
                                System.out.println("Current Pos: " + currentPosition.get(0) + ":" + currentPosition.get(1));
                               
                                currentPosition = new ArrayList<Integer>(2);
                                currentPosition.add(0, nextPosition[0]);
                                currentPosition.add(1, nextPosition[1]);
                               
                                System.out.println("Next Pos: " + nextPosition[0] + ":" + nextPosition[1]);
                               
                                //check if nextPosition is valid
                                ArrayList<Character> line = map.get(nextPosition[1]);
                                char c = map.get(nextPosition[1]).get(nextPosition[0]);
                                if (c == '#') {
                                                blocker = true;
                                                // blocked, move right instead
                                                if (direction == 0) {
                                                                //System.out.println("blocked, turning right");
                                                                direction = 90; // right
                                                               
                                                                nextPosition[0] = nextPosition[0]+1;
                                                                nextPosition[1] = nextPosition[1]+1;
                                                } else if (direction == 90) {
                                                                //System.out.println("blocked, turning down");
                                                                direction = 180; // down
                                                               
                                                                nextPosition[0] = nextPosition[0]-1;
                                                                nextPosition[1] = nextPosition[1]+1;
                                                } else if (direction == 180) {
                                                                //System.out.println("blocked, turning left");
                                                                direction = 270; //left
                                                               
                                                                nextPosition[0] = nextPosition[0]-1;
                                                                nextPosition[1] = nextPosition[1]-1;
                                                } else if (direction == 270) {
                                                                //System.out.println("blocked, turning up");
                                                                direction = 0; //up
                                                               
                                                                nextPosition[0] = nextPosition[0]+1;
                                                                nextPosition[1] = nextPosition[1]-1;
                                                } else {
                                                                System.out.println("should never get here !");
                                                }
                                }
                                else {   
                                                blocker = false;
                                // we move one up
                                                if (direction == 0) {         
                                                                //System.out.println("going up");
                                                                nextPosition[0] = nextPosition[0];
                                                                nextPosition[1] = nextPosition[1]-1;
                                                } else if (direction == 90) {
                                                                //System.out.println("going right");
                                                                nextPosition[0] = nextPosition[0]+1;
                                                                nextPosition[1] = nextPosition[1];
                                                } else if (direction == 180) {
                                                                //System.out.println("going down");
                                                                nextPosition[0] = nextPosition[0];
                                                                nextPosition[1] = nextPosition[1]+1;
                                                } else if (direction == 270) {
                                                                //System.out.println("going left");
                                                                nextPosition[0] = nextPosition[0]-1;
                                                                nextPosition[1] = nextPosition[1];
                                                } else {
                                                                System.out.println("should never get here !");
                                                }
                                }
                               
                                // we add the visited place
                                ArrayList<Integer>vis = new ArrayList<>(2);
                vis.add(currentPosition.get(0));
                vis.add(currentPosition.get(1));
                if (!visited.contains(vis) && !blocker) {
                                visited.add(vis);
                }
                }
                catch (Exception e) {
                                System.out.println("Went out of map");
                                break;
                }
        }
        System.out.println("Number of fields visisted: " + visited.size());
    }
 
    public static void part2()
    {
        System.out.println("AoC Day 6 Part 2");
       
        boolean full = false;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
   public static void main(String[] args) {
    part1();
   }
}