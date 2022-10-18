public class QualifiedThis {
    private int value = 828;

    public void printValue() {
        System.out.println("value=" + value);
        System.out.println("this.value=" + this.value);
        System.out.println("QualifiedThis.this.value=" + QualifiedThis.this.value);
    }

    public void printHiddenValue() {
        int value = 131;
        System.out.println("value=" + value);
        System.out.println("this.value=" + this.value);
        System.out.println("QualifiedThis.this.value=" + QualifiedThis.this.value);
    }
}
