package edu.escuelaing.arsw.app.App.httpServer;
import edu.escuelaing.arsw.app.App.httpServer.model.BrowserService;

import java.net.*;
import java.io.*;

public class HttpServer {
    /**
     * Server that allows to visualize files contained in it
     * @param args n/a
     * @throws IOException because of the libraries used in the implementation of sockets
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(35002);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35002");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            try {
                Integer count = 0;
                String[] header = null;
                while ((inputLine = in.readLine()) != null) {
                    if (count == 0) {
                        header = inputLine.split(" ");
                    }
                    count++;
                    if (!in.ready()) {
                        break;
                    }
                }
                String path = "src/main/resources/";
                path = path + header[1].substring(1);
                BrowserService browserService = new BrowserService(path);
                String fileFound = browserService.getFileBrowser();
                outputLine = fileFound;
                out.println(outputLine);
                out.close();
                in.close();

            } catch (Exception e) {
                out.println(
                        "HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                                "<html><head><title>Error 404</title></head><body><h1>ERROR 404: Archivo no encontrado en el sistema</h1></body></html>"

                );
            }
            clientSocket.close();
            serverSocket.close();
        }
    }
}