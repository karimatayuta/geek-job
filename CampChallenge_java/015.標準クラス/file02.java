/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperation;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author karimatayuuta2
 */
public class file02 {
    public static void main(String[] args){
    
        try{
        
        File file02 = new File("File01");
        
        FileReader fl = new FileReader(file02);
        
        int ch = fl.read();
        while(ch != -1){
        System.out.print((char)ch);

        ch = fl.read();
        }
        
        fl.close();
        }catch(IOException e){
            System.out.print(e);
        }
}
}
