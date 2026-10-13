package dcst;

public class SearchService {
    public static void searchStudent(int rollNumber) {
        System.out.println("Overloaded search by roll number: " + rollNumber);
    }

    public static void searchStudent(String name) {
        System.out.println("Overloaded search by name: " + name);
    }
}
