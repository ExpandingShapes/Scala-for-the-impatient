import java.util.Scanner
import java.io.File
import java.util
import scala.collection.mutable
import scala.jdk.CollectionConverters._

object Chapter04 {

  /**
    * Set up a map of prices for a number of gizmos that you covet.
    * Then produce a second map with the same keys and the prices at a 10 percent discount.
    */
  def exercise01: Map[String, Double] = {
    val gizmos = Map("Smart Watches" -> 1200, "Shower Speaker" -> 650, "Portable Projector" -> 460)
    for((gizmo, price) <- gizmos) yield (gizmo -> price * 0.9)
  }

  /**
    * Write a program that reads words from a file. Use a mutable map to count how often each word appears. To read the words, simply use a java.util.Scanner
    * @param fileName file name to read from
    */
  def exercise02(fileName: String): scala.collection.mutable.Map[String, Int] = {
    val words = scala.collection.mutable.Map[String, Int]()
    val in = new Scanner(new File(fileName))

    while (in.hasNext()) {
      val nextWord = in.next()
      words.get(nextWord) match {
        case Some(count) => words(nextWord) += 1
        case None => words += (nextWord -> 1)
      }
    }

    in.close()
    words
  }

  /**
    * Repeat the preceding exercise with an immutable map.
    * @param fileName file name to read from
    */
  def exercise03(fileName: String): Map[String, Int] = {
    var words = Map[String, Int]()
    val in = new Scanner(new File(fileName))

    while (in.hasNext()){
      val nextWord = in.next()
      words.get(nextWord) match {
        case Some(count) => words += (nextWord -> (count + 1))
        case None => words += (nextWord -> 1)
      }
    }

    in.close()
    words
  }

  /**
    * Repeat the preceding exercise with a sorted map,
    * so that the words are printed in sorted order.
    * @param fileName file name to read from
    */
  def exercise04(fileName: String): scala.collection.immutable.SortedMap[String, Int] = {
    var words = scala.collection.immutable.SortedMap[String, Int]()
    val in = new Scanner(new File(fileName))

    while (in.hasNext()){
      val nextWord = in.next()
      words.get(nextWord) match {
        case Some(count) => words += (nextWord -> (count + 1))
        case None => words += (nextWord -> 1)
      }
    }

    in.close()
    words
  }

  /**
    * Repeat the preceding exercise with a java.util.TreeMap
    * that you adapt to the Scala API.
    * @param fileName file name to read from
    */
  def exercise05(fileName: String): java.util.TreeMap[String, Int] = {
    val words = new util.TreeMap[String, Int]()
    val in = new Scanner(new File(fileName))

    while (in.hasNext()){
      val nextWord = in.next()
      if(words.containsKey(nextWord)) {
        words.replace(nextWord, words.get(nextWord) + 1)
      } else {
        words.put(nextWord, 1)
      }
    }

    in.close()
    words
  }

  /**
    * Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY,
    * and similarly for the other weekdays.
    * Demonstrate that the elements are visited in insertion order.
    */
  def exercise06 = mutable.LinkedHashMap[String, Int](
    "Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY,
  )

  /**
    * Print a table of all Java properties, like this:
    *  java.runtime.name        | Java(TM) SE Runtime Environment
    *  sun.boot.library.path    | /home/apps/jdk1.6.0_21/jre/lib/i386
    *  java.vm.version          | 17.0-b16
    *  java.vm.vendor           | Sun Microsystems Inc.
    *  java.vendor.url          | http://java.sun.com/
    *  path.separator           | :
    *  java.vm.name             | Java HotSpot(TM) Server VM
    * You need to find the length of the longest key before you can print the table.
    */
  def exercise07(): Unit = {
    val KEY_VALUE_SEPARATOR = "    "
    val properties = java.lang.System.getProperties.asScala
    val maxKeyLength = properties.keys.maxBy(_.length).length
    properties.keys.foreach { key =>
      println(s"$key${" " * (maxKeyLength - key.length)}$KEY_VALUE_SEPARATOR| ${properties(key)}")
    }
  }

  /**
    * Write a function minmax(values: Array[Int]) that returns a pair
    * containing the smallest and largest values in the array.
    */
  def exercise08(values: Array[Int]): (Int, Int) = (values.min, values.max)

  /**
    * Write a function lteqgt(values: Array[Int], v: Int) that returns a triple
    * containing the counts of values less than v, equal to v, and greater than v.
    */
  def exercise09(values: Array[Int], v: Int): (Int, Int, Int) = (
    values.count(_ < v),
    values.count(_ == v),
    values.count(_ > v)
  )

  /**
    * What happens when you zip together two strings, such as "Hello".zip("World")?
    * Come up with a plausible use case.
    * Answer: You get a sequence of tuples consisting of str1(0) -> str2(0), str1(1) -> str2(1), etc.
    * With .fold(), it is possible to check two strings for equality
    */
  def exercise10: Seq[(Char, Char)] = "Hello".zip("World")
}
