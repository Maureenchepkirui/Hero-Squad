# Hero Squad

This is a java app that enables a user create a hero and a squad and also the user can add a hero to a squad
## Author

* **Arnold Oduma** 

### -*Initial works*-
  - [Github Search](https://github.com/ArnoldOduma/git-search) - An app to search github users and their repositories
  - [Quotes](https://github.com/ArnoldOduma/quotes) - An app that enables a user create quotes and delete quotes they don't want
  - [Goals](https://github.com/ArnoldOduma/goals-application) - This is an application to create goals and checkout the ones you completed
  - [Pig Dice](https://github.com/ArnoldOduma/Pig-Dice) - This is a simole java script game of pigdice
  - [Delani Studio](https://github.com/ArnoldOduma/Delani_Studio) - A front end of a studio website
  - [Triangle Tracker](https://github.com/ArnoldOduma/triangle-tracker) - Tracks what type a triangle is by checking its length width and height
  - [portfolio](https://github.com/ArnoldOduma/portfolio) - My portfolio website 

## Demo
<img src="./demo.png" width="100%"/>

## Getting Started

Clone this repository to your local machine to get Started

Github: [https://github.com/ArnoldOduma/Hero-Squad-.git](https://github.com/ArnoldOduma/Hero-Squad.git)

### Prerequisites

You need the following installed on your machine
- java
- JDK - Java Development Kit
- Maven
- Gradle
- An IDE - Intellij


To confirm run the following command on linux
```
$ java --version       //java version
$ mvn --version        //maven version
$ gradle --version     //gradle version
```

## Installing

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.
* Navigate into the ``` src/main/java/App.java ``` and click run in intellij.
* Go to your browser and type ``` localhost:4567 ```

## Running the Tests 

Create a test class for running tests in the application.

This is a sample test that tests if the getter method works

```
@Test
public void newHero_getName_String(){
  hero testHero = Hero.setUpNewHero();
  assertEquals("Arnold", testHero.getName());
}
```

## Built With

* [Java](https://www.java.com/) - The language used
* [Intellij Idea](https://www.jetbrains.com/idea/) - Intergated development
* [Spark]() - Framework


## Contributing
If you want to put out a pull request you first have to send us the sample code that you want to add to our repository for cross-checking before we allow the pull.

## Versioning

We use [Github](https://github.com/) for versioning. This is the first version of this application

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Acknowledgments

* Hat tip to  ```Stackoverflow```

