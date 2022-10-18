public @interface Description {
    Name name();
    Version version();
    String comments() default "";
}
