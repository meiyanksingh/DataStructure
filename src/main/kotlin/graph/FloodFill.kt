package graph

import java.util.*

class FloodFill {
    fun callSolution(){
        val adjacencyMatrix = arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,0,0)
           // intArrayOf(1,0,1)


        )

        floodFill(adjacencyMatrix,1,0,2)
    }
    private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        var blueColor=image[sr][sc];
        var bc=blueColor
        return bfs(image,sr,sc,color,bc)
    }

    private fun bfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int, blueColor:Int): Array<IntArray>{

        var queue= LinkedList<Pair<Int,Int>>()
        queue.add(Pair(sr,sc))


        image[sr][sc]=color

        var x=intArrayOf(0,-1,0,1)
        var y=intArrayOf(-1,0,1,0)
        while(!queue.isEmpty()){
            var item=queue.poll()

            var row=item.first
            var col=item.second
            println("row , col : ${row} , ${col}")

            for(i in 0..3){
                var nx=x[i]+row
                var ny=y[i]+col
                println("nx , ny : ${nx} , ${ny}")
                println("blueColor : ${blueColor} ")

                if(nx>=0 && nx<image.size &&
                    ny>=0 && ny<image[nx].size &&
                    image[nx][ny]==blueColor &&
                    image[nx][ny]!=color
                ){
                    image[nx][ny]=color
                    println("image[nx][ny] :${nx} , ${ny}-> ${image[nx][ny]} ")
                    queue.add(Pair(nx,ny))
                }
            }

        }
        return image;
    }
}