import stdlib.StdOut;
public class Riemann_Sum {
    static int n; // Number of rectangles. (Iterations)
    static float delta_x; // The delta x value
    static float i; // The starting interval
    public static void main(String[] args) {
        String mode = args[0];
        StdOut.print("Your " + mode + " Riemann Sum is: " );
        n = Integer.parseInt(args[1]);
        delta_x = Float.parseFloat(args[2]);
        i = Float.parseFloat(args[3]);
        if (mode.equalsIgnoreCase("left")) {
            StdOut.println(L_Riemann_Sum(n, delta_x, i));
        }
        if (mode.equalsIgnoreCase("right")) {
            StdOut.println(R_Riemann_Sum(n, delta_x, i));
        }
        if (mode.equalsIgnoreCase("mid")) {
            StdOut.println(Mid_Riemann_Sum(n, delta_x, i));
        }
    }
    // Helper method to define f(x) (EDIT HERE)
    private static float function(float i) {
        return (float) 12 / i;
    }
    private static float L_Riemann_Sum(int n, float delta_x, float i) {
        float sum = 0;
        for (int j = 0; j < n; j++) {
            float f = function(i);
            sum += f * delta_x;
            i += delta_x;
        }
        return (sum);
    }
    private static float R_Riemann_Sum(int n, float delta_x, float i) {
        float sum = 0;
        float r = delta_x + i;
        for (int j = 1; j <= n; j++) {
            float f = function(r);
            sum += f;
            r += delta_x;
        }
        return (sum * delta_x);
    }
    private static float Mid_Riemann_Sum(int n, float delta_x, float i) {
        float sum = 0;
        float r = delta_x + i;
        float mid = (r + i) / 2;
        for (int j = 0; j < n; j++) {
            float f = function(mid);
            sum += f;
            mid += delta_x;
        }
        return (sum * delta_x);
    }
}
