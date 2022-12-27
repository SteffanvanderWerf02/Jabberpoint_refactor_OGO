import java.io.IOException;

public abstract class Writer {
    public static final String DEMO_NAME = "Demo presentation";
    public static final String DEFAULT_EXTENSION = ".xml";

    abstract public void saveFile(Presentation p, String fn) throws IOException;
}