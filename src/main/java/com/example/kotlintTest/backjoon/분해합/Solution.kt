
fun sum(k: Int): Int {
    var k = k
    var ret = k
    while (k > 0) {
        ret += k % 10
        k /= 10
    }
    return ret
}

fun main() {
    val N = readLine()!!.toInt()
    var M = 0

    for (i in 0 until N) {
        if (N == sum(i)) {
            M = i
            break
        }
    }
    println(M)
}