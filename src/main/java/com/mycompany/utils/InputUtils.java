package com.mycompany.utils;

import com.mycompany.datadiri.BioData;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputUtils {

    private InputUtils() {
        // Private constructor to hide the implicit public one
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static BioData readBioData(
        Scanner scan,
        Logger logger,
        String genderLabel,
        String... extraPrompts
    ) {
        logger.info("Masukan nama: ");
        String nama = scan.nextLine();
        logger.info("Masukan tanggal lahir spasi dengan (-): ");
        String dataLahir = scan.nextLine();
        logger.info("Tempat tinggal: ");
        String alamat = scan.nextLine();
        logger.info("Umur: ");
        int umur = -1;
        if (scan.hasNextInt()) {
            umur = scan.nextInt();
            scan.nextLine(); // consume newline
        } else if (scan.hasNextLine()) {
            scan.nextLine();
        }

        String gender = "L/P";
        if (genderLabel != null && !genderLabel.isEmpty()) {
            logger.log(Level.INFO, "{0}: ", genderLabel);
            gender = scan.nextLine();
        }

        String[] extras = new String[3];
        for (int i = 0; i < 3; i++) {
            if (i < extraPrompts.length) {
                logger.log(Level.INFO, "{0}: ", extraPrompts[i]);
                extras[i] = scan.nextLine();
            } else {
                extras[i] = "";
            }
        }

        return new BioData(
            nama,
            dataLahir,
            alamat,
            gender,
            umur,
            extras[0],
            extras[1],
            extras[2]
        );
    }
}