package cz.muni.fi.pb162.project.db;


/**
 * Exception when a server is unreachable.
 * 
 * @author Samuel Lesko, 409202
 * @version 12.11.2013
 */
public class DbUnreachableException extends DbException
{
    public DbUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
