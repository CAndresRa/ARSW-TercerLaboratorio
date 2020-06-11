package edu.escuelaing.arsw.app.App.httpServer.model;

import edu.escuelaing.arsw.app.App.httpServer.model.FileBrowser;

import java.io.*;

public class HtmlFile  implements FileBrowser {

    @Override
    public String getFile(String path) throws IOException {
        String result = "";
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while (( line = bufferedReader.readLine()) != null){
            result = result + line;
        }
        fileReader.close();

        String output = "HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" + result;
        return output;
    }
}
