import java.util.Scanner;

public class DepartmentManager {
    static int enteredNum;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        Department.setDepartments();
        boolean programOn = true;
        Department department = new Department();
        viewMenu();

        while(programOn) {
            switch (checkInt(console)) {
                case 1: {
                    Department d = createDept();
                    Department dd = new Department();
                    dd.createDepartment(d);
                    break;
                }

                case 2: {
                    department.getAllDepartments();
                    break;
                }

                case 3: {
                    System.out.println("What is the department id?");
                    int id = console.nextInt();
                    Department.getDepartment(id);
                    break;
                }

                case 4: {
                    System.out.print("Enter Department id you want to update: ");
                    int deptId = console.nextInt();
                    Department department1 = Department.getDept(deptId);
                    if (!department.isAvailable(deptId))
                    {
                        System.out.println("Not a Valid Department ID!");
                        break;
                    }
                    else
                    {
                        updateDepartment(department1);
                    }
                    break;
                }

                case 5: {
                    System.out.println("What is the department id?");
                    int id = console.nextInt();
                    Department.deleteDepartment(id);
                    break;
                }

                case 6: {
                    MainPage.main(null);
                    break;
                }

                case 7: {
                    viewMenu();
                    break;
                }

                case 8: {
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
        System.out.println("|1.) Create New Department          |");
        System.out.println("|2.) Get All Departments Information|");
        System.out.println("|3.) Get Department Information     |");
        System.out.println("|4.) Update Department Information  |");
        System.out.println("|5.) Delete Department              |");
        System.out.println("|6.) Return to Main Menu            |");
        System.out.println("|7.) Show Options                   |");
        System.out.println("|8.) Exit Program!                  |");
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
    public static Department createDept(){
        System.out.println("What is Department Id?: ");
        int department_id = console.nextInt();

        while (Department.departmentIdExist(department_id)){
            System.out.println("Department ID exist enter another department ID!");
            department_id = console.nextInt();
        }

        System.out.println("What is Department  Name?: ");
        String department_name = console.next();
        System.out.println("What is Department Manager Id?: ");
        int manager_id = console.nextInt();
        System.out.println("What is Department Location Id?: ");
        int location_id = console.nextInt();


        return new Department(department_id, department_name, manager_id, location_id);
    }
    public static void updateDepartment(Department department) {
        int index = Department.departments.indexOf(department);

        System.out.println("What do you want to update?");
        System.out.println("|   Select number and press enter   |");
        System.out.println("|       to perform operation        |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("| 1.) Update Department Name        |");
        System.out.println("| 2.) Update Manager Id             |");
        System.out.println("| 3.) Update Location Id            |");
        System.out.println("|                                   |");
        System.out.println("-------------------------------------");
        switch (console.nextInt()){
            case 1:
                System.out.println("What is the new Department Name?: ");
                Department.departments.get(index).setDepartment_name(console.next());
                break;
            case 2:
                System.out.println("What is the new Manager Id?: ");
                Department.departments.get(index).setManager_id(console.nextInt());
                break;
            case 3:
                System.out.println("What is the new Location Id?: ");
                Department.departments.get(index).setLocation_id(console.nextInt());
                break;
        }
    }
}
