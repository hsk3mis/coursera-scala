val x = List(('a', 2), ('b', 1), ('c', 1))
val y = List(('a', 1), ('b', 2))


//val res: List[(Char, Int)] = y foldLeft[List[(Char, Int)]](x)((xs: List[(Char, Int)], el: (Char, Int)) => xs)



val a: List[Int] = List(1,2,3)
val b = List(4,5)
//b foldLeft(a)((xs, e) => xs ++ List(e))
a.foldLeft(0)((a, b) => a + b)