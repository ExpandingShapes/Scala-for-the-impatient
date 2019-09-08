1.In the Scala REPL, type 3. followed by the Tab key. What methods can be
applied?

scala> 3.
!=   >>            isFinite        max              toFloat
%    >>>           isInfinite      min              toHexString
&    ^             isInfinity      round            toInt
*    abs           isNaN           self             toLong
+    byteValue     isNegInfinity   shortValue       toOctalString
-    ceil          isPosInfinity   sign             toRadians
/    compare       isValidByte     signum           toShort
<    compareTo     isValidChar     to               unary_+
<<   doubleValue   isValidInt      toBinaryString   unary_-
<=   floatValue    isValidLong     toByte           unary_~
==   floor         isValidShort    toChar           until
>    getClass      isWhole         toDegrees        |
>=   intValue      longValue       toDouble

2.In the Scala REPL, compute the square root of 3, and then square that value.
By how much does the result differ from 3? (Hint: The res variables are your
friend.)

scala> import scala.math._
import scala.math._

scala> val sqrtOfThree = sqrt(3)
sqrtOfThree: Double = 1.7320508075688772

scala> pow(sqrtOfThree, 2)
res1: Double = 2.9999999999999996

3.Are the res variables val or var?

Res variables are val.

4.Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
What does this operation do? Where can you find it in Scaladoc?

scala> "crazy" * 3
res2: String = crazycrazycrazy

final classStringOps extends AnyVal

def*(n: Int): String
Return the current string concatenated n times.

5.What does 10 max 2 mean? In which class is the max method defined?

final class RichInt(val self: Int) extends AnyVal with ScalaNumberProxy[Int] with RangedProxy[Int]
override def max(that: Int): Int = math.max(self, that)
Find the max of two numbers.

6.Using BigInt, compute 2^1024.

scala> val big: BigInt = 2
big: scala.math.BigInt = 2

scala> big.pow(1024)
res7: scala.math.BigInt = 17976931348623159077293051907890247336179769789423065727343
0081157732675805500963132708477322407536021120113879871393357658789768814416622492847
4306394741243777678934248654852763022196012460941194530829520850057688381506823424628
81473913110540827237163350510684586298239947245938479716304835356329624224137216

7.What do you need to import so that you can get a random prime as
probablePrime(100, Random), without any qualifiers before probablePrime and Random?

import scala.BigInt._
import scala.util.Random

8.One way to create random file or directory names is to produce a random
BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
Poke around Scaladoc to find a way of doing this in Scala.

scala> probablePrime(100,Random).toString(36)
res0: String = 28ly9ib8ol1cn1tdre9h

9.How do you get the first character of a string in Scala? The last character?

A.head - the first element of the sequence
A.last - the last element of the sequence

10.What do the take, drop, takeRight, and dropRight string functions do? What
advantage or disadvantage do they have over using substring?

def take(n: Int): String
A string containing the first n chars of this string.

def drop(n: Int): String
The rest of the string without its n first chars.

def takeRight(n: Int): String
A string containing the last n chars of this string.

def dropRight(n: Int): String
The rest of the string without its n last chars.

public String substring(int startIndex)
This method returns new String object containing the substring of the given string from specified startIndex (inclusive).

public String substring(int startIndex, int endIndex)
This method returns new String object containing the substring of the given string from specified startIndex to endIndex.
