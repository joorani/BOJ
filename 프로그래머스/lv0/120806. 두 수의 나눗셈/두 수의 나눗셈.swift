import Foundation

func solution(_ num1:Int, _ num2:Int) -> Int {
    
    var temp: Double = Double(num1) / Double(num2)
    var res: Int = Int(temp * 1000)
    return res
}

