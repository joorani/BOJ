import Foundation

func solution(_ slice:Int, _ n:Int) -> Int {
    let res = n / slice
    if n % slice == 0 {
        return res
    } else {
        return res + 1
    }
}