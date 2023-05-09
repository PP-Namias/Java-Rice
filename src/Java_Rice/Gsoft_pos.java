/*
 * Java-Rice - An Interactive Food Ordering System group project for Intermediate Proggraming
 * 
 * Group Members:
 * 1. Kurt Daniel S. Cano
 * 2. Mike Rufino J. Caram II
 * 3. Joshua O. Lonoza
 * 4. Kevin A. Llanes
 * 5. Jhon Keneth Ryan B. Namias
 */

package Java_Rice;

import java.awt.Color;

public class Gsoft_pos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Progress p = new Progress();
        p.setVisible(true);
        
        try{
            for(int i = 0; i <= 100; i++){
                Thread.sleep(50);
                p.percent.setText(Integer.toString(i)+"%");
                
                Login log = new Login();
                if(i == 70){
                   p.system_load.setText("System ready. . .");
                }else if(i == 100){
                    log.show();
                    p.setVisible(false);  
                   
                }
            }
               }catch(Exception x){
             }
    }
    
}
