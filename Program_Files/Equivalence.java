public class NameVsStructuralEquivalence {

    public static void main(String[] args) {
        // Create two Point objects
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // Print whether p1 and p2 are equal using ==
        if (p1 == p2) {
            System.out.println("p1 and p2 are the same object");
        } else {
            System.out.println("p1 and p2 are different objects");
        }

        // Print whether p1 and p2 are equal using equals() method
        if (p1.equals(p2)) {
            System.out.println("p1 and p2 have the same values");
        } else {
            System.out.println("p1 and p2 have different values");
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
