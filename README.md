JabberPoint
Overview
JabberPoint is a simple Java-based presentation tool. This project allows you to create and display slides with text and images. The primary components include slide navigation, loading and saving presentations, and viewing slides.

Features
Create and view presentations.
Navigate through slides using keyboard shortcuts or menu options.
Load presentations from XML files.
Save presentations to XML files.
Demo mode for initial demonstration.
Requirements
Java 19 or higher
Maven 3.8.1 or higher
Project Structure
The project consists of the following main packages:

controller: Contains classes for handling user input and menu actions.
model: Defines the data structures for the presentation, slides, and various items (text, images) within slides.
util: Provides utility classes such as styles and dialogs.
view: Handles the graphical user interface components for displaying the presentation.
git clone https://github.com/timothyadewale/Software-Quality-Redo.git
cd JabberPoint

Build the project using Maven:
mvn clean install
Running the Application
To run the JabberPoint application, execute the following command:
mvn exec:java -Dexec.mainClass="com.nhlstenden.JabberPoint.JabberPoint"
This will start the application in demo mode. You can also specify an XML file to load a specific presentation:

Keyboard Shortcuts
Next Slide: PgDn, Enter, +
Previous Slide: PgUp, Up Arrow, -
Quit: q, Q
Running Tests
The project includes unit tests for various components. To run the tests, use the following command:


mvn test
Usage
Menu Options:
File:
Open: Load a presentation from an XML file.
New: Clear the current presentation.
Save: Save the current presentation to an XML file.
Exit: Exit the application.
View:
Next: Go to the next slide.
Prev: Go to the previous slide.
Go to: Jump to a specific slide number.
Help:
About: Show information about JabberPoint.

License
This project is licensed under the MIT License.

Acknowledgements
Original version by Ian F. Darwin.

For any further questions or issues, please open an issue in the GitHub repository.
