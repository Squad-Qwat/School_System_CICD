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
public class Registrasi extends User {

    private static final Logger logger = Logger.getLogger(
        Registrasi.class.getName()
    );
    private String email;

    // Constructor
    public Registrasi(String username, String password, String email) {
        super(username, password);
        this.email = email;
    }

    // Getter untuk Email
    public String getEmail() {
        return email;
    }

    // Setter untuk Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Metode registrasi
    public boolean register(String username, String password, String email) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            logger.warning("Error: Semua field harus diisi.");
            return false;
        }
        setUsername(username);
        setPassword(password);
        setEmail(email);
        logger.log(
            Level.INFO,
            "Registrasi berhasil for username: {0}",
            username
        );
        return true;
    }
}
