import Foundation

func solution(_ numbers:[Int]) -> Int {
    let sortedNumbers = numbers.sorted(by: >)
    return sortedNumbers[0] * sortedNumbers[1]
}