# Jay's Over-engineered Quiz App (JOQA)
![build is probably passing](https://img.shields.io/badge/build-passing,_probably-green)
![no license, i think](https://img.shields.io/badge/license-none!-blue)

Jay's Over-engineered Quiz App (JOQA) is an over-engineered Java app for
writing and playing quizzes.

I have no idea why I spent so much time on an AP Comp Sci project, but at least
I know I had fun doing it.

### Running JOQA
Pre-compiled binaries are available on the GitHub [releases page](https://github.com/Jaeyoon07031/joqa/releases)

If you prefer to compile from source, the instructions are [below](#Building-The-Project) 
### Building The Project
##### Prerequisites
- Maven 3.3.x or higher
- JDK (of your choice) 17+, might work with 8+ but not tested 
- A functioning brain
##### Building on Windows
1. Navigate to the root directory of the downloaded repo (The folder with the pom.xml file)
2. Verify with `mvn --version` that you meet the prerequisites
3. Run `mvn compile` then `mvn package` to build the project
4. The executable jar can then be found in the `target` directory
5. Run as `java -jar target/JAR_NAME_HERE.jar`
##### Building on Windows, Easy Mode*
1. Download the repo as a .zip file and extract it somewhere
2. Open the whole folder as a project in IntelliJ IDEA
3. Click the run button and hope it just works
##### Building on Linux
1. figure it out, you're using linux already

### Contributing
dont