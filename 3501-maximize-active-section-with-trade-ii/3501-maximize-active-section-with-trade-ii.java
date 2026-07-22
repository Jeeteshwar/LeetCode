import java.util.*;

class ZeroGrp {
    int startIdx;
    int len;
    ZeroGrp(int startIdx, int len) {
        this.startIdx = startIdx;
        this.len = len;
    }
}

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String sections_, int[][] queries_) {
        int totSections = sections_.length();
        int totOnes = 0;
        List<ZeroGrp> zeroGrps = new ArrayList<>();
        int[] lastZeroGrpId = new int[totSections];
        Arrays.fill(lastZeroGrpId, -1);

        int idx = 0, grpId = -1;
        // Chunk the string by contiguous identical characters
        while (idx < totSections) {
            int startIdx = idx;
            char c = sections_.charAt(startIdx);
            while (idx < totSections && sections_.charAt(idx) == c) {
                idx++;
            }
            int sectionLen = idx - startIdx;
            
            // Record contiguous groups of zeros
            if (c == '0') {
                grpId++;
                zeroGrps.add(new ZeroGrp(startIdx, sectionLen));
            } else {
                totOnes += sectionLen;
            }
            
            // Map every index to the most recently encountered zero-group ID
            for (int i = startIdx; i < idx; i++) {
                lastZeroGrpId[i] = grpId;
            }
        }

        // No inactive sections available to trade
        if (zeroGrps.isEmpty()) {
            return new ArrayList<>(Collections.nCopies(queries_.length, totOnes));
        }

        int totAdjPairs = Math.max(0, zeroGrps.size() - 1);
        int maxLog2Step = 32 - Integer.numberOfLeadingZeros(Math.max(1, totAdjPairs));
        if (totAdjPairs == 0) maxLog2Step = 0;
        int[] sparseTbl = new int[Math.max(1, maxLog2Step) * totAdjPairs];

        // Construct a sparse table for O(1) Range Maximum Queries
        if (totAdjPairs > 0) {
            for (int pairIdx = 0; pairIdx < totAdjPairs; pairIdx++) {
                sparseTbl[pairIdx] = zeroGrps.get(pairIdx).len + zeroGrps.get(pairIdx + 1).len;
            }

            for (int logStep = 1; logStep < maxLog2Step; logStep++) {
                for (int pairIdx = 0; pairIdx + (1 << logStep) <= totAdjPairs; pairIdx++) {
                    int currIdx = logStep * totAdjPairs + pairIdx;
                    int prevIdx1 = (logStep - 1) * totAdjPairs + pairIdx;
                    int prevIdx2 = (logStep - 1) * totAdjPairs + pairIdx + (1 << (logStep - 1));
                    sparseTbl[currIdx] = Math.max(sparseTbl[prevIdx1], sparseTbl[prevIdx2]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(queries_.length);
        for (int i = 0; i < queries_.length; i++) {
            int qrStart = queries_[i][0];
            int qrEnd = queries_[i][1];

            int leftGrpId = lastZeroGrpId[qrStart];
            int rightGrpId = lastZeroGrpId[qrEnd];

            int firstFullyEnclosedGrpId = leftGrpId + 1;
            int lastFullyEnclosedGrpId = rightGrpId - (sections_.charAt(qrEnd) == '0' ? 1 : 0);

            // Calculate available lengths for zero-groups truncated by query boundaries
            int firstPartialGrpId = leftGrpId == -1 ? -1 :
                (zeroGrps.get(leftGrpId).len - (qrStart - zeroGrps.get(leftGrpId).startIdx));
            int lastPartialGrpId = rightGrpId == -1 ? -1 :
                (qrEnd - zeroGrps.get(rightGrpId).startIdx + 1);

            int maxTotMergedZeros = 0;

            // Case 1: Max sum from pairs entirely inside the query range
            if (firstFullyEnclosedGrpId < lastFullyEnclosedGrpId) {
                int l = firstFullyEnclosedGrpId, r = lastFullyEnclosedGrpId - 1;
                if (l <= r) {
                    int rngLen = r - l + 1;
                    int logStep = 31 - Integer.numberOfLeadingZeros(rngLen);
                    int tblIdx1 = logStep * totAdjPairs + l;
                    int tblIdx2 = logStep * totAdjPairs + r - (1 << logStep) + 1;
                    maxTotMergedZeros = Math.max(maxTotMergedZeros, 
                        Math.max(sparseTbl[tblIdx1], sparseTbl[tblIdx2]));
                }
            }
            // Case 2: Query boundaries truncate two distinct adjacent zero-groups
            if (sections_.charAt(qrStart) == '0' && sections_.charAt(qrEnd) == '0' && 
                leftGrpId + 1 == rightGrpId) {
                maxTotMergedZeros = Math.max(maxTotMergedZeros, 
                    firstPartialGrpId + lastPartialGrpId);
            }
            // Case 3: Left boundary truncates a group, adjacent group is fully enclosed
            if (sections_.charAt(qrStart) == '0' && 
                leftGrpId + 1 < rightGrpId + (sections_.charAt(qrEnd) == '1' ? 1 : 0)) {
                maxTotMergedZeros = Math.max(maxTotMergedZeros, 
                    firstPartialGrpId + zeroGrps.get(leftGrpId + 1).len);
            }
            // Case 4: Right boundary truncates a group, prior group is fully enclosed
            if (sections_.charAt(qrEnd) == '0' && leftGrpId < rightGrpId - 1) {
                maxTotMergedZeros = Math.max(maxTotMergedZeros, 
                    lastPartialGrpId + zeroGrps.get(rightGrpId - 1).len);
            }

            ans.add(totOnes + maxTotMergedZeros);
        }

        // Process all queries and materialize results into a list
        return ans;
    }
}