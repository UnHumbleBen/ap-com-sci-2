public class NotChecker implements Checker {
    private Checker a;

    public NotChecker(Checker a) {
        this.a = a;
    }

    public boolean accept(String text) {
        return !a.accept(text);
    }

    public static void main(String[] args) {
        Checker aChecker = new SubstringChecker("artichokes"); 
        Checker kChecker = new SubstringChecker("kale"); 
        Checker yummyChecker; 
        yummyChecker = new AndChecker(new NotChecker(aChecker), new NotChecker(kChecker));
    }
}