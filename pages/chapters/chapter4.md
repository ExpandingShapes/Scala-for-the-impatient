# Chapter 4. Maps and Tuples

_1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with
the same keys and the prices at a 10 percent discount._
```scala
val gizmos = Map("Smart Watches" -> 1200, "Shower Speaker" -> 650, "Portable Projector" -> 460)
for((gizmo, price) <- gizmos) yield (gizmo -> price * 0.9)
```

_2. Write a program that reads words from a file. Use a mutable map to count how often each word
appears. To read the words, simply use a `java.util.Scanner`:_
```scala
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) process in.next()
```
_Or look at Chapter 9 for a Scalaesque way.
At the end, print out all words and their counts._
```scala
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
```

_3. Repeat the preceding exercise with an immutable map._
```scala
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
```    

_4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order._
```scala    
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
```
    
_5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API._
```scala
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
```
    
_6. Define a linked hash map that maps `"Monday"` to `java.util.Calendar.MONDAY`, and similarly for the other
weekdays. Demonstrate that the elements are visited in insertion order._
```scala
mutable.LinkedHashMap[String, Int](
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY,
  "Sunday" -> java.util.Calendar.SUNDAY
)
```

_7. Print a table of all Java properties, like this:_
```
java.runtime.name        | Java(TM) SE Runtime Environment
sun.boot.library.path    | /home/apps/jdk1.6.0_21/jre/lib/i386
java.vm.version          | 17.0-b16
java.vm.vendor           | Sun Microsystems Inc.
java.vendor.url          | http://java.sun.com/
path.separator           | :
java.vm.name             | Java HotSpot(TM) Server VM
```
_You need to find the length of the longest key before you can print the table._
```scala
val KEY_VALUE_SEPARATOR = "    "
val properties = java.lang.System.getProperties.asScala
val maxKeyLength = properties.keys.maxBy(_.length).length
properties.keys.foreach { key =>
  println(s"$key${" " * (maxKeyLength - key.length)}$KEY_VALUE_SEPARATOR| ${properties(key)}")
}
```

_8. Write a function `minmax(values: Array[Int])` that returns a pair containing the smallest and largest
values in the array._
```scala
def minmax(values: Array[Int]): (Int, Int) = (values.min, values.max)
```

_9. Write a function `lteqgt(values: Array[Int], v: Int)` that returns a triple containing the counts of
values less than v, equal to v, and greater than v._
```scala
def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = (
  values.count(_ < v),
  values.count(_ == v),
  values.count(_ > v)
)
```

_10. What happens when you zip together two strings, such as `"Hello".zip("World")`? Come up with a
plausible use case._  
**You get a sequence of tuples consisting of `str1(0) -> str2(0)`, `str1(1) -> str2(1)`, etc.  
`Vector((H,W), (e,o), (l,r), (l,l), (o,d))`  
With `fold`, it is possible to check two strings for equality**
