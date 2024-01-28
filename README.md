# Stackoverflow issue [#77894103](https://stackoverflow.com/q/77894103/3764965)

Switch between Java 8 and 17 and compare the test results.

# Set up

- Java 8
    ```xml
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    ```
- Java 17
    ```xml
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    ```

Remember to configure `JAVA_HOME` properly for Maven or Maven Wrapper to pick up the correct version.

The issue should be reproducible with any Maven version from `3.5.4` to `3.9.2`.

Tested on `3.5.4`.

# Run

```shell
./mvnw clean install
```

- Java 8 passes the test.
- Java 17 fails the test.
