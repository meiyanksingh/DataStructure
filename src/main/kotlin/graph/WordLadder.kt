package graph

import java.util.*
import kotlin.collections.ArrayList

class WordLadder {

    fun solution(){
        val list=ArrayList<String>()
        //["hot","dot","dog","lot","log","cog"]
        list.add("hot")
        list.add("dot")
        list.add("dog")
        list.add("lot")
        list.add("log")
        list.add("cog")

       val count= ladderLength("hit","cog",list)
        println("word ladder count $count")
    }
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val list= arrayListOf<String>()
        list.addAll(wordList)

        val set=list.toMutableSet()





        val queue=LinkedList<Pair<String,Int>>()
        var currentWord=beginWord
        var count=1
        var p=Pair(beginWord,count)
        queue.add(p)

        list.remove(currentWord)
        while(!queue.isEmpty()){
            p=queue.poll()
            currentWord=p.first

            count =p.second
            if(currentWord==endWord){
                return count
            }
            for(i in currentWord.indices){
                var c:Char = 'a'
                var orgnalWord=currentWord
                while(c<='z'){

                    currentWord= currentWord.substring(0, i) + c + currentWord.substring(i + 1)
                    if(set.contains(currentWord)){

                        queue.add(Pair(currentWord,count+1))
                        set.remove(currentWord)




                    }

                    ++c;
                }
                currentWord=orgnalWord
            }

        }


        return 0;
    }
}