package info;

public class Lines {

    private String line;


    public String getLine() {
        return line;
    }

    public Lines(String line) {
        this.line = line;
    }


    @Override
    public String toString() {
        return "Lines{" +
                "line='" + line + '\'' +
                '}';
    }
}
