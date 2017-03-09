package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
  
  /**
   * Exercise 2
   */
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
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeRec(money: Int, coins: List[Int]): Int = {
        if (money == 0) 1
        else if (money < 0 || coins.isEmpty) 0
        else countChangeRec(money - coins.head, coins) + countChangeRec(money, coins.tail)
      }

      if (money == 0) 0
      else countChangeRec(money, coins);
    }

  }
