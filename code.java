class Value {
  private int value;
  Test(int value) { this.value = value; } 
  public int getValue() { return value; }
  public void setValue(int value) { this.value = value; }
}
public void method(Test test) {
   int value = test.getValue();
   value += 5;
   test.setValue(value);
}
Test t1 = new Test(1);
method(t1);
t1.getValue();
public void method2(final Test test) {
   int value = test.getValue();
   value += 6;
   test.setValue(value);
}
method2(t1);
t1.getValue();
