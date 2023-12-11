package proyectomp;

import javax.swing.JOptionPane;

public class PruebaEmpleadoss {
    public static void main(String[] args) {
   String greeting = "Java World!";
   String w = greeting.substring(7, 11);
   System.out.println(w);
   String ola;
   int a; a = 10;
     int x = 100;
  int y = x;
  y++;
  System.out.println("Value of x is " + x);
  System.out.println("Value of y is " + y);
   
   int input = Integer.parseInt(JOptionPane.showInputDialog("??")) + 1;
int longToInt = (int)20L;
char size = 'M';


        Empleado emple1 = new Empleado("jairo", "453424354", 19,true ,45676.60);


        emple1.mostrarInformacion("Empleado");






    }


}
