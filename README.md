# Casio-LikeCalculatorLib
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

#### Maven

We have to install maven to package this project.

If you use Arch Linux or Arch-based distros:
```bash
	
	sudo pacman -S maven
	
```
If you use ubuntu/devian-based distros:

```bash

    sudo apt install maven

```
If you use MacOS in order to install maven you will have to install [Homebrew](https://brew.sh/)

```bash

    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

```
And now you can just install it 

```bash
    
    brew install wget
    
```
If you are using Windows please find your own way, I don't work with Windows and I don't know how to install maven on it.

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

Package it using maven

```bash

    mvn clean install

```
## Built With

* [Maven](https://maven.apache.org/) - The sofware project management tool

## Contributing

Feel free to fork it and made pull request if you think that your own version is better or adds new functionalities. 
Please after you open the pull request, make sure that you can actually build the library. If you want to add new methods then write also
new test for them. 


## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

### Casio-LikeCalculator

Copyright (C) 2020 Diego Dominguez Gonzalez

This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License 
as published by the Free Software Foundation; eitherversion 3 of the License, or any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not check it [here](https://www.gnu.org/licenses/lgpl-3.0.txt) 

![lgpl3](https://www.gnu.org/graphics/lgplv3-with-text-154x68.png)

