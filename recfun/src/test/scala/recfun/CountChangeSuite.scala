package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  test("countChange: 5 of 1,2,3") {
    assert(countChange(5,List(1,2,3)) === 5)
  }

  test("countChange: 0 of 1,2,3 is 0") {
    assert(countChange(0,List(1,2,3)) === 0)
  }

  test("countChange: 0 of Nil is 0") {
    assert(countChange(0,Nil) === 0)
  }

  test("countChange: 4 of Nil is 0") {
    assert(countChange(4,Nil) === 0)
  }

}
