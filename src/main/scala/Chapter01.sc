//Chapter 1 - The Basics
import scala.math.{BigInt, pow, sqrt}
import scala.util.Random

//1. In the Scala REPL, type 3. followed by the Tab key. What methods can applied?
//A:
//  !=   >             floatValue      isValidInt     to               toRadians
//  %    >=            floor           isValidLong    toBinaryString   toShort
//  &    >>            getClass        isValidShort   toByte           unary_+
//  *    >>>           intValue        isWhole        toChar           unary_-
//  +    ^             isInfinite      longValue      toDegrees        unary_~
//  -    abs           isInfinity      max            toDouble         underlying
//  /    byteValue     isNaN           min            toFloat          until
//  <    ceil          isNegInfinity   round          toHexString      |
//  <<   compare       isPosInfinity   self           toInt
//  <=   compareTo     isValidByte     shortValue     toLong
//  ==   doubleValue   isValidChar     signum         toOctalString


//2. In the Scala REPL, compute the square root of 3, and then square that value.
//By how much does the result differ from 3? (Hint: The res variables are your friends.)
pow(sqrt(3), 2) - 3

//3. Are res variables val or var?
//A: They are vals.

//4. Scala lets you multiply a string with a number -- try out "crazy" * 3 in the REPL.
//What does this operation do? Where can you find it in Scaladoc?
//A: Returns the string concatenated n times. Can be found in scala.collection.StringOps.*

//5. What does 10 max 2 mean? In which class is the max method defined?
//A: Called on a number of Int/Short/Byte/etc and given the parameter that of the same type,
//the number gets implicitly converted to RichInt/RichShort/RichByte/etc, and max returns
//the number if it is greater than the parameter or is equal to the parameter or the parameter otherwise.

//6. Using BigInt, compute 2 ^ 1024
BigInt(2).pow(1024)

//7. What do you need to import so that you can get a random prime as probablePrime(100, Random),
//without any qualifiers before probablePrime and Random?
//A: scala.util.Random and scala.math.BigInt.probablePrime

//8. One way to create random file or directory names is to produce a random BigInt and
//convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
//Poke around ScalaDoc to find a way of doing this in Scala.
BigInt.probablePrime(100, Random).toString(36)

//9. How do you get the first character of a string in Scala? The last character?
//A: By calling `head`/`headOption` and `last`/`takeRight(1)` methods.

//10. What do the take, drop, takeRight, and dropRight string functions do?
//What advantage or disadvantage do they have over using substring?
//A: drop/dropRight return the string without its n first/last chars,
//take/takeRight return the string's n first/last chars.
//The differences between them and substring are:
//- these StringOps operations use slice method which delegates to String.substring.
//- substring can throw IndexOutOfBoundsException.
//- substring is less readable.
//- substring doesn't allow one to treat a String as a sequential collection of chars.
