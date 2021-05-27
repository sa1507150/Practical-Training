import java.util.Scanner;

public class EmployeeManager {
    static int enteredNum;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        Department.setDepartments();
        Employee.setEmployees();
        boolean programOn = true;
        Employee employee = new Employee();
        viewMenu();

        while(programOn) {
            switch (checkInt(console)) {
                case 1: {
                    Employee e = createEmp();
                    Employee ee = new Employee();
                    ee.createEmployee(e);
                    break;
                }

                case 2: {
                    employee.getAllEmployees();
                    break;
                }

                case 3: {
                    System.out.println("What is the employee id?");
                    int id = console.nextInt();
                    Employee.getEmployee(id);
                    break;
                }

                case 4: {
                    System.out.print("Enter Employee id you want to update: ");
                    int empId = console.nextInt();
                    Employee employee1 = Employee.getEmp(empId);
                    if (!employee.isAvailable(empId))
                    {
                        System.out.println("Not a Valid Employee ID!");
                        break;
                    }
                    else
                    {
                        updateEmployee(employee1);
                    }
                    break;
                }

                case 5: {
                    System.out.println("What is the employee id?");
                    int id = console.nextInt();
                    Employee.deleteEmployee(id);
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
        System.out.println("| 1.) Create New Employee           |");
        System.out.println("| 2.) Get All Employees Information |");
        System.out.println("| 3.) Get Employee Information      |");
        System.out.println("| 4.) Update Employee Information   |");
        System.out.println("| 5.) Delete Employee               |");
        System.out.println("| 6.) Return to Main Menu           |");
        System.out.println("| 7.) Show Options                  |");
        System.out.println("| 8.) Exit Program!                 |");
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
    public static Employee createEmp(){
        System.out.println("What is Employee Id?: ");
        int employee_id = console.nextInt();
        System.out.println("What is Employee First Name?: ");
        String first_name = console.next();
        System.out.println("What is Employee Last Name?: ");
        String last_name = console.next();
        System.out.println("What is Employee Email?: ");
        String email = console.next();
        System.out.println("What is Employee Phone number?: ");
        int phone_number = console.nextInt();
        System.out.println("What is Employee Hire Date?: ");
        String hire_date = console.next();
        System.out.println("What is Employee Job Id?: ");
        int job_id = console.nextInt();
        System.out.println("What is Employee Salary?: ");
        int salary = console.nextInt();
        System.out.println("What is Employee Commission PCT?: ");
        int commission_pct = console.nextInt();
        System.out.println("What is Employee Department Id?: ");
        int did = console.nextInt();
        int department_id;
        int manager_id;
        while (!Department.departmentIdExist(did)){
            System.out.println("Department ID does not exist enter a correct department ID!");
            did = console.nextInt();
        }
        department_id = did;
        manager_id = Department.getDeptManager(did);
        return new Employee(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary,commission_pct, manager_id, department_id);
    }
    public static void updateEmployee(Employee employee) {
        int index = Employee.employees.indexOf(employee);
                //Employee.getEmployeeIndex(empId);

        System.out.println("What do you want to update?");
        System.out.println("|   Select number and press enter   |");
        System.out.println("|       to perform operation        |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("| 1.) Update Phone Number           |");
        System.out.println("| 2.) Update Job Id                 |");
        System.out.println("| 3.) Update Salary                 |");
        System.out.println("| 4.) Update Commission pct         |");
        System.out.println("| 5.) Update Manager id             |");
        System.out.println("| 6.) Update Department id          |");
        System.out.println("|                                   |");
        System.out.println("-------------------------------------");
        switch (console.nextInt()){
            case 1:
                System.out.println("What is the new Phone Number?: ");
                Employee.employees.get(index).setPhone_number(console.nextInt());
                break;
            case 2:
                System.out.println("What is the new Job Id?: ");
                Employee.employees.get(index).setJob_id(console.nextInt());
                break;
            case 3:
                System.out.println("What is the new Salary?: ");
                Employee.employees.get(index).setSalary(console.nextInt());
                break;
            case 4:
                System.out.println("What is the new Commission PCT?: ");
                Employee.employees.get(index).setCommission_pct(console.nextInt());
                break;
            case 5:
                System.out.println("What is the new Manager Id?: ");
                Employee.employees.get(index).setManager_id(console.nextInt());
                break;

            case 6:
                System.out.println("What is the new Department Id?: ");
                int did = console.nextInt();
                //Employee.employees.get(index).setDepartment_id();

                while (!Department.departmentIdExist(did)){
                    System.out.println("Department ID does not exist enter a correct department ID!");
                    did = console.nextInt();
                }
                Employee.employees.get(index).setDepartment_id(did);
                int manager_id = Department.getDeptManager(did);
                Employee.employees.get(index).setManager_id(manager_id);

                break;
        }
    }
}
