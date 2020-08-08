# Engineering Interview Challenge

## Introduction

### This project helps basically in getting the answer for the following two questions:

1. Which 10 countries in the data have the highest population growth rates from 2010 to 2018?
1. Of those 10 countries, when combined with GDP/PPP, which would be the best 3 countries to start investing marketing into for our products?

## Project Structure

The project contains two main parts to achieve their objectives:

- **Data Ingestion Service**: Allows the user to perform the data ingestion, by requesting the data via API REST and programmatically persisting the results in an embedded database.

- **Data Querying Service**: Allows the user to answer the aforementioned question by internally performing SQL queries that in turn manipulate the previously loaded data.

## Usage

### Prerequisites

|Technology|Version|Type|
|----------|-------|----|
|*n?x or Windows OS | Any of your preference, but one that supports the installation and usage of the other components|mandatory|
|Java|8 or higher|mandatory|
|Git|2.22 or higher ( older versions may also work)| optional|

### Compilation

The first phase takes care of the compilation and packaging of the application to make it ready to use. 
For this, we provide the shell script `compile.sh` file located on the `bin/` folder of the project. This script contains all the configuration and dependencies needed to build our project.

To get the application compiled, follow the instructions below:

1. Open a bash-compatible terminal and clone the `master` branch of this repository using this command: 
    ```bash
    git clone https://github.com/iamezcua-dev/global-marketing-worldbank-report.git
    ```

1. Change to the newly generated directory:
    ```bash
    cd global-marketing-worldbank-report
    ```

1. In the root of the project, issue the following command to make `compile.sh` executable:
    ```bash
    chmod 755 bin/compile.sh
    ```
   
1.  Execute this command to start the compilation
    ```bash
    bin/sh compile.sh
    ```
    
1. Wait for the compilation to finish. On command completion, we should have a `jar` file inside the `target/` folder, which contains all what you need to run the project.

### Execution

The project provides a `run.sh` shell script. You can locate it at the root of the project. This script allows us to specify two different operations that, if properly executed, will get the job done.

So, let's have fun and perform the execution of our application. For this, follow the instructions below:

#### Data Loading

 1. In the root of the project, issue the following command to make `run.sh` executable:
    ```bash
    chmod 755 bin/run.sh
    ```
    
 1. Execute the `run.sh` script and use the `--dataload` flag:
    ```bash
    sh bin/run.sh --dataload
    ```

 1. Wait for the data ingestion to complete.

#### Showing the answers to the questions

 1. Execute the same `run.sh` script but this time using the `--results` flag:
    ```bash
    sh bin/run.sh --results
    ```

 1. Wait for the results to show up.

# Questions?

Please don't hesitate to contact me at <iamezcua.dev@gmail.com>.
