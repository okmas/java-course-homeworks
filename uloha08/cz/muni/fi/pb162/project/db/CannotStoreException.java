package cz.muni.fi.pb162.project.db;


/**
 * Exception when a unable to write data to server.
 * 
 * @author Samuel Lesko, 409202
 * @version 12.11.2013
 */
public class CannotStoreException extends DbException
{
    public CannotStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
