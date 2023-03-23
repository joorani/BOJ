import Foundation

func solution(_ n:Int) -> [Int] {
    var num = n
    var primeArray = (2...num).filter { isPrime($0) }
    var result = Set<Int>()

    for prime in primeArray {
        if num % prime == 0 {
            result.insert(prime)
            while num % prime == 0 {
                num /= prime
            }
        }
    }
    return result.sorted()
}

func isPrime(_ n: Int) -> Bool {
    var i = 2
    while i * i <= n {
        if n % i == 0 {
            return false
        }
        i += 1
    }
    return true
}
