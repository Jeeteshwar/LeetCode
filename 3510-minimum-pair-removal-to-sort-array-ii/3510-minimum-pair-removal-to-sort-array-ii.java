class Solution {
    
    private static class Segment implements Comparable<Segment> {
        int originalIndex;
        long totalValue;
        long mergeCost;
        Segment leftSegment;
        Segment rightSegment;
        
        Segment(int idx, long val) {
            originalIndex = idx;
            totalValue = val;
        }
        
        @Override
        public int compareTo(Segment other) {
            if (rightSegment == null || other.rightSegment == null) {
                return rightSegment == null ? 1 : -1;
            }
            long costDifference = mergeCost - other.mergeCost;
            if (costDifference != 0) return costDifference < 0 ? -1 : 1;
            return originalIndex - other.originalIndex;
        }
    }
    
    public int minimumPairRemoval(int[] nums) {
        TreeSet<Segment> activeSegments = new TreeSet<>();
        int violationCount = 0;
        
        Segment currentSegment = null;
        
        for (int i = 0; i < nums.length; i++) {
            Segment newSegment = new Segment(i, nums[i]);
            
            if (currentSegment != null) {
                if (newSegment.totalValue < currentSegment.totalValue) {
                    violationCount++;
                }
                
                currentSegment.rightSegment = newSegment;
                newSegment.leftSegment = currentSegment;
                
                currentSegment.mergeCost = currentSegment.totalValue + newSegment.totalValue;
                activeSegments.add(currentSegment);
            }
            currentSegment = newSegment;
        }
        
        activeSegments.add(currentSegment);
        
        int totalOperations = 0;
        
        while (violationCount > 0) {
            totalOperations++;
            
            Segment bestMergeCandidate = activeSegments.pollFirst();
            Segment rightNeighbor = bestMergeCandidate.rightSegment;
            
            if (rightNeighbor.totalValue < bestMergeCandidate.totalValue) {
                violationCount--;
            }
            
            bestMergeCandidate.totalValue += rightNeighbor.totalValue;
            bestMergeCandidate.mergeCost = bestMergeCandidate.totalValue + 
                (rightNeighbor.rightSegment != null ? rightNeighbor.rightSegment.totalValue : 0);
            
            bestMergeCandidate.rightSegment = rightNeighbor.rightSegment;
            if (rightNeighbor.rightSegment != null) {
                if (rightNeighbor.rightSegment.totalValue < rightNeighbor.totalValue) {
                    violationCount--;
                }
                rightNeighbor.rightSegment.leftSegment = bestMergeCandidate;
                if (bestMergeCandidate.totalValue > rightNeighbor.rightSegment.totalValue) {
                    violationCount++;
                }
            }
            
            activeSegments.remove(rightNeighbor);
            activeSegments.add(bestMergeCandidate);
            
            Segment leftNeighbor = bestMergeCandidate.leftSegment;
            if (leftNeighbor != null) {
                activeSegments.remove(leftNeighbor);
                
                if (leftNeighbor.totalValue > leftNeighbor.mergeCost - leftNeighbor.totalValue) {
                    violationCount--;
                }
                if (leftNeighbor.totalValue > bestMergeCandidate.totalValue) {
                    violationCount++;
                }
                
                leftNeighbor.mergeCost = leftNeighbor.totalValue + bestMergeCandidate.totalValue;
                leftNeighbor.rightSegment = bestMergeCandidate;
                
                activeSegments.add(leftNeighbor);
            }
        }
        
        return totalOperations;
    }
}