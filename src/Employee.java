import java.util.ArrayList;

public class Employee {

    int employee_id;
    String first_name;
    String last_name;
    String email;
    int phone_number;
    String hire_date;
    int job_id;
    int salary;
    int commission_pct;
    int manager_id;
    int department_id;
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void setEmployees() {
        employees.add(new Employee(12, "Mohammed","Ali","ma@gmail.com", 33465784,"20-02-2013", 454,20000,2,3,1));
        employees.add(new Employee(23, "Ali","Mohammed","am@gmail.com", 55874637,"18-05-2016", 549,18000,3,4,2));
        employees.add(new Employee(35, "Ahmed","Nasser","an@gmail.com", 66846372,"13-10-2011", 89,25000,7,8,3));
        employees.add(new Employee(42, "Nasser","Ahmed","na@gmail.com", 77946373,"20-12-2019", 765,15000,3,2,4));
    }

    public Employee(int employee_id, String first_name, String last_name, String email, int phone_number, String hire_date, int job_id, int salary, int commission_pct, int manager_id, int department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
    }

    public Employee() {

    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(int commission_pct) {
        this.commission_pct = commission_pct;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", hire_date=" + hire_date +
                ", job_id=" + job_id +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", manager_id=" + manager_id +
                ", department_id=" + department_id +
                '}';
    }

    public void createEmployee(Employee employee) {
        Department.setDepartments();
        employee_id = employee.employee_id;
        first_name = employee.first_name;
        last_name = employee.last_name;
        email = employee.email;
        phone_number = employee.phone_number;
        hire_date = employee.hire_date;
        job_id = employee.job_id;
        salary = employee.salary;
        commission_pct = employee.commission_pct;
        manager_id = employee.manager_id;
        department_id = employee.department_id;
        employees.add(employee);
    }
    static void getEmployee(int emp_id)
    {
        for(Employee employee: employees)
        {
            if(employee.getEmployee_id() == emp_id){
                System.out.println("The employee information is:");
                System.out.println(employee);
            }
        }
    }

    static Employee getEmp(int emp_id)
    {
        for(Employee employee: employees)
        {
            if(employee.getEmployee_id() == emp_id){
                return employee;
            }
        }
        return null;
    }

    static void deleteEmployee(int emp_id)
    {
        for(Employee employee: employees)
        {
            if(employee.getEmployee_id() == emp_id){
                System.out.println("The employee information is:");
                System.out.println(employee);
                employees.remove(employee);
                System.out.println("The employee is deleted!");
                break;
            }
        }
    }

    public boolean isAvailable(int empId) {
        for(Employee employee: employees)
        {
            if(employee.getEmployee_id() == empId){
                return true;
            }
        }
        return false;

    }
    void getAllEmployees()
    {
        int j=0;
        System.out.println("All the employee information is:");
        for(Employee employee: employees)
        {
            System.out.println("#"+ (j + 1) + ": " + employee);
            j++;
        }
    }
    public static void updateEmployee(Employee employee){
        Department.setDepartments();
        int index = employees.indexOf(employee);
        //int index = getEmployeeIndex(employee.employee_id);
        employees.get(index).setPhone_number(employee.phone_number);
        employees.get(index).setJob_id(employee.job_id);
        employees.get(index).setSalary(employee.salary);
        employees.get(index).setCommission_pct(employee.commission_pct);
        int m = Department.getDeptManager(employee.department_id);
        employees.get(index).setManager_id(m);
        employees.get(index).setDepartment_id(employee.department_id);
    }


}
