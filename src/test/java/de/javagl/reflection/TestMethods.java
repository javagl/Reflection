package de.javagl.reflection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test for the {@link Methods} class
 */
@SuppressWarnings("javadoc")
@RunWith(JUnit4.class)
public class TestMethods
{
    @Test
    public void testGetMethod() 
    {
        Class<?> c = MethodsTestClass.class;
        
        assertNotNull(Methods.getMethodOptional(c, "publicStaticMethod"));
        assertNull(   Methods.getMethodOptional(c, "protectedStaticMethod"));
        assertNull(   Methods.getMethodOptional(c, "defaultStaticMethod"));
        assertNull(   Methods.getMethodOptional(c, "privateStaticMethod"));

        assertNotNull(Methods.getMethodOptional(c, "publicMethod"));
        assertNull(   Methods.getMethodOptional(c, "protectedMethod"));
        assertNull(   Methods.getMethodOptional(c, "defaultMethod"));
        assertNull(   Methods.getMethodOptional(c, "privateMethod"));

        assertNotNull(Methods.getMethodOptional(c, "publicStaticMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "protectedStaticMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "defaultStaticMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "privateStaticMethodOnlyInChild"));

        assertNotNull(Methods.getMethodOptional(c, "publicMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "protectedMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "defaultMethodOnlyInChild"));
        assertNull(   Methods.getMethodOptional(c, "privateMethodOnlyInChild"));
        
        assertNotNull(Methods.getMethodOptional(c, "publicStaticMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "protectedStaticMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "defaultStaticMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "privateStaticMethodOnlyInParent"));

        assertNotNull(Methods.getMethodOptional(c, "publicMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "protectedMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "defaultMethodOnlyInParent"));
        assertNull(   Methods.getMethodOptional(c, "privateMethodOnlyInParent"));
        
        assertNull(   Methods.getMethodOptional(c, "_NO_SUCH_FIELD_"));
        
    }
    
    @Test
    public void testGetDeclaredMethod() 
    {
        Class<?> c = MethodsTestClass.class;
        
        assertNotNull(Methods.getDeclaredMethodOptional(c, "publicStaticMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "protectedStaticMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "defaultStaticMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "privateStaticMethod"));

        assertNotNull(Methods.getDeclaredMethodOptional(c, "publicMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "protectedMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "defaultMethod"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "privateMethod"));

        assertNotNull(Methods.getDeclaredMethodOptional(c, "publicStaticMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "protectedStaticMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "defaultStaticMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "privateStaticMethodOnlyInChild"));

        assertNotNull(Methods.getDeclaredMethodOptional(c, "publicMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "protectedMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "defaultMethodOnlyInChild"));
        assertNotNull(Methods.getDeclaredMethodOptional(c, "privateMethodOnlyInChild"));
        
        assertNull(   Methods.getDeclaredMethodOptional(c, "publicStaticMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "protectedStaticMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "defaultStaticMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "privateStaticMethodOnlyInParent"));

        assertNull(   Methods.getDeclaredMethodOptional(c, "publicMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "protectedMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "defaultMethodOnlyInParent"));
        assertNull(   Methods.getDeclaredMethodOptional(c, "privateMethodOnlyInParent"));
        
        assertNull(   Methods.getDeclaredMethodOptional(c, "_NO_SUCH_FIELD_"));
    }

    
    @Test
    public void testGetMethods() 
    {
        Class<?> c = MethodsTestClass.class;
        
        Set<String> actual = Methods.getMethodsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "MethodsTestClass#publicStaticMethod",
            "MethodsTestClass#publicMethod",
            "MethodsTestClass#publicStaticMethodOnlyInChild",
            "MethodsTestClass#publicMethodOnlyInChild",
            "MethodsTestParentClass#publicMethodOnlyInParent",
            "MethodsTestParentClass#publicStaticMethodOnlyInParent",
            "MethodsTestInterface#publicMethodOnlyInInterface",
            "Object#wait",
            "Object#hashCode",
            "Object#getClass",
            "Object#toString",
            "Object#notify",
            "Object#notifyAll",
            "Object#equals"
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }
    
    @Test
    public void testGetDeclaredMethods() 
    {
        Class<?> c = MethodsTestClass.class;
        
        Set<String> actual = Methods.getDeclaredMethodsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "MethodsTestClass#publicStaticMethod",
            "MethodsTestClass#protectedStaticMethod",
            "MethodsTestClass#defaultStaticMethod",
            "MethodsTestClass#privateStaticMethod",
            "MethodsTestClass#publicMethod",
            "MethodsTestClass#protectedMethod",
            "MethodsTestClass#defaultMethod",
            "MethodsTestClass#privateMethod",
            "MethodsTestClass#publicStaticMethodOnlyInChild",
            "MethodsTestClass#protectedStaticMethodOnlyInChild",
            "MethodsTestClass#defaultStaticMethodOnlyInChild",
            "MethodsTestClass#privateStaticMethodOnlyInChild",
            "MethodsTestClass#publicMethodOnlyInChild",
            "MethodsTestClass#protectedMethodOnlyInChild",
            "MethodsTestClass#defaultMethodOnlyInChild",
            "MethodsTestClass#privateMethodOnlyInChild"
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }

    
    @Test
    public void testGetAllDeclaredMethods() 
    {
        Class<?> c = MethodsTestClass.class;
        
        Set<String> actual = Methods.getAllDeclaredMethodsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "MethodsTestClass#publicStaticMethod",
            "MethodsTestClass#protectedStaticMethod",
            "MethodsTestClass#defaultStaticMethod",
            "MethodsTestClass#privateStaticMethod",
            "MethodsTestClass#publicMethod",
            "MethodsTestClass#protectedMethod",
            "MethodsTestClass#defaultMethod",
            "MethodsTestClass#privateMethod",
            "MethodsTestClass#publicStaticMethodOnlyInChild",
            "MethodsTestClass#protectedStaticMethodOnlyInChild",
            "MethodsTestClass#defaultStaticMethodOnlyInChild",
            "MethodsTestClass#privateStaticMethodOnlyInChild",
            "MethodsTestClass#publicMethodOnlyInChild",
            "MethodsTestClass#protectedMethodOnlyInChild",
            "MethodsTestClass#defaultMethodOnlyInChild",
            "MethodsTestClass#privateMethodOnlyInChild",
            "MethodsTestParentClass#publicStaticMethod", 
            "MethodsTestParentClass#protectedStaticMethod", 
            "MethodsTestParentClass#defaultStaticMethod",
            "MethodsTestParentClass#privateStaticMethod", 
            "MethodsTestParentClass#publicMethod", 
            "MethodsTestParentClass#protectedMethod", 
            "MethodsTestParentClass#defaultMethod", 
            "MethodsTestParentClass#privateMethod", 
            "MethodsTestParentClass#publicStaticMethodOnlyInParent", 
            "MethodsTestParentClass#protectedStaticMethodOnlyInParent", 
            "MethodsTestParentClass#defaultStaticMethodOnlyInParent", 
            "MethodsTestParentClass#privateStaticMethodOnlyInParent", 
            "MethodsTestParentClass#publicMethodOnlyInParent", 
            "MethodsTestParentClass#protectedMethodOnlyInParent", 
            "MethodsTestParentClass#defaultMethodOnlyInParent", 
            "MethodsTestParentClass#privateMethodOnlyInParent", 
            "MethodsTestInterface#publicStaticMethod",
            "MethodsTestInterface#defaultStaticMethod",
            "MethodsTestInterface#publicStaticMethodOnlyInInterface",
            "MethodsTestInterface#defaultStaticMethodOnlyInInterface",
            "MethodsTestInterface#publicMethod",
            "MethodsTestInterface#publicMethodOnlyInInterface",
            "Object#registerNatives",
            "Object#toString",
            "Object#wait",
            "Object#hashCode",
            "Object#getClass",
            "Object#finalize",
            "Object#notify",
            "Object#notifyAll",
            "Object#clone",
            "Object#equals"            
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }
    
    @Test
    public void testGetOwnMethods() 
    {
        Class<?> c = MethodsTestClass.class;
        
        Set<String> actual = Methods.getOwnMethodsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "MethodsTestClass#publicStaticMethodOnlyInChild",
            "MethodsTestClass#publicMethodOnlyInChild"
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }
    
}
