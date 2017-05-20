package de.javagl.reflection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test for the {@link Classes} class
 */
@SuppressWarnings("javadoc")
@RunWith(JUnit4.class)
public class TestClasses
{
    @Test
    public void testForName() 
    {
        String p = "de.javagl.reflection.testpackage.";
        assertNotNull(Classes.forNameOptional(p + "DefaultClassWithPrivateConstructor"));
        assertNotNull(Classes.forNameOptional(p + "DefaultClassWithPublicConstructor"));
        assertNotNull(Classes.forNameOptional(p + "PublicClassWithPrivateConstructor"));
        assertNotNull(Classes.forNameOptional(p + "PublicClassWithPublicConstructor"));
        assertNull   (Classes.forNameOptional(p + "_INVALID_NAME_"));
    }

    @Test
    public void testNewInstance() 
    {
        String p = "de.javagl.reflection.testpackage.";
        assertNull   (Classes.newInstanceOptional(p + "DefaultClassWithPrivateConstructor"));
        assertNull   (Classes.newInstanceOptional(p + "DefaultClassWithPublicConstructor"));
        assertNull   (Classes.newInstanceOptional(p + "PublicClassWithPrivateConstructor"));
        assertNotNull(Classes.newInstanceOptional(p + "PublicClassWithPublicConstructor"));
        assertNull   (Classes.newInstanceOptional(p + "_INVALID_NAME_"));
    }
    
    @Test
    public void testNewInstanceNonAccessible() 
    {
        String p = "de.javagl.reflection.testpackage.";
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "DefaultClassWithPrivateConstructor"));
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "DefaultClassWithPublicConstructor"));
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "PublicClassWithPrivateConstructor"));
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "PublicClassWithPublicConstructor"));
        assertNull   (Classes.newInstanceOptional(p + "_INVALID_NAME_"));
    }
    
    
}
