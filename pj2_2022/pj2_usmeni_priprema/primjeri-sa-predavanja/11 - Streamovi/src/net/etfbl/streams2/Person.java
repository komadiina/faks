package net.etfbl.streams2;

public class Person {
  protected String firstName, lastName;
  
  public Person(String firstName,
                String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public Person() {
    this.firstName = PersonUtils.randomFirstName();
    this.lastName = PersonUtils.randomLastName();
  }
  
  
  public String getFirstName() {
    return (firstName);
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return (lastName);
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getFullName() {
    return(firstName + " " + lastName);
  }

  public int firstNameComparer(Person other) {
    System.out.println("Comparing first names");
    return(firstName.compareTo(other.getFirstName()));
  }

  @Override
  public String toString() {
    return(String.format("%s (%s)", getFullName(), 
                         getClass().getSimpleName()));
  }
}
