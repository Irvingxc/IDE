/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import conexion.Conexion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import Models.Usuario;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Irving Calix
 */
public class Usuarios {
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
    
    public static boolean verificarCredenciales(Usuario usuario) {
    String consulta = "SELECT * FROM Usuarios WHERE username = ?";
    try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
        preparedStatement.setString(1, usuario.getUser());

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                // Obtener el salt y la contraseña almacenados en la base de datos
                String storedSalt = resultSet.getString("salt");
                String storedPasswordHash = resultSet.getString("password_hash");

                // Verificar la contraseña ingresada utilizando el salt almacenado
                usuario.setSalt(storedSalt);
                System.out.println(usuario.getPassword());
                System.out.println(usuario.getSalt());
                String enteredPasswordHash = hashPassword(usuario);
                System.out.println(storedPasswordHash);
                System.out.println(enteredPasswordHash);
                // Comparar las contraseñas
                return storedPasswordHash.equals(enteredPasswordHash);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return false; // El usuario no existe
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
        e.printStackTrace();
        return false;
    }
}
    
    private static String hashPassword(Usuario usuario) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Concatenar la contraseña y el salt
            String saltedPassword = usuario.getPassword() + usuario.getSalt();

            // Calcular el hash
            byte[] hash = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

            // Convertir el hash a una representación hexadecimal
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashByte : hash) {
                hexStringBuilder.append(String.format("%02x", hashByte));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

/*private static byte[] hashPassword(Usuario usuario) {
    try {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        // Obtener la contraseña como cadena
        String password = String.valueOf(usuario.getPassword());

        // Obtener el salt como cadena (para imprimirlo)
        String saltString = new String(usuario.getSalt(), StandardCharsets.UTF_8);

        // Concatenar la contraseña y el salt
        String saltedPassword = password + saltString;

        // Imprimir información de depuración
        System.out.println("Salted Password: " + saltedPassword);

        byte[] hash = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

        // Imprimir información de depuración
        System.out.println("Generated Password Hash: " + toHexString(hash));

        return hash;
    } catch (NoSuchAlgorithmException e) {
        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
        e.printStackTrace();
        return null;
    }
}*/


    
    /*public static boolean verificarCredenciales(Usuario usuario) {
        JOptionPane.showMessageDialog(null, usuario.getUser());
        String consulta = "SELECT * FROM Usuarios WHERE username = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setString(1, usuario.getUser());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Obtener el salt y la contraseña almacenados en la base de datos
                    String storedSalt = resultSet.getString("salt");
                    String storedPasswordHash = resultSet.getString("password");
                    // Verificar la contraseña ingresada utilizando el salt almacenado
                    usuario.setSalt(storedSalt);
                    String enteredPasswordHash = hashPassword(usuario);

                    // Comparar las contraseñas
                    return storedPasswordHash.equals(enteredPasswordHash);
                } else {
                    JOptionPane.showMessageDialog(null, "Te encontre");
                    return false; // El usuario no existe
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return false;
        }
    }

    // Método para hashear la contraseña con salt
    private static String hashPassword(Usuario usuario) {
        try {
            JOptionPane.showMessageDialog(null, usuario.getPassword()+ usuario.getSalt());
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = usuario.getPassword() + usuario.getSalt();
            byte[] hash = messageDigest.digest(saltedPassword.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return null;
        }
    }
*/
}
