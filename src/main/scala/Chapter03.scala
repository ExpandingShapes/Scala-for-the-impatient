object Chapter03 {
  val isEven: Int => Boolean = _ % 2 == 0

  def exercise01(n: Int): Array[Int] = {
    val random = scala.util.Random
    (for (i <- 1 to n) yield random.nextInt(n)).toArray
  }

  def exercise02(array: Array[Int]): Array[Int] = {
    var temp = 0
    val maxIndex = if(isEven(array.length)) array.length - 2 else array.length - 3
    for(i <- 0 to maxIndex by 2) {
      temp = array(i)
      array(i) = array(i + 1)
      array(i + 1) = temp
    }
    array
  }

  def exercise03(array: Array[Int]): Array[Int] = {
    for {
      i <- array.indices.toArray
      indexToSwap = i match {
        case lastIndex if i == array.length - 1 && isEven(i) => i
        case even if isEven(i) => i + 1
        case odd if !isEven(i) => i - 1
      }
    } yield array(indexToSwap)
  }

  def exercise04(array: Array[Int]): Array[Int] = {
    array.filter(_ > 0) ++ array.filter(_ <= 0)
  }
  
    def exercise05(array: Array[Double]): Double = array.sum / array.length
  
  def exercise06(array: Array[Int]): Array[Int] = array.sorted.reverse
  
  def exercise07[A](array: Array[A]): Array[A] = array.distinct
  
  def exercise08(arrayBuffer: ArrayBuffer[Int]): Unit = {
    val indexes = for (i <- arrayBuffer.indices if arrayBuffer(i) < 0) yield i
    for (j <- indexes.drop(1).reverse) {
      arrayBuffer.remove(j)
    }
  }
  
  def exercise09: Array[String] =
  java.util.TimeZone.getAvailableIDs.collect {
    case timeZone if timeZone.startsWith("America/") => timeZone.drop(8)
  }

def exercise10 = {
  import java.awt.datatransfer._
  val flavors: SystemFlavorMap = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer
}
}
