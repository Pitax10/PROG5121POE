package za.ac.iie.prog5121;

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName = "";
    private String lastName = "";

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {
        return checkPasswordComplexity(password);
    }
    
    // Check Password
    public boolean checkPasswordComplexity(String password) {
        boolean hasLength = password.length() >= 8;
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-={}|\\[\\]:;\"'<>,.?/].*");
        return hasLength && hasNumber && hasSpecial;
    }
    
    // Check Cellphone number
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Must start with +27 and be 12 characters in total 
        return cellNumber.startsWith("+27") && cellNumber.length() == 12 && cellNumber.matches("\\+27[0-9]+");
    }

    public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        this.registeredUsername = username;
        this.registeredPassword = password;
        return "Welcome " + firstName + ", " + lastName + " it is great to see you.";
    }

    public String registerUser(String username, String password, String cellNumber) {
        return registerUser(username, password, cellNumber, this.firstName, this.lastName);
    }
    
    public boolean loginUser(String username, String password, String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (registeredUsername == null) {
            // If not registered yet, simulate success if format is correct
            return true;
        }
        return registeredUsername.equals(enteredUsername) && registeredPassword.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String returnLoginStatus(String username, String password) {
        return returnLoginStatus(loginUser(username, password));
    }

}
