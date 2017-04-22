CMD Zipper
---
This application will allow you to Split & Compress files in parts:

Requirements
--
* At least JDK 8

How to run?
---

1. Compile the project with the following command:
```
mvn clean install
```
2. The project is a Maven application, you can run inside of your ide or
 from terminal with the following command: 
 ```
 java -classpath cmd-zipper-jar-with-dependencies.jar com.jcalvopinam.CmdZipperApplication
 ```

The application will show something like this:


![alt text](https://github.com/juanca87/cmd-zipper/blob/master/src/main/resources/screenshots/menu.jpg?raw=true "Menu")


3. Complete according to the Menu

Example:
---
##### Option 1:

```
Please choose an option: 1
Please enter the full file path: 
```

* Full path file:
```
/Volumes/Stonehall/juanca/Desktop/file.txt
```

* Split in volumes of (size) in MB, for example, to set 10MB just enter 10

```
Please enter the size file (MB) to split: 10
```

* Wait while the process ends
```
Please wait while the file is split:
......................................
Ended process!
```

##### Option 2:
```
Please choose an option: 2
Please enter the full path of the first part: 
```

* The application assumes that all parts of the files are in the same folder, so here you must enter the full path of the first file. For example:

```
/Volumes/Stonehall/juanca/Desktop/file_001.zip
```
* The application will find all parts of the files. Wait while the process ends.
```
File found: file_001.zip
File found: file_002.zip
File found: file_003.zip
Please wait while the files are joined: 
......................................
Ended process!
```

##### Option 0:
```
Please choose an option: 0
```

* The application will close
