package edu.escuelaing.arsw.app.App.httpServer.model;

import java.io.IOException;

public interface FileBrowser {

    /**
     * @param path path of file
     * @return data understandable by the server for display in browser
     * @throws IOException because of the libraries used in the implementation of files
     */
    public String getFile(String path) throws IOException;
}
