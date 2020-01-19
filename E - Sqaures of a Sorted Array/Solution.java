class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int positive = 0;
        while(positive < N && A[positive] < 0)
            positive++;
        int negative = positive - 1;
        
        int[] result = new int[N];
        int index = 0;
        
        while(negative >= 0 && positive < N) {
            if(A[negative] * A[negative] > A[positive] * A[positive]) {
                result[index++] = A[positive] * A[positive];
                positive++;
            } else {
                result[index++] = A[negative] * A[negative];
                negative--;
            }
        }
        while(negative >= 0) {
            result[index++] = A[negative] * A[negative];
            negative--;
        }
        while(positive < N) {
            result[index++] = A[positive] * A[positive];
            positive++;
        }
        return result;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
// Memory Usage: 51 MB, less than 5.48% of Java online submissions for Squares of a Sorted Array.

class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }    
        Arrays.sort(A);
        return A;
    }
}

// Runtime: 2 ms, faster than 66.24% of Java online submissions for Squares of a Sorted Array.
// Memory Usage: 50.6 MB, less than 5.48% of Java online submissions for Squares of a Sorted Array.