public class SumarMain {

    public static void main(String...args) {
        Sumar s = new AdaptadorSumar2();
        System.out.println(s.sumar("2", 3));
    }
}
