public class LinearEquation {
    /* Instance Variables */
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    /* Creates a LinearEquation object */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.hypot((x2 - x1), (y2 - y1)));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double yInt() {
        return roundedToHundredth(y1- (slope() * x1));
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth(((double) y2 - y1 ) / ((double) x2 - x1));
    }

    //find change in x and y
    public int deltaX() {
        return x2 - x1;
    }

    public int deltaY() {
        return y2-y1;
    }

    /* Returns a String that represents the linear equation of the line through points
   (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form */
    public String equation() {
        int deltaX = deltaX();
        int deltaY = deltaY();
        String yIntNeg = " + ";
        String yInt = "";
        double yIntVal = yInt();

        if (yInt() < 0){
            yIntNeg = " - ";
            yIntVal = yInt() * -1;
        }

        if (yInt() != 0){
            yInt = yIntNeg + yIntVal;
        }

        if (deltaX() < 0){
            deltaX = deltaX() * -1;
            deltaY = deltaY() * -1;
        }

        if (((double) deltaY) / ((double) deltaX) == 1){
            return "y = " + "x" + yInt;
        } else if (((double) deltaY) / ((double) deltaX) == -1) {
            return "y = -x" + yInt;
        }  else if (((double) deltaY) / ((double) deltaX) == 0) {
            return "y = " + yInt();
        } else if (deltaY % deltaX == 0) {
            return "y = " + deltaY/deltaX + "x" + yInt;
        } return "y = " +deltaY + "/" + deltaX + "x" + yInt;
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
   both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        return "(" + xValue + ", " + (roundedToHundredth(xValue*slope()+yInt())) + ")";
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
    to the nearest hundredth*/
    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100.0) / 100.0;
    }

    /* Returns a string that includes all information about the linear equation, each on
   separate lines*/
    public String lineInfo() {
        return "The two points are: (" + x1 + "," + " " + y1 + ")" + " and " + "(" + x2 + "," + " " + y2 + ")" + "\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of the line is: " + yInt() + "\nThe distance between the two points is: " + distance();
    }
}