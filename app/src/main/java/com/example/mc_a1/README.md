**JourneyApp**
JourneyApp is a sample Android application built using Jetpack Compose. It demonstrates a simple journey tracking app where users can view their current stop, distance covered, distance left, and progress. Users can also switch between kilometers and miles for distance units and navigate to the next stop.

Implementation
The app is implemented using the following components and features:

MainActivity: This is where our app starts. We set up the look and feel of our app here.
1.JourneyApp Function: This is the main part of our app where we create what the user sees. We show the current stop, how much distance is covered, how much is left, and a progress bar to show the journey's progress.
2.State Management: We keep track of things that can change while the app is running, like which stop the user is currently at and whether they want distances shown in kilometers or miles.
3.LinearProgressIndicator: This is the progress bar that moves as the user travels from one stop to the next.
4.Buttons: We have buttons for the user to click on. One button moves the user to the next stop, and another button switches between showing distances in kilometers or miles.
5.StopList Function: This is where we list all the stops the user will pass by during their journey. We highlight the current stop so the user knows where they are.
6.Utility Functions: These are helper functions we use to do things like calculate how far the user has traveled and how far is left, and to handle actions like moving to the next stop or switching distance units.
7.Preview Function: This just lets us see how our app will look while we're building it.

How to Use
Clone the repository to your local machine.
Open the project in Android Studio or your preferred IDE.
Build and run the app on an Android device or emulator.
Explore the app interface to view current stop information, progress, and interact with buttons.


Screenshots
![image](https://github.com/adityajain20554/Mobile-Computing/assets/88880715/abb276cd-c426-44ee-b5cf-bdcf1c15f344)
![image](https://github.com/adityajain20554/Mobile-Computing/assets/88880715/bb024dc9-f24a-4907-a866-ef66c7c2a0f7)

Steps to Run : 
Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and ensure the code compiles.
Test your changes thoroughly.
Commit your changes and create a pull request.

