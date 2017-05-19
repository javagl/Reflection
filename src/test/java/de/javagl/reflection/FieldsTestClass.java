package de.javagl.reflection;

@SuppressWarnings({"javadoc", "unused"})
public class FieldsTestClass 
    extends FieldsTestParentClass 
    implements FieldsTestInterface
{
    public static int publicStaticField;
    protected static int protectedStaticField;
    static int defaultStaticField;
    private static int privateStaticField;
    
    public int publicField;
    protected int protectedField;
    int defaultField;
    private int privateField;
    
    public static int publicStaticFieldOnlyInChild;
    protected static int protectedStaticFieldOnlyInChild;
    static int defaultStaticFieldOnlyInChild;
    private static int privateStaticFieldOnlyInChild;
    
    public int publicFieldOnlyInChild;
    protected int protectedFieldOnlyInChild;
    int defaultFieldOnlyInChild;
    private int privateFieldOnlyInChild;
    
}
