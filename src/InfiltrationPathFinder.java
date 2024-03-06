import java.util.Scanner;
import java.util.ArrayList;

public class InfiltrationPathFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the starting and goal positions
        System.out.println("Enter the starting position (x y):");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        System.out.println("Enter the goal position (x y):");
        int goalX = scanner.nextInt();
        int goalY = scanner.nextInt();

        ArrayList<String> path = findPath(startX, startY, goalX, goalY);

        // Output the path
        System.out.println("Path to the goal:");
        for (String step : path) {
            System.out.println(step);
        }

        scanner.close();
    }

    private static ArrayList<String> findPath(int startX, int startY, int goalX, int goalY) {
        ArrayList<String> path = new ArrayList<>();

        // Move horizontally to the goal column
        while (startX != goalX) {
            path.add("(" + startX + ", " + startY + ")");
            startX += (goalX > startX) ? 1 : -1;
        }

        // Move vertically to the goal row
        while (startY != goalY) {
            path.add("(" + startX + ", " + startY + ")");
            startY += (goalY > startY) ? 1 : -1;
        }

        // Add the final goal position
        path.add("(" + goalX + ", " + goalY + ")");

        return path;
    }
}