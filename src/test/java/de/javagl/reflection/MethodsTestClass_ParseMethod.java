package de.javagl.reflection;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("javadoc")
class MethodsTestClass_ParseMethod
{
    public <A> void methodA(A a, String b)
    {
        // Test method
    }
    
    public static strictfp synchronized <  A   ,  B  > List<? super Number> methodB(A a, B b)
    {
        return null;
    }
    
    public <A> void methodC(A a, int b, float c)
    {
        // Test method
    }

    public <T> void methodD(List<? extends T> list, Collection<? super T> collection)
    {
        // Test method
    }
    
    public <T> void methodE(Map<String, Integer> mapA, Map<String, Integer> mapB)
    {
        // Test method
    }
    
    
}