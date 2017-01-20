
public class Manager extends Employee {
   // Override setSalary in the Employee class
   @Override
   // public void setSalary(int salary) {
   public void setSalary(double salary) {
      System.out.println("Manager.setSalary():" + salary);
   }
}
