class QuickSort {
    fun quickSort(arr: IntArray, s: Int, e: Int) {
        if (s >= e)
            return
        val pivotIndex: Int = partition(arr, s, e)
        println (" privot index-> $pivotIndex ,")

        quickSort(arr, s, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, e)


    }

    fun partition(arr: IntArray,  s: Int, e: Int): Int {

        var pivotIndex = s;
        var pivotElement = arr[s]
        var count = 0;


        for(i in s until e+1){

            if(arr[i]<=arr[pivotIndex]){

                count++;

            }
        }
        var rightIndex=count+s;

        arr[pivotIndex]=arr[rightIndex].also { arr[rightIndex]=arr[pivotIndex] }
        pivotIndex = rightIndex;
        var i=s;
        var j=e;

        while(i<pivotIndex && j> pivotIndex){
            while(arr[i]<=pivotElement){
                ++i;
            }
            while(arr[j]>pivotElement){
                --j;
            }
            if(i<pivotIndex && j>pivotIndex){
                arr[i]=arr[j].also { arr[j]=arr[i] }

            }
        }





        return pivotIndex
    }
}