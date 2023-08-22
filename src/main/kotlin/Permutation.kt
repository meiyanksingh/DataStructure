class Permutation {

    var listOfPermutation= ArrayList<String>()

    fun isAvailable(s2:String):Boolean{
        for(item in listOfPermutation){
            println(item)
            if(s2.contains(item))
             return true;
        }
        return false;
    }

    fun getPermutation(s1:String,s2:String,startIndex:Int):Boolean{
        var s1=s1;
        //println(" startIndex ->$startIndex")
        //println(" s1 length ->${s1.length}")
        if(startIndex>=s1.length){
           // println(s1)
            listOfPermutation.add(s1)
            return s2.contains(s1)
        }

        val j=startIndex;
        for(i in j until  s1.length){

             s1=swapChar(s1,i,j)
            getPermutation(s1,s2,startIndex+1)
            s1=swapChar(s1,i,j)
        }

        return s2.contains(s1)

    }

    fun swapChar(s1:String,i:Int,j:Int):String{
        val charArray=s1.toCharArray();
//        println("i->$i")
//        println("j->$j")
        charArray[i]=charArray[j].also { charArray[j]=charArray[i] }

        str=String(charArray)
       // println("swapped -> $str")
       var s1=str;
        return str;
    }
}