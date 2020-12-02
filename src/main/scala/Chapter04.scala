import java.util.{Properties, Scanner}
import java.io.File
import java.util
import scala.collection.mutable
import scala.jdk.CollectionConverters._

object Chapter04 {
  def exercise01: Map[String, Double] = {
    val gizmos = Map("Smart Watches" -> 1200, "Shower Speaker" -> 650, "Portable Projector" -> 460)
    for((gizmo, price) <- gizmos) yield (gizmo -> price * 0.9)
  }

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

  //Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
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

  def exercise06 = mutable.LinkedHashMap[String, Int](
    "Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY,
  )

  def exercise07(): Unit = {
    val KEY_VALUE_SEPARATOR = "    "
    val properties = java.lang.System.getProperties.asScala
    val maxKeyLength = properties.keys.maxBy(_.length).length
    properties.keys.foreach { key =>
      println(s"$key${" " * (maxKeyLength - key.length)}$KEY_VALUE_SEPARATOR| ${properties(key)}")
    }
  }

  def exercise08(values: Array[Int]): (Int, Int) = (values.min, values.max)

  def exercise09(values: Array[Int], v: Int): (Int, Int, Int) = (
    values.count(_ < v),
    values.count(_ == v),
    values.count(_ > v)
  )

  // What happens when you zip together two strings, such as "Hello".zip("World")? Come up with a plausible use case.
  // You get a sequence of tuples consisting of str1(0) -> str2(0), str1(1) -> str2(1), etc.
  // With .fold(), it is possible to check two strings for equality
  def exercise10: Seq[(Char, Char)] = "Hello".zip("World")
}
