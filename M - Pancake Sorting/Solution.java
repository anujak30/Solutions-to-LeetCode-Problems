class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> answer = new ArrayList<Integer>();
        int N = A.length;
        for(int i = A.length; i > 0; i--) {
            int last = findLastIndex(A, i);
            answer.add(last + 1);
            reverseElements(last, A);
            answer.add(N);
            reverseElements(N - 1, A);
            N--;
        }
        return answer;        
    }
    
    public int findLastIndex(int[] A, int maxElement) {
        int position = 0;
        for(position = 0; position < A.length && A[position] != maxElement; position++);
        return position;
    }
    
    public void reverseElements(int last, int[] A) {
        int start = 0;
        while(start < last) {
            int temp = A[start];
            A[start++] = A[last];
            A[last--] = temp;
        }
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake Sorting.
// Memory Usage: 42.1 MB, less than 5.26% of Java online submissions for Pancake Sorting.