package edu.escuelaing.arsw.app.App.httpServer.model;

import java.io.*;
import java.net.Socket;

public class HtmlFile  implements FileBrowser {

    @Override
    public void getFile(String path, Socket clientSocket) throws IOException {
        String result = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;
        while (( line = bufferedReader.readLine()) != null){
            result = result + line;
        }
        clientSocket.getOutputStream().write(("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" + result).getBytes());
        bufferedReader.close();
    }
}
