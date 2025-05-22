import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Enter the file name (e.g., bridge_1.txt): ");
            String fileName = scanner.nextLine().trim();

            File file = new File("benchmarks/" + fileName);

            if (file.exists()) {
                FlowNetwork network = NetworkParser.parseFile(file.getPath());
                System.out.println("Source node: 0, Sink node: " + (network.V - 1));
                FordFulkerson solver = new FordFulkerson(network, 0, network.V - 1);

                System.out.println("\nMaximum flow in the network: " + solver.value());
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }

            System.out.print("\nDo you want to solve another file? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("yes")) {
                continueProgram = false;
                System.out.println("Goodbye!");
            }
        }

        scanner.close();
    }
}
