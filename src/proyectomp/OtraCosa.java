/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

/**
 *
 * @author Calix
 */
public class OtraCosa {
    public class Empleado {

    private String nombre;
    private String numeroIdentidad;
    private int edad;
    private boolean casado;
    private double salario;
    private String toString;

    public Empleado(String nombre, String numeroIdentidad, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.numeroIdentidad = numeroIdentidad;
        setEdad(edad);
        this.casado = casado;
        this.salario = salario;
        this.toString = toString();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
   this.edad = edad >  0 ? 0 : edad;

    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    public String getToString () {
        return toString;
    }

    public void  setToString(String tosString) {
            if(edad >= 18 && edad <=28){
                System.out.println("El Empleado es Principiante ");
            }else{
                if(edad >=29 && edad <= 39){
                    System.out.println("El Empleado es intermedio");
                }else{
                    if(edad >= 40){
                        System.out.println("El Empleado es Senior");
                    }
                }
            }


    }

    public void mostrarInformacion(String Empleado) {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Numero de Identidad: " + getNumeroIdentidad());
        System.out.println("Edad: " + getEdad());
        System.out.println("Salario: " + getSalario());
        System.out.println( getToString());
    }




}
    
}
