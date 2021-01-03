import Chapter06.Suit._

//Objects
object Chapter06 {

  /**
    * 1. Write an object Conversions with methods inchesToCentimeters,
    * gallonsToLiters, and milesToKilometers.
    */
  object Conversations {
    def inchesToCentimeters(inchesCount: Double): Double = inchesCount * 2.54
    def gallonsToLiters(gallonsCount: Double): Double = gallonsCount * 3.785411784
    def milesToKilometers(milesCount: Double): Double = milesCount * 1.609344
  }

  /**
    * 2. The preceding problem wasn’t very object-oriented.
    * Provide a general superclass UnitConversion and define objects
    * InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
    */
  class UnitConversion

  object InchesToCentimeters extends UnitConversion {
    def apply(inchesCount: Double): Double = inchesCount * 2.54
  }

  object GallonsToLiters extends UnitConversion {
    def apply(gallonsCount: Double): Double = gallonsCount * 3.785411784
  }

  object MilesToKilometers extends UnitConversion {
    def apply(milesCount: Double): Double = milesCount * 1.609344
  }

  /**
    * 3. Define an Origin object that extends java.awt.Point.
    * Why is this not actually a good idea? (Have a close look at the methods of the Point class.)
    * A: Not a good idea probably because we get getters in Java style, like getX(), and
    * at the same time x and y fields are public
    */
  object Origin extends java.awt.Point

  /**
    * 4. Define a Point class with a companion object so that you can construct Point instances
    * as Point(3,4), without using new.
    */
  class Point(val x: Int, val y: Int)

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }

  /**
    * 5. Write a Scala application, using the App trait,
    * that prints the command-line arguments in reverse order, separated by spaces.
    * For example, scala Reverse Hello World should print World Hello.
    */
  object Reverse extends App {
    println(args.reverse.mkString(" "))
  }

  /**
    * 6. Write an enumeration describing the four playing card suits so that
    * the toString method returns ♣, ♦, ♥, or ♠.
    */
  object Suit extends Enumeration {
    type Suit = Value

    val Spades = Value("♠")
    val Hearts = Value("♥")
    val Diamonds = Value("♦")
    val Clubs = Value("♣")
  }

  /**
    * 7. Implement a function that checks
    * whether a card suit value from the preceding exercise is red.
    */
  val isSuitRed = (suit: Suit) => suit == Hearts || suit == Diamonds

  /**
    * 8. Write an enumeration describing the eight corners of the RGB color cube.
    * As IDs, use the color values (for example, 0xff0000 for Red).
    */
  object RGBCubeCornerColor extends Enumeration {
    type RGBCubeCornerColor = Value

    val Black = Value(0x000000)
    val Blue = Value(0x0000ff)
    val Green = Value(0x00ff00)
    val Cyan = Value(0x00ffff)
    val Red = Value(0xff0000)
    val Magenta = Value(0xff00ff)
    val Yellow = Value(0xffff00)
    val White = Value(0xffffff)
  }
}
