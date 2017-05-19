/**
 * Utility classes related to reflection.<br>
 * <br>
 *
 * Many things can go wrong when using reflection. Nearly all methods
 * will ask a SecurityManager for permission to perform their respective
 * task. Other possible reasons for errors are, for example, methods
 * that have been renamed and are thus no longer found under the name
 * that is given in the reflective call, or limited visibility of the
 * classes or methods. <br>
 * <br>
 * Be sure to only use these utilities when you know what you're doing. <br>
 * <br>
 * Many methods in these utilities come in two flavors:
 * <ul>
 *   <li>
 *     An <code>...Unchecked</code> version, which wraps all exceptions 
 *     of the underlying call into an unchecked 
 *     {@link de.javagl.reflection.ReflectionException}
 *   </li>
 *   <li>
 *     An <code>...Optional</code> version, which returns <code>null</code> 
 *     (or empty lists, where applicable) if the underlying call causes 
 *     an exception
 *   </li>
 * </ul>
 */
package de.javagl.reflection;

