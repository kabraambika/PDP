## Assignment3
Email and letter generator program for the insurance company.

## Features
- CSV file
The insurance company holds some information about their members in a CSV file. CSV file is organized as a plain text file, containing information such that each piece of data is enclosed in double quotes, and separated by a comma. The first line of the file contains the headers for each column. 
- The program will take this file as input, and generate files that will contain the email messages and letters to send to their members. Email messages and letters will be generated from templates.
- The templates are stored as text files with special placeholders in the text that refer to the CSV file's header names. Placeholders are placed between [[ and ]].
- This program accepts Command Line Arguments.

## Command Line Arguments
This program will accept certain arguments at the command line. 
| Command | Description |
| ------ | ------ |
| `--email` | only generate email messages |
| `--email-template <file>` | accept a filename that holds the email template, Required if `--email` is used |
| `--letter` | only generate letters |
|`--letter-template <file>` | accept a filename that holds the letter template, Required if `--letter` is used |
|`--output-dir <path>`|accept the name of a folder, all output is placed in this folder|
|`--csv-file <path>` | accept the name of the csv file to process|

Examples:
```sh
    --email --email-template email-template.txt --output-dir emails --csv-file customer.csv
    --letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv
    --csv-file customer.csv --email-template email-template.txt --output-dir emails --email
```

> Note : the order of the command line options does not matter

Please note that some options take arguments, for example `--email-template` takes one argument, and it is the name of a file. Similarly, `--output-dir` takes one argument, and it is the name of a folder.
Other options, however, take no arguments, and indicate an action, i.e., `--email` indicates that we should generate emails on this execution of the program.
The command line option -`-output-dir` and `csv-file` are required.
This program will generate one of the two options (emails or letters) per invocation. If `--email` is given, then `--email-template` must also be provided, if `--letter` is given then `--letter-template` must also be given.

> Note: Calling this program and passing any other combination of options should generate an error, for example:
```sh
--email --letter-template letter-template.txt --output-dir letters/ is illegal. 
```

When a user provides an illegal combination of inputs, the program will exit with a helpful error message, and a short explanation of how to use the program along with examples.

## How to run this program

## Run application with help of ```gradle run``` task in Terminal/cli

- In build.gradle, ```assingment3.problem1.Main``` is main class for providing arguments which is added in gradle as mainClassName.

> Changes made in build.gradle for adding run task 
> id 'application' is added in plugins and mainClassName provided
```
plugins {
id 'application'
}

application {
    mainClassName = 'assignment3.problem1.Main'
}
```

- Open terminal/cli and change directory to project folder ```assignment3```
- Run the gradle task ```gradle run --args=<all args should be here>``` which will provide args in main method of Main class and program will be successfully run. 
>Note : Args provided should be in quotes
For reference, you can copy the below-mentioned gradle command and change args as per requirement
```sh
gradle run --args='--letter --letter-template src/test/resources/letter-template.txt --output-dir src/test/resources/lettersAndEmails --csv-file src/test/resources/insurance-company-members.csv'
```

> Terminal result after running gradle task:
```sh
ambikakabra@kabra-MacBook-Pro assignment3 % gradle run --args='--letter --letter-template src/test/resources/letter-template.txt --output-dir src/test/resources/lettersAndEmails --csv-file src/test/resources/insurance-company-members.csv'
Starting a Gradle Daemon, 1 incompatible Daemon could not be reused, use --status for details

> Configure project :
all done!

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.5.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 6s
3 actionable tasks: 3 executed
```
