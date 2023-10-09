package graph

import java.util.*
import kotlin.collections.ArrayList

class CourseSchedule2 {

    fun callSolution(){
        //[[1,0],[2,0],[3,1],[3,2]]
        val adjacencyMatrix = arrayOf(
            intArrayOf(1,0),
            intArrayOf(2,0),
            intArrayOf(3,1),
            intArrayOf(3,2)



        )

      val validCourse=  findOrder(4,adjacencyMatrix)
        println()
        println("valid courses: ")
        for(element in validCourse){
            print(" $element ")
        }
        println()

    }
    private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj=ArrayList<ArrayList<Int>>()
        if(prerequisites.isNotEmpty()){
            for(i in 0 until numCourses){
                adj.add(ArrayList())
            }
            for(arr in prerequisites ){
                val u=arr[0]
                val v=arr[1]
                adj[v].add(u)
            }

            return topologicalSortByBfs(adj)
        }
        val arr= IntArray(numCourses)
        var j=0;
        for(i in numCourses-1 downTo 0){
            arr[j]=i
            ++j
        }

        return arr

    }

    fun topologicalSortByBfs(adjList:ArrayList<ArrayList<Int>>):IntArray{
        val queue= LinkedList<Int>()
        val inorderList=IntArray(adjList.size)
        val tList=ArrayList<Int>()
        for(i in 0 until adjList.size){


            for(nbr in adjList[i]){
                inorderList[nbr]++
            }



        }

        for(i in inorderList.indices){
            println("=$i: ->${inorderList[i]}")
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

        if(tList.size!=adjList.size)
        {
            return intArrayOf()
        }


        return tList.toIntArray()



    }
}