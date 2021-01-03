import scala.beans.BeanProperty

//Classes
object Chapter05 {

  /**
    * 1. Improve the Counter class in Section 5.1,
    * “Simple Classes and Parameterless Methods,” on page
    * 49 so that it doesn’t turn negative at Int.MaxValue.
    */
  class Counter {
    private var value: Int = 0
  
    def increment() = if(value == Int.MaxValue - 1) value = 0 else value += 1
    def current = value
  }

  /**
    * 2. Write a class BankAccount with methods deposit and withdraw,
    * and a read-only property balance.
    */
  class BankAccount {
    private var privateBalance: Double = 0.0
  
    def balance = privateBalance
    def deposit(amount: Double) = privateBalance += amount
    def withdraw(amount: Double) = privateBalance -= amount
  }

  /**
    *
    * 3. Write a class Time with read-only properties hours and minutes and
    * a method before(other: Time): Boolean that checks whether this time comes before the other.
    * A Time object should be constructed as new Time(hrs, min), where hrs is in military time format
    * (between 0 and 23).
    */
  class Time(val hours: Int, val minutes: Int) {
    def before(other: Time): Boolean = hours <= other.hours && minutes < other.minutes
  }

  /**
    *
    * 4. Reimplement the Time class from the preceding exercise so that the internal representation
    * is the number of minutes since midnight (between 0 and 24 × 60 – 1).
    * Do not change the public interface. That is, client code should be unaffected by your change.
    */
  class Time2(val hours: Int, val minutes: Int) {
    private val overallMinutes = hours * 60 + minutes
    def before(other: Time2): Boolean = overallMinutes < other.overallMinutes
  }

  /**
    * 5. Make a class Student with read-write JavaBeans properties name (of type String) and id
    * (of type Long). What methods are generated? (Use javap to check.)
    * Can you call the JavaBeans getters and setters in Scala? Should you?
    */
  class Student(@BeanProperty val name: String, @BeanProperty val id: Long)

  /**
    * 6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
    * on page 49, provide a primary constructor that turns negative ages to 0.
    */
  class Person(var age: Int) {
    if (age < 0){
      age = 0
    }
  }

  /**
    * 7. Write a class Person with a primary constructor that accepts
    * a string containing a first name, a space, and a last name, such as new Person("Fred Smith").
    * Supply read-only properties firstName and lastName.
    * Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
    */
  class Person2(val name: String) {
  val firstName = name.split(" ").headOption.getOrElse("")
  val lastName = name.split(" ").lastOption.getOrElse("")
  }

  /**
    *
    * 8. Make a class Car with read-only properties for
    * manufacturer, model name, and model year, and a read-write property for the license plate.
    * Supply four constructors. All require the manufacturer and model name.
    * Optionally, model year and license plate can also be specified in the constructor.
    * If not, the model year is set to -1 and the license plate to the empty string.
    * Which constructor are you choosing as the primary constructor? Why?
    */
  class Car(val manufacturer: String, val modelName: String, modelYear: Int = -1, var licensePlate: String = "") {
  
    def this(manufacturer: String, modelName: String, modelYear: Int) = {
      this(manufacturer, modelName, modelYear, "")
    }
  
    def this(manufacturer: String, modelName: String, licensePlate: String) = {
      this(manufacturer, modelName, -1, licensePlate)
    }
  
    def this(manufacturer: String, modelName: String) = {
      this(manufacturer, modelName, -1, "")
    }
  }

  /**
    * 9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice).
    * How much shorter is the Scala class?
    */
  def exercise09 =
  """   public class Car {
            private final String manufacturer;
            public String getManufacturer() { return manufacturer; }
        
            private final String modelName;
            public String getModelName() { return modelName; }
        
            private final int modelYear;
            public int getModelYear() { return modelYear; }
        
            private String licensePlate;
            public String getLicensePlate() { return licensePlate; }
            public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
        
            Car(String manufacturer, String modelName, int modelYear, String licensePlate) {
                this.manufacturer = manufacturer;
                this.modelName = modelName;
               this.modelYear = modelYear;
               this.licensePlate = licensePlate;
            }
        
            Car(String manufacturer, String modelName, int modelYear) {
                this(manufacturer, modelName, modelYear, "");
            }
        
            Car(String manufacturer, String modelName, String licensePlate) {
                this(manufacturer, modelName, -1, licensePlate);
            }
        
            Car(String manufacturer, String modelName ) {
                this(manufacturer, modelName, -1, "");
            }
    }"""

  /**
    *
    * 10. Consider the class
    * class Employee(val name: String, var salary: Double) {
    *   def this() { this("John Q. Public", 0.0) }
    * }
    * Rewrite it to use explicit fields and a default primary constructor.
    * Which form do you prefer? Why?
    */
  class Employee(val name: String = "John Q. Public", var salary: Double = 0.0)
}
