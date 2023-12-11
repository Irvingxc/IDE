/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Irving Calix
 */
public class Encargados {
    private int id;
    private String Nombres;
    private String Apellidos;

    public Encargados(int id, String Nombres, String Apellidos) {
        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    @Override
    public String toString() {
        return Nombres+ " "+ Apellidos;
    }
    
    
    
}
