package peanoNumbers

abstract class Natural {
  def isZero: Boolean
  def predecessor: Natural
  def successor: Natural = new Succ(this)
  def + (that: Natural): Natural
  def - (that: Natural): Natural
}

object Zero extends Natural {
  override def isZero = true
  override def predecessor = throw new NoSuchElementException
  override def +(that: Natural) = that
  override def -(that: Natural) = if (that.isZero) Zero else throw new NoSuchElementException
}

class Succ(n: Natural) extends Natural {
  override def isZero = false
  override def predecessor = n
  override def +(that: Natural) = new Succ(n + that)
  override def -(that: Natural) = if (that.isZero) this else n - that.predecessor
}
