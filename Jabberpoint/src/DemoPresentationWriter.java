public class DemoPresentationWriter extends Writer {

    public void saveFile(Presentation presentation, String unusedFilename) {
        throw new IllegalStateException("Save As->Demo! called");
    }
}