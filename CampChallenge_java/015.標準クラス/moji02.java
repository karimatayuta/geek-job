
package moji;


public class moji02 {
    public static void main(String[] args){
        String mail = "ignorantbeginner@gmail.com";
        
        int mailad= mail.indexOf("@");
        
        System.out.print(mail.substring(mailad));
        
    }
    
}
//String変数.substring("指定した位置")
//しかし、指定した位置を見つけるのは大変なので、指定した位置を探してくれるプログラムを使う。
//それが、String変数.indexof()なので、これをを使う。
