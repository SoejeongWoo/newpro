public class Word {
    int level;
    String word;
    String meaning;

    @Override
    public String toString() {
        return "*".repeat(level) + " " + word + " " + meaning;
    }
}