
package moji;


//以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、結果を表示してください。
//「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」
public class moji03 {
    public static void main(String[] args){
    String moja ="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
    
    String moja01 = moja.replace("I", "い");
    String moja02 = moja01.replace("U","う");
    System.out.println(moja02);   
    }
    
}
//文字の入れ替えを行うときは、String変数.replace(置換前,置換後)を使う。
//しかし、一文字分の置換しか入れられないため工夫する。
//一度変換した変数に、再度新しく置換するための変数を使う。
//完成した変数を表示すれば完成する。
