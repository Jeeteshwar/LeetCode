class Solution {
    public List<Integer> replaceNonCoprimes(int[] numbers) {
        List<Integer> resultStack = new ArrayList<>();
        
        for (int currentNumber : numbers) {
            while (!resultStack.isEmpty()) {
                int lastNumber = resultStack.get(resultStack.size() - 1);
                int greatestCommonDivisor = computeGCD(lastNumber, currentNumber);
                if (greatestCommonDivisor == 1) {
                    break;
                }
                // merge lastNumber with currentNumber using their LCM
                resultStack.remove(resultStack.size() - 1);
                currentNumber = (lastNumber / greatestCommonDivisor) * currentNumber;
            }
            resultStack.add(currentNumber);
        }
        
        return resultStack;
    }
    
    private int computeGCD(int first, int second) {
        if (second == 0) return first;
        return computeGCD(second, first % second);
    }
}
