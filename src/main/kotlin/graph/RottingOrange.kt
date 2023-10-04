package graph

import java.util.*

class RottingOrange {
    fun solution(){
        val adjacencyMatrix = arrayOf(
            intArrayOf(2,1,1),
            intArrayOf(1,1,1),
            intArrayOf(0,1,1)


        )

       println("Number of time to be rotten is :  ${orangesRotting(adjacencyMatrix)}")
    }

    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue= LinkedList<Pair<Pair<Int,Int>,Int>>()
        var time=0
        var ansTime=0

        for(i in 0..grid.size-1){
            for(j in 0..grid[0].size-1){
                if(grid[i][j]==2){
                    queue.add(Pair(Pair(i,j),0))
                }
            }
        }



        val x=intArrayOf(-1,0,1,0)
        val y=intArrayOf(0,1,0,-1)

        while(!queue.isEmpty()){
            val p=queue.poll()
            val row=p.first.first
            val col=p.first.second
            time=p.second


            for(i in 0..3){
                val  nRow=row+x[i]
                val  nCol=col+y[i]
                if(nRow>=0 && nCol>=0 &&
                    nRow<grid.size && nCol<grid[row].size &&
                    grid[nRow][nCol]==1){
                    ansTime=kotlin.math.max(time+1,ansTime)
                    queue.add(Pair(Pair(nRow,nCol),time+1))
                    grid[nRow][nCol]=2


                }
            }


        }




        for(i in 0..grid.size-1){
            for(j in 0..grid[i].size-1){
                if(grid[i][j]==1){
                    ansTime=-1
                    break
                }
            }
        }
        return ansTime

    }
}