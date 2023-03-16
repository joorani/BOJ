import Foundation

func solution(_ angle:Int) -> Int {
    var result: Int = 0
    switch angle {
    case ..<90:
        result = 1
    case 90:
        result = 2
    case ..<180:
        result = 3
    default:
        result = 4
    }
    
    
    return result
}