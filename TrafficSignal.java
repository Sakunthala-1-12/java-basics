public class TrafficSignal {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public static void main(String[] args) {

        int signalA = 20;
        int signalB = 30;
        System.out.println(
            "Both signals turn green together after "
            + lcm(signalA, signalB)
            + " seconds."
        );
    }
}
