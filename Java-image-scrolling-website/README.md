# Java Web Crawler Project

## Overview
This project is a Java-based web crawler designed to index and manage web pages. The crawler can retrieve, parse, link, and delete HTML files, providing an organized structure of web content. The project uses multiple classes to handle various aspects of the crawling and indexing process.

## Project Structure

- **CommonUtils.java**: Utility class for handling common operations like string manipulation, file handling, and logging.
- **Crawler.java**: Main crawling functionality to retrieve and process web pages.
- **HtmlFileDeleter.java**: Handles deletion of HTML files from the local storage once they are processed or deemed unnecessary.
- **Index.java**: Maintains the indexed data, allowing for efficient searching and retrieval of crawled information.
- **Linker.java**: Manages link extraction from crawled web pages, identifying and storing hyperlinks for further crawling.
- **Main.java**: The entry point of the program, initializing the components and starting the crawling process.
- **Page.java**: Represents a single web page and stores attributes like URL, content, and links.
- **Makefile**: Makefile for compiling and running the project.

## Requirements

- **Java 8 or higher**: Ensure that Java is installed and set up on your machine.
- **Internet Connection**: Necessary for crawling live web pages.

## Setup

1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Compile the Project**:
    Use the provided `Makefile` to compile all classes.
    ```bash
    make
    ```

3. **Run the Project**:
    Execute the crawler by running the `Main` class.
    ```bash
    make run
    ```

4. **Clean Up**:
    To remove compiled classes and temporary files, use:
    ```bash
    make clean
    ```

## Usage

1. **Configure the Crawler**:
   - Modify the configurations in `Main.java` to adjust the crawler's starting URL, depth limit, and other settings.
   
2. **Run Crawling**:
   - Start the crawler to fetch and index pages.
   - Links and content are stored in the structure defined in `Page.java` and managed through `Linker.java`.

3. **Index Management**:
   - `Index.java` stores and manages the indexed content, allowing for efficient searching.
   - Implement search functionality as needed to utilize the indexed data.

4. **HTML File Deletion**:
   - `HtmlFileDeleter.java` can delete crawled HTML files post-processing to free up space.
