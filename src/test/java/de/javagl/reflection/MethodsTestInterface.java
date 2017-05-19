package de.javagl.reflection;

@SuppressWarnings({"javadoc"})
public interface MethodsTestInterface 
{
    public static void publicStaticMethod()
    {
        // Test method
    }
    static void defaultStaticMethod()
    {
        // Test method
    }

    public static void publicStaticMethodOnlyInInterface()
    {
        // Test method
    }
    static void defaultStaticMethodOnlyInInterface()
    {
        // Test method
    }
    
    public void publicMethod();
    public void publicMethodOnlyInInterface();
}
