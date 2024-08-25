# File Filtering Utility

This is a command-line utility that filters content from input files into separate output files based on data type.
The utility supports filtering integers, floating-point numbers, and strings into different output files.

## Prerequisites

- **Java**: OpenJDK 21.0.4
- **Maven**: 3.9.6

## Building the Project

To build the project, follow these steps:

1. Clone the repository:

    ```bash
    git clone https://github.com/angryWilly/FFUtility.git
    cd FFUtility
    ```

2. Build the project using Maven:

    ```bash
    mvn clean compile assembly:single
    ```

This command will compile the source code and create a standalone JAR file in the `target` directory.
The JAR file will include all dependencies.

## Usage

After building the project, you can run the utility from the command line.

### Basic Usage

```bash
java -jar target/ffu.jar [options] file1.txt file2.txt ...
```

### Options

    -o, --output <directory>: Specifies the output file directory. Default is the current directory.
    -p, --prefix <prefix>: Specifies a prefix for output file names (e.g., result_).
    -a, --append: Enables append mode for writing to files. By default, files are overwritten.
    -s, --short: Enables collection of brief statistics (only counts of filtered items).
    -f, --full: Enables collection of detailed statistics (including min, max, sum, average for numbers; shortest and longest length for strings).
    -h, --help: Displays usage instructions.

### Example

```bash
java -jar target/ffu.jar -s -a -p sample- in1.txt in2.txt
```