import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    Department department = new Department();
    ArrayList<Department> deps = new ArrayList<>();

    @Test
    void createDepartment() {
        Department d = new Department(22, "Accounting", 6, 4);
        department.createDepartment(d);
        Assertions.assertTrue(Department.departments.contains(d),
                () -> String.format("Department %s was not found", d));
    }

    @Test
    void deleteDepartment() {
        Department d = new Department(22, "Accounting", 6, 4);
        Department dd = new Department(55, "Entertainment", 7, 7);
        department.createDepartment(d);
        department.createDepartment(dd);
        Department.deleteDepartment(d.department_id);
        Assertions.assertFalse(Department.departments.contains(d),
                () -> String.format("Department %s was not found", d));
    }

    @Test
    void updateDepartment() {
        Department d = new Department(22, "Accounting", 6, 4);
        Department dd = new Department(55, "Entertainment", 7, 7);
        department.createDepartment(d);
        department.createDepartment(dd);

        deps.add(d);
        deps.add(dd);

        deps.get(0).manager_id = 55;
        deps.get(1).location_id = 6;

        d.setManager_id(55);
        dd.setLocation_id(6);
        Department.updateDepartment(d);
        Department.updateDepartment(dd);

        System.out.println("Expected Array:" + deps);
        System.out.println("Actual Array:  " + Department.departments);

        Assertions.assertTrue(isDepUpdated(deps, Department.departments));
    }
    boolean isDepUpdated(ArrayList<Department> d1, ArrayList<Department> d2){
        int i=0;
        for(Department d: d1){
            d = d1.get(i);
            Department dd = d2.get(i);
            ++i;
            return  d.department_id == dd.department_id
                    && d.department_name.equals(dd.department_name)
                    && d.manager_id == dd.manager_id
                    && d.location_id == dd.location_id;
        }
        return false;
    }
}