import java.util.Random;

public class Generator {

    private int liczbalosowa;

    public Generator(int liczbalosowa) {
        this.liczbalosowa = liczbalosowa;
    }

    public int randomBetween(int start, int end){
        Random random = new Random();
        int a1 = random.nextInt(end); // 0-99
        liczbalosowa = a1 + start;
        System.out.println(liczbalosowa);
        return liczbalosowa;
    }
}
