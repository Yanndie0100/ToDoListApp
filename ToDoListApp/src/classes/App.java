package classes;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
public class App {
    private static TaskManager taskManager = new TaskManager();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the To-Do List App!");
        while (true) {
            System.out.println("\n     OPTIONS:");
            System.out.println("__________________");
            System.out.println("\n1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Mark a task as not completed");
            System.out.println("5. Change Task Priority");
            System.out.println("6. Exit");
            System.out.println("__________________");
            System.out.print("\nChoose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                addNewTask(scanner);
                break;
                case 2:
                taskManager.viewTasks();
                break;
                case 3:
                completeTask(scanner);
                break;
                case 4:
                notCompleteTask(scanner);
                break;
                case 6:
                System.out.println("Exiting the app. Goodbye!");
                scanner.close();
                return;
                case 5:
                if (!taskManager.getTasks().isEmpty()){
                    taskManager.viewTasks();
                    System.out.print("Please choose which task to change (Input ID): ");
                    int taskIndex = scanner.nextInt();
                    System.out.println();
                    System.out.println("Please input the new priority: ");
                    scanner.nextLine();
                    String newPriority = scanner.nextLine();
                    taskManager.tasks.get(taskIndex-1).changePriority(newPriority);
                    System.out.println("Priority successfully changed");
                }
                else{
                    System.out.println("No tasks have been added yet.");
                    continue;
                }
                break;
                default:
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void addNewTask(Scanner scanner) {
        System.out.print("\nEnter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();
        System.out.print("Enter task priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        Task task = new Task(description, deadline, priority);
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }
    private static void completeTask(Scanner scanner) {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        if (taskManager.markTaskAsCompleted(taskId)) {
        System.out.println("Task marked as completed.");
        } else {
        System.out.println("Task not found.");
        }
    }
    private static void notCompleteTask(Scanner scanner) {
        System.out.print("Enter task ID to mark as not completed: ");
        int taskId = scanner.nextInt();
        if (taskManager.markTaskAsNotCompleted(taskId)) {
            System.out.println("Task marked as not completed.");
        } else {
            System.out.println("Task not found.");
        }
    }
}