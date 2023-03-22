import Foundation

func factorial(_ n: Int) -> Int {
    if n == 0 {
        return 1
    }
    return n * factorial(n - 1)
}


func solution(_ n:Int) -> Int {
    var result = 1
    for i in (1...n) {
        print("i = \(i), factorial = \(factorial(i))")
      guard factorial(i) <= n else {
          print("i = \(i)")
          return i - 1
      }
       result = i
    } 
    return result
}
