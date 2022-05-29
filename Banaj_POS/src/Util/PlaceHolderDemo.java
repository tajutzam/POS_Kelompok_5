/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author user
 */

public class PlaceHolderDemo {

    
    
    
    
  public void addPlaceHolder(JTextField field){
      
      Font font = field.getFont();
      font = font.deriveFont(Font.ITALIC);
      field.setFont(font);
      field.setForeground(Color.GRAY);
  }  
  public static void removeAddPlaceHolder(JTextField field){
      
      Font font = field.getFont();
 
      field.setFont(font);
      field.setForeground(new Color(90, 90, 90));
      
  }
    
    
}
