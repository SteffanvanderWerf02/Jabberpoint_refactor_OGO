import java.io.IOException;

public abstract class Reader {
    public static final String DEMO_NAME = "Demo presentation";
    public static final String DEFAULT_EXTENSION = ".xml";

    abstract public void loadFile(Presentation p, String fn) throws IOException;
}