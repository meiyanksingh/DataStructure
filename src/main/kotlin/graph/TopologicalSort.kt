package graph

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

class TopologicalSort(private var v: Int) {
    var list=ArrayList<ArrayList<Int>>()
    var stack= Stack<Int>()

    init {
        for(i in 0 until v){
            list.add(ArrayList())
        }
    }


    private fun addEdge(list:ArrayList<ArrayList<Int>>,v:Int, w:Int){
        list[v].add(w)

    }


    fun callTopologicalSort(){
        val visited=BooleanArray(v){ _ ->false}
        val graph=TopologicalSort(8)
        graph.addEdge(list,0,1)
        graph.addEdge(list,1,2)
        graph.addEdge(list,2,3)
        graph.addEdge(list,3,4)
        graph.addEdge(list,3,5)
        graph.addEdge(list,4,6)
        graph.addEdge(list,5,6)
        graph.addEdge(list,6,7)

        for(i in 0 until v){
            if(!visited[i]){
                toplogicalSortByDfs(i,visited,list,stack)
            }
        }


        println("topological order:----------->")
        println(stack)




        println("topological order by bfs:----------->")
        topologicalSortByBfs(list)


    }
    fun toplogicalSortByDfs(vertex:Int, visited:BooleanArray,adjList:ArrayList<ArrayList<Int>>,stack:Stack<Int>){
        visited[vertex]=true
        print(" $vertex ")

        adjList[vertex].forEachIndexed{ index, element ->
            run {
                if (index != 0 && !visited[element]) {
                    toplogicalSortByDfs(element, visited,adjList,stack)
                }
            };
        }
        // store vertex on stack while returning



        stack.add(vertex)


    }

    fun topologicalSortByBfs(adjList:ArrayList<ArrayList<Int>>){
        val queue= LinkedList<Int>()
        val inorderList=IntArray(adjList.size)
        val tList=ArrayList<Int>()
        for(i in 0 until adjList.size){


            for(nbr in adjList[i]){
                    inorderList[nbr]++
            }



        }

        for(i in inorderList.indices){

            if(inorderList[i]==0){
                queue.add(i)
            }

        }

        while(!queue.isEmpty()){
            var element=queue.poll()
            tList.add(element)
            for(nbr in adjList[element]){
                inorderList[nbr]--
                if(inorderList[nbr]==0){
                    queue.push(nbr)


                }
            }



        }
        for(i in 0 until tList.size){
            print(" ${tList[i]} ")
        }
    }



}