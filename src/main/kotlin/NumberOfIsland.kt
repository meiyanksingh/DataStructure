import java.util.*

class NumberOfIsland {
    fun numIslands(grid: Array<CharArray>): Int {

        var row =grid.size
        var col=grid[0].size
        println(" row: ${row}  col: ${col}")

        var visited=Array(row){BooleanArray(col){false}}
        var count=0;
        for (i in grid.indices) {
            for(j in grid[0].indices){
                if(!visited[i][j] && grid[i][j]=='1'){
                    ++count;
                    bfs(i,j,grid,visited)
                }
            }
        }
        return count
    }





    fun bfs(r:Int,c:Int,grid: Array<CharArray>, visited:Array<BooleanArray>)
    {
        val queue = LinkedList<Pair<Int,Int>>()
        var nr=r
        var nc=c
        visited[nr][nc]=true
        queue.add(Pair(r,c))
        while (!queue.isEmpty())
        {
            //println(queue.poll())
            var p=queue.pop()
          var  nx=p.first
          var  ny=p.second

            var ax=intArrayOf(0,1,0,-1)
            var ay=intArrayOf(-1,0,1,0)
            for(i in 0..3){
                nr =nx+ ax[i]
                nc =ny+ay[i]


                if(nr>=0 && nr<grid.size && nc>=0 && nc<grid[0].size && !visited[nr][nc] && grid[nr][nc]=='1'  )

                {


                    println(" [${nr}][${nc}]")
                    visited[nr][nc]=true
                    queue.add(Pair(nr,nc))

                }
            }
        }





    }

    fun isNbrWater(i:Int,j:Int,grid: Array<CharArray>):Boolean{
        for(r in -1..1){
            for(c in -1..1){
                if(r==c)
                    continue
                var row=i+r
                var col=j+c

                if(row>=0 && row<grid.size && col>=0 && col<grid[0].size){
                    if(grid[row][col]=='1'){
                        return false
                    }
                }
            }
        }

        return true;
    }
}