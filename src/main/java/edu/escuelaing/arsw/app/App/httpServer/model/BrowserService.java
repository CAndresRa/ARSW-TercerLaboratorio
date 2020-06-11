package edu.escuelaing.arsw.app.App.httpServer.model;

import java.io.IOException;

public class BrowserService {
    FileBrowser fileBrowser;
    String filePath;
    /**
     * constructor that allows to identify the type of file to be found
     * @param filePath path of file
     */
    public BrowserService(String filePath){
        this.filePath = filePath;
        if(filePath.contains(".html")){
            fileBrowser = new HtmlFile();
        }
        else if (filePath.contains(".png")){
            fileBrowser = new PngFile();
        }
    }

    /**
     * @return data understandable by the server for display in browser
     * @throws IOException because of the libraries used in the implementation of files
     */
    public String getFileBrowser() throws IOException {
        String file = fileBrowser.getFile(filePath);
        return file;
    }

}
