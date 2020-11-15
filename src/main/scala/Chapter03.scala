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
}
