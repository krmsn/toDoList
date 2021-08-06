import java.util.Scanner;
import java.util.ArrayList;

public class toDoList
{

    public static void newPage()
    {
        for (int i = 0; i < 60; i++)
        {
            System.out.println("\n");
        }
       
    }

    public static void welcomePage()
    {
        System.out.println("######################################");
        System.out.println("#####  Welcome to the toDoList!  #####");
        System.out.println("######################################");
        System.out.println("\nStart by adding your new task below:");
    }

    public static void displayTasks(ArrayList<String> tasks)
    {
        System.out.println("toDo:  ###############################");
        System.out.println("######################################");
        for (String item : tasks)
        {
            System.out.println(" - " + item);
        }

        System.out.println("\n######################################");
        System.out.println("###  Please enter a command below: ###");
        System.out.println("###   (ADD, REMOVE, or COMPLETE)   ###");
        System.out.println("######################################");
    }

    public static void completedTasks(ArrayList<String> completed)
    {
        System.out.println("itsDone:  ############################");
        System.out.println("######################################");
        for (String done : completed)
        {
            System.out.println(" - " + done);
        }
        System.out.println("\n######################################");
    }

    public static void main(String[] args)
    {   
        // set loop for interface startup - this will be useful later.
        boolean engage = true;
        
        // create scanner (to catch user input), an empty "toDoList", and an empty "itsDone" list.
        Scanner scan = new Scanner(System.in);
        ArrayList<String> toDoList = new ArrayList<String>();
        ArrayList<String> itsDone = new ArrayList<String>();

        // create welcome page and prompt user for the first task.
        newPage();
        welcomePage();

        // receive input and add task.
        String task = scan.nextLine().toUpperCase();
        toDoList.add(task);
        newPage();
    
        while (engage == true)
        {
            // Display toDo list
            displayTasks(toDoList);

            String newTask = scan.nextLine().toUpperCase();

            if (newTask.startsWith("ADD "))
            {
                String[] splitTask = newTask.split(" ", 2);
                String taskName = splitTask[1];
                toDoList.add(taskName);
                newPage();
                if (itsDone.size() > 0)
                {
                    completedTasks(itsDone);
                }
            }
            else if (newTask.startsWith("REMOVE "))
            {
                String[] splitTask = newTask.split(" ", 2);
                String taskName = splitTask[1];
                toDoList.remove(taskName);
                newPage();
                if (itsDone.size() > 0)
                {
                    completedTasks(itsDone);
                }
            }
            else if (newTask.startsWith("COMPLETE "))
            {
                String[] splitTask = newTask.split(" ",  2);
                String taskName = splitTask[1];
                toDoList.remove(taskName);
                itsDone.add(taskName);
                newPage();
                completedTasks(itsDone);

            }
            else if (newTask.startsWith("EXIT"))
            {
                engage = false;
                newPage();
                welcomePage();
                task = scan.nextLine().toUpperCase();
                engage = true;
                itsDone = new ArrayList<String>();
                toDoList.add(task);
                newPage();
            }
            
        }

    }       
}
