import Foundation

func solution(_ my_string:String) -> [Int] {
    return Array(my_string).filter { $0.isNumber }.sorted().map { Int(String($0))!}
}