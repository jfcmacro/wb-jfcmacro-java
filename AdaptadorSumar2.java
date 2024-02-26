public class AdaptadorSumar2 implements Sumar {

    private Sumar2 sumar2;

    public AdaptadorSumar2() {
        sumar2 = new ImplSumar2();
    }

    public int sumar(String a, int b) {
        return sumar2.sumar(b, a);
    }
}
