package leetcode.q91


// https://leetcode.com/problems/decode-ways/
fun main() {
    val result = numDecodings("06")
    println(result)
}

fun numDecodings(s: String): Int {
    if(s.isEmpty()) return 0
    val list = IntArray(s.length+1)

    list[0] = 1
    list[1] = if(s[0]=='0') 0 else 1
    for (i in 2 .. s.length)
    {
        val one = s.substring(i-1,i).toInt()
        val two = s.substring(i-2,i).toInt()

        if(one >= 1)
            list[i] += list[i-1]

        if(two in 10 .. 26)
            list[i] += list[i-2]
    }
    return list[s.length]
}