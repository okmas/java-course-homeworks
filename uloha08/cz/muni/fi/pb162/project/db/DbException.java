package cz.muni.fi.pb162.project.db;


/**
 * General database server communication exception.
 * 
 * @author Samuel Lesko, 409202 
 * @version 12.11.2013
 */
public class DbException extends Exception
{
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }
}
