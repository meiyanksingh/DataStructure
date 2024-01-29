package string

/*Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"
Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/
class ReOrganizeString {
    fun printReOrganizeString(){
       println("aaabc - > ${reorganizeString("aaabc")}")
    }

    private fun reorganizeString(s: String): String {
        var sb=StringBuilder(s)
        var hash=IntArray(26){0}
        for(element in s){
            hash[element.code - 'a'.code]++
        }

        var maxCount=0
        var maxFrequecyChar=0
        for(i in 0..25){
            if(hash[i]>maxCount){
                maxCount=hash[i]
                maxFrequecyChar=i+ 'a'.code
            }
        }

        var index=0
        while(index<s.length && maxCount>0){
            sb[index]=maxFrequecyChar.toChar()
            --maxCount
            index += 2
        }

        if(maxCount!=0){
            return ""
        }

        hash[maxFrequecyChar- 'a'.code]=0
        for(i in 0..25){
            while(hash[i]>0){

                if(index>s.length-1){
                    index=1
                }
                sb[index]=(i+'a'.toInt()).toChar()
                index += 2
                hash[i]--
            }
        }
        return sb.toString()

    }
}