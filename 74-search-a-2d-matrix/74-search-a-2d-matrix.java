class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowNum = 0;
        //find rowNum in which target might be present using single for loop
        for(int i=0;i<rows;i++) {
            if(target>=matrix[i][0] && target<=matrix[i][cols-1])
                rowNum = i;
        }
        int arr[] = new int[cols];
        int idx = 0;
        for(int i=0;i<cols;i++) {
            arr[i] = matrix[rowNum][idx];
            idx++;
        }
        //apply binary search in the rowNum of matrix;
        return binarySearch(arr, target);
    }
    private boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(target==arr[mid])
                return true;
            else if(target>arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    } 
}