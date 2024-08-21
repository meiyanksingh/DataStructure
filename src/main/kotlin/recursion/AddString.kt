package recursion

class AddString {
    var ans=StringBuilder()
    var n1=""
    var n2=""



    private fun addRecursively(i:Int,j:Int, carry:Int){
        if(i<0 && j< 0){
            if(carry!=0){
                ans.append(carry)

            }
            return;
        }

        val val1=if(i<0 || n1[i]=='0')  '0'-'0' else n1[i]-'0'
        val val2=if(j<0 || n2[j]=='0')  '0'-'0' else n2[j]-'0'
        val sum=val1+val2+carry
        val c=sum/10
        val res=sum%10
        ans.append(res)

        addRecursively(i-1,j-1,c)
    }
    private fun addStrings(num1: String, num2: String): String {

        n1=num1
        n2=num2

        addRecursively(num1.length-1,num2.length-1,0)
        return ans.reversed().toString();
    }

    fun runSolution(){
        addStrings("456","77")
        println(" Add of \"456\",\"77\" Answer ${ans.reversed().toString()}")
        ans.clear()
        addStrings("123234321333333333","23232")
        println("Add of \"123234321333333333\",\"23232\" Answer ${ans.reversed().toString()}")

    }
}