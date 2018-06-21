Guide:

clean: mvn clean
compile: mvn package
execute prorgram: in directory target execute 'java -jar NAMEOFJAR'

output files to be found in '/target/outputFiles'

# Automatic random ELkT Generator

Needed to randomly create ElkT files that only contain nodes. Edges may be added later.

### Prerequisites

You will need to have Java and Maven installed.

### Usage

A step by step series of examples that tell you how to get the program running.

Clean previous builds (not always necessary)

```
mvn clean
```

Compile project

```
mvn package
```

Set properties in the 'properties.config' file. There is a property for the amount of files to be printed and bounds regarding number of nodes and their width and height.

Execute program. After compiling go to the 'target' directory and execute

```
java -jar NAMEOFJAR
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Daniel Lucas** - *Initial work* - [dalu2104](https://github.com/dalu2104)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details
