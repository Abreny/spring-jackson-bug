# Bug description
I want to manage a serialization of an object like this:
```java
public class MyPojo {
    private String property;

    private String propertyPublic;

    private String propertyAdmin;
}
```
For this class, the requirements is below:
- if the user is not connected, only property should be serialized to REST API
- if the connected user is not an admin, admin properties should not serialized into REST API
- if the user is an admin, all attributes should be serialized

In this repository, I expose this problem by writing my implementation to achieve these goals.

But a problem occurred, if no json view has provided to ObjectMapper, all attributes are serialized into REST API. It violate the first requirement.

**How to solve it?**

Please, send me a pull request if you have an idea.

[stackoverflow](https://stackoverflow.com/questions/77806134/jackson-jsonview-why-all-attributes-have-been-serialized-when-no-jsonview-has-b)
