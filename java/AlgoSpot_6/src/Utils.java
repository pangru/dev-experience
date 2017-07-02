public class Utils {
    public static boolean inRange(int x, int xLimit) {
        return x >= 0 && x < xLimit;
    }

    public static boolean inRange(int x, int y, int xLimit, int yLimit) {
        return (y >= 0 && x >= 0) && (y < yLimit && x < xLimit);

    }
}
