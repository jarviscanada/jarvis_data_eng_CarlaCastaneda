# Introduction
(50-100 words)
Discuss the design of each app. What does the app do? What technologies have you used? (e.g. core java, libraries, lambda, IDE, docker, etc..)

For this Project I created a grep (regex) style application in Java which is able to parse through a directory 
of Files, similar to the `grep` linux command which returns matcing strings from files.
My java application is able to recursively check a root directory and all its child directories for files which
contain the regex specific. Once found, the line containing the matching regex expressions are writted to a file
specified by by user in the command line arguments.
In order to create this java application I have used a number of libraries and API's such as Stream, Arrays, ArrayList
Lambda expressions, Regex API provided by java JRE and JDK distributions. The IDE used is Intelliji and docker was used for deployment.


# Quick Start
How to use your apps? 

Using Docker:

`docker run --rm \
-v ${pwd} /data:/data -v ${pwd}/log:/log \
${docker_user}/grep .*Romeo.*Juliet.* /data /log/grep.out`

Using command line in Linux ( assuming all files and dependecies are set up on client computer properly):

`java -jar grep-demo.jar ${regex_pattern} ${src_dir} ./out/${outfile}`

#Implemenation
## Pseudocode
write `process` method pseudocode.

```
for (files in directory):

  if (file is a directory):
    add child files 
  else:
    readlines in file:
      if contains regex pattern:
        write to output file

```


## Performance Issue
(30-60 words)
Discuss the memory issue and how would you fix it

The problem I was presented with was assuming we want our grep app to proces large amounts of data that is bigger than physical memory with a small heap memory size.
The best way to fix this is using Stream Apis and bufferReader to read the files.


# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)

Intelliji built-in debugger was used whenever errors were encountered while running tests and I was able to find the solution pretty quickly.

for testing I used the main function to create class objects and run them in order to make sure everything was working smoothly, also used Junit used for unit testing functions in JavaGrepImp class. Used the romeo and juliet data.txt file to test the overrall application, as sample data and compared answers to confirm it had executed as intended.

Used `cat` to view contents of outfile to confirm the writetoFiles method had executed properly.

# Deployment
How you dockerize your app for easier distribution?

# Improvement
List three things you can improve in this project.
1. In order to optimize/ make more efficient with large data sets return stream intermediate operations rather than lists/collections
2. Override process function since return value type of methods would be different.
3. create a new interface to make abstract functions which return streams instead of list<string> and can then be implemented as such in main class.
