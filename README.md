# Vote Easy

Vote Easy is a secure and intuitive Android application designed to facilitate voter authentication, voter ID registration, and seamless voting functionality. Built using Firebase for backend services and Firestore for database storage, the app ensures a smooth and secure user experience throughout the voting process.

# Contributing
**Contributions are welcome! If you have ideas for improving Vote Easy, feel free to fork the repository, make changes, and submit a pull request.**

## Features

### Authentication

- **Login and Signup**:
  - Users must sign up to create an account.
  - Only authenticated users can access the application features.

### Home Page

- A clean and responsive design with four main buttons to navigate the app.
- A dedicated button at the top for **Voter ID Registration**:
  - Users can register their voter ID number.
  - The entered voter ID is securely stored in Firestore.

### Bottom Navigation

- Includes 5-6 intuitive options for easy navigation within the app.

### Voting System

- **Vote Page**:
  - Utilizes a TabLayout for easy access to voter features.
  - Users can view candidate details, including profiles and manifestos.
  - A **Vote** button lets users proceed to the voting interface.
  
- **Casting a Vote**:
  - Users see a list of candidates along with checkboxes for selection.
  - Confirmation is required before casting the final vote, ensuring user intent is captured accurately.

### Firebase Integration

- **Authentication**: Secure email and password authentication for users.
- **Firestore Database**: Stores registered voter ID numbers and voting-related data.

## Tech Stack

- **Programming Language**: Java
- **Development Environment**: Android Studio
- **Backend**: Firebase Authentication and Firestore Database
- **UI/UX Framework**: Material Design

## Navigation

- Bottom Navigation for seamless app exploration.
- TabLayout for modularized access to voting features.

## Future Enhancements placed but not sure will it be done
- Add real-time vote tracking and results display.
- Include push notifications for voter reminders and updates.
= Enhance UI/UX for a more dynamic experience.


## License
This project is licensed under the MIT License. See the LICENSE file for more details.
