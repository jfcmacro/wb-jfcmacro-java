public class RefGC {

    public static void main(String...args) {

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        // 1.
        List<Person> list = Arrays.asList(p1, p2, p3);
        // 2.
        p1 = null;
        // 3.
        list = null;
        // 4.
    }

}
