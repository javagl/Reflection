package de.javagl.reflection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * Tests for the {@link Constructors#parseConstructorUnchecked(String)} method
 */
@SuppressWarnings("javadoc")
@RunWith(JUnit4.class)
public class TestConstructorsParseConstructor
{
    @Test
    public void testParseConstructor() 
    {
        Constructor<?> constructor = 
            Constructors.getConstructorUnchecked(
                ConstructorsTestClass_ParseConstructor.class, 
                Object.class, Object.class, int.class);
        
        testParseConstructor(constructor);
    }

    @Test
    public void testParseConstructorWithParameterizedParameters() 
    {
        Constructor<?> constructor = 
            Constructors.getConstructorUnchecked(
                ArrayList.class, Collection.class);
        
        testParseConstructor(constructor);
    }
    

    private void testParseConstructor(Constructor<?> constructor)
    {
        String string = constructor.toString();
        Constructor<?> parsedFromString = 
            Constructors.parseConstructorUnchecked(string);
        assertEquals(constructor, parsedFromString);
        
        String genericString = constructor.toGenericString();
        Constructor<?> parsedFromGenericString = 
            Constructors.parseConstructorUnchecked(genericString);
        assertEquals(constructor, parsedFromGenericString);
    }
    
    
}
