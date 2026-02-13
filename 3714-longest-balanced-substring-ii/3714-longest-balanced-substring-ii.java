class Solution {
    public int longestBalanced(String s) {
        char[] characters = s.toCharArray();
        int singleCharMax = calculateSingleChar(characters);
        int twoCharMax = Math.max(
            calculateTwoChar(characters, 'a', 'b'), 
            Math.max(
                calculateTwoChar(characters, 'b', 'c'), 
                calculateTwoChar(characters, 'a', 'c')
            )
        );
        int threeCharMax = calculateThreeChar(characters);
        
        return Math.max(singleCharMax, Math.max(twoCharMax, threeCharMax));
    }

    private int calculateSingleChar(char[] characters) {
        int maxLength = 0;
        int index = 0;
        int length = characters.length;
        
        while (index < length) {
            int nextIndex = index + 1;
            while (nextIndex < length && characters[nextIndex] == characters[index]) {
                nextIndex++;
            }
            maxLength = Math.max(maxLength, nextIndex - index);
            index = nextIndex;
        }
        return maxLength;
    }

    private int calculateTwoChar(char[] characters, char firstChar, char secondChar) {
        int maxLength = 0;
        int index = 0;
        int length = characters.length;
        
        while (index < length) {
            // Skip characters that are neither firstChar nor secondChar
            while (index < length && characters[index] != firstChar && characters[index] != secondChar) {
                index++;
            }
            
            // Track balance between firstChar and secondChar
            Map<Integer, Integer> balanceMap = new HashMap<>();
            balanceMap.put(0, index - 1);
            int balance = 0;
            
            // Process consecutive segment containing only firstChar and secondChar
            while (index < length && (characters[index] == firstChar || characters[index] == secondChar)) {
                balance += (characters[index] == firstChar) ? 1 : -1;
                Integer previousIndex = balanceMap.get(balance);
                
                if (previousIndex != null) {
                    maxLength = Math.max(maxLength, index - previousIndex);
                } else {
                    balanceMap.put(balance, index);
                }
                index++;
            }
        }
        return maxLength;
    }

    private int calculateThreeChar(char[] characters) {
        Map<Long, Integer> diffMap = new HashMap<>();
        diffMap.put(encodeDiff(0, 0), -1);

        int[] counts = new int[3]; // counts[0] for 'a', counts[1] for 'b', counts[2] for 'c'
        int maxLength = 0;

        for (int i = 0; i < characters.length; i++) {
            char currentChar = characters[i];
            counts[currentChar - 'a']++;
            
            int diffAB = counts[0] - counts[1];
            int diffAC = counts[1] - counts[2];
            long encodedDiff = encodeDiff(diffAB, diffAC);

            Integer previousIndex = diffMap.get(encodedDiff);
            if (previousIndex != null) {
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                diffMap.put(encodedDiff, i);
            }
        }
        return maxLength;
    }

    private long encodeDiff(int diffAB, int diffAC) {
        // Shift by 100000 to handle negative values, then pack into a single long
        return (diffAB + 100000) << 20 | (diffAC + 100000);
    }
}