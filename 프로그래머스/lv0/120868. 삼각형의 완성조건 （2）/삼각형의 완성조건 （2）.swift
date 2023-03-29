import Foundation

func solution(_ sides:[Int]) -> Int {
    var result = [Int]()
    var num1 = sides[0]
    var num2 = sides[1]
    for i in ((abs(num1 - num2) + 1)..<num1+num2) {
        result.append(i)
    }
    
    
    return result.count
}