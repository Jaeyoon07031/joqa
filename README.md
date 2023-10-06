# Jay's Over-engineered Quiz App (JOQA)
![build is probably passing](https://img.shields.io/badge/build-passing,_probably-green)
![no license, i think](https://img.shields.io/badge/license-MIT_License-blue)
![i wasted so much time on this](https://img.shields.io/badge/time_wasted-5_hours_and_counting-purple)
![why would you pr for this](https://img.shields.io/badge/pull_requests-if_you_want-mediumaquamarine)

Jay's Over-engineered Quiz App (JOQA) is an over-engineered Java app for writing and playing simple quizzes.

I have no idea why I spent so much time on an AP Comp Sci project, but at least I know I had some fun doing it.

### Running JOQA
Pre-compiled binaries are available on the GitHub [releases page](https://github.com/Jaeyoon07031/joqa/releases)

If you prefer to compile from source, the instructions are [below](#Building-The-Project) 
### Building The Project
##### Prerequisites
- Maven 3.2.5+ required, 3.8.x+ recommended
- Java 8+ required, 17+ recommended
- A functioning brain
##### Building on Windows
1. Navigate to the root directory of the downloaded repo (The folder with the pom.xml file)
2. Verify with `mvn --version` that you meet the prerequisites
3. Run `mvn compile` then `mvn package` to build the project
4. The executable jar can then be found in the `target` directory
5. Run as `java -jar target\JAR_NAME_HERE.jar`
##### Building on Windows, Easy Mode*
1. Download the repo as a .zip file and extract it somewhere
2. Open the whole folder as a project in IntelliJ IDEA
3. Click the run button and hope it just works
##### Building on Linux
1. figure it out, you're using linux already

### Contributing
why

### License(s)
JOQA is distributed under the MIT license.
The one library I do use (googlecode json-simple) is distributed under the Apache-2.0 License.
Both of these can be found in `LICENSE.txt` or [here](https://opensource.org/license/mit/) and [here](https://www.apache.org/licenses/LICENSE-2.0).
