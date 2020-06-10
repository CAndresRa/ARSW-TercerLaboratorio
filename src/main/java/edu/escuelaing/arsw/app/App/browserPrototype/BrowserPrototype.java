package edu.escuelaing.arsw.app.App.browserPrototype;

import java.io.*;
import java.net.*;

public class BrowserPrototype {
    public static void main(String[] args) throws Exception {
        String url = args[0];
        File file = new File("src/main/resources/browserAnswer.html");
        file.delete();

        URL inUrl = new URL(url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inUrl.openStream()))) {
            String inputLine = null;
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(file));
            while ((inputLine = reader.readLine()) != null) {
                bw.write(inputLine + "\n");
            }
            bw.close();
            System.out.println("El archivo se genero con exito, se encuentra en src/main/resources/browserAnswer.html");
        } catch (IOException x) {
            System.err.println(x);
        }

    }
}