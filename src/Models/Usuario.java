/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Irving Calix
 */
public class Usuario {
    
    private String user;
    private String password;
    private String salt;
    private static String userlogeado;
    private static int userlogeadoid;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
        public static void setUsuarioLogeado(String usuario) {
        userlogeado = usuario;
    }

    public static String getUsuarioLogeado() {
        return userlogeado;
    }
    
    public static void setUsuarioLogeadoid(int usuario) {
        userlogeadoid = usuario;
    }

    public static int getUsuarioLogeadoid() {
        return userlogeadoid;
    }
  

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
