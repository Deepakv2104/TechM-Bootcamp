package AssociateForGivenTechnology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Associate[] associates = new Associate[5];
        for (int i = 0; i < 5; i++) {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String technology = scanner.nextLine();
            int experienceInYears = Integer.parseInt(scanner.nextLine());
            associates[i] = new Associate(id, name, technology, experienceInYears);
        }
        String searchTechnology = scanner.nextLine();

        Associate[] result = Solution.associatesForGivenTechnology(associates, searchTechnology);

        for (Associate associate : result) {
            System.out.println(associate.getId());
        }

        scanner.close();
    }
}
