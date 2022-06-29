
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Coba {
      JProgressBar jb;
    int i=0,num=0;
    JFrame jf = new JFrame();
    JPanel panel = new JPanel();
    
    
    
    public Coba() {
        
       jb=new JProgressBar(0,2000);    
jb.setBounds(40,40,160,30);         
jb.setValue(0);    
jb.setStringPainted(true);    
jf.add(jb);    
jf.setSize(250,150);    
jf.setLayout(null);    
jf.setLocationRelativeTo(null);
jf.setVisible(true);

    }
    
    public void iterate(){
        while(i<=2000){
            jb.setValue(i);
            i=i+20;
            
           try{Thread.sleep(50);}catch(Exception e){}    
        }    
    }
    public static void main(String[] args) {
        Coba coba = new Coba();
        coba.iterate();
    }
    
}
