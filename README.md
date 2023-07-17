
# Instagram-Backend-Practice

This is the code for Instagram-Backend-Practice, this contains various types of mappings as and stores data of user and their instagram posts.

This also uses **Relational Data** and **JPA** for data source

This Project also uses **Sign-In**, **Sign-Up**, **Sign-Out** functionalities.



## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer trainee at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot.


# Data Flow

## Controller
-   *This section contains 2 classes which uses APIs as mentioned below* :

* ### PostController Class

    * @PostMapping("posts/post")
    * @GetMapping("posts/get")

* ### UserController Class

    * @PostMapping("userSignUp")
    * @PostMapping("userSignIn")
    * @DeleteMapping("userSignOut")
    * @PutMapping("user/updatePhoneNumber")
    * @PutMapping("user/updateAge")

## Services
-  *This section contains 3 classs with functions that helps API to perform their specific tasks* : 

* ### PostService Class

    * instaPost(Post post, String email)
    * getPost(Integer postId, String email)

* ### UserService Class
    
    * userSignUp(User user)
    * userSignIn(SignInInput signInInput)
    * userSignOut(String email)
    * findUserByEmail(String email)
    * updateNumber(String phoneNumber, String email)
    * updateAge(Integer age, String email)

* ### AuthenticationService Class
    
    * authenticate(String email, String token)
    * saveAuthToken(Authentication Token)

## Model
- *This section contains 3 models as required by project named **User**, **Post**, **Authentication**. Each have their relative datamembers in them which will be used as columns to store their respective data*.

- *This also contains a DTO with 2 classes **SignInInput** and **SignUpOutput**. They help in accomplishing sign-in, sign-out sign-up functionalities.*

##  Repository
- *This section contains 3 **Interfaces** named IUserRepo, IPostRepo, IAuthenticationRepo.*

- *All of these extends JpaRepository Interface*.


## Database Design
- *In this section we used the models as mentioned in Model section, which are used as a table to store data*.
- *It also uses **Relational Database** and **JPA** to create datastructure*.
- *We use **MYSQL** which is a management system for relational data*

## Data Structure Used

- *We used **Relational database** along with **JPA** as the data source in this project*.

- *Relational Data is stored in form of tables which further can be connected via various types of mappings/relations, such as One to One, One to Many, etc*.

- *This kind of data persists forever and we use **SQL** to manipulate this data via MYSQL.*

- *Here we also used the concept of **Mapping** which uses **Foreign Keys** to define relation between 2 tables.*
## Summary

*This project performs the task of managing User with various types of API's like **Get, Post, Put, Delete***.

*This project is also connected to a relational data which is the data source of this project.*

*We used **MVC Architecture** to create this project. 
And this is created in **SpringBoot** using **Maven** and **Java**.*

*Here a user can singup and login using **email** and **password**, and it demonstrate how they can use it to post on instagram via credentials.*


## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)


