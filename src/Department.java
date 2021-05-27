import java.util.ArrayList;

public class Department {

    int department_id;
    String department_name;
    int manager_id;
    int location_id;
    static ArrayList<Department> departments = new ArrayList<>();

    public static void setDepartments() {
        departments.add(new Department(1, "HR", 3, 45));
        departments.add(new Department(2, "IT", 4, 33));
        departments.add(new Department(3, "Management", 8, 89));
        departments.add(new Department(4, "Finance", 2, 76));
    }

    public Department(int department_id, String department_name, int manager_id, int location_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.manager_id = manager_id;
        this.location_id = location_id;
    }
    public Department(){

    }

    public int getDepartment_id() {
        return department_id;
    }
    public static int getDeptManager(int id){
        for (Department department: departments){
            if(departmentIdExist(id)){
                return department.getManager_id();
            }
        }
        return 0;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", manager_id=" + manager_id +
                ", location_id=" + location_id +
                '}';
    }

    static boolean departmentIdExist(int id){
        for(Department department: departments)
        {
            if(department.getDepartment_id() == id){
                return true;
            }
        }
        return false;
    }

    public void createDepartment(Department department) {
        department_id = department.department_id;
        department_name = department.department_name;
        manager_id = department.manager_id;
        location_id = department.location_id;

        departments.add(department);
    }
    static void getDepartment(int department_id)
    {
        for(Department department: departments)
        {
            if(department.getDepartment_id() == department_id){
                System.out.println("The department information is:");
                System.out.println(department);
            }
        }
    }

    public static Department getDept(int department_id) {
        for(Department department: departments)
        {
            if(department.getDepartment_id() == department_id){
                return department;
            }
        }
        return null;
    }

    static void deleteDepartment(int department_id)
    {
        for(Department department: departments)
        {
            if(department.getDepartment_id() == department_id){
                System.out.println("The department information is:");
                System.out.println(department_id);
                departments.remove(department);
                System.out.println("The department is deleted!");
                break;
            }
        }
    }

    public boolean isAvailable(int department_id) {
        for(Department department: departments)
        {
            if(department.getDepartment_id() == department_id){
                return true;
            }
        }
        return false;

    }
    void getAllDepartments()
    {
        int j=0;
        System.out.println("All the departments information is:");
        for(Department department: departments)
        {
            System.out.println("#"+ (j + 1) + ": " + department);
            j++;
        }
    }
    public static void updateDepartment(Department department){
        setDepartments();
        int index = departments.indexOf(department);
        departments.get(index).setDepartment_name(department.department_name);
        departments.get(index).setManager_id(department.manager_id);
        departments.get(index).setLocation_id(department.location_id);
    }

}
