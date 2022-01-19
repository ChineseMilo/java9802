package demo03_annotation.customAnnotation;

public @interface MyAnnotation1 {
    byte b();
    int i();
    short s();
    boolean flag();

    String str();

    Class c();

    MyAnnotation my();

    Sex sex();

    byte[] arrb();

}
