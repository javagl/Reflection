package de.javagl.reflection;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Utility methods
 */
class Utils
{
    /**
     * Checks whether the given sets are equal, printing their differences
     * if this is not the case.
     * 
     * @param <T> The element type
     * @param expected The expected set
     * @param actual The actual set
     * @return Whether the assertion held
     */
    static <T> boolean debugAssertEquals(Set<T> expected, Set<T> actual)
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
