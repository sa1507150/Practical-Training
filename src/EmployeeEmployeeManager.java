import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;


class EmployeeTest {
    Employee employee = new Employee();
    ArrayList<Employee> emps = new ArrayList<>();
    @org.junit.jupiter.api.Test
    void createEmployee() {
        Employee e = new Employee(222,"sss","sss","eee",333,"202020",3,10000,3,4,2);
        employee.createEmployee(e);
        Assertions.assertTrue(Employee.employees.contains(e),
                () -> String.format("Employee %s was not found", e));

    }


    @org.junit.jupiter.api.Test
    void deleteEmployee() {
        Employee ee = new Employee(434,"sss","sss","eee",333,"202020",3,10000,3,4,2);
        Employee e = new Employee(222,"sss","sss","eee",333,"202020",3,10000,3,4,3);
        employee.createEmployee(e);
        employee.createEmployee(ee);
        Employee.deleteEmployee(222);
        Assertions.assertFalse(Employee.employees.contains(e),
                () -> String.format("Employee %s was found", e));
    }

    @org.junit.jupiter.api.Test
    void updateEmployee() {
        Employee e1 = new Employee(111,"Ahmed","Mohd","am@gmail.com",55647484,"12042002",3,17000,2,3,1);
        Employee e2 = new Employee(555,"Ali","Nasser","an@gmail.com",66758393,"20022007",5,15000,3,4,2);

        employee.createEmployee(e1);
        employee.createEmployee(e2);

        emps.add(e1);
        emps.add(e2);

        emps.get(0).phone_number = 66783838;
        emps.get(1).setJob_id(6);

        e1.setPhone_number(66783838);
        e2.setJob_id(6);
        Employee.updateEmployee(e1);
        Employee.updateEmployee(e2);

        System.out.println("Expected Array:" + emps);
        System.out.println("Actual Array:  " + Employee.employees);

        Assertions.assertTrue(isEmpUpdated(emps, Employee.employees));
    }
    boolean isEmpUpdated(ArrayList<Employee> e1, ArrayList<Employee> e2){
        int i=0;
        for(Employee e: e1){
            e = e1.get(i);
            Employee ee = e2.get(i);
            ++i;
            return  e.employee_id == ee.employee_id
                    && e.first_name.equals(ee.first_name)
                    && e.last_name.equals(ee.last_name)
                    && e.email.equals(ee.email)
                    && e.phone_number == ee.phone_number
                    && e.hire_date.equals(ee.hire_date)
                    && e.job_id == ee.job_id
                    && e.salary == ee.salary
                    && e.commission_pct == ee.commission_pct
                    && e.manager_id == ee.manager_id
                    && e.department_id == ee.department_id;
        }
        return false;
    }
}