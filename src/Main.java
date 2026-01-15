// Imports the ArrayList class so we can store a list of tasks
import java.util.ArrayList;

// Imports the Scanner class so we can read user input from the keyboard
import java.util.Scanner;

public class Main {

    // A static list that holds all tasks as strings
    // "static" means it belongs to the class, not an object
    static ArrayList<String> tasks = new ArrayList<>();

    // Scanner object to read input from the console
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Infinite loop so the menu keeps showing until the user exits
        while (true) {

            // Display the menu options
            showMenu();

            // Read the user's menu choice (number)
            int choice = scanner.nextInt();

            // Consume the leftover newline character
            scanner.nextLine();

            // Decide what to do based on the user's choice
            switch (choice) {

                // If user enters 1, call addTask()
                case 1 -> addTask();

                // If user enters 2, call viewTasks()
                case 2 -> viewTasks();

                // If user enters 3, call deleteTask()
                case 3 -> deleteTask();

                // If user enters 4, exit the program
                case 4 -> {
                    System.out.println("Goodbye!");
                    return; // Ends the program
                }

                // If user enters anything else
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // Method to display the menu options
    static void showMenu() {

        // Print menu options to the console
        System.out.println("\n1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Exit");

        // Prompt the user to choose an option
        System.out.print("Choose: ");
    }

    // Method to add a new task
    static void addTask() {

        // Ask the user to enter a task
        System.out.print("Enter task: ");

        // Read the task and add it to the list
        tasks.add(scanner.nextLine());

        // Confirm task was added
        System.out.println("Task added!");
    }

    // Method to display all tasks
    static void viewTasks() {

        // Check if the task list is empty
        if (tasks.isEmpty()) {

            // Inform the user if there are no tasks
            System.out.println("No tasks yet.");

            // Exit the method early
            return;
        }

        // Loop through all tasks
        for (int i = 0; i < tasks.size(); i++) {

            // Print task number (starting at 1) and task text
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Method to delete a task
    static void deleteTask() {

        // Show the current tasks
        viewTasks();

        // Only continue if there are tasks
        if (!tasks.isEmpty()) {

            // Ask the user which task to delete
            System.out.print("Enter task number to delete: ");

            // Convert user input to zero-based index
            int index = scanner.nextInt() - 1;

            // Check if the index is valid
            if (index >= 0 && index < tasks.size()) {

                // Remove the selected task
                tasks.remove(index);

                // Confirm task was removed
                System.out.println("Task removed!");
            }
        }
    }
}
