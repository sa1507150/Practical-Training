import java.util.Scanner;

public class MainPage {
    static int enteredNum;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        boolean programOn = true;
        viewMenu();

        while(programOn) {
            switch (checkInt(console)) {
                case 1: {
                    DepartmentManager.main(null);
                    break;
                }

                case 2: {
                    EmployeeManager.main(null);
                    break;
                }

                case 3: {
                    System.out.println("Program Exited!");
                    programOn = false;
                    break;
                }
            }
        }

    }

    private static void viewMenu() {
        System.out.println("|   Select number and press enter   |");
        System.out.println("|       to perform operation        |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("| 1.) Department Manager            |");
        System.out.println("| 2.) Employee Manager              |");
        System.out.println("| 3.) Exit Program!                 |");
        System.out.println("|                                   |");
        System.out.println("-------------------------------------");
    }
    public static int checkInt(Scanner console)
    {
        do {
            while(!console.hasNextInt())
            {
                System.out.println("That is not a number!");
                console.next();
            }
            enteredNum = console.nextInt();
        }while (enteredNum <= 0);

        return enteredNum;
    }
}
