import scala.beans.BeanProperty

//Classes
object Chapter05 {
  //1
  class Counter {
    private var value: Int = 0
  
    def increment() = if(value == Int.MaxValue - 1) value = 0 else value += 1
    def current = value
  }

  //2
  class BankAccount {
    private var privateBalance: Double = 0.0
  
    def balance = privateBalance
    def deposit(amount: Double) = privateBalance += amount
    def withdraw(amount: Double) = privateBalance -= amount
  }

  //3
  class Time(val hours: Int, val minutes: Int) {
    def before(other: Time): Boolean = hours <= other.hours && minutes < other.minutes
  }

  //4
  class Time2(val hours: Int, val minutes: Int) {
    private val overallMinutes = hours * 60 + minutes
    def before(other: Time2): Boolean = overallMinutes < other.overallMinutes
  }

  //5
  class Student(@BeanProperty val name: String, @BeanProperty val id: Long)
  
  //6
  class Person(var age: Int) {
    if (age < 0){
      age = 0
    }
  }
  
  //7
  class Person(val name: String) {
  val firstName = name.split(" ").headOption.getOrElse("")
  val lastName = name.split(" ").lastOption.getOrElse("")
  }
  
  //8
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
  
  //9
  def exercise09 =
  """    public class Car {
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

  //10
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0)
}
