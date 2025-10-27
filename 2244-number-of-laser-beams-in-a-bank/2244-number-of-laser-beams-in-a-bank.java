class Solution {
    public int numberOfBeams(String[] securityGrid) {
        if (securityGrid == null || securityGrid.length == 0) {
            return 0;
        }
        
        int beamCount = 0;
        int previousLaserCount = countLasers(securityGrid[0]);
        
        for (int rowIndex = 1; rowIndex < securityGrid.length; rowIndex++) {
            int currentLaserCount = countLasers(securityGrid[rowIndex]);
            
            if (currentLaserCount == 0) {
                continue;
            }
            
            beamCount += previousLaserCount * currentLaserCount;
            previousLaserCount = currentLaserCount;
        }
        
        return beamCount;
    }
    
    private int countLasers(String rowData) {
        int laserCount = 0;
        for (char cellValue : rowData.toCharArray()) {
            if (cellValue == '1') {
                laserCount++;
            }
        }
        return laserCount;
    }
}
