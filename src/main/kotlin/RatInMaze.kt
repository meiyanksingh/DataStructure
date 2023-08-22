class RatInMaze {

    fun getPath(n:Int,srcX:Int,srcY:Int,move:String,ans:ArrayList<String>,arr:Array<Array<Int>>,vis:Array<Array<Int>>){
        if(srcX==n-1 && srcY==n-1){
            ans.add(move);
            return;
        }
        //D,U,L,R
        val xMoveList= intArrayOf(srcX+1,srcX-1,srcX,srcX )  // i
        val yMoveList= intArrayOf(srcY,srcY,srcY-1,srcY+1 )  // j
        val moveList= charArrayOf('D','U','L','R')

        for(i in 0 until (xMoveList.size)){
            if(xMoveList[i] in 0 until n && yMoveList[i]in 0 until n && arr[xMoveList[i]][yMoveList[i]]==1
                && vis[xMoveList[i]][yMoveList[i]]==0
            ) {
                vis[xMoveList[i]][yMoveList[i]] = 1;
                getPath(n, xMoveList[i], yMoveList[i], move+" "+moveList[i].toString(), ans, arr, vis)
                vis[xMoveList[i]][yMoveList[i]] = 0;
            }
        }
    }

    var arr= arrayOf(arrayOf(1, 0, 0, 0), arrayOf(1, 1, 0, 1), arrayOf(1, 1, 0, 0), arrayOf(0, 1, 1, 1))
    var vis=arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0), arrayOf(0, 0, 0, 0))
    var ans=ArrayList<String>();
    var n=arr.size
    var srcX=0;
    var srcY=0;
    var move=""

    fun findPath(){
        getPath(n,srcX,srcY,move,ans,arr,vis)
        for(i in 0 until ans.size){
            println(ans[i])
        }
    }

}