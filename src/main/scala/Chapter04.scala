import java.util.Scanner
import java.io.File

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
}
