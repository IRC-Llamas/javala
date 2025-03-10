# Javala

Javala is a Vala-to-Java transpiler written in Java, leveraging ANTLR for parsing Vala code and converting it to equivalent Java code.

## Features
- Parses Vala classes and properties.
- Converts Vala types to Java equivalents.
- Generates Java source code from Vala input.

## Getting Started

### Prerequisites
- Java 21+
- Gradle
- ANTLR 4

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/IRC-Llamas/javala.git
   cd javala
   ```
2. Build the project:
   ```sh
   ./gradlew build
   ```

### Usage
Run the transpiler with a sample Vala input:
```sh
./gradlew run
```

### Example
#### **Vala Input**
```vala
class Example {
    int x;
    string name;
}
```

#### **Generated Java Output**
```java
public class Example {
    private int x;
    private String name;
}
```

## Roadmap
- [ ] Support method conversion.
- [ ] Handle Vala-specific constructs (e.g., properties, signals).
- [ ] Improve type conversion and error handling.

## Contributing
Contributions are welcome! Feel free to open issues and submit pull requests.

## License
This project is licensed under the [CC0](https://creativecommons.org/publicdomain/zero/1.0/deed.en) License and is public domain.

