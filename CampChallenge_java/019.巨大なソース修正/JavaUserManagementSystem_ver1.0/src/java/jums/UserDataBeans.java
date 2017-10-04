//Servletと連携しクライアントからのデータを保存し、JSPと連携しJSPから保存したデータを参照します。
package jums;

//Javabeansのルール
//java.io.Serializableを実装していること
//クラスはpublicパッケージに所属している
//publicで引数のないコンストラクタ（初期化処理）を持つ
//フィールドは隠匿化されている。（カプセル化・private）
//getter/setterを持つ
import java.io.Serializable;


//クラス名の後ろに「implements Serializable」を追記し、シリアライズ可能にする。
//シリアライズとはメモリ上のデータを変換し、ファイルに保存＆ネットワークに送信できるようになる。
public class UserDataBeans implements Serializable{
    
    //publicで引数のないコンストラクタ {}の中の記述はなし
    public UserDataBeans(){}
    
    //フィールドの作成と隠匿化（private） 宣言と同時に初期化
    //データを保存する変数を宣言する。
    private String name0 ="";
    private String year0 ="";
    private String month0="";
    private String day0  ="";
    private String type0 ="";
    private String tell0 ="";
    private String comment0 ="";
    
    //getterとは、あるフィールドから情報を取り出すメソッド
    //getterの命令規則：getで開始し、以降の単語の頭文字を大文字にする。
    //ただし、「boolean」はisで開始する。
    public String getName(){
        return this.name0;
    }
    public String getYear(){
        return this.year0;
    }
    public String getMonth(){
        return this.month0;
    }
    public String getDay(){
        return this.day0;
    }
    public String getType(){
        return this.type0;
    }
    public String getTell(){
        return this.tell0;
    }
    public String getComment(){
        return this.comment0;
    }
    
    
    //setterとはあるフィールドへ情報を格納するメソッド
    //setterの命令規則：setで開始し、以降の単語の頭文字を大文字で入力する。
    public void setName(String name){
        this.name0=name;
    }
    public void setYear(String year){
        this.year0=year;
    }
    public void setMonth(String month){
        this.month0=month;
    }
    public void setDay(String day){
        this.day0=day;
    }
    public void setType(String type){
        this.type0=type;
    }
    public void setTell(String tell){
        this.tell0=tell;
    }
    public void setComment(String comment){
        this.comment0=comment;
    }
}
