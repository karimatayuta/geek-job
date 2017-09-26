
package Class;

import java.util.Calendar;
        

public class Calendar03 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016, 10, 4, 10, 0, 0);
        
        System.out.print(
                c.get(Calendar.YEAR)        + "年"+
                c.get(Calendar.MONTH)       + "月"+
                c.get(Calendar.DAY_OF_MONTH)+"月"+
                c.get(Calendar.HOUR_OF_DAY) +"日"+
                c.get(Calendar.MINUTE)      + "分"+
                c.get(Calendar.SECOND)      + "秒"
                     
        );
        
    }
    
    
}
