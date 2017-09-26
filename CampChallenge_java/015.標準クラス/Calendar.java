/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author karimatayuuta2
 */
public class Calendar {

    public static void main(String[] args) {
        //当日の日付情報を作成。
        Date d = new Date(2016, 0, 1, 0, 0, 0);

        
        System.out.print(d.getTime());
    }

}
