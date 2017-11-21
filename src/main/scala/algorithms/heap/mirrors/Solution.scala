package algorithms.heap.mirrors

import scala.collection.mutable.ListBuffer

object Solution {
  def solution(num: Int): Int = {
    val numStr = Math.abs(num).toString
    val numStrArr = numStr.toArray.map(c => c.toString)
    val accum = new Accum[String]
    val permutations = genPermutations(numStrArr)
    permutations.distinct.count(str => !(str startsWith "0"))
  }

  def genPermutations(arr: Array[String]): Array[String] = {
    val permutationAccum = new Accum[String]
    gen(arr.length, arr, permutationAccum)
    permutationAccum.get.toArray
  }

  // this looks like best article http://ruslanledesma.com/2016/06/17/why-does-heap-work.html#heap
  private def gen(n: Int, arr: Array[String], accum: Accum[String]): Unit = {
    if (n == 1) {
      accum ++ arr.mkString("")
    } else {
      0 until n foreach { i =>
        n % 2 match {
          case 0 => swap(arr, 0, n - 1)
          case 1 => swap(arr, i, n - 1)
        }
        gen(n - 1, arr, accum)
      }
    }
  }

  private def swap(arr: Array[String], i1: Int, i2: Int): Unit = {
    val tmp = arr(i1)
    arr(i1) = arr(i2)
    arr(i2) = tmp
  }

  private class Accum[T] {
    private var buf = ListBuffer[T]()

    def ++(value: T): Unit = buf += value

    def get: List[T] = buf.toList
  }

}
