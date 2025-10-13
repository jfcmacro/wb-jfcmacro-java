
public class UsingNewSingleton {
    public static void main(String...args) {
	NewSingleton singleton = NewSingleton.INSTANCE;
	System.out.println(singleton.doSomething());
	other();
    }

    public static void other() {
	System.out.println(NewSingleton.INSTANCE.doSomething());
    }
}
