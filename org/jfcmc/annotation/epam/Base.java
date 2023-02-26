package org.jfcmc.annotation.epam;

@BaseAction(level = 2, sqlRequest = "SELECT name, phone FROM phonebook")
public class Base {
    public void doAction() {
        Class clazz = Base.class;
        try {
            BaseAction action = (BaseAction) clazz.getAnnotation(BaseAction.class);
            System.out.println(action.level());
            System.out.println(action.sqlRequest());
        }
        catch (NullPointerException npe) {
            System.err.println("Error: " + npe);
            npe.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.doAction();
    }
}
