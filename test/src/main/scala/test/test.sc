import scala.annotation.tailrec

@tailrec
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)


def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)


def factorialTailRec(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)
  loop(1, n)
}



/** Pascal's Triangle */
def pascal(c: Int, r: Int): Int =
  if (c == 0 || c == r) 1
  else pascal(c - 1, r - 1) + pascal(c, r - 1)

/** Combinatoric solution:  pascal(c, r) =  r! / (c! * (r - c)!) */

assert(pascal(0, 2) == 1)
assert(pascal(1, 2) == 2)
assert(pascal(1, 3) == 3)


/** Parentheses Balancing */
def balance(chars: List[Char]): Boolean = {
  def balanceTailRec(balance: Int, chars: List[Char]): Boolean =
    if (balance < 0) false
    else if (chars.isEmpty) (balance == 0)
    else {
      if (chars.head == '(') balanceTailRec(balance + 1, chars.tail)
      else if (chars.head == ')') balanceTailRec(balance - 1, chars.tail)
      else balanceTailRec(balance, chars.tail)
    }
  balanceTailRec(0, chars)
}

assert(balance("(if (zero? x) max (/ 1 x))".toList) == true)
assert(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList) == true)
assert(balance(":-)".toList) == false)
assert(balance("())(".toList) == false)


/** Counting Change */
def countChange(money: Int, coins: List[Int]): Int = {
  if (money == 0) 1
  else if (money < 0 || coins.isEmpty) 0
  else countChange(money - coins.head, coins) + countChange(money, coins.tail)
}

val countChangeFor4List1 = countChange(4, List(1)) == 1
val countChangeFor4List2 = countChange(4, List(2)) == 1

val countChangeFor2List1234 = countChange(2, List(1, 2, 3, 4)) //1+1, 2
val countChangeFor4List12 = countChange(4, List(1, 2)) //1+1+1+1, 1+1+2, 2+2
val countChangeFor0Nil = countChange(0, Nil) == 1
val countChangeFor0List12 = countChange(0, List(1, 2)) == 1
val countChangeFor4Nil = countChange(4, Nil) == 0

