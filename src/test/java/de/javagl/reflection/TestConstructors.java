package de.javagl.reflection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test for the {@link Constructors} class
 */
@SuppressWarnings("javadoc")
@RunWith(JUnit4.class)
public class TestConstructors
{
    @Test
    public void testGetConstructor() 
    {
        String p = "de.javagl.reflection.testpackage.";
        Class<?> classWithPrivateConstructor = Classes.forNameOptional(p + "TestClass_PublicClassPrivateConstructor");
        Class<?> classWithPublicConstructor  = Classes.forNameOptional(p + "TestClass_PublicClassPublicConstructor");
        assertNull   (Constructors.getConstructorOptional(classWithPrivateConstructor));
        assertNotNull(Constructors.getConstructorOptional(classWithPublicConstructor));
    }

    @Test
    public void testGetDeclaredConstructor() 
    {
        String p = "de.javagl.reflection.testpackage.";
        Class<?> classWithPrivateConstructor = Classes.forNameOptional(p + "TestClass_PublicClassPrivateConstructor");
        Class<?> classWithPublicConstructor  = Classes.forNameOptional(p + "TestClass_PublicClassPublicConstructor");
        assertNotNull(Constructors.getDeclaredConstructorOptional(classWithPrivateConstructor));
        assertNotNull(Constructors.getDeclaredConstructorOptional(classWithPublicConstructor));
    }
    
    @Test
    public void testGetConstructors() 
    {
        Class<?> c = ConstructorsTestClass.class;
        Constructors.getConstructorsOptional(c);
        
        Set<String> actual = Constructors.getConstructorsOptional(c).stream()
            .map(Object::toString)
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "public de.javagl.reflection.ConstructorsTestClass(byte)"
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }

    @Test
    public void testGetDeclaredConstructors() 
    {
        Class<?> c = ConstructorsTestClass.class;
        Constructors.getConstructorsOptional(c);
        
        Set<String> actual = Constructors.getDeclaredConstructorsOptional(c)
            .stream()
            .map(Object::toString)
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "public de.javagl.reflection.ConstructorsTestClass(byte)",
            "protected de.javagl.reflection.ConstructorsTestClass(short)",
            "de.javagl.reflection.ConstructorsTestClass(int)",
            "private de.javagl.reflection.ConstructorsTestClass(long)"
        ));
        
        assertTrue(TestUtils.debugAssertEquals(expected, actual));
    }
    
    
    @Test
    public void testNewInstance() 
    {
        String p = "de.javagl.reflection.testpackage.";
        Class<?> classWithPrivateConstructor = Classes.forNameOptional(p + "TestClass_PublicClassPrivateConstructor");
        Class<?> classWithPublicConstructor  = Classes.forNameOptional(p + "TestClass_PublicClassPublicConstructor");
        Constructor<?> privateConstructor = Constructors.getDeclaredConstructorOptional(classWithPrivateConstructor);
        Constructor<?> publicConstructor  = Constructors.getDeclaredConstructorOptional(classWithPublicConstructor);
        assertNull   (Constructors.newInstanceOptional(privateConstructor));
        assertNotNull(Constructors.newInstanceOptional(publicConstructor));
    }
    
    @Test
    public void testNewInstanceNonAccessible() 
    {
        String p = "de.javagl.reflection.testpackage.";
        Class<?> classWithPrivateConstructor = Classes.forNameOptional(p + "TestClass_PublicClassPrivateConstructor");
        Class<?> classWithPublicConstructor  = Classes.forNameOptional(p + "TestClass_PublicClassPublicConstructor");
        Constructor<?> privateConstructor = Constructors.getDeclaredConstructorOptional(classWithPrivateConstructor);
        Constructor<?> publicConstructor  = Constructors.getDeclaredConstructorOptional(classWithPublicConstructor);
        assertNotNull(Constructors.newInstanceNonAccessibleOptional(privateConstructor));
        assertNotNull(Constructors.newInstanceNonAccessibleOptional(publicConstructor));
    }
    
    
}
