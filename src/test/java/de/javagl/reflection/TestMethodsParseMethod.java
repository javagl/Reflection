package de.javagl.reflection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * Test for the {@link Methods#parseMethodUnchecked(String)} class
 */
@RunWith(JUnit4.class)
@SuppressWarnings("javadoc")
public class TestMethodsParseMethod
{
    @Test
    public void testParseMethodA() 
    {
        Method methodA = Methods.getMethodOptional(
            MethodsTestClass_ParseMethod.class, 
            "methodA", Object.class, String.class);
        testParseMethod(methodA);
    }
    
    @Test
    public void testParseMethodB() 
    {
        Method methodB = Methods.getMethodOptional(
            MethodsTestClass_ParseMethod.class, 
            "methodB", Object.class, Object.class);
        testParseMethod(methodB);
    }
    
    @Test
    public void testParseMethodC() 
    {
        Method methodC = Methods.getMethodOptional(
            MethodsTestClass_ParseMethod.class,
            "methodC", Object.class, int.class, float.class);
        testParseMethod(methodC);
    }

    @Test
    public void testParseMethodD() 
    {
        Method methodD = Methods.getMethodOptional(
            MethodsTestClass_ParseMethod.class,
            "methodD", List.class, Collection.class);
        testParseMethod(methodD);
    }

    @Test
    public void testParseMethodE() 
    {
        Method methodE = Methods.getMethodOptional(
            MethodsTestClass_ParseMethod.class,
            "methodE", Map.class, Map.class);
        testParseMethod(methodE);
    }

    @Test
    public void testParseMethodAdd() 
    {
        Method methodF = Methods.getMethodOptional(
            Collection.class, "add", Object.class);
        testParseMethod(methodF);
    }

    
    /**
     * Test the {@link Methods#parseMethodUnchecked(String)} method
     * 
     * @param method The method to test with
     */
    private void testParseMethod(Method method)
    {
        String string = method.toString();
        Method parsedFromString = 
            Methods.parseMethodUnchecked(string);
        assertEquals(method, parsedFromString);
        
        String genericString = method.toGenericString();
        Method parsedFromGenericString = 
            Methods.parseMethodUnchecked(genericString, true);
        assertEquals(method, parsedFromGenericString);
    }
}
