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
 * Test for the {@link Fields} class
 */
@SuppressWarnings("javadoc")
@RunWith(JUnit4.class)
public class TestFields
{
    @Test
    public void testGetField() 
    {
        Class<?> c = FieldsTestClass.class;
        
        assertNotNull(Fields.getFieldOptional(c, "publicStaticField"));
        assertNull(   Fields.getFieldOptional(c, "protectedStaticField"));
        assertNull(   Fields.getFieldOptional(c, "defaultStaticField"));
        assertNull(   Fields.getFieldOptional(c, "privateStaticField"));

        assertNotNull(Fields.getFieldOptional(c, "publicField"));
        assertNull(   Fields.getFieldOptional(c, "protectedField"));
        assertNull(   Fields.getFieldOptional(c, "defaultField"));
        assertNull(   Fields.getFieldOptional(c, "privateField"));

        assertNotNull(Fields.getFieldOptional(c, "publicStaticFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "protectedStaticFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "defaultStaticFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "privateStaticFieldOnlyInChild"));

        assertNotNull(Fields.getFieldOptional(c, "publicFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "protectedFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "defaultFieldOnlyInChild"));
        assertNull(   Fields.getFieldOptional(c, "privateFieldOnlyInChild"));
        
        assertNotNull(Fields.getFieldOptional(c, "publicStaticFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "protectedStaticFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "defaultStaticFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "privateStaticFieldOnlyInParent"));

        assertNotNull(Fields.getFieldOptional(c, "publicFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "protectedFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "defaultFieldOnlyInParent"));
        assertNull(   Fields.getFieldOptional(c, "privateFieldOnlyInParent"));
        
        assertNull(   Fields.getFieldOptional(c, "_NO_SUCH_FIELD_"));
        
    }
    
    @Test
    public void testGetDeclaredField() 
    {
        Class<?> c = FieldsTestClass.class;
        
        assertNotNull(Fields.getDeclaredFieldOptional(c, "publicStaticField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "protectedStaticField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "defaultStaticField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "privateStaticField"));

        assertNotNull(Fields.getDeclaredFieldOptional(c, "publicField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "protectedField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "defaultField"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "privateField"));

        assertNotNull(Fields.getDeclaredFieldOptional(c, "publicStaticFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "protectedStaticFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "defaultStaticFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "privateStaticFieldOnlyInChild"));

        assertNotNull(Fields.getDeclaredFieldOptional(c, "publicFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "protectedFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "defaultFieldOnlyInChild"));
        assertNotNull(Fields.getDeclaredFieldOptional(c, "privateFieldOnlyInChild"));
        
        assertNull(   Fields.getDeclaredFieldOptional(c, "publicStaticFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "protectedStaticFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "defaultStaticFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "privateStaticFieldOnlyInParent"));

        assertNull(   Fields.getDeclaredFieldOptional(c, "publicFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "protectedFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "defaultFieldOnlyInParent"));
        assertNull(   Fields.getDeclaredFieldOptional(c, "privateFieldOnlyInParent"));
        
        assertNull(   Fields.getDeclaredFieldOptional(c, "_NO_SUCH_FIELD_"));
    }

    
    @Test
    public void testGetFields() 
    {
        Class<?> c = FieldsTestClass.class;
        
        Set<String> actual = Fields.getFieldsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "FieldsTestClass#publicStaticField",
            "FieldsTestClass#publicField",
            "FieldsTestClass#publicStaticFieldOnlyInChild",
            "FieldsTestClass#publicFieldOnlyInChild",
            "FieldsTestParentClass#publicStaticField",
            "FieldsTestParentClass#publicField",
            "FieldsTestParentClass#publicStaticFieldOnlyInParent",
            "FieldsTestParentClass#publicFieldOnlyInParent",
            "FieldsTestInterface#publicStaticFieldInInterface",
            "FieldsTestInterface#defaultStaticFieldInInterface"
        ));
        
        assertTrue(debugAssertEquals(expected, actual));
    }
    
    @Test
    public void testGetDeclaredFields() 
    {
        Class<?> c = FieldsTestClass.class;
        
        Set<String> actual = Fields.getDeclaredFieldsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "FieldsTestClass#publicStaticField",
            "FieldsTestClass#protectedStaticField",
            "FieldsTestClass#defaultStaticField",
            "FieldsTestClass#privateStaticField",
            "FieldsTestClass#publicField",
            "FieldsTestClass#protectedField",
            "FieldsTestClass#defaultField",
            "FieldsTestClass#privateField",
            "FieldsTestClass#publicStaticFieldOnlyInChild",
            "FieldsTestClass#protectedStaticFieldOnlyInChild",
            "FieldsTestClass#defaultStaticFieldOnlyInChild",
            "FieldsTestClass#privateStaticFieldOnlyInChild",
            "FieldsTestClass#publicFieldOnlyInChild",
            "FieldsTestClass#protectedFieldOnlyInChild",
            "FieldsTestClass#defaultFieldOnlyInChild",
            "FieldsTestClass#privateFieldOnlyInChild"
        ));
        
        assertTrue(debugAssertEquals(expected, actual));
    }

    
    @Test
    public void testGetAllDeclaredFields() 
    {
        Class<?> c = FieldsTestClass.class;
        
        Set<String> actual = Fields.getAllDeclaredFieldsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "FieldsTestClass#publicStaticField",
            "FieldsTestClass#protectedStaticField",
            "FieldsTestClass#defaultStaticField",
            "FieldsTestClass#privateStaticField",
            "FieldsTestClass#publicField",
            "FieldsTestClass#protectedField",
            "FieldsTestClass#defaultField",
            "FieldsTestClass#privateField",
            "FieldsTestClass#publicStaticFieldOnlyInChild",
            "FieldsTestClass#protectedStaticFieldOnlyInChild",
            "FieldsTestClass#defaultStaticFieldOnlyInChild",
            "FieldsTestClass#privateStaticFieldOnlyInChild",
            "FieldsTestClass#publicFieldOnlyInChild",
            "FieldsTestClass#protectedFieldOnlyInChild",
            "FieldsTestClass#defaultFieldOnlyInChild",
            "FieldsTestClass#privateFieldOnlyInChild",
            "FieldsTestParentClass#publicStaticField", 
            "FieldsTestParentClass#protectedStaticField", 
            "FieldsTestParentClass#defaultStaticField",
            "FieldsTestParentClass#privateStaticField", 
            "FieldsTestParentClass#publicField", 
            "FieldsTestParentClass#protectedField", 
            "FieldsTestParentClass#defaultField", 
            "FieldsTestParentClass#privateField", 
            "FieldsTestParentClass#publicStaticFieldOnlyInParent", 
            "FieldsTestParentClass#protectedStaticFieldOnlyInParent", 
            "FieldsTestParentClass#defaultStaticFieldOnlyInParent", 
            "FieldsTestParentClass#privateStaticFieldOnlyInParent", 
            "FieldsTestParentClass#publicFieldOnlyInParent", 
            "FieldsTestParentClass#protectedFieldOnlyInParent", 
            "FieldsTestParentClass#defaultFieldOnlyInParent", 
            "FieldsTestParentClass#privateFieldOnlyInParent", 
            "FieldsTestInterface#publicStaticFieldInInterface",
            "FieldsTestInterface#defaultStaticFieldInInterface"
        ));
        
        assertTrue(debugAssertEquals(expected, actual));
    }
    
    @Test
    public void testGetOwnFields() 
    {
        Class<?> c = FieldsTestClass.class;
        
        Set<String> actual = Fields.getOwnFieldsOptional(c).stream()
            .map(f -> f.getDeclaringClass().getSimpleName() + "#" + f.getName())
            .collect(Collectors.toSet());
        
        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "FieldsTestClass#publicField",
            "FieldsTestClass#publicStaticFieldOnlyInChild",
            "FieldsTestClass#publicStaticField",
            "FieldsTestClass#publicFieldOnlyInChild"
        ));
        
        assertTrue(debugAssertEquals(expected, actual));
    }
    
    /**
     * Checks whether the given sets are equal, printing their differences
     * if this is not the case.
     * 
     * @param <T> The element type
     * @param expected The expected set
     * @param actual The actual set
     */
    private static <T> boolean debugAssertEquals(Set<T> expected, Set<T> actual)
    {
        boolean equal = expected.equals(actual);
        if (!equal)
        {
            Set<T> missing = new LinkedHashSet<T>(expected);
            missing.removeAll(actual);
            Set<T> superfluous = new LinkedHashSet<T>(actual);
            superfluous.removeAll(expected);
            System.out.println("Missing: ");
            for (T t : missing)
            {
                System.out.println("    " + t);
            }
            System.out.println("Superfluous: ");
            for (T t : superfluous)
            {
                System.out.println("    " + t);
            }
        }
        return equal;
    }
}
