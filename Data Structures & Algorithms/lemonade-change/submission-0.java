class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for(int bill:bills){
          
          if(bill == 5) {
            five++;
          }
          else if(bill == 10){    
             
             if(five == 0) return false;

             five--; //5 gaye
             ten++; //10 aaye, total 5 aane chaiye

          }

          else { // bill == 20

            if(ten>0 && five>0){
                ten--;
                five--;
            }
            else if (five>=3){
                five -= 3 ;
            } 
            else  return false;

          }

        }

        return true;
        
    }
}

//18-nov-2026