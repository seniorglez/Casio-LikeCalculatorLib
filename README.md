# Casio-LikeCalculatorLib

A simple library that aims to be able to do all the stuff that a scholar calculator can do. Written on JDK8, that's because 
we want this library to use it on android projects.

I want this library to be able to calculate the same thinks that the casio calculator I used on my secondary school can 
do. When we reach that point I did not want to stop there, it will be great if we can add new awesome features to it.

<p align="center">
<img src ='https://4.bp.blogspot.com/-mtanr8C8_XE/V4Mk5DuTvBI/AAAAAAAAChI/klNV2_xixSs117gNzu_jh7FtMTf5khtowCLcB/s1600/fx82es.jpg' alt='casio'  height="350 em">
</p>


## How to use it

These instructions will get you a copy of the project to use it on yours.

### Downloading the jar

You can get the last jar file [here](https://github.com/seniorglez/Casio-LikeCalculatorLib/packages/141400).

### Maven Dependency

Some people will prefer to use this lib with a maven project, to do it add this dependency to your pom file:

```xml
<dependency>
  <groupId>com.seniorglez.calc</groupId>
  <artifactId>Casio-LikeCalculatorLib</artifactId>
  <version>1.0-snapshot</version>
</dependency>

```

And then install it from the command line:

```bash
mvn install

```

### Android project

You can get the last jar file [here](https://github.com/seniorglez/Casio-LikeCalculatorLib/packages/141400).

Using it is very simple you only have to import the jar as in your android project and add the following to the build.gradle file:

```
    android {
       compileOptions {
           sourceCompatibility JavaVersion.VERSION_1_8
           targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

And you should be able to import the library classes. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

#### Java

In order to run Maven you will need to install Java's JDK but as long we are using Maven we didn't need to have the
specific version of Java that we are using to write owr project (Maven will compile on JDK8 anyway). I recommend to install versions older 
that JDK8 (minimum JDK7). On my case I'm using JDK11.

I think that everybody who works with Java already knows how to set his JAVA_HOME system variable, but some of you use to set it like this:

```bash
    export JAVA_HOME="/usr/lib/jvm/java-11-openjdk/bin"
    
    export PATH=$JAVA_HOME/bin:$PATH

```

With the most of the programs this will works nice but Maven will not recognize this variable as a valid one. If you have set up
your JAVA_HOME like this the only think you need to do is to remove that /bin. 

```bash
    export JAVA_HOME="/usr/lib/jvm/java-11-openjdk"
    
    export PATH=$JAVA_HOME/bin:$PATH

```

#### Maven

We have to install maven to package this project.

If you use **Arch Linux or Arch-based** distros:
```bash
	
	sudo pacman -S maven
	
```
If you use **ubuntu/devian-based** distros:

```bash

    sudo apt install maven

```
If you use **MacOS** in order to install maven you will have to install [Homebrew](https://brew.sh/)

```bash

    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

```
And now you can just install it 

```bash
    
    brew install maven
    
```
If you are using **Windows** download maven form the [maven website](http://maven.apache.org/download.cgi). And the follow the
guide and the advice of the [installation guide](http://maven.apache.org/install.html).



Now we can check if maven works properly

```bash

	mvn -version

```

You should get something like this:

```
	Apache Maven 3.6.3 (NON-CANONICAL_2019-11-27T20:26:29Z_root)
	Maven home: /opt/maven
	Java version: 11.0.6, vendor: Oracle Corporation, runtime: /usr/lib/jvm/java-11-openjdk
	Default locale: es_ES, platform encoding: UTF-8
	OS name: "linux", version: "5.4.15-arch1-1", arch: "amd64", family: "unix"

```
## Packaging

Package it using Maven

```bash

    mvn clean install

```
## Built With

* [Maven](https://maven.apache.org/) - The software project management tool
* [JUnit](https://junit.org/junit4/) - The unit testing framework

## Contributing

Feel free to fork it and made pull request if you think that your own version is better or adds new functionalities. 
Please after you open the pull request, make sure that you can actually build the library. If you want to add new methods then write also new test for them. 

And because we aim to have a safe enviroment for everybody take a look at owr [code of conduct](CODE_OF_CONDUCT.md).


## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

### Casio-LikeCalculator

Copyright (C) 2020 Diego Dominguez Gonzalez

This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License 
as published by the Free Software Foundation; either version 3 of the License, or any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library, if not check it [here](https://www.gnu.org/licenses/lgpl-3.0.txt) 

![lgpl3](https://www.gnu.org/graphics/lgplv3-with-text-154x68.png)

