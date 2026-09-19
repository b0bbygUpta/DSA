// -- Leetcode 1401 -- 
// -- Circle and Rectangle Overlapping -- 

APPROACH I:
  
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int xclose=Math.max(x1,Math.min(xCenter,x2));
        int yclose=Math.max(y1,Math.min(yCenter,y2));

        int dx=xCenter-xclose;
        int dy=yCenter-yclose;

        return dx*dx+dy*dy <= (long) radius*radius;
        
    }
}
