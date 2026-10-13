package dcst;

public final class MemberCounter {
    private static int count = 0;
    private MemberCounter() { }

    public static void increment() { count++; }

    public static void displayCount() {
        System.out.println("Total Student/Staff objects created: " + count);
    }
}
