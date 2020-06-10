package edu.escuelaing.arsw.app.App.pow;

import java.net.*;
import java.io.*;

public class EchoServerPow {

public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Esperando conexion del cliente ...");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Se establecio conexion por el puerto 35000");
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("salir"))
                break;
            try{
                Double number = Double.parseDouble(inputLine);
                outputLine = "El cuadrado del numero ingresado es: " + Math.pow(number,2);
            }  catch ( Exception e){
                outputLine ="El dato ingresado no es un numero o el formato es incorrecto, utilice . en caso de numeros con decimales";
            }
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
