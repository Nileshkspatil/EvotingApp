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
2. Navigate into the Project Directory: cd EvotingApp
3. Install Dependencies: mvn clean install
4. Run the Application:  mvn spring-boot:run
5. Access the Application: http://localhost:8080

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
![home](https://github.com/user-attachments/assets/eccd527c-3cc6-4758-b13c-db4361a0d366)


![addcandidate](https://github.com/user-attachments/assets/19fe59a1-ac6b-4ba9-aca8-0126ab588fe1)

![candi-info](https://github.com/user-attachments/assets/b4481d03-52a3-4641-9969-4b3fc5c13d70)

![evm](https://github.com/user-attachments/assets/3bde0d01-744c-4a4a-b830-e824679b4028)

![vvpad](https://github.com/user-attachments/assets/215b9662-d67b-4631-8999-8c64b1eac2ce)


![result](https://github.com/user-attachments/assets/99f653dd-7ff7-4d92-b6e1-5836759956af)






# Technologies Used
- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, Javascript, Thymeleaf
- **Database**: MySQL
- **Build Tool**: Maven

# Contact
For any queries or support, please contact nileshkspatil@gmail.com.
