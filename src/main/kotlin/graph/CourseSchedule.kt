package graph

import java.util.*
import kotlin.collections.ArrayList

class CourseSchedule {

    fun callSolution(){
        //[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
        val adjacencyMatrix = arrayOf(
            intArrayOf(0,10),
            intArrayOf(3,18),
            intArrayOf(5,5),
            intArrayOf(6,11),
            intArrayOf(11,14),
            intArrayOf(13,1),
            intArrayOf(15,1),
            intArrayOf(17,4)



        )
        val isCourseFinish=canFinish(20,adjacencyMatrix)
        println()
        println("Course Schedule")
        println("Can course be finished: $isCourseFinish")
    }

    private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var adj=ArrayList<ArrayList<Int>>()
        if(prerequisites.isNotEmpty()){
            for(i in 0 until numCourses){
                adj.add(ArrayList())
            }
            for(arr in prerequisites ){
                var u=arr[0]
                var v=arr[1]
                adj[v].add(u)
            }

            return topologicalSortByBfs(adj)
        }

        return true

    }


    fun topologicalSortByBfs(adjList:ArrayList<ArrayList<Int>>):Boolean{
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
        for(i in 0 until tList.size){
            print(" ${tList[i]} ")
        }

        return tList.size==adjList.size



    }
}