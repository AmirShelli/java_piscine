fun rez(): Boolean {
    var numbers = mutableListOf<Int>()
    var count = 0
    for(i in 0..3) {
        numbers += readLine()!!.toInt()
    }
    for(i in 0..3){
        for(j in 0..3){
            if(numbers[i] == numbers[j])
                count++;
        }
        if(count == 2) return true else count = 0
    }
    return false
}
fun main(args: Array<String>) {
    println(rez())
}