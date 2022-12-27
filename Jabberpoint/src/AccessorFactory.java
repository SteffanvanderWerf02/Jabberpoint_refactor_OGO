public class AccessorFactory {

    public static Reader getReader(String filename) {
        if (filename.endsWith(Reader.DEFAULT_EXTENSION)) {
            return new XMLReader();
        } else {
            throw new IllegalArgumentException("Unknown file type: " + filename);
        }
    }
    public static Reader getReaderWithArgs(String[] arguments) {
        if (arguments.length == 0) {
            return new DemoPresentationReader();
        } else {
            return new XMLReader();
        }
    }



    public static Writer getWriter(String filename) {
        if (filename.endsWith(Writer.DEFAULT_EXTENSION)) {
            return new XMLWriter();
        } else {
            throw new IllegalArgumentException("Unknown file type: " + filename);
        }
    }
}