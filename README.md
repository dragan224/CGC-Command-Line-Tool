# CGC-Command-Line-Tool
CLI that wraps Cancer Genomics Cloud (CGC) api.

## API
For the full api, please see: https://docs.cancergenomicscloud.org/docs/the-cgc-api. This tool only wraps a small portion of it so far.

## Prerequisite
Gradle is required in order to build this project. 
For gradle installation instructions, click [here](https://gradle.org/install/)

## Building and Installation 
Run the following command from project's root directory:

``
gradle build
``

This will build the project and binplace the executable on your path - usr/local/bin on Unix and %SYSTEMROOT32% on Windows.

## Running unit tests
You can run the tests with:

``
gradle task test
``

From procjet's root directory.

## Usage
If the installation was successful, you should be able to run

``
cgccli --help
``

from terminal.
