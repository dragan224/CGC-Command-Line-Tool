# CGC-Command-Line-Tool
CLI that wraps Cancer Genomics Cloud (CGC) api.

## API
For the full api, please see: https://docs.cancergenomicscloud.org/docs/the-cgc-api. This tool only wraps a small portion of it so far.

## Building and Installation 

``
gradle build
``

This will build the project and binplace them on your path - usr/local/bin on Unix and %SYSTEMROOT32% on Windows.

## Running unit tests
You can run the tests with

``
gradle task test
``

## Usage
Please find the sample commands in test_commands.txt. However if stuck, you can always run

``
cgccli --help
``
