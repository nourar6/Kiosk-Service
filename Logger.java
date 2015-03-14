import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Logger {

    private static Logger instance;
    private PrintWriter writer;
    public Logger () throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(System.getProperty("user.home").concat("\\Desktop\\kiosk-service\\out\\log_file.txt"), "UTF-8");
    }

	public void log(String message){
        writer.printf("Window" + message + " \n");

    }

    public static Logger getInstance()
    {
        if (instance == null) {
            try {
                instance = new Logger();
            }
            catch (FileNotFoundException e){}
            catch (UnsupportedEncodingException u){}
        }
        return instance;
    }

    public void close(){
        writer.close();
    }
}

