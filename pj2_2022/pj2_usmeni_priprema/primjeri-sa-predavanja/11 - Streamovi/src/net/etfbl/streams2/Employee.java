package net.etfbl.streams2;

public class Employee extends Person {
  private int employeeId, salary;
  
  public Employee(String firstName, String lastName,
                  int employeeId, int salary) {
    super(firstName, lastName);
    this.employeeId = employeeId;
    this.salary = salary;
  }
  

  public int getEmployeeId() {
    return (employeeId);
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }
  
  public int getSalary() {
    return(salary);
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  @Override
  public String toString() {
    return(String.format("%s %s [Employee#%s $%,d]", 
           firstName, lastName, employeeId, salary));
  }
}
