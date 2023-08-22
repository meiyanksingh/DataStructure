import java.util.*
import kotlin.collections.ArrayList

class BfsGraph(var v: Int) {
    var adjList=ArrayList<ArrayList<Int>>()



    init {
        for(i in 0 until v){
            adjList.add(ArrayList())
        }
    }

    fun addEdge(v:Int,w:Int){
        adjList[v].add(w)
      //  adjList[w].add(v)
    }

    fun showGraph(){
        for((i, list) in adjList.withIndex()){
            println()
            print(i)
            print(" :")
            for(value in list){
                print(" $value ")
            }
        }
    }

    fun bfs(vertex:Int){
        val visited=BooleanArray(v)

        val queue = LinkedList<Int>()

        visited[vertex]=true
        queue.add(vertex)
        while (!queue.isEmpty()){
            println(queue.poll())

            for(value in adjList[vertex]){
                if(!visited[value]){
                    visited[value]=true;
                    queue.add(value)
                }
            }
        }



    }

    fun findCycleUsingBFS(src:Int,visited: BooleanArray,parent:IntArray):Boolean{
        visited[src]=true;
        val queue = LinkedList<Int>()
        queue.add(src)
        parent[src]=-1
        while(!queue.isEmpty()){
            var p=queue.poll();
            for(value in adjList[p]){
                if(!visited[value]){
                    visited[value]=true
                    queue.add(value)
                    parent[value]=p
                }
                else {
                  if(parent[value]!=p){
                      // cycle present
                      return true
                  }
                }
            }

        }


        return false;
    }

    fun dfs(vertex:Int, visited:BooleanArray){
           visited[vertex]=true
           print(" $vertex ")

      adjList[vertex].forEachIndexed{ index, element ->
          run {
              if (index != 0 && !visited[element]) {
                  dfs(element, visited)
              }
          };
       }


    }
}


