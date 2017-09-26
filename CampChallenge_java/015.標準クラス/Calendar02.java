
package Class;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Calendar02 {

    public static void main(String[] args) {
        //現在時刻の作成
        Date now = new Date();
        
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        System.out.print(sdf.format(now));
        

    }

}
