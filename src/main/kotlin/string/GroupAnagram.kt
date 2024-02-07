package string

/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]] */

class GroupAnagram {

    fun solution(){
        var strs= arrayOf("eat","tea","tan","ate","nat","bat")
        println(groupAnagrams(strs))
    }
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var result = ArrayList<ArrayList<String>>()
        if (strs.isEmpty()) {
              return result


        }
        var map=HashMap<String,ArrayList<String>>()
        for(str in strs){


            var sortedStr=String(str.toCharArray().apply { sort() })

            var list= map[sortedStr]
            if(list ==null ){
                list= ArrayList<String>()
            }
            list.add(str)
            map.put(sortedStr,list)

        }

        for((k,v) in map){
            var newList=ArrayList<String>()
            for(list in v){
                newList.add(list)
            }
            result.add(newList)
        }

        return result
    }
}