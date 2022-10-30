import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");

        System.out.print("Enter the first coordinate: ");
        String coord1 = scan.nextLine();
        int x1 = Integer.parseInt(coord1.substring(1,coord1.indexOf(", ")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(", ") + 2, coord1.length() - 1));

        System.out.print("Enter the second coordinate: ");
        String coord2 = scan.nextLine();
        int x2 = Integer.parseInt(coord2.substring(1,coord2.indexOf(", ")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(", ") + 2, coord2.length() - 1));

        System.out.println();

        if (x1 == x2) {
            System.out.println("The equation will be vertical line: x " + x1);
        } else {
            LinearEquation equation = new LinearEquation(x1,y1,x2,y2);
            System.out.println(equation.lineInfo());
            System.out.println();

            System.out.print("Enter an x-value: ");
            double xVal = scan.nextDouble();
            System.out.println();
            System.out.println("The y-value for this point is: " + equation.coordinateForX(xVal));
            System.out.println();
        }
    }
}