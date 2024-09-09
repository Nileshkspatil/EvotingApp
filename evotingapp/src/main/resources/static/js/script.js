document.addEventListener("DOMContentLoaded", function() {
    // Getting form and form fields
    const form = document.querySelector("form");
    const nameField = document.getElementById("name_field");
    const emailField = document.getElementById("email_field");
    const mobileField = document.getElementById("mobile_field");
    const passwordField = document.getElementById("password_field");

    // Regular expressions for validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const mobileRegex = /^[0-9]{10}$/;

    // Function to validate form fields
    function validateForm() {
        let isValid = true;
        
        // Name validation: should not be empty
        if (nameField.value.trim() === "") {
            alert("Please enter your name.");
            nameField.focus();
            isValid = false;
        }
        
        // Email validation: must match email regex
        else if (!emailRegex.test(emailField.value.trim())) {
            alert("Please enter a valid email address.");
            emailField.focus();
            isValid = false;
        }
        
        // Mobile number validation: must be 10 digits
        else if (!mobileRegex.test(mobileField.value.trim())) {
            alert("Please enter a valid 10-digit mobile number.");
            mobileField.focus();
            isValid = false;
        }
        
        // Password validation: should not be empty
        else if (passwordField.value.trim() === "") {
            alert("Please enter your password.");
            passwordField.focus();
            isValid = false;
        }

        return isValid;
    }

    // Adding event listener to form on submit
    form.addEventListener("submit", function(event) {
        if (!validateForm()) {
            // Prevent form submission if validation fails
            event.preventDefault();
        }
    });
});
