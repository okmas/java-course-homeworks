package cz.muni.fi.pb162.project.db;

import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.io.IOException;

/**
 * Handles fictive storage of graphical data to remote server.
 * 
 * @author Samuel Lesko, 409202
 * @version 12.11.2013
 */
public class MyStorage implements Storage
{
    private Connector connector;
    private int maxAttempts;
    
    /**
     * Constructor.
     * 
     * @param connector         connector to be used in comunication with server
     * @param maxAttempts       maximum number of attempt of uploading data to server
     */
    public MyStorage(Connector connector, int maxAttempts) {
        if (connector == null) {
            throw new IllegalArgumentException("connector");
        }
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts");
        }
        
        this.connector = connector;
        this.maxAttempts = maxAttempts;
    }
    
    /**
     * Stores data to host.
     * 
     * @param host              name of host
     * @param data              data to be stored
     */
    public void store(String host, Object data) throws DbUnreachableException, CannotStoreException {
        Connection c;
        try {
            c = connector.getConnection(host);
        } catch (UnknownHostException | NoRouteToHostException e) {
            throw new DbUnreachableException("Could not reach host " + host, e);
        }
        
        int attempt = 0;
        boolean trySend = true;
        while (trySend) {
            try {
                attempt++;
                c.sendData(data);
                trySend = false;
                System.out.println("Data sent after " + attempt + " attempts."); 
            } catch (IOException e) {
                if (attempt >= maxAttempts) {
                    throw new CannotStoreException("Could not store data after " + maxAttempts 
                                                   + " attempts.", e);
                }
            }
        }
    }
}
