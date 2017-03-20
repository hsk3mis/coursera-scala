val M = 5
val N = 3

(1 to M) flatMap (x => (1 to N) map (y => (x, y)))


def isPrime(n: Int): Boolean =
  (2 until n) forall (d => n % d != 0)

isPrime(13)
isPrime(23)
isPrime(757)


(for (i <- 1 to 4) yield i::Nil)

def combinationsRec = Nil
for {
  i <- 1 to 1
  xscomb <- combinationsRec
} yield ('a', i)