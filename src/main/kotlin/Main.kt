import dynamic_programming.Fibonacci

val a=arrayOf(1,2,3,4,5,6,7,8);

val arr=IntArray(5){4}

fun reverseArray(  i:Int){
 if(i>=a.size/2){
     return
 }

    swap(i,a.size-1-i)
    reverseArray(i+1)

}


var values = intArrayOf(3,2,1);
var subList= ArrayList<Int>()
var size=2;
fun subsequence(list: ArrayList<Int>, i : Int){
if(i>size){
    list.forEach { print(it)}
println()
    return
}
    list.add(values[i])
    println("value of i $i")
    subsequence(list,i+1)
    println("After adding value of i $i")
    var lastIndext=list.size-1;
    list.removeAt(lastIndext)
    subsequence(list,i+1)

}

var s:String="madam"
fun palindrom(i:Int):Boolean{
    if(i>s.length/2)
        return true;

    if(s[i]!=s[s.length-i-1])
        return false;

    return palindrom(i+1)


}

fun fibonacci(n:Int) : Int{
    if(n<=1)
        return 1

    return fibonacci(n-1)+fibonacci(n-2)
}

fun swap(i:Int, n:Int){
    a[i]=a[n]+a[i]
    a[n]=a[i]-a[n]
    a[i]=a[i]-a[n]
}



var ans=ArrayList<ArrayList<Int>>();
var output=ArrayList<Int>()
var outputValue=ArrayList<Int>();

var str = "";
fun getSubsequence(nums:ArrayList<Int>,index:Int){
    if(index>=nums.size){


        println(" ")
        str+="[ "
        output.forEach{
            outputValue.add(it)
            str += it
            print(it)}
        str+=" ] "

        ans.add(outputValue);
        outputValue=ArrayList<Int>();
      return ;
    }

    output.add(nums[index])
    getSubsequence(nums,index+1);

    output.removeLast()

    getSubsequence(nums,index+1);


}
fun main(args: Array<String>) {

    // BFS ------------------>

    var bfsGraph=BfsGraph(4)
    bfsGraph.addEdge(0, 1);
    bfsGraph.addEdge(0, 2);
    bfsGraph.addEdge(0, 3);
    bfsGraph.addEdge(2, 0);
    bfsGraph.addEdge(2, 3);
    bfsGraph.addEdge(3, 2);

    bfsGraph.showGraph()

    println()
   bfsGraph.bfs(2)
    var visited=BooleanArray(4){ _ ->false}
    val parent=IntArray(4){_ -> -1}
    println("dfs-->")
    bfsGraph.dfs(2,visited)

    visited=BooleanArray(4){ _ ->false}
    var isCycle=bfsGraph.findCycleUsingBFS(0,visited,parent)

    println(" cyle available: ${isCycle}")


//    var map=HashMap<Int,Int>()
//
//    var fibByDp=Fibonacci();
//    println("fib:${fibByDp.fib(6,map)}")


//    val ratInMaze=RatInMaze()
//    ratInMaze.findPath()

//    var p=Permutation()
//
//  var isPermutation=  p.getPermutation("prosperity","properties",0)
//    println("is permutation ${p.isAvailable("properties")}")



//    var qSort=QuickSort();
//    var arr= intArrayOf(3,2,1,4,1,5,3,9,11,23,21)
//    var s1:String="heloo"
//
//    for(num in arr){
//        print("${num} ,")
//    }
//    qSort.quickSort(arr,0,10)
//    println(" sortent list ")
//    for(n in arr){
//        print("${n} ,")
//    }

//    var nums=ArrayList<Int>()
//    nums.add(3)
//    nums.add(2)
//    nums.add(1)
//
//
//
//
//
//    getSubsequence(nums,0)
//  //  println(str)
//
//        ans.forEach{
//        print("[ ")
//        it.forEach {
//            print( it )
//        }
//        print(" ]  ")
//    };


//    println("Hello World!")
//    a.forEach { print(it) }
//    println()
//    reverseArray(0)
//    a.forEach { print(it) }
//
//    println()
//
//    println("${s[0]}")
//    println("$s is palindrom : ${palindrom(0)}");
//
//    var fib:Int=fibonacci(6)
//
//    println("fibonacci of 6: $fib")

//    subsequence(subList,0);

}