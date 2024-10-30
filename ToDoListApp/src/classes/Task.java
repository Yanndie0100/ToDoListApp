package classes;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private String deadline; // **Changed to LocalDate for better date handling**

    private boolean isCompleted;
    private String priority; // New attribute for task priority
 
    public Task(String description, String deadline,String priority) {
        this.id = idCounter++;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority; // Set priority
        this.isCompleted = false;
    }
    public int getId() {
    return id;
    }
    
    public String getDescription() {

        return description;
    }

    public String getDeadline() {
        return deadline;
    }
    
    public boolean isCompleted() {
    return isCompleted;
    }
  
    public void markAsCompleted() {
    this.isCompleted = true;
    }
    public void markAsNotCompleted() {
        this.isCompleted = false;
        }

    // Method to set the deadline with validation
    public void setDeadline(String deadline) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.deadline = String.format(deadline, formatter);
            System.out.println("Date valid and applied!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
            this.deadline = null; // or set to a default date if necessary
        }
    }


    @Override
    public String toString() {
    return "Task ID: " + id +
    ", Description: " + description +
    ", Completed: " + (isCompleted ? "yaurs" : "naur") +
    ", Priority: " + priority; // Include priority in toString

    }
}