
package fileoperation;

import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class file03 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("file04");
            pw.println("処理の開始");
            pw.println("2017年9月5日18時00分00秒");
            pw.println("1~10の数字の中からランダムに数字を出します。");
            
              //Randomクラスのインスタンス化
            Random rnd = new Random();

            int ran = rnd.nextInt(10);
            String ran0 = String.valueOf(ran);
            pw.println("数字は" + ran0);
            pw.println("処理の終了");
            pw.close();
            
            File open = new File("file04");
            FileReader fr = new FileReader(open);
            BufferedReader br = new BufferedReader(fr);
            // 1行読み出し
            String str = br.readLine();
            while(str != null){
            System.out.println(str);

            str = br.readLine();
            }
            
            br.close();
            

        } catch (IOException e) {
            System.err.print(e);
        }
    }
}

