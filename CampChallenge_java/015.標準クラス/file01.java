/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author karimatayuuta2
 *///ファイルに自己紹介を書き出し、保存してください。
public class file01 {

    public static void main(String[] args) {

        try {
            File file01 = new File("file01");

            FileWriter fl = new FileWriter(file01);

            fl.write("狩俣佑太です。");

            fl.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
//ファイルを操作するには、例外として操作ができなくなることがあるのに何も対策をしていないと問題なので
//try~catchをつける必要がある。