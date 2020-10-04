import scala.annotation.tailrec

object Chapter02 {
  val isEven: Int => Boolean = _ % 2 == 0

  /**
    * A signum function.
    * @return 1 if x is positive, -1 if x is negative, and 0 if x is 0.
    */
  def exercise01(x: Int): Int =
    x match {
      case x if x > 0 => 1
      case x if x < 0 => -1
      case 0          => 0
    }

  /**
    * Exercise 02:
    * Q: What is the value of an empty block expression {}?
    * What is its type?
    * A: The value is () and the return type is Unit.
    */

  /**
    * Come up with the situation where the assignment x = y = 1
    * is valid in Scala. (Hint: Pick a suitable type for x.)
    */
  def exercise03(): Unit = {
    var y = 0
    def x = y = 1
  }

  /**
    *
    * @return equivalent for the Java loop
    * for (int i = 10; i >= 0; i--)
    *   System.out.println(i);
    */
  def exercise04: Seq[Unit] = for (i <- 10 to 0 by -1) yield println(i)

  /**
    *
    * @return prints the numbers from n to 0.
    */
  def exercise05(n: Int): Unit = {
    def countdown(n: Int): Seq[Unit] = {
      val step = if (n > 0) -1 else 1
      for (i <- n to 0 by step) yield println(i)
    }
  }

  /**
    *
    * @return the product of the Unicode codes of all letters in s
    */

  def exercise06(s: String): Int =
    (for (c <- s) yield c.toInt).product

  /**
    * This method does not use a for loop.
    * @return the product of the Unicode codes of all letters in s
    */
  def exercise07(s: String): Long =
    s.foldLeft(1L)((prod, ch) => prod * ch.toLong)

  /**
    *
    * @return the product of the Unicode codes of all letters in s
    */
  def exercise08(s: String): Long =
    s.foldLeft(1L)((prod, ch) => prod * ch.toLong)

  /**
    * A recursive solution.
    * @return the product of the Unicode codes of all letters in s
    */
  def exercise09(s: String): Long = {
    @tailrec
    def iter(s: String, acc: Long): Long =
      if (s.isEmpty) acc else iter(s.tail, acc * s.head.toLong)
    iter(s, 1)
  }

  /**
    * Function that computes x raised to the power of n.
    * @return x raised to the power of n.
    */
  def exercise10(x: Int, n: Int): Double =
    n match {
      case n if isEven(n) && n > 0 =>
        exercise10(x, n / 2) * exercise10(x, n / 2)
      case n if !isEven(n) && n > 0 => x * exercise10(x, n - 1)
      case 0                        => 1
      case n if n < 0               => 1 / exercise10(x, -n)
    }
}
