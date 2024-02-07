# Vortex
Vortex is a in java written template for complex java applications with mysql support and custom configs.

# Preview
![](demo.png)

# Installing Vortex

Make sure you've installed following things:
- Java Development Kit 20 [Installation Guide](https://docs.oracle.com/en/java/javase/20/install/)
- Maven [Installation Guide](https://maven.apache.org/install.html)

<details>
  <summary>Initialize IntelliJ Project</summary>

  1. Start cloning this repository
     
     ```bash
      git clone "https://github.com/maxi-schaefer/vortex"
     ```

  2. Open your Project in Intellij
     File > Open > "Path to Vortex"

  3. And your done!
</details>

# Start using Vortex
## Commands

  You can create commands in dev.max.vortex.commands.impl, just create your command class and implement Command.java.
  Implement the methods and change the return values.
  Example:
  ```java
  public class YourCommand implements Command {
    @Override
    public String name() {
      return "MyFirstCommand";
    }
  
    @Override
    public String description() {
      return "I like to code with vortex";
    }
  
    @Override
    public void execute(String[] args) {
      System.out.println("Hello World");
    }
  }
  ```
  Register your command in the CommandManager with:
  ```java
  commands.add(new YourCommand());
  ```
After that your command should be registered and you can start coding it with the execute method.
If you want your command to have aliases use the aliases method like this:
```java
  @Override
  public List<String> aliases() {
    return List.of(new String[]{ "test", "myAlias" });
  }
```

## Configs

Create your config class in dev.max.vortex.config.impl, add all your variables, getter, setter and a constructor
Example:
```java
@Getter
@Setter
@AllArgsConstructor
public class TestConfig {

  private int testInt;
  private String testString;
  private double testDouble;
  private float testFloat;
  private boolean testBoolean;

}
```
Now add your new Config to the Configs class in dev.max.vortex.config like this:
```java
@Setter
@Getter
public class Configs {

  private TestConfig testConfig;

}
```

After this you need to initialize it VortexInstance you can do it like this:
```java
public class VortexInstance {
  private final TestConfig testConfig;

  public VortexInstance() {
    //...

    testConfig = new TestConfig(1, "String", 2D, 0.3f, false);
  }
}
```

In the ConfigSaver and ConfigLoader class you need to add following code:
### ConfigSaver | saveConfig()
```java
  config.setTestConfig(VortexInstance.getInstance().getTestConfig();
```

### ConfigLoader | loadConfig()
```java
  TestConfig testConfig = VortexInstance.getInstance().getTestConfig();
  testConfig.setTestInt(config.getTestConfig().getTestInt());
  testConfig.setTestString(config.getTestConfig().getTestString());
  testConfig.setTestDouble(config.getTestConfig().getTestDouble());
  testConfig.setTestFloat(config.getTestConfig().getTestFloat());
  testConfig.setTestBoolean(config.getTestConfig().getTestBoolean());
```
Now you added your first config!
