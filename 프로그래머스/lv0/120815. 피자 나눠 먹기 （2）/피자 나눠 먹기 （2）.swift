import Foundation

func gcd(_ a: Int, _ b: Int = 6) -> Int {
    return b == 0 ? a: gcd(b, a % b)
}

func solution(_ n:Int) -> Int {
    let lcm = (n * 6) / gcd(n)
    return lcm / 6
}

//최소공배수를 6으로 나눈 몫 