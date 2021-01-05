# Chapter 1. The Basics  

_1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?_
```
!=   >             floatValue      isValidInt     to               toRadians
%    >=            floor           isValidLong    toBinaryString   toShort
&    >>            getClass        isValidShort   toByte           unary_+
*    >>>           intValue        isWhole        toChar           unary_-
+    ^             isInfinite      longValue      toDegrees        unary_~
-    abs           isInfinity      max            toDouble         underlying
/    byteValue     isNaN           min            toFloat          until
<    ceil          isNegInfinity   round          toHexString      |
<<   compare       isPosInfinity   self           toInt
<=   compareTo     isValidByte     shortValue     toLong
==   doubleValue   isValidChar     signum         toOctalString
```

_2. In the Scala REPL, compute the square root of 3, and then square that value. By how much does
the result differ from 3? (Hint: The res variables are your friend.)_
```scala
pow(sqrt(3), 2) - 3
```
**The difference is -4.440892098500626E-16**

_3. Are the res variables `val` or `var`?_  
**They are `val`s.**

_4. Scala lets you multiply a string with a number—try out `"crazy" * 3` in the REPL. What does this
operation do? Where can you find it in Scaladoc?_  
**Returns the string concatenated n times. Can be found in `scala.collection.StringOps`.**

_5. What does `10 max 2` mean? In which class is the `max` method defined?_  
**Called on a number of Int/Short/Byte/etc and given the parameter that of the same type,
the number gets implicitly converted to RichInt/RichShort/RichByte/etc,
and the number if it is greater than the parameter or is equal to the parameter or the parameter otherwise.**

_6. Using `BigInt`, compute 2 ^ 1024._
```scala
BigInt(2).pow(1024)
```

_7. What do you need to import so that you can get a random prime as `probablePrime(100, Random)`,
without any qualifiers before `probablePrime` and `Random`?_  
**`scala.util.Random` and `scala.math.BigInt.probablePrime`.**

_8. One way to create random file or directory names is to produce a random `BigInt` and convert it
to base 36, yielding a string such as `"qsnvbevtomcj38o06kul"`. Poke around Scaladoc to find a way of
doing this in Scala._
```scala
BigInt.probablePrime(100, Random).toString(36)
```

_9. How do you get the first character of a string in Scala? The last character?_  
**By calling `head`/`headOption` and `last`/`takeRight(1)` methods.**

_10. What do the `take`, `drop`, `takeRight`, and `dropRight` string functions do? What advantage or
disadvantage do they have over using `substring`?_  
**`take`/`takeRight` return the string's n first/last chars.
The differences between them and `substring` are:
- these `StringOps` operations use slice method which delegates to `String.substring`.
- `substring` can throw `IndexOutOfBoundsException`.
- `substring` is less readable.
- `substring` doesn't allow one to treat a `String` as a sequential collection of chars.**
