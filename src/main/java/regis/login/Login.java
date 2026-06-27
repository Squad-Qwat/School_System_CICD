/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regis.login;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bintang
 */
public class Login extends User {

    private static final Logger logger = Logger.getLogger(
        Login.class.getName()
    );

    // Constructor Login
    public Login(String username, String password) {
        super(username, password);
    }

    public boolean login(String username, String password) {
        boolean isValid = false;

        try {
            if (
                username.equals(getUsername()) && password.equals(getPassword())
            ) {
                isValid = true;
                logger.log(
                    Level.INFO,
                    "Login berhasil! Selamat datang, {0}",
                    username
                );
            } else {
                throw new IllegalArgumentException(
                    "Username atau password salah."
                );
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Error login: {0}", e.getMessage());
        }

        return isValid;
    }
}
