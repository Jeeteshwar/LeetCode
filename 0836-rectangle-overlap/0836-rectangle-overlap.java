class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
                // rec = [x1, y1, x2, y2]
                        // (x1, y1) = bottom-left corner
                                // (x2, y2) = top-right corner
                                        
                                                // Two rectangles overlap if and only if their projections
                                                        // on BOTH the x-axis and y-axis overlap.
                                                                
                                                                        // Check if they do NOT overlap on the x-axis
                                                                                boolean noOverlapX = rec1[2] <= rec2[0] || rec2[2] <= rec1[0];
                                                                                        
                                                                                                // Check if they do NOT overlap on the y-axis
                                                                                                        boolean noOverlapY = rec1[3] <= rec2[1] || rec2[3] <= rec1[1];
                                                                                                                
                                                                                                                        // They overlap only if they overlap on both axes
                                                                                                                                return !noOverlapX && !noOverlapY;
                                                                                                                                    }
                                                                                                                                    }
