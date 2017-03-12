def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)

product(x => x * x)(3, 4)

def factorial(n: Int) = product(x => x)(1, n)

factorial(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def product2(f: Int => Int)(a: Int, b:Int): Int =
  //mapReduce(f, (x, y) => x * y, 1)(a, b)
  mapReduce(f, _*_, 1)(a, b)

product2(x => x * x)(3, 4)



class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def g = 2;
  def numer = x*g //lazy evaluated
  val denom = y*g //eagerly evaluated

  override def toString: String = numer + " / " + denom
  def toStringOrigin: String = x + " / " + y
}

val twoThird = new Rational(2, 3)
twoThird.toString
twoThird.toStringOrigin

class A(x: Int, y: Int) {
  def toS: String = x + " / " + y
  def unary_- = new A(-x, -y)
}

def x = { println("x init"); 123 }
def y = { println("y init"); 456 }

val a = new A(x, y)
"-a = " + (-a).toS
"a.unary_- = " + a.unary_-.toS