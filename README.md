# Engineering Interview Challenge

## Introduction

### This project helps basically in getting the answer for the following two questions:

1.	Which 10 countries in the data have the highest population growth rates from 2010 to 2018?
2.	Of those 10 countries, when combined with GDP/PPP, which would be the best 3 countries to start investing marketing into for our products?

## Project Structure

The project contains two main parts to achieve their objectives:

- **Data Ingestion Service**: Allows the user to perform the data ingestion, by requesting the data via API REST and programmatically persisting the results in an embedded database.

- **Data Querying Service**
Allows the user to answer the aforementioned question by internally performing SQL queries that in turn manipulate the previously loaded data.

## Usage

### Prerequisites

|Technology|Version|Type|
|----------|-------|----|
|*n?x or Windows OS | Any of your preference, but one that supports the installation and usage of the other components|mandatory|
|Java|8 or higher|mandatory|
|Git|2.22 or higher ( older versions may also work)| optional|

### Compilation

The first step is to compile and package the components to make them ready to use. 
For this, we can use the `compile.sh` file located on the root of the project, since it contains all the configuration and dependencies needed to build our project.

To achieve this, open a terminal and issue the following command:
 
```bash
sh compile.sh
```

On command completion, we should get a packaged `jar` file inside the `target/` folder, created at the root of the project and which contains all what we need to run our project.

### Execution

The project provides a `run.sh` shell script. You can locate it at the root of the project.

Such script permits specifying two different operations that, if properly executed, will get the job done.

So, let's have a little of fun by executing our application. Follow the instructions below:

#### 1. Loading the data

1.1. In the root of the project, issue the following command to make `run.sh` to have execution permission:

```bash
chmod 755 run.sh
```

1.2. Execute the `run.sh` script and use the `--dataload` flag:
```bash
sh run.sh --dataload
```
1.3. Wait for the command completion.

#### 2. Showing results

2.1. Execute the same `run.sh` script but this time using the `--results` flag:
 ```bash
 sh run.sh --dataload
 ``` 

2.2. Wait for the results to show up.

# Questions

Please don't hesitate to contact me at <iamezcua.dev@gmail.com>.
