# Chapter 2. Control Structures and Functions  

### [To the main page](/Scala-for-the-impatient)  

_1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero.  
Write a function that computes this value._  
```scala
def signum(x: Int): Int = x match {
  case x if x > 0 => 1
  case x if x < 0 => -1
  case 0          => 0
}
```    

_2. What is the value of an empty block expression {}? What is its type?_  
**The value is () and the return type is Unit.**

_3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a
suitable type for x.)_  
```scala
var y = 0
def x: Unit = y = 1
```  

_4. Write a Scala equivalent for the Java loop_
```java
for (int i = 10; i >= 0; i--)  
  System.out.println(i);
```  
```scala
for (i <- 10 to 0 by -1) yield println(i)
```  

_5. Write a procedure countdown(n: Int) that prints the numbers from n to 0._  
```scala
def countdown(n: Int): Seq[Unit] = {
  val step = if (n > 0) -1 else 1
  for (i <- n to 0 by step) yield println(i)
}
```  

_6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For
example, the product of the characters in "Hello" is 9415087488L._  
```scala
(for (char <- string) yield char.toInt).product
```

_7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)_  
```scala
string.foldLeft(1L)((prod, char) => prod * char.toLong)
```

_8. Write a function product(s : String) that computes the product, as described in the preceding
exercises._  
```scala
def product(string: String): Long =
  string.foldLeft(1L)((prod, char) => prod * char.toLong)
```  

_9. Make the function of the preceding exercise a recursive function._  
```scala
def product(s: String): Long = {
  @tailrec
  def iter(s: String, acc: Long): Long =
    if (s.isEmpty) acc else iter(s.tail, acc * s.head.toLong)
  iter(s, 1)
}
```  

_10. Write a function that computes xn, where n is an integer. Use the following recursive definition:_  
• xn = y2 if n is even and positive, where y = xn / 2.
• xn = x·xn – 1 if n is odd and positive.
• x0 = 1.
• xn = 1 / x–n if n is negative.
_Don’t use a return statement._  
```scala
def exercise10(x: Int, n: Int): Double = n match {
    case n if isEven(n) && n > 0 =>
      exercise10(x, n / 2) * exercise10(x, n / 2)
    case n if !isEven(n) && n > 0 => x * exercise10(x, n - 1)
    case 0                        => 1
    case n if n < 0               => 1 / exercise10(x, -n)
}
```  

### [To the main page](/Scala-for-the-impatient)
