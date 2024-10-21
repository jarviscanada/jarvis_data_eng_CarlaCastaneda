# Carla Castaneda . Jarvis Consulting

Software developer with over a year of experience and a Computer Science degree from Wilfrid Laurier University, deeply passionate about technology and education. During my placement at Teranet through Jarvis Consulting, I collaborated seamlessly across teams to ensure the delivery of top-tier software solutions. Proficient in Jira ticket management and resolution, leveraging Java, Groovy, and XML. Eager to apply my expertise in addressing complex challenges and driving innovation.

## Skills

**Proficient:** Python, Node.js, Angular, Express.js, RDBMS/SQL, Knex.js, Java, Git

**Competent:** React.js, HTML/CSS, Agile/Scrum, C, Android Studio
**Competent:** React.js, HTML/CSS, Agile/Scrum, C, Android Studio

**Familiar:** Linux/Bash, Docker, PHP, Pandas, VBA

## Jarvis Projects

Project source code: [https://github.com/jarviscanada/jarvis_data_eng_CarlaCastaneda](https://github.com/jarviscanada/jarvis_data_eng_CarlaCastaneda)


**Cluster Monitor** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_CarlaCastaneda/tree/master/linux_sql)]:
      
  - Created a Monitoring Agent program using Bash scripts which collect hardware specs and memory usage data from nodes in Linux cluster. I did this by creating a PSQL instance with docker, a database called host_agent using PSQL REPL, and tables host_info and host_usage to store the hardware specs and server usage. I then created shell scripts host_info.sh and host_usage.sh to collect the information with bash commands stored in variables and then inserted them into the respective database tables. host_usage.sh inserts a new entry to the host_usage table every minute that the server is running and is healthy. We do this by using crontab to schedule the script to execute every minute.
  - Technologies used PSQL, Docker, Linux/Bash, git/GitHub, shell scripts

**Core Java Apps** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_CarlaCastaneda/tree/master/core_java)]:
      
  - Twitter App: Developed a Twitter CRUD App that uses twitter's official API, Java, and followed the MVC design pattern to create data models of the tweet object and DAOs to get tweet data in the form of posts and get requests. I also implemented a service layer to implement the business logic, a controller which calls the corresponding service method depending on the arguments passed. I used spring boot to implement dependency management.
  - JDBC App: Developed CustomerDAO (data access object) which performs CRUD operations on customer table of hplussport database stored in docker PSQL instance. also contains a database connection Manager class to connect to JDBC URL which contains the database and host and username and password. Technologies used are JDBC to manipulate data in the database using CRUD operations and Customer objects, PSQL to access database, MVN, Docker, IntelliJ, and git/ GitHub.
  - Grep App: Developed a Grep (regex) style application in Java which can parse through a directory of Files, similar to the grep Linux command which returns matching strings from files. Able to recursively check a root directory and all its child directories for files that contain the regex pattern specified by the user in command line arguments and write the matching lines to a file also specified by the user. I have used several libraries and API's such as Stream, Arrays, ArrayList Lambda expressions, and Regex API. The IDE used is Intelliji and docker was used for deployment. 

**Twitter CRUD Web App** [[GitHub](https://github.com/carlaac99/TwitterCrud)]:
      
  - Created a twitter CRUD app to create delete and update tweets and usernames.
  - Technologies used: Angular to implement front end, Express.js to implement backend, and Knex.js used in the backend to connect to PostgreSQL database and build SQL queries.


## Highlighted Projects
**CuddleBug App** [[GitHub](https://github.com/carlaac99/CP470finalproject)]: Developed an Android application that allows users to create a movie list based on suggested movies and view movies in common with friends. Users swipe through movie titles and their posters, swiping left for dislike and right for movies they like. The movies they like then get added to their movie list called 'MyList'. For users to add friends, they must add. Used Google Firebase to implement user login, MongoDB to store users and movies, and our REST API to GET movies and their data on Android Studio with Java as the programming language.

**Sudoku Puzzle Solver** [[GitHub](https://github.com/carlaac99/CP476-FinalProject)]: Implemented the AC-3 Algorithm (Arc consistency algorithm) and backtracking that can solve a sudoku puzzle. Used MongoDB database to store user names and the time the puzzles take to solve. Can solve puzzles randomly generated or take user input. Allows the user to solve puzzles of varying difficulties and highlights the sudoku box in red if the user input violates the sudoku puzzle constraints and will not allow for any other inputs except numbers to be entered. Used Javascript, Node.js, React, Flask, Python, HTML/CSS, MongoDB


## Professional Experiences

**Software Developer, Jarvis (2022-present)**: Develop Full stack solutions using programs and applications for clients with different business needs. Practice Agile development through daily scrum meetings, using scrum boards during development, and bi-weekly sprint meetings where my team members and I discuss our progress and any impediments that we may be experiencing as we are developing.

**Tutor, Code Ninjas (2020-2021)**: Introduced students to programming using Scratch, Javascript, and the Code Ninjas curriculum based on the age and experience of the student. taught students basic Javascript syntax as well as fundamental programming concepts such as loops, global variables, data types (boolean, integer), and conditional statements in an interactive and fun way by creating simple games provided by the Code Ninjas Curriculum. Created, implemented, and managed student progress feedback system for parents and built strong communication skills through interactions with parents and students.


## Education
**Wilfrid Laurier University (2017-2022)**, Honours Bachelor of Science, Computer Science
- Entrance Scholarship: Faculty of Science
- Dean's List (2017, 2018): Faculty of Science
- Dean's List (2020, 2022): Faculty of Science
- GPA: 10.56/12
- Graduated With Distinction


## Miscellaneous
- Video Editing
- Digital Advertising and Marketing
- Flamenco
- Painting
- Hiking
