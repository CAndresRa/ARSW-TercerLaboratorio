package edu.escuelaing.arsw.app.App.trigonometricFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTrigonometric {
    static String operation = "cos";

    /**
     * Server that calculates cosine, sine or tangent of values entered by the user and determined operation
     * @param args n/a
     * @throws IOException  because of the libraries used in the implementation of sockets and files
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35001);
            System.out.println("Esperando conexion del cliente ...");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }
            Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Se establecio conexion por el puerto 35001");
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
                Double value = Double.parseDouble(inputLine);
                Double result = calculate(value);
                if (Double.compare(result, -111111.0) == 0){
                    outputLine = "El valor ingresado es invalido, intente nuevamente";
                }
                else {
                    outputLine = "El resultado de la operacion " + operation + " de " + inputLine + " es " + result;
                }
            } catch (Exception e){
                checkOperation(inputLine);
                if(operation.equals("invalid")){
                    outputLine = "El valor ingresado es invalido, intente nuevamente";
                } else {
                    outputLine = "Se cambio la operacion a " + operation;
                }
            }
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * Check if the user changed the operation
     * @param inputLine Line entered by customer
     */
    public static void checkOperation(String inputLine){
        if(inputLine.contains("fun:sin")) {
            operation = "sin";
        }
        else if (inputLine.contains("fun:cos")){
            operation = "cos";
        }
        else if (inputLine.contains("fun:tan")){
            operation = "tan";
        }
        else {
            operation = "invalid";
        }
    }

    /**
     * Calculates the value corresponding to the trigonometric function selected by the client
     * @param value number entered by customer
     * @return Value of trigonometric function selected
     */
    public static Double calculate(Double value){
        if(operation.equals("sin")){
            return Math.sin(value);
        }
        else if (operation.equals("cos")){
            return Math.cos(value);
        }
        else if (operation.equals("tan")){
            return Math.tan(value);
        }
        else {
            return -111111.0;
        }
    }
}

