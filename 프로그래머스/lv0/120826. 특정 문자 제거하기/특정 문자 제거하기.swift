import Foundation

func solution(_ my_string:String, _ letter:String) -> String {
    var result = ""
my_string.forEach {
    if $0 != Character(letter) {
        result = result + String($0)
    }
}
    return result
}