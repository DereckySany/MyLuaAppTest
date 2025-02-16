package com.dingyi.myluaapp.build.api.plugins

/**
 * Objects that can be extended at runtime with other objects.
 *
 * <pre class='autoTested'>
 * // Extensions are just plain objects, there is no interface/type
 * class MyExtension {
 * String foo
 *
 * MyExtension(String foo) {
 * this.foo = foo
 * }
 * }
 *
 * // Add new extensions via the extension container
 * project.extensions.create('custom', MyExtension, "bar")
 * //                       («name»,   «type»,       «constructor args», …)
 *
 * // extensions appear as properties on the target object by the given name
 * assert project.custom instanceof MyExtension
 * assert project.custom.foo == "bar"
 *
 * // also via a namespace method
 * project.custom {
 * assert foo == "bar"
 * foo = "other"
 * }
 * assert project.custom.foo == "other"
 *
 * // Extensions added with the extension container's create method are themselves extensible
 * assert project.custom instanceof ExtensionAware
 * project.custom.extensions.create("nested", MyExtension, "baz")
 * assert project.custom.nested.foo == "baz"
 *
 * // All extension aware objects have a special “ext” extension of type ExtraPropertiesExtension
 * assert project.hasProperty("myProperty") == false
 * project.ext.myProperty = "myValue"
 *
 * // Properties added to the “ext” extension are promoted to the owning object
 * assert project.myProperty == "myValue"
</pre> *
 *
 * Many Gradle objects are extension aware. This includes; projects, tasks, configurations, dependencies etc.
 *
 *
 * For more on adding &amp; creating extensions, see [ExtensionContainer].
 *
 *
 * For more on extra properties, see [ExtraPropertiesExtension].
 *
 *
 * An `ExtensionAware` object has several 'scopes' that Gradle searches for properties. These scopes are:
 *
 *
 *  * The object itself. This scope includes any property getters and setters declared by the
 * implementation class. The properties of this scope are readable or writable depending on the presence
 * of the corresponding getter or setter method.
 *
 *  * Groovy Meta-programming methods implemented by the object's class, like `propertyMissing()`. Care must be taken by plugin authors to
 * ensure `propertyMissing()` is implemented such that if a property is not found a MissingPropertyException(String, Class) exception is thrown.
 * If `propertyMissing()` always returns a value for any property, *Gradle will not search the rest of the scopes below.*
 *
 *  * The *extra* properties of the object.  Each object maintains a map of extra properties, which
 * can contain any arbitrary name -&gt; value pair.  Once defined, the properties of this scope are readable and writable.
 *
 *  * The *extensions* added to the object by plugins. Each extension is available as a read-only property with the same name as the extension.
 *
 */
interface ExtensionAware {
    /**
     * The container of extensions.
     */
    fun getExtensions():ExtensionContainer
}
