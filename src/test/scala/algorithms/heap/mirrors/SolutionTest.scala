package algorithms.heap.mirrors

import org.scalatest.FunSuite

class SolutionTest extends FunSuite {
  test("should be 1 permutations for 1") {
    assertResult(1) {
      Solution.genPermutations(Array("1")).length
    }
  }

  test("should be 2 permutations for 12") {
    assertResult(2) {
      Solution.genPermutations(Array("1", "2")).length
    }
  }

  test("should be 6 permutations for 123") {
    assertResult(6) {
      Solution.genPermutations(Array("1", "2", "3")).length
    }
  }

  test("should be 24 permutations for 1234") {
    assertResult(24) {
      Solution.genPermutations(Array("1", "2", "3", "4")).length
    }
  }

  test("should be no mirrors for 0") {
    assertResult(0) {
      Solution.solution(0)
    }
  }

  test("should be 1 mirror for 1") {
    assertResult(1) {
      Solution.solution(1)
    }
  }

  test("should be 1 mirror for 10") {
    assertResult(1) {
      Solution.solution(10)
    }
  }

  test("should be 2 mirror for 12") {
    assertResult(2) {
      Solution.solution(12)
    }
  }

  test("should be 1 mirror for 100") {
    assertResult(1) {
      Solution.solution(100)
    }
  }

}
