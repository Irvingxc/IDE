/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import java.awt.event.KeyEvent;

/**
 *
 * @author Calix
 */
public class Validaciones {
    
    public static void Space(int tam, KeyEvent e){
        if (tam==0 && e.getKeyChar()==KeyEvent.VK_SPACE) {
            e.consume();
            
        }
        
    }
    

}
