# Java Quiz Game 🎯

A console-based quiz game built in Java that fetches trivia questions from the Open Trivia Database API and provides an interactive quiz experience.

## Features ✨

- **Dynamic Questions**: Fetches 5 random multiple-choice trivia questions from the Open Trivia Database
- **Interactive Console Interface**: User-friendly command-line interface with emojis and clear formatting
- **Real-time Scoring**: Tracks and displays your score as you progress through the quiz
- **HTML Decoding**: Properly handles HTML entities in questions and answers
- **Immediate Feedback**: Shows correct answers when you get a question wrong

## Project Structure 📁

```
Java_QuizGame_Project/
├── src/
│   ├── QuizGame.java      # Main class with game logic and user interface
│   ├── Question.java      # Question model class
│   ├── QuizService.java   # Service class for API calls and data processing
│   └── *.class           # Compiled Java bytecode files
├── lib/
│   └── json-simple-1.1.1.java.jar  # JSON parsing library
├── run.bat               # Windows batch script to compile and run the game
└── README.md            # This file
```

## Prerequisites 📋

- **Java Development Kit (JDK)** 8 or higher
- **Internet Connection** (required to fetch questions from the API)
- **Windows OS** (for the provided batch script)

## How to Run 🚀

### Option 1: Using the Batch Script (Windows)

1. Double-click `run.bat` or run it from the command prompt:
   ```bash
   run.bat
   ```

### Option 2: Manual Compilation and Execution

1. **Compile the Java files:**
   ```bash
   javac -cp ".;lib/json-simple-1.1.1.java.jar" src\*.java
   ```

2. **Run the game:**
   ```bash
   java -cp ".;lib/json-simple-1.1.1.java.jar;src" QuizGame
   ```

## How to Play 🎮

1. **Start the Game**: Run the application using one of the methods above
2. **Answer Questions**: For each question, you'll see:
   - The question text
   - Four multiple-choice options (numbered 1-4)
   - A prompt to enter your answer
3. **Enter Your Choice**: Type the number (1-4) corresponding to your answer
4. **Get Feedback**: The game will immediately tell you if you're correct or wrong
5. **View Final Score**: After all 5 questions, see your total score

## Example Gameplay 🎪

```
Q1: What is the capital of France?
1. London
2. Berlin
3. Paris
4. Madrid
Your answer (1-4): 3
✅ Correct!

Q2: Which planet is known as the Red Planet?
1. Venus
2. Mars
3. Jupiter
4. Saturn
Your answer (1-4): 1
❌ Wrong! Correct: Mars

🎉 Game Over! Your Score: 4/5
```

## Technical Details 🔧

### Classes Overview

- **`QuizGame`**: Main class containing the game loop and user interface logic
- **`Question`**: Model class representing a quiz question with options and correct answer
- **`QuizService`**: Service class that handles API communication and data processing

### External Dependencies

- **JSON Simple 1.1.1**: Used for parsing JSON responses from the Open Trivia Database API
- **Open Trivia Database API**: Provides the trivia questions (https://opentdb.com/)

### API Integration

The game fetches questions from: `https://opentdb.com/api.php?amount=5&type=multiple`

This endpoint returns 5 multiple-choice trivia questions in JSON format.

## Troubleshooting 🛠️

### Common Issues

1. **"Class not found" error**: Make sure you're running the java command from the project root directory
2. **Compilation errors**: Ensure the JSON Simple JAR file is in the `lib/` directory
3. **Network errors**: Check your internet connection as the game requires API access
4. **Input errors**: Make sure to enter numbers 1-4 when answering questions

### System Requirements

- Java 8+ installed and configured in PATH
- At least 50MB of available memory
- Active internet connection

## Future Enhancements 🚀

Potential improvements for the game:

- [ ] Add difficulty level selection
- [ ] Implement different question categories
- [ ] Add a timer for each question
- [ ] Save high scores to a file
- [ ] Create a GUI version
- [ ] Add multiplayer support
- [ ] Implement question caching for offline play

## Contributing 🤝

Feel free to fork this project and submit pull requests for any improvements!

## License 📄

This project is open source and available under the [MIT License](LICENSE).

---

**Enjoy the quiz! 🎉**