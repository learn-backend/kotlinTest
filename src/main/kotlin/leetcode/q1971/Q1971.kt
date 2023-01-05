package leetcode.q1971

// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

object Q1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        if (source == destination) {
            return true
        }

        val check = BooleanArray(n)
        val graph = Array(destination + 1) { HashSet<Int>() }

        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        if (graph[source].contains(destination)) {
            return true
        }

        val q = ArrayDeque<Int>()
        var v = source

        q.add(source)
        check[v] = true

        while (q.isNotEmpty()) {
            v = q.removeFirst()

            for (i in graph[v]) {
                if (i == destination) {
                    return true
                }

                if (!check[i]) {
                    q.add(i)
                    check[i] = true
                }
            }
        }
        return false
    }
}
