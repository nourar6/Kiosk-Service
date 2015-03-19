import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

// Singleton Pattern aka The Logger
public class Logger {

    // instantiate the logger instance
    private static Logger instance;
    // the printerwriter we will be using for the log file.
    private PrintWriter writer;

    // constructor
    public Logger () throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(System.getProperty("user.home").concat("\\Desktop\\kiosk-service\\out\\log_file.txt"), "UTF-8");
    }

    // Log method to write to the log file
	public void log(String message){
        writer.printf(message + " \n");
    }

    //  method to get the current instance of the logger
    public static Logger getInstance()
    {
        if (instance == null) {
            try {
                instance = new Logger();
            }
            // as the logger creates a new  PrinterWriter we need to catch possible Exceptions
            catch (FileNotFoundException e){System.out.println(e.getMessage());}
            catch (UnsupportedEncodingException u){System.out.println(u.getMessage());}
        }
        return instance;
    }

    // method to close the writer
    public void close(){
        writer.close();
    }
}

