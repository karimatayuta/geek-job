
package Class;
import java.util.Calendar;


public class Calendar04 {
    public static void main(String[] args){
        
        Calendar c = Calendar.getInstance();//カレンダー１インスタンスの作成。
        c.set(2015, 1, 1, 0, 0, 0);
        
        Calendar d = Calendar.getInstance();//カレンダー２インスタンスの作成。
        d.set(2015, 12, 31, 23, 59, 59);
        
        
        
        long diffTime = d.getTimeInMillis() - c.getTimeInMillis();//タイムスタンプの差分。
        System.out.print(diffTime);//タイムスタンプの差分を表示する。
        
    }
    
}
