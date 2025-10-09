class Solution {
    public long minTime(int[] skill, int[] mana) {
        int numWizards = skill.length;
        long[] completionTime = new long[numWizards];

        for (int potionMana : mana) {
            // Update first wizard
            completionTime[0] = completionTime[0] + (long) skill[0] * potionMana;
            
            // Forward pass: calculate completion times
            for (int i = 1; i < numWizards; i++) {
                completionTime[i] = Math.max(completionTime[i], completionTime[i - 1]) + (long) skill[i] * potionMana;
            }
            
            // Backward pass: adjust completion times
            for (int i = numWizards - 2; i >= 0; i--) {
                completionTime[i] = completionTime[i + 1] - (long) skill[i + 1] * potionMana;
            }
        }
        
        return completionTime[numWizards - 1];
    }
}