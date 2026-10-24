// -- Leetcode 2409 -- 
// -- Count Days Spent Together -- 



APPROACH I: 
  // Using Switch case to count days within a helper function 
  
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
    
        String asm=arriveAlice.substring(0,2);
        String asd=arriveAlice.substring(3);
        int salice=days(asm,asd);
        String aem=leaveAlice.substring(0,2);
        String aed=leaveAlice.substring(3);
        int ealice=days(aem,aed);

        String bsm=arriveBob.substring(0,2);
        String bsd=arriveBob.substring(3);
        int sbob=days(bsm,bsd);
        String bem=leaveBob.substring(0,2);
        String bed=leaveBob.substring(3);
        int ebob=days(bem,bed);

        int start=Math.max(salice, sbob);
        int end=Math.min(ealice, ebob);

        return Math.max(0, end-start+1);

    }

//    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

    private int days(String month, String date){
       
        int d=Integer.parseInt(date);
        int dayss=0;

        switch(month){
            case "01": dayss=d; break;
            case "02": dayss=31+d; break;
            case "03": dayss=59+d; break;
            case "04": dayss=90+d; break;
            case "05": dayss=120+d; break;
            case "06": dayss=151+d; break;
            case "07": dayss=181+d; break;
            case "08": dayss=212+d; break;
            case "09": dayss=243+d; break;
            case "10": dayss=273+d; break;
            case "11": dayss=304+d; break;
            case "12": dayss=334+d; break; 

            default: ;

        }
        return dayss;
    }
}


/* 
Complexities: 

    Time complexity: 
        O(1)
    Space complexity: 
        O(1)
*/
