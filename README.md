# EvotingApp

EvotingApp is a web-based voting application designed to simplify the voting process for organizations and communities. Built using Spring Boot, it allows users to register, log in, and cast votes electronically in a secure and efficient manner.

# Features
- User login and registration system.
- Manage candidate information (add, update, delete).
- Voting system that ensures one vote per user.
- View voting results in real-time.
- admin can view only the result
- Mobile-friendly interface.

 # Installation
1. Clone the repository:
   To download a copy of the project, use the following command:
   ```bash
   git clone https://github.com/Nileshkspatil/EvotingApp.git
2. Navigate into the Project Directory:
   After cloning, navigate to the project folder:
   cd EvotingApp
3. Install Dependencies: The project uses Maven to manage dependencies. Run the following command to download and install the required       
   libraries:
   mvn clean install
4. Run the Application: Once the dependencies are installed, you can start the Spring Boot application with: mvn spring-boot:run
5. Access the Application: After the application starts, open a browser and navigate to: http://localhost:8080

# Usage  

1. Register an Account:
 Users must register with a mobile number and other required details.
 If the registered mobile number matches the admin's number, the user will have admin privileges; otherwise, they will be a regular user.

2. Login:
 After registration, users can log in using their registered mobile number.
 Admin users can access features such as adding, updating, deleting users, and viewing the voting results.
 Regular users will be redirected to the EVM (Electronic Voting Machine) page after logging in.

3. Admin Features:
 Admin users can:
 Add new users.
 Update existing user details.
 Delete users.
 View the election results.

4. Casting a Vote (for Regular Users):
 After logging in, regular users are directed to the EVM page, where they can see a list of candidates.
 Users can select their preferred candidate and cast their vote.

5. VVPAT Page:
 After casting a vote, users are taken to the VVPAT (Voter Verifiable Paper Audit Trail) page, where they can clearly see the selected candidate's symbol and name.
 After verifying, users can log out.
 
6. Login Restrictions:
 Once a user casts their vote, they are logged out and cannot log in again.
 If a user logs in but encounters an issue and cannot cast their vote, they can log in again later to successfully cast their vote.

# UI Snapshots
Here is a preview of the EvotingApp interface:


# Technologies Used
- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, Javascript, Thymeleaf
- **Database**: MySQL
- **Build Tool**: Maven

# Contact
For any queries or support, please contact nileshkspatil@gmail.com.
