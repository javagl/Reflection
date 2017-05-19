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
        assertNotNull(Classes.forNameOptional(p + "TestClass_DefaultClassPrivateConstructor"));        
        assertNotNull(Classes.forNameOptional(p + "TestClass_DefaultClassPublicConstructor"));        
        assertNotNull(Classes.forNameOptional(p + "TestClass_PublicClassPrivateConstructor"));        
        assertNotNull(Classes.forNameOptional(p + "TestClass_PublicClassPublicConstructor"));        
        assertNull   (Classes.forNameOptional(p + "_INVALID_NAME_"));
    }

    @Test
    public void testNewInstance() 
    {
        String p = "de.javagl.reflection.testpackage.";
        assertNull   (Classes.newInstanceOptional(p + "TestClass_DefaultClassPrivateConstructor"));        
        assertNull   (Classes.newInstanceOptional(p + "TestClass_DefaultClassPublicConstructor"));        
        assertNull   (Classes.newInstanceOptional(p + "TestClass_PublicClassPrivateConstructor"));        
        assertNotNull(Classes.newInstanceOptional(p + "TestClass_PublicClassPublicConstructor"));        
        assertNull   (Classes.newInstanceOptional(p + "_INVALID_NAME_"));
    }
    
    @Test
    public void testNewInstanceNonAccessible() 
    {
        String p = "de.javagl.reflection.testpackage.";
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "TestClass_DefaultClassPrivateConstructor"));        
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "TestClass_DefaultClassPublicConstructor"));        
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "TestClass_PublicClassPrivateConstructor"));        
        assertNotNull(Classes.newInstanceNonAccessibleOptional(p + "TestClass_PublicClassPublicConstructor"));        
        assertNull   (Classes.newInstanceOptional(p + "_INVALID_NAME_"));
    }
    
    
}
