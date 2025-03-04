import java.util.*;


/**
 * A simple To-Do List application that allows users to:
 * 1. Add tasks
 * 2. View tasks
 * 3. Remove tasks
 * 4. Exit the program
 * Uses an ArrayList to store tasks and Scanner for user input.
 */


public class ToDoListApp {
    // Stores the list of tasks
    private static ArrayList<Task> tasks = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice; // Stores user menu choice

        // Loop to continuously show menu until user exits
        do {
            // Display menu options
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            // Read user input (menu choice)
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left after nextInt()

            // Handle user choice using a switch statement
            switch (choice) {
                case 1 -> addTask(scanner); // Call method to add a task
                case 2 -> viewTasks(); // Call method to display tasks
                case 3 -> removeTask(scanner); // Call method to remove a task
                case 4 -> System.out.println("Exiting..."); // Exit message
                case 727 -> Create_Dummy_List(); //dummy list for debug
                default -> System.out.println("Invalid choice. Try again."); // Handle invalid input
            }
        } while (choice != 4); // Loop until user selects option 4 (Exit)

        scanner.close(); // Close scanner to prevent memory leaks
    }

    /**
     * Method to create dummy tasks and add to array for debugging / testing
     */


    private static void Create_Dummy_List(){
        Task task0 = new Task("Take out trash", 2);
        tasks.add(task0);
        Task task1 = new Task("Email boss", 3);
        tasks.add(task1);
        Task task2 = new Task("Get car wash", 1);
        tasks.add(task2);
        Task task3 = new Task("Call mom", 3);
        tasks.add(task3);
        Task task4 = new Task("Get milk", 2);
        tasks.add(task4);
        Task task5 = new Task("Get mail", 1);
        tasks.add(task5);
        Sort_Task_List();
        System.out.println("\nDummy List Created!");
    }

    /**
     * Method to add a new task to the list.
     * @param scanner Scanner object for user input.
     */



    private static void addTask(Scanner scanner) {
        System.out.print("Enter a name for your task: ");
        String Task_Name = scanner.nextLine(); // Read task Name from user

        int Task_Priority = Task.getPriority(); // Read task priority from user
        //if user cancels quit creating task
        if (Task_Priority == 0) {
            System.out.println("Task Canceled");
        }
        else {
            Task task = new Task(Task_Name, Task_Priority);
            tasks.add(task);
            Sort_Task_List();
            System.out.println("Task added!");


             // Add task to the list
             // Confirmation message
        }
    }

    /**
     * Method to sort task list by priority
     */
    private static void Sort_Task_List() {
        if (!tasks.isEmpty()){
        tasks.sort(new Comparator<Task>() {
            public int compare(Task o1, Task o2) {
                if (o1.intPriority == o2.intPriority) {
                    return 0;

                }
                return o1.intPriority < o2.intPriority ? -1 : 1;
            }
        });}
    }
    /**
     * Method to display all tasks in the list.
     */
    private static void viewTasks() {
        if (tasks.isEmpty()) { // Check if the list is empty
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            // Loop through the list and display each task with a number
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    /**
     * Method to remove a task from the list.
     * @param scanner Scanner object for user input.
     */

    private static void removeTask(Scanner scanner) {
        viewTasks(); // Show current tasks before asking for input
        if (tasks.isEmpty()) return; // If no tasks, exit method
        System.out.println((tasks.size()+1) + ". Cancel task removal"); //last option in list becomes cancel option
        System.out.print("Enter task number to remove: ");
        int index = scanner.nextInt(); // Get task number from user
        // cancels if option is picked
        if (index == (tasks.size()+1)){
            System.out.println("removal canceled");
        }
        else{
        // Validate the task number before removing
            if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1); // Remove task (index is 1-based, ArrayList is 0-based)
            System.out.println("Task removed."); // Confirmation message
            } else {
            System.out.println("Invalid task number."); // Handle invalid input
        }
        }
    }
}
