package dynamic_programming

class Fibonacci {
    fun  fib(n:Int,map:HashMap<Int,Int>) :Int{
        if(n==0 || n==1) {
           // print(" $n")
            return n
        }
        if(map[n]!=null)
            return map[n]!!
         val f=fib(n-1,map)+ fib(n-2,map)
         map.put(n,f);

        return f
    }
}