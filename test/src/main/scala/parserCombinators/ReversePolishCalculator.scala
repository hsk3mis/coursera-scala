package parserCombinators

import scala.util.parsing.combinator._

/**
  * This trait provides the mathematical operations which the calculator can perform.
  */
trait Maths {
  def add(x: Float, y: Float) = x + y
  def sub(x: Float, y: Float) = x - y
  def mul(x: Float, y: Float) = x * y
  def div(x: Float, y: Float) = if (y > 0) (x / y) else 0.0f
}

/**
  * This class is the complete Reverse Polish parser and calculator
  * JavaTokenParsers is extended in order to use the floatingPointNumber parser
  * Maths is extended to provide the underlying mathematical operations
  */
class ReversePolishCalculator extends JavaTokenParsers with Maths {
  /**
    * Takes an expression, which consists of N repetitions of a term followed by an operator
    * In case you are wondering, the parser combinators used here are as follows:
    *  |   => The ablternation combinator, it parses successfully if either the left or right side match
    *  ~   => This combinator forms a sequential combination of it's operands (ex. a~b expects a followed by b)
    *  ~>  => This combinator says "ensure the left operand exists, but don't include it in the result"
    *  <~  => This combinator says "ensure the right operand exists, but don't include it in the result"
    *  ^^  => This combinator says "if parsed successfully, transform the result using the block on the right"
    *  rep => This cominator says "expect zero or more repetitions of X"
    */

  def brackets: Parser[Float] = num | "(" ~> expr <~ ")" ^^ (_.toFloat)
  // Converts a floating point number as a String to Float
  def num: Parser[Float] = floatingPointNumber ^^ (_.toFloat)
  // Parses an operator and converts it to the underlying function it logically maps to
  def operator: Parser[(Float, Float) => Float] = ("*" | "/" | "+" | "-") ^^ {
    case "+" => add
    case "-" => sub
    case "*" => mul
    case "/" => div
  }

  def expr: Parser[Float] = rep(num | operator) ^^ {
    case terms =>
      var stack: List[Float] = List.empty;
      terms.foreach(t =>
        t match {
          case n: Float => stack = n :: stack
          case op: ((Float, Float) => Float) =>
            stack match {
              case a :: b :: rest => stack = op(a, b) :: rest
          }
        }
      )
      if (stack.size != 1) throw new IllegalArgumentException("Bad syntax ...")
      stack.head
  }
}

object ReversePolishCalculator extends ReversePolishCalculator {
  def main(input: String): Float = {
    parseAll(expr, input).get
  }
}
