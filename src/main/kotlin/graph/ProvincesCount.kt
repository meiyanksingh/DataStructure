package graph

import java.util.*

class ProvincesCount {

    fun showNoOfProvince(){
        val adjacencyMatrix = arrayOf(
            intArrayOf(1,0,0,0,0,0,0,0,0,1,0, 0, 0, 0, 0),
            intArrayOf(0,1,0,1,0,0,0,0,0,0,0, 0, 0, 1, 0),
            intArrayOf(0,0,1,0,0,0,0,0,0,0,0, 0, 0, 0, 0),
            intArrayOf(0,1,0,1,0,0,0,1,0,0,0, 1, 0, 0, 0),
            intArrayOf(0,0,0,0,1,0,0,0,0,0,0, 0, 1, 0, 0),
            intArrayOf(0,0,0,0,0,1,0,0,0,0,0, 0, 0, 0, 0),
            intArrayOf(0,0,0,0,0,0,1,0,0,0,0, 0, 0, 0, 0),
            intArrayOf(0,0,0,1,0,0,0,1,1,0,0, 0, 0, 0, 0),
            intArrayOf(0,0,0,0,0,0,0,1,1,0,0, 0, 0, 0, 0),
            intArrayOf(1,0,0,0,0,0,0,0,0,1,0, 0, 0, 0, 0),
            intArrayOf(0,0,0,0,0,0,0,0,0,0,1, 0, 0, 0, 0),
            intArrayOf(0,0,0,1,0,0,0,0,0,0,0, 1, 0, 0, 0),
            intArrayOf(0,0,0,0,1,0,0,0,0,0,0, 0, 1, 0, 0),
            intArrayOf(0,1,0,0,0,0,0,0,0,0,0, 0, 0, 1, 0),
            intArrayOf(0,0,0,0,0,0,0,0,0,0,0, 0, 0, 0, 1)

        )

        println("No of province ${findCircleNum(adjacencyMatrix)}")
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var visited=BooleanArray(isConnected.size){ _ ->false}
        var count=0;
        for(i in 0..isConnected.size-1 ){
            if(!visited[i]){
                ++count;
                dfs(visited,i,isConnected)
                //bfs(visited,i,isConnected)

            }
        }

        return count;

    }

    fun dfs(visited:BooleanArray,src:Int,isConnected: Array<IntArray>){
        visited[src]=true;
        var col=isConnected[src].size
        for(i in 0..col-1){
            if(!visited[i] && i!=src && isConnected[src][i]==1){
                bfs(visited,i,isConnected);
            }
        }
    }

    fun bfs(visited:BooleanArray,src:Int,isConnected: Array<IntArray>){
        visited[src]=true;
        var source=src
        var col=isConnected[source].size
        print(col)
        val queue= LinkedList<Int>()
        queue.add(source)
        while(!queue.isEmpty()){
            var currentVertex=queue.poll()
            println("poll: ")
            print(currentVertex)
            println("")
            for(i in 0 until col){
                if( !visited[i] && i!=currentVertex && isConnected[currentVertex][i]==1  ){
                    queue.add(i)
                    visited[i]=true

                }
            }



        }

    }
}