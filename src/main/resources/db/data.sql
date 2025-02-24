INSERT INTO `user` (`id`, `enabled`, `created`, `modified`, `bio`, `email`, `first_name`, `last_name`, `password`,
                    `role`, `is_teacher_access_requested`, `linked_in_profile_url`, `profile_image_path`)
VALUES
    -- Root Admin Users
    (1, 1, '2024-01-31 02:00:50.000000', '2024-01-31 02:00:50.000000', '<p>The cornerstone
of the Virtual Learning Platform, the Root Admin oversees the entire ecosystem, ensuring smooth operation and seamless
user experiences. With unparalleled authority, they manage admin roles, monitor user activities, and uphold platform
integrity. </p> <p>Driven by innovation and excellence, the Root Admin ensures that teachers, students, and admins
collaborate effectively. Their leadership ensures the platform evolves to meet modern learning demands. </p><p><em>A
visionary role shaping the future of online education.</em></p>', 'root@admin.com', 'Ivan', 'Simeonov',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ROOT_ADMIN', 0,
     'https://www.linkedin.com/in/ivannicksimeonov/', 'usersProfileImages/1/user_1_root_admin.png'),

    -- Regular Admin Users
    (2, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>Driven by innovation and excellence, the Admin
ensures that teachers and students collaborate effectively. Their leadership ensures the platform evolves to meet modern
learning demands. </p><p><em>A visionary role shaping the future of online education.</em></p>', 'max@admin.com', 'Max',
     'Mustermann', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0, NULL,
     'usersProfileImages/2/user_2_max_mustermann.png'),
    (3, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>Driven by innovation and excellence, the Admin
ensures that teachers and students collaborate effectively. Their leadership ensures the platform evolves to meet modern
learning demands. </p><p><em>A visionary role shaping the future of online education.</em></p>', 'erika@admin.com',
     'Erika', 'Mustermann', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0, NULL,
     'usersProfileImages/3/user_3_erika_mustermann.png'),

    -- Teacher Users
    (4, 1, '2024-03-15 02:00:50.000000', '2024-03-15 02:00:50.000000', '<p>An experienced professional bridging the gap
between development and operations, this teacher is dedicated to sharing expertise in automation, CI/CD pipelines, and
cloud infrastructure. With a passion for innovation, they simplify complex DevOps concepts for students.</p>
<p>From mastering tools like Docker, Kubernetes, and Jenkins to adopting agile methodologies, this teacher equips learners
with practical skills for real-world applications.</p><p><em>Empowering the next generation of DevOps professionals.</em></p>',
     'thomas@teacher.com', 'Thomas', 'Müller', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u',
     'ROLE_TEACHER',
     0, NULL, 'usersProfileImages/4/user_4_thomas_mueller.png'),
    (5, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>A seasoned software developer and mentor, this
teacher excels at breaking down complex programming concepts into manageable steps. With expertise in coding, design
patterns, and system architecture, they guide students from beginner to advanced levels.</p><p>Specializing in hands-on
projects, they foster problem-solving and critical thinking skills that prepare students for real-world challenges in
software development.</p><p><em>Turning code into innovation, one student at a time.</em></p>', 'lina@teacher.com',
     'Lina', 'Fischer', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL,
     'usersProfileImages/5/user_5_lina_fischer.png'),
    (6, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>A passionate science teacher with a knack for
making complex concepts simple and engaging. Specializing in fostering curiosity and critical thinking, they aim to
inspire the next generation of scientists and innovators through hands-on experiments and real-world applications.</p><p>
From the fundamentals of physics and chemistry to the wonders of biology, this teacher covers a wide range of topics
designed to ignite a love for discovery and learning.</p><p><em>Creating a bridge between scientific knowledge and everyday
life.</em></p>', 'james@teacher.com', 'James', 'Wilson', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u',
     'ROLE_TEACHER', 0, NULL, 'usersProfileImages/6/user_6_james_wilson.png'),
    (7, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>An accomplished business professional and
educator with a strong background in entrepreneurship, marketing, and financial management. This teacher combines
practical experience with academic knowledge to deliver impactful lessons.</p><p>Through interactive sessions, students
learn the art of strategic thinking, business planning, and market analysis, equipping them for success in competitive
industries.</p><p><em>Empowering learners to turn their ideas into reality.</em></p>', 'david@teacher.com', 'David',
     'Brown', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL,
     'usersProfileImages/7/user_7_david_brown.png'),
    (8, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>Dedicated to teaching the fundamentals and
advanced concepts of electrical engineering, this teacher combines theoretical knowledge with practical applications.
Their goal is to nurture problem-solving skills and a deep understanding of circuits, systems, and technology.</p><p>
From power systems to electronics, they provide students with the tools to excel in both academic and professional
environments.</p><p><em>Lighting up minds with the power of engineering knowledge.</em></p>', 'michael@teacher.com',
     'Michael', 'Johnson', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL,
     'usersProfileImages/8/user_8_michael_johnson.png'),
    (9, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>A dedicated personal development mentor,
this teacher is passionate about helping individuals unlock their full potential. With expertise in leadership,
time management, and emotional intelligence, they guide students toward achieving both personal and professional growth.
</p><p>Through interactive workshops and practical exercises, students learn strategies to build confidence, set
meaningful goals, and overcome challenges.</p><p><em>Empowering individuals to create a path to success and fulfillment.
</em></p>', 'anna@teacher.com', 'Anna', 'Taylor', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u',
     'ROLE_TEACHER', 0, NULL, 'usersProfileImages/9/user_9_anna_taylor.png'),
    (10, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>A creative and detail-oriented UI/UX designer
and educator, this teacher is passionate about crafting intuitive and visually appealing digital experiences. They
specialize in teaching the principles of user-centric design, wireframing, and prototyping.</p><p>Through engaging
lessons, students learn how to merge creativity with functionality to build user-friendly websites and applications.</p>
<p><em>Designing the future, one user experience at a time.</em></p>', 'lucas@teacher.com', 'Lucas', 'Kim',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL,
     'usersProfileImages/10/user_10_lucas_kim.png'),
    (11, 1, '2024-02-11 02:00:50.000000', '2024-02-11 02:00:50.000000', '<p>An advocate for healthy living, this teacher
inspires students to prioritize fitness, nutrition, and mental well-being. With a holistic approach, they provide
practical strategies for achieving a balanced and sustainable lifestyle.</p><p>From fitness planning to understanding
nutritional needs, their lessons are designed to empower students to make informed health choices.</p><p><em>Transforming
lives through the power of wellness education.</em></p>', 'marcus@teacher.com', 'Marcus', 'Anderson',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL,
     'usersProfileImages/11/user_11_marcus_anderson.png'),

    -- Student Users
    (12, 1, NOW(), NOW(), NULL, 'hans@hofer.com', 'Hans', 'Hofer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/12/user_12_hans_hofer.png'),
    (13, 1, NOW(), NOW(), NULL, 'sabine@mayer.com', 'Sabine', 'Mayer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/13/user_13_sabine_mayer.png'),
    (14, 1, NOW(0), NOW(), NULL, 'lukas@wagner.com', 'Lukas', 'Wagner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/14/user_14_lukas_wagner.png'),
    (15, 1, NOW(), NOW(), NULL, 'julia@bauer.com', 'Julia', 'Bauer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/15/user_15_julia_bauer.png'),
    (16, 1, NOW(), NOW(), NULL, 'markus@gruber.com', 'Markus', 'Gruber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/16/user_16_markus_gruber.png'),
    (17, 1, NOW(), NOW(), NULL, 'sophia@huber.com', 'Sophia', 'Huber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/17/user_17_sophia_huber.png'),
    (18, 1, NOW(), NOW(), NULL, 'felix@steiner.com', 'Felix', 'Steiner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/18/user_18_felix_steiner.png'),
    (19, 1, NOW(), NOW(), NULL, 'emma@berger.com', 'Emma', 'Berger',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/19/user_19_emma_berger.png'),
    (20, 1, NOW(), NOW(), NULL, 'paul@maier.com', 'Paul', 'Maier',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/20/user_20_paul_maier.png'),
    (21, 1, NOW(), NOW(), NULL, 'laura@wolf.com', 'Laura', 'Wolf',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/21/user_21_laura_wolf.png'),
    (22, 1, NOW(), NOW(), NULL, 'simon@weber.com', 'Simon', 'Weber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/22/user_22_simon_weber.png'),
    (23, 1, NOW(), NOW(), NULL, 'anna@schmid.com', 'Anna', 'Schmid',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/23/user_23_anna_schmid.png'),
    (24, 1, NOW(), NOW(), NULL, 'david@schwarz.com', 'David', 'Schwarz',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/24/user_24_david_schwarz.png'),
    (25, 1, NOW(), NOW(), NULL, 'sarah@koch.com', 'Sarah', 'Koch',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/25/user_25_sarah_koch.png'),
    (26, 1, NOW(), NOW(), NULL, 'max@binder.com', 'Max', 'Binder',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/26/user_26_max_binder.png'),
    (27, 1, NOW(), NOW(), NULL, 'lisa@fuchs.com', 'Lisa', 'Fuchs',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL,
     'usersProfileImages/27/user_27_lisa_fuchs.png'),
    (28, 1, NOW(), NOW(), NULL, 'thomas@auer.com', 'Thomas', 'Auer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/28/user_28_thomas_auer.png'),
    (29, 1, NOW(), NOW(), NULL, 'nina@winkler.com', 'Nina', 'Winkler',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/29/user_29_nina_winkler.png'),
    (30, 1, NOW(), NOW(), NULL, 'christian@moser.com', 'Christian', 'Moser',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/30/user_30_christian_moser.png'),
    (31, 0, NOW(), NOW(), NULL, 'philipp@schneider.com', 'Philipp', 'Schneider',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1, NULL,
     'usersProfileImages/31/user_31_philipp_schneider.png'),


    -- Disabled Student Users
    (32, 0, NOW(), NOW(), NULL, 'katarina@berg.com', 'Katarina', 'Berg',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL, NULL),
    (33, 1, NOW(), NOW(), NULL, 'marie@reiter.com', 'Marie', 'Reiter',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL, NULL),
    (34, 0, NOW(), NOW(), NULL, 'sebastian@lang.com', 'Sebastian', 'Lang',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL, NULL),
    (35, 0, NOW(), NOW(), NULL, 'victoria@keller.com', 'Victoria', 'Keller',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0, NULL, NULL),

    -- Disabled Teacher Users
    (36, 0, NOW(), NOW(), 'A Mathematics Teacher', 'robert@teacher.com', 'Robert', 'Wagner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL, NULL),
    (37, 0, NOW(), NOW(), 'A Literature Teacher', 'isabel@teacher.com', 'Isabel', 'Hoffmann',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL, NULL),
    (38, 0, NOW(), NOW(), 'A Physics Teacher', 'klaus@teacher.com', 'Klaus', 'Schmidt',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0, NULL, NULL),

    -- Disabled Admin Users
    (39, 0, NOW(), NOW(), 'A Regular Admin', 'stefan@admin.com', 'Stefan', 'Bauer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0, NULL, NULL),
    (40, 0, NOW(), NOW(), 'A Regular Admin', 'hannah@admin.com', 'Hannah', 'Weber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0, NULL, NULL);

INSERT INTO `topic` (`id`, `title`, `description`)
VALUES (1, 'Software Development', 'Learn programming languages and tools to build efficient software solutions.'),
       (2, 'Science', 'Explore major scientific disciplines and discover how science explains our world.'),
       (3, 'Business', 'Master essential business skills from management to finance for organizational success.'),
       (4, 'Engineering', 'Study engineering principles and technologies across various engineering fields.'),
       (5, 'Personal Development', 'Develop life skills, productivity habits, and strategies for personal growth.'),
       (6, 'Design', 'Learn visual design principles and tools for creating compelling digital content.'),
       (7, 'Health & Wellness', 'Discover practices for improving physical and mental well-being.');

INSERT INTO `course` (`id`, `author_id`, `topic_id`, `created`, `modified`, `title`, `short_description`,
                      `full_description`, `requirements`, `passing_score`, `difficulty_level`, `status`, `image_path`)
VALUES
    -- Software Development Courses
    (1, 5, 1, '2024-01-31 02:00:50.000000', '2024-01-31 02:00:50.000000', 'Software Development Introduction',
     'Learn the basics of software development including programming languages and tools.',
     '<p>Software development is a foundational skill in today''s tech-driven world, and this course provides a
comprehensive introduction to the key concepts and tools every developer needs to know. Whether you are considering a
career in software development or just want to gain an understanding of the field, this course will equip you with the
basics to get started on the right path.</p><p>In this course, you''ll explore the core principles of software
development, including programming languages, development methodologies, and best practices. From writing your first
lines of code to understanding how software is built and maintained, this course provides a solid foundation for your
journey into the world of programming.</p><p>Here’s what this course covers:</p><ul><li>An introduction to the basic
concepts of software development.</li><li>Overview of popular programming languages like JavaScript, Python, and Java.
</li><li>The software development life cycle (SDLC) and its stages.</li><li>How to approach problem-solving and
algorithm design.</li><li>Development tools and environments, including version control systems like Git.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to write your first program and run it using different programming languages.</li>
<li>The structure of software applications and how they interact with hardware.</li><li>The importance of debugging,
testing, and documentation in software development.</li><li>How to break down problems into smaller, manageable tasks
using algorithms.</li><li>Version control systems like Git and how they help in managing project code.</li><li>The
basics of developing software applications and understanding their life cycle from planning to deployment.</li></ul>
<p>By the end of this course, you''ll have the foundational knowledge to start writing code, debugging, and working
with development tools. Whether you continue on to advanced topics or use this course as a stepping stone, it’s the
perfect start for any aspiring software developer.</p><h6>Why this course?</h6><p>This course takes you from
understanding the basics of programming to writing your own software applications. If you want to pursue a career in
software development, or simply gain a deeper understanding of how technology works, this is the perfect place to begin
your learning journey.</p><p>Start your software development journey now! Enroll today and lay the groundwork for your
future in tech!</p>', '<ul><li>No prior knowledge is required</li><li>A desire to learn</li></ul>', 50,
     'BEGINNER', 'PUBLISHED', 'userCourseImages/1/course_1_software_dev.png'),
    (2, 5, 1, '2024-02-12 21:17:38.000000', '2024-02-12 21:17:38.000000', 'SOLID Principles',
     'Explore advanced techniques in software development and best practices.', '<p>Master the key principles of
object-oriented programming with this focused course on SOLID principles. These five foundational guidelines are essential
for designing software that is scalable, maintainable, and easy to understand. Whether you’re a developer looking to
refine your coding skills or an aspiring software engineer, this course equips you with the best practices to write clean
and robust code.</p><p>The SOLID principles—Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation,
and Dependency Inversion—serve as a blueprint for building software that adapts to change without unnecessary complexity. By
understanding and applying these principles, you’ll gain the ability to solve challenging programming problems and design
software that meets modern development standards.</p><p>Here’s what this course covers:</p><ul><li>What SOLID principles are
and why they are critical for software design.</li><li>A deep dive into each principle with examples and practical
demonstrations.</li><li>Common design patterns that align with SOLID principles.</li><li>How to identify violations of
SOLID principles in existing code and refactor it effectively.</li><li>Case studies showcasing how SOLID principles i
mprove codebases in real-world projects.</li></ul><h6>What You’ll Learn:</h6><ul><li>The importance of modularity and how
it improves code maintainability.</li><li>How to apply the Single Responsibility Principle (SRP) to reduce the complexity of
classes and methods.</li><li>Techniques to make your code extendable with the Open/Closed Principle (OCP).</li><li>Implementing
the Liskov Substitution Principle (LSP) to ensure code integrity in inheritance hierarchies.</li><li>Breaking down
interfaces into manageable parts with the Interface Segregation Principle (ISP).</li><li>Understanding Dependency Inversion (DIP)
for better decoupling of components.</li></ul><p>This course is designed to empower developers to create high-quality software.
By learning the SOLID principles, you’ll be well-equipped to tackle software projects with confidence and skill.</p><h6>Why this
course?</h6><p>SOLID principles are more than just theoretical concepts—they’re actionable techniques that transform the way you
approach software development. By the end of this course, you’ll have the knowledge and tools to create elegant, future-proof designs
for any project.</p><p>Take the next step in your software development journey. Enroll now and bring SOLID principles to your code!</p>',
     '<ul><li>Basic understanding of programming concepts</li><li>Experience with object-oriented programming</li><li>Interest in design principles</li></ul>',
     60, 'ADVANCED', 'PUBLISHED', 'userCourseImages/2/course_2_solid.png'),
    (3, 5, 1, '2024-02-14 21:20:34.000000', '2024-02-14 21:20:34.000000', 'Software Development Methodologies',
     'Understand different methodologies like Agile and Waterfall in software development.',
     '<p>Explore the essential methodologies that define modern software development. This course offers an in-depth
understanding of the frameworks and processes that enable teams to deliver high-quality software efficiently. Whether
you''re a budding developer or a seasoned engineer, mastering these methodologies will give you the edge in any software
project.</p><p>From Agile to Waterfall, Scrum to Kanban, this course covers the most widely used methodologies in the
software industry. You''ll learn how to select the right approach for your projects and how to adapt these methodologies
to meet the dynamic needs of the development cycle.</p><p>Here’s what this course covers:</p><ul><li>An overview of
traditional and modern software development methodologies.</li><li>The principles and practices of Agile development
and its variants.</li><li>Understanding the Scrum framework and its core components.</li><li>How Kanban supports
continuous delivery and workflow optimization.</li><li>Case studies showcasing the application of these methodologies
in real-world scenarios.</li></ul><h6>What You’ll Learn:</h6><ul><li>The history and evolution of software development
methodologies.</li><li>How to implement Agile principles to improve collaboration and productivity.
</li><li>The roles and responsibilities in a Scrum team and how to manage sprints effectively.</li>
<li>How to visualize workflows and eliminate bottlenecks using Kanban boards.</li>
<li>The pros and cons of Waterfall and when to use it for specific project needs.</li>
<li>Strategies to integrate hybrid models for unique business requirements.</li></ul>
<p>This course is tailored to help you understand and apply methodologies that maximize efficiency and
minimize risks in your projects. By the end, you''ll be equipped to lead or contribute effectively to
any development team.</p><h6>Why this course?</h6><p>Software development methodologies are the backbone of successful
projects. This course not only teaches you the concepts but also shows you how to implement them practically. With
real-world examples and actionable insights, you''ll be ready to take your development process to the next level.</p>
<p>Transform your approach to software development. Enroll now and master the methodologies that power the tech
industry!</p>',
     '<ul><li>Familiarity with Agile or Scrum</li><li>Experience working on software projects</li></ul>', 55,
     'ADVANCED', 'DRAFT', 'userCourseImages/3/course_3_methodologies.png'),
    (4, 4, 1, '2024-02-21 22:17:04.000000', '2024-02-21 22:17:04.000000', 'Docker and Kubernetes Basics',
     'Learn the fundamentals of Docker and Kubernetes incl. Virtual Machines.', '<p>Unlock the power of containerization and
orchestration with this beginner-friendly course on Docker and Kubernetes. Learn how these cutting-edge technologies
revolutionize software development and deployment, making applications scalable, portable, and resilient. Whether you’re
a developer, DevOps engineer, or IT enthusiast, this course provides a solid foundation in modern infrastructure
management.</p><p>Docker enables you to package applications and their dependencies into lightweight containers, while
Kubernetes automates the deployment, scaling, and management of these containers across clusters. By mastering these
tools, you’ll streamline workflows and bring efficiency to any software project.</p><p>Here’s what this course covers:</p>
<ul><li>Introduction to containerization and its benefits for development and deployment.</li><li>How to build, run, and
manage Docker containers effectively.</li><li>The architecture and key components of Kubernetes, including nodes, pods,
and clusters.</li><li>Hands-on examples of deploying and scaling applications with Kubernetes.</li><li>Best practices
for container security and orchestration.</li></ul><h6>What You’ll Learn:</h6><ul><li>The fundamentals of Docker,
including images, containers, and registries.</li><li>How to create Dockerfiles to containerize applications seamlessly.
</li><li>The basics of Kubernetes objects such as Deployments, Services, and ConfigMaps.</li><li>Scaling applications
dynamically using Kubernetes Horizontal Pod Autoscaler.</li><li>Strategies for managing stateful applications in a
Kubernetes environment.</li><li>How to troubleshoot common issues in Docker and Kubernetes setups.</li></ul><p>This
course is designed to provide practical knowledge and hands-on skills. By the end, you’ll be able to deploy containerized
applications confidently and manage them effectively using Kubernetes.</p><h6>Why this course?</h6><p>Docker and
Kubernetes are the cornerstones of modern DevOps practices. With this course, you’ll gain the skills to optimize workflows,
reduce deployment errors, and embrace the future of software development. By combining theoretical insights with
real-world use cases, this course ensures that you’re industry-ready.</p><p>Take the leap into containerization and
orchestration. Enroll now to begin your journey with Docker and Kubernetes!</p>',
     '<ul><li>No prior knowledge is required</li><li>A computer with internet access</li></ul>', 50, 'BEGINNER',
     'PUBLISHED', 'userCourseImages/4/course_4_docker_k8s.png'),
    (5, 4, 1, '2024-03-04 20:25:43.000000', '2024-03-04 20:25:43.000000', 'Become a DevOps Master',
     'Become a DevOps Master learning Jenkins & integrations with powerful tools like Docker, Ansible, AWS, GIT & more!',
     '<p>Embark on your journey to mastering DevOps, the essential framework that bridges the gap between development and
operations. This course is designed to equip you with the skills and tools necessary to build a collaborative, efficient,
and automated software development lifecycle. Whether you’re new to DevOps or looking to deepen your expertise, this
course will empower you to excel in today’s fast-paced tech industry.</p><p>DevOps is more than just tools; it’s a
cultural shift that emphasizes collaboration, automation, and continuous improvement. Through this course, you’ll learn
how to implement DevOps principles effectively and leverage industry-leading tools to deliver high-quality software
faster.</p><p>Here’s what this course covers:</p><ul><li>The core principles and benefits of DevOps.</li><li>How to
create CI/CD pipelines using tools like Jenkins, GitLab, and GitHub Actions.</li><li>An introduction to infrastructure
as code with tools like Terraform and Ansible.</li><li>Monitoring and logging best practices with Prometheus and ELK
Stack.</li><li>Strategies to foster collaboration between development and operations teams.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to streamline software development with continuous integration and delivery.</li>
<li>Techniques for automating repetitive tasks and reducing manual errors.</li><li>Implementing cloud-native practices
with platforms like AWS, Azure, and Google Cloud.</li><li>How to monitor system performance and ensure application
reliability.</li><li>Approaches to scaling DevOps practices across large teams and organizations.</li><li>The future of
DevOps: Trends, challenges, and opportunities.</li></ul><p>This course provides a hands-on, practical approach to
mastering DevOps. With detailed demonstrations and real-world case studies, you’ll be ready to tackle any challenge in
the DevOps ecosystem.</p><h6>Why this course?</h6><p>DevOps is not just a buzzword—it’s a necessity in modern software
development. By mastering DevOps, you’ll become a key asset to any organization, driving innovation and efficiency. This
course combines practical skills with actionable insights to help you succeed in your DevOps journey.</p><p>Don’t wait
to revolutionize your development process. Enroll now and become a DevOps master!</p>',
     '<ul><li>Basic understanding of Linux and command line</li><li>Some experience with version control systems</li></ul>',
     60, 'INTERMEDIATE', 'PUBLISHED', 'userCourseImages/5/course_5_devops.png'),

    -- Science Courses
    (6, 6, 2, '2024-03-08 08:49:10.000000', '2024-03-08 08:49:10.000000', 'Fundamentals of Physics',
     'An introductory course covering the basic principles of physics.',
     '<p>Explore the fascinating world of physics and uncover the principles that govern the universe with this
comprehensive introductory course. Designed for beginners and enthusiasts alike, this course provides a strong foundation
in the fundamental concepts of physics, from motion and forces to energy and matter. Whether you''re preparing for
further studies or simply curious about the natural world, this course will ignite your passion for discovery.</p>
<p>Physics is the cornerstone of all sciences, explaining everything from the smallest particles to the vastness of space.
Through engaging lessons and practical examples, you''ll develop an understanding of how the physical laws shape our
world and how they apply to real-life scenarios.</p><p>Here’s what this course covers:</p><ul><li>Core principles of
physics, including mechanics, thermodynamics, and electromagnetism.</li><li>The laws of motion and their applications
in everyday life.</li><li>Understanding energy, work, and power in physical systems.</li><li>The basics of waves, sound,
and light.</li><li>An introduction to modern physics topics like relativity and quantum mechanics.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>The foundational concepts of motion, forces, and Newton’s laws.</li>
<li>How to calculate energy transformations and their practical applications.</li><li>The behavior of waves and the
properties of sound and light.</li><li>An overview of electric and magnetic fields and their interactions.</li>
<li>The role of physics in technology and innovation.</li><li>How to think critically and solve physics problems
effectively.</li></ul><p>This course offers a blend of theoretical insights and practical exercises to help you grasp
the essence of physics. By the end, you''ll have a clear understanding of the physical world and the skills to apply
this knowledge in academic or professional pursuits.</p><h6>Why this course?</h6><p>Physics is more than equations and
theories—it''s a way to understand and appreciate the universe. This course makes complex concepts accessible and
engaging, laying the groundwork for further exploration in science and engineering. With real-world examples and
interactive lessons, you’ll find physics both enjoyable and meaningful.</p><p>Step into the world of physics and
discover its wonders. Enroll now to begin your journey into the fundamentals of physics!</p>',
     '<ul><li>No prior knowledge is required</li><li>A curiosity about the natural world</li></ul>', 60, 'BEGINNER',
     'PUBLISHED',
     'userCourseImages/6/course_6_physics.png'),
    (7, 6, 2, '2024-03-25 18:45:58.000000', '2024-03-25 18:45:58.000000', 'Astrophysics: Exploring the Universe',
     'Delve into astrophysics and learn about celestial phenomena.', '<p>Embark on a cosmic journey through the wonders
of the universe with this captivating course on astrophysics. Designed for enthusiasts and aspiring astronomers, this
course explores the mysteries of space, from the birth of stars to the mechanics of black holes and galaxies. Whether
you''re a beginner or a science enthusiast, this course will deepen your understanding of the universe and inspire awe
for its vastness.</p><p>Astrophysics combines physics and astronomy to study celestial phenomena. By delving into the
cosmos, you''ll gain insights into the origins of the universe, the behavior of celestial bodies, and the forces that
shape our galaxy. This course makes complex topics approachable and exciting.</p><p>Here’s what this course covers:</p>
<ul><li>The formation and lifecycle of stars, from nebulae to supernovae.</li><li>The structure and dynamics of galaxies,
including our Milky Way.</li><li>The fundamentals of black holes, dark matter, and dark energy.</li><li>An introduction
to the Big Bang theory and cosmic evolution.</li><li>Exploration of exoplanets and the search for extraterrestrial life.
</li></ul><h6>What You’ll Learn:</h6><ul><li>The processes that lead to star formation and stellar evolution.</li>
<li>How galaxies form, interact, and evolve over time.</li><li>The science behind black holes and their impact on
space-time.</li><li>Techniques used by astronomers to study the universe.</li><li>The role of astrophysics in space
exploration and technology.</li><li>How to interpret celestial phenomena and astronomical data.</li></ul><p>This course
blends scientific theories with awe-inspiring visuals and practical insights. By the end, you''ll have a profound
understanding of the universe and the tools to pursue further studies in astronomy and astrophysics.</p>
<h6>Why this course?</h6><p>The universe is a vast and mysterious place, and astrophysics helps us unravel its secrets.
This course offers a unique combination of knowledge and wonder, making complex concepts accessible and engaging. With
a focus on exploration and discovery, you''ll leave with a newfound appreciation for the cosmos.</p><p>Begin your
journey among the stars. Enroll now and explore the universe through the lens of astrophysics!</p>',
     '<ul><li>Basic understanding of physics</li><li>Interest in space and astronomy</li></ul>', 60, 'INTERMEDIATE',
     'PUBLISHED', 'userCourseImages/7/course_7_astrophysics.png'),
    (8, 6, 2, '2024-03-27 12:58:09.000000', '2024-03-27 12:58:09.000000', 'Quantum Mechanics Basics',
     'A beginner-friendly introduction to the principles of quantum mechanics.', '<p>Dive into the intriguing world of
quantum mechanics with this introductory course designed for curious minds and budding physicists. Quantum mechanics
reveals the behavior of matter and energy at the smallest scales, challenging our understanding of reality. This course
simplifies complex concepts and makes the fascinating quantum world accessible to learners of all levels.</p><p>Quantum
mechanics forms the foundation of modern physics and technology, influencing fields like computing, cryptography,
and materials science. By exploring its principles, you''ll gain insights into the nature of atoms, particles, and waves,
and discover how quantum phenomena shape our universe.</p><p>Here’s what this course covers:</p><ul><li>The historical
development and key experiments of quantum mechanics.</li><li>Core principles such as wave-particle duality and
superposition.</li><li>The uncertainty principle and its implications.</li><li>An introduction to quantum states and
wave functions.</li><li>Applications of quantum mechanics in modern technology.</li></ul><h6>What You’ll Learn:</h6><ul>
<li>The significance of Planck’s constant and its role in quantization.</li><li>How particles exhibit wave-like
behavior and vice versa.</li><li>The mathematics of wavefunctions and probability densities.</li><li>The basics of
quantum entanglement and its real-world applications.</li><li>The role of quantum mechanics in developing technologies
like lasers and semiconductors.</li><li>How to think critically and approach problems from a quantum perspective.</li>
</ul><p>This course combines theory with real-world examples to make quantum mechanics relatable and exciting. By the
end, you''ll understand the fundamental principles and be ready to explore more advanced topics in physics and
engineering.</p><h6>Why this course?</h6><p>Quantum mechanics isn''t just for physicists—it''s a gateway to understanding
the fundamental building blocks of our universe. This course provides a balance of scientific rigor and intuitive
explanations, ensuring a rewarding learning experience for all.</p><p>Unlock the mysteries of the quantum world.
Enroll now to start your journey into quantum mechanics!</p>',
     '<ul><li>No prior knowledge is required</li><li>A willingness to learn complex concepts</li></ul>', 60, 'BEGINNER',
     'DRAFT', 'userCourseImages/8/course_8_quantum_mechanics.png'),
    (9, 6, 2, '2024-03-28 22:37:17.000000', '2024-03-28 22:37:17.000000', 'Chemistry Fundamentals',
     'An introduction to the basic concepts of chemistry and its applications.', '<p>Uncover the essential principles of
chemistry and explore the building blocks of matter in this foundational course. Designed for beginners and students,
this course lays the groundwork for understanding chemical processes and reactions, equipping you with the knowledge to
succeed in science and engineering fields.</p><p>Chemistry connects the physical and biological sciences, explaining how
atoms and molecules interact to create the world around us. From the composition of substances to the energy changes in
reactions, this course provides a comprehensive introduction to the subject.</p><p>Here’s what this course covers:</p>
<ul><li>The structure of atoms, elements, and the periodic table.</li><li>The basics of chemical bonding and molecular
structure.</li><li>An introduction to stoichiometry and balancing chemical equations.</li><li>The properties of gases,
liquids, and solids.</li><li>Acids, bases, and their roles in chemical reactions.</li></ul><h6>What You’ll Learn:</h6>
<ul><li>The periodic trends and how they influence element behavior.</li><li>How to predict and explain chemical bonding
and molecular geometry.</li><li>The principles of conservation of mass in chemical equations.</li><li>The relationship
between energy, heat, and chemical processes.</li><li>The role of solutions, solubility, and concentration in reactions.
</li><li>Techniques for conducting safe and effective experiments in the lab.</li></ul><p>This course provides a mix of
theoretical knowledge and practical applications to help you understand and appreciate chemistry. By the end, you’ll
have the tools to excel in academic studies or apply chemistry in real-world scenarios.</p><h6>Why this course?</h6>
<p>Chemistry is the science of change, and understanding it is key to exploring the natural world. This course makes
chemistry engaging and accessible, breaking down complex topics into clear and manageable lessons.</p><p>Start your
journey into the fascinating world of chemistry. Enroll now and master the fundamentals of this essential science!</p>',
     '<ul><li>No prior knowledge is required</li><li>Interest in chemistry and its applications</li></ul>', 60,
     'BEGINNER', 'DRAFT', 'userCourseImages/9/course_9_chemistry.png'),

    -- Business Courses
    (10, 7, 3, '2024-05-03 21:05:07.000000', '2024-05-03 21:05:07.000000', 'Entrepreneurship Essentials',
     'Learn the key skills needed to start and run a successful business.', '<p>Turn your business ideas into reality
with this comprehensive course on entrepreneurship essentials. Whether you''re a budding entrepreneur or someone looking
to start their journey, this course equips you with the knowledge and tools needed to create and grow a successful business.
</p><p>Entrepreneurship is about identifying opportunities, solving problems, and creating value. Through this course,
you’ll learn how to navigate the challenges of starting and managing a business while developing the mindset needed to
thrive in today’s competitive landscape.</p><p>Here’s what this course covers:</p><ul><li>The key traits and skills of
successful entrepreneurs.</li><li>How to identify market opportunities and develop a unique value proposition.</li>
<li>Creating effective business plans and strategies.</li><li>Understanding the basics of finance, marketing, and
operations.</li><li>The role of innovation and adaptability in business success.</li></ul><h6>What You’ll Learn:</h6>
<ul><li>How to analyze market trends and identify target audiences.</li><li>The steps to create a robust business model
and strategy.</li><li>Effective methods for securing funding and managing finances.</li><li>Techniques to market your
product or service and build a brand.</li><li>The importance of networking and building professional relationships.</li>
<li>How to handle risks and make informed decisions under uncertainty.</li></ul><p>This course offers actionable insights
and real-world examples to help you launch and grow your business. By the end, you''ll have a clear path to
entrepreneurship and the confidence to take the next step.</p><h6>Why this course?</h6><p>Entrepreneurship isn’t just
about starting a business—it’s about creating opportunities and making an impact. This course provides the foundation
you need to succeed in a rapidly changing world, combining practical skills with a visionary approach.</p><p>Take charge
of your future. Enroll now and begin your journey as an entrepreneur!</p>',
     '<ul><li>No prior knowledge is required</li><li>Passion for entrepreneurship</li></ul>', 60, 'BEGINNER',
     'PUBLISHED', 'userCourseImages/10/course_10_enterpreneurship.png'),
    (11, 7, 3, '2024-05-26 02:56:47.000000', '2024-05-26 02:56:47.000000', 'Advanced Marketing Strategies',
     'Explore advanced marketing strategies for business growth.',
     '<p>Take your marketing knowledge to the next level with this advanced course designed for professionals looking to
master modern marketing techniques. Whether you''re a marketer or a business owner, this course helps you develop
strategies that drive business growth, enhance customer engagement, and boost ROI.</p><p>Advanced marketing strategies
involve a deep understanding of consumer behavior, digital tools, and data analytics. By applying these strategies,
you''ll be equipped to create impactful campaigns, lead successful product launches, and influence brand perception in a
competitive market.</p><p>Here’s what this course covers:</p><ul><li>Understanding the psychology of consumer behavior.</li>
<li>Advanced techniques in digital marketing, including SEO, SEM, and social media marketing.</li><li>How to leverage
content marketing and storytelling for deeper connections.</li><li>Using data analytics to track performance and optimize
strategies.</li><li>The importance of personalization and automation in marketing campaigns.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to analyze customer data and create targeted marketing strategies.</li>
<li>Effective methods for integrating traditional and digital marketing.</li><li>The role of artificial intelligence and
machine learning in modern marketing.</li><li>How to build strong brand loyalty and customer retention strategies.</li>
<li>Advanced SEO and SEM techniques to increase online visibility.</li><li>The importance of cross-channel marketing and
multi-platform campaigns.</li></ul><p>This course combines theoretical insights with practical case studies, providing
you with the skills to lead high-performing marketing teams and execute impactful marketing strategies.</p>
<h6>Why this course?</h6><p>As marketing evolves, staying ahead of trends and mastering advanced techniques becomes
essential. This course helps you become a strategic marketer capable of delivering exceptional results across all
channels.</p><p>Elevate your marketing expertise. Enroll now and start mastering the strategies that drive success
in the digital age!</p>',
     '<ul><li>Understanding of basic marketing concepts</li><li>Experience with business strategy</li></ul>', 60,
     'ADVANCED', 'PUBLISHED', 'userCourseImages/11/course_11_marketing.png'),
    (12, 7, 3, '2024-05-28 20:45:08.000000', '2024-05-28 20:45:08.000000', 'Financial Management for Entrepreneurs',
     'Understand financial management principles essential for entrepreneurs.',
     '<p>Master the key financial management principles every entrepreneur needs to know to make informed decisions and
build a sustainable business. This course covers essential topics such as budgeting, cash flow, and financing to help you
take control of your business’s financial health.</p><p>Understanding financial management is crucial for any entrepreneur,
as it empowers you to allocate resources efficiently, manage risks, and maximize profitability. By learning these principles,
you''ll be better equipped to navigate financial challenges and plan for future growth.</p><p>Here’s what this course
covers:</p><ul><li>How to create and manage a business budget.</li><li>Understanding and improving cash flow for your
business.</li><li>Different sources of financing for small businesses.</li><li>The basics of financial statements and
their role in decision-making.</li><li>How to make data-driven financial decisions and forecasts.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>The importance of financial planning and budgeting for long-term success.</li>
<li>How to manage working capital and optimize cash flow.</li><li>Different financing options, including loans, equity,
and crowdfunding.</li><li>How to interpret financial statements like balance sheets and income statements.</li><li>How
to use financial data to make informed business decisions.</li><li>Effective strategies for reducing costs and maximizing
profits.</li></ul><p>This course provides practical tools and strategies for managing your business’s finances, with
real-world examples to guide you through the most common financial challenges faced by entrepreneurs.</p>
<h6>Why this course?</h6><p>Financial literacy is one of the most important skills for any entrepreneur. This course
gives you the knowledge to take control of your business’s financial health, helping you avoid costly mistakes and drive
long-term profitability.</p><p>Take charge of your business finances today. Enroll now and start managing your money like
a pro!</p>',
     '<ul><li>No prior experience is needed</li><li>A basic understanding of arithmetic</li></ul>', 60, 'INTERMEDIATE',
     'DRAFT', 'userCourseImages/12/course_12_financial_management.png'),
    (13, 7, 3, '2024-05-29 15:27:53.000000', '2024-05-29 15:27:53.000000', 'Digital Marketing Strategies',
     'Learn effective digital marketing strategies to enhance online presence.',
     '<p>In today’s fast-paced digital world, mastering digital marketing is essential for businesses to reach and
engage their audience. This course teaches you how to develop, implement, and optimize digital marketing strategies
that drive measurable results.</p><p>With an ever-growing range of online platforms and marketing tools, businesses
must be strategic in their approach to digital marketing. This course covers a wide array of techniques and strategies,
from social media marketing to search engine optimization (SEO), that will help you build effective campaigns and
improve your digital presence.</p><p>Here’s what this course covers:</p><ul><li>The fundamentals of digital marketing
and the key channels available.</li><li>Effective strategies for search engine marketing (SEM) and search engine
optimization (SEO).</li><li>How to leverage social media platforms for brand building and lead generation.</li>
<li>Email marketing techniques for customer retention and engagement.</li><li>Measuring success with analytics tools
and making data-driven decisions.</li></ul><h6>What You’ll Learn:</h6><ul><li>How to create a comprehensive digital
marketing strategy.</li><li>SEO and SEM techniques to improve online visibility and attract traffic.</li><li>Best
practices for leveraging social media for business growth.</li><li>How to optimize digital ads to maximize return on
investment (ROI).</li><li>Advanced email marketing tactics to nurture customer relationships.</li><li>How to use Google
Analytics and other tools to measure campaign success.</li></ul><p>By combining theory with hands-on practice, this
course prepares you to execute effective digital marketing strategies and grow your business online.</p>
<h6>Why this course?</h6><p>Digital marketing is essential for success in the modern business landscape. This course
gives you the tools and techniques needed to master digital marketing and achieve your business objectives.</p>
<p>Level up your digital marketing skills. Enroll now and start driving meaningful results for your business!</p>',
     '<ul><li>Understanding of basic marketing concepts</li><li>Experience with digital marketing tools</li></ul>', 60,
     'INTERMEDIATE', 'PUBLISHED', 'userCourseImages/13/course_13_digital_marketing.png'),

    -- Engineering Courses
    (14, 8, 4, '2024-05-30 04:33:16.000000', '2024-05-30 04:33:16.000000', 'Electrical Engineering Basics',
     'An introductory course on electrical engineering concepts.',
     '<p>This comprehensive course provides an introduction to electrical engineering, covering fundamental principles
that are essential for understanding electrical systems. Whether you''re a student, aspiring engineer, or hobbyist,
this course will help you grasp the core concepts and apply them in real-world scenarios.</p><p>Electrical engineering
is the backbone of many modern technologies. From power generation to communication systems, electrical engineers are
responsible for designing, developing, and optimizing the electrical systems that power our world. In this course,
you’ll learn the basics of electricity, circuits, and electronics to build a strong foundation for further study in
electrical engineering.</p><p>Here’s what this course covers:</p><ul><li>Introduction to electrical circuits and
components like resistors, capacitors, and inductors.</li><li>Basic circuit analysis techniques including
Ohm’s Law, Kirchhoff’s Laws, and more.</li><li>Understanding alternating current (AC) and direct current (DC) systems.</li>
<li>Introduction to semiconductor devices like diodes and transistors.</li><li>Key concepts in signal processing and
electrical power generation.</li></ul><h6>What You’ll Learn:</h6><ul><li>The fundamentals of electrical circuits, including
current, voltage, and resistance.</li><li>How to apply Ohm''s Law and Kirchhoff’s Laws for circuit analysis.</li>
<li>How to work with both AC and DC circuits and understand their differences.</li><li>How semiconductors and transistors
are used in modern electrical systems.</li><li>The basics of electrical power, energy, and their conversion in various
systems.</li><li>How to analyze simple electrical circuits and systems using basic tools and techniques.</li></ul>
<p>By the end of this course, you’ll have a strong understanding of the key concepts in electrical engineering,
which will serve as the foundation for more advanced studies or practical applications in electrical and electronic
systems.</p><h6>Why this course?</h6><p>Electrical engineering is a versatile field that plays a crucial role in almost
every technological advancement. Whether you plan to pursue a career in electrical engineering or simply want to
understand the basics, this course provides the essential knowledge to get started.</p><p>Start your journey in electrical
engineering today. Enroll now and learn the fundamental concepts that power the modern world!</p>',
     '<ul><li>No prior knowledge required</li><li>A desire to understand electrical systems</li></ul>', 60, 'BEGINNER',
     'PUBLISHED', 'userCourseImages/14/course_14_electrical_eng.jpg'),
    (15, 8, 4, '2024-06-01 06:39:08.000000', '2024-06-01 06:39:08.000000', 'Advanced Topics in Civil Engineering',
     'Explore advanced topics in civil engineering and its applications.',
     '<p>Take your civil engineering skills to the next level with this course on advanced topics in the field. Designed
for professionals or those with a background in civil engineering, this course delves deeper into the complex aspects
of structural analysis, materials science, and project management.</p><p>In civil engineering, it''s essential to
understand both the technical and managerial aspects of large infrastructure projects. This course covers advanced
principles and techniques to help you solve complex engineering problems, optimize designs, and manage large-scale
construction projects effectively.</p><p>Here’s what this course covers:</p><ul><li>Advanced techniques in structural
analysis and design.</li><li>Materials science, including the properties and applications of concrete, steel, and
composites.</li><li>Geotechnical engineering and its role in foundation design and soil analysis.</li><li>Advanced
surveying techniques and modern tools for civil engineers.</li><li>Project management strategies for large-scale
infrastructure projects.</li></ul><h6>What You’ll Learn:</h6><ul><li>How to apply advanced structural analysis
techniques to complex projects.</li><li>The properties of various construction materials and how they affect design
decisions.</li><li>How to conduct soil analysis and design foundations in different conditions.</li><li>Modern
surveying tools and methods for accurate data collection in civil engineering projects.</li><li>Project management
best practices for leading teams and delivering infrastructure projects on time and within budget.</li></ul><p>This
course is designed to help you refine your skills and apply advanced concepts to real-world civil engineering projects,
preparing you for leadership roles in the industry.</p><h6>Why this course?</h6><p>In the rapidly evolving field of civil
engineering, keeping up with the latest advancements is essential. This course equips you with the knowledge to tackle
more complex projects and improve your expertise in construction and design.</p><p>Elevate your career in civil
engineering. Enroll now and start mastering the advanced techniques that define the future of infrastructure!</p>',
     '<ul><li>Basic understanding of civil engineering principles</li><li>Knowledge of mathematics and physics</li>
<li>Familiarity with construction and design tools</li></ul>',
     60, 'ADVANCED', 'DRAFT', 'userCourseImages/15/course_15_civil_eng.png'),
    (16, 8, 4, '2024-06-07 03:01:49.000000', '2024-06-07 03:01:49.000000', 'Introduction to Mechanical Engineering',
     'Learn about the fundamentals of mechanical engineering.',
     '<p>This course provides a solid introduction to mechanical engineering, covering the fundamental principles and
practices that define the field. Whether you''re starting your studies in mechanical engineering or considering a career
in this area, this course will help you understand the basics and the essential concepts.</p><p>Mechanical engineering
is one of the broadest and most versatile fields, with applications in everything from manufacturing to robotics. This
course focuses on the key principles that underpin the design, analysis, and manufacturing of mechanical systems, giving
you a well-rounded foundation to build upon.</p><p>Here’s what this course covers:</p><ul><li>Introduction to mechanical
systems, including machines and tools.</li><li>Basic principles of mechanics, including force, motion, and energy.</li>
<li>How to use CAD (Computer-Aided Design) tools for creating mechanical drawings.</li><li>Fundamentals of thermodynamics
and heat transfer.</li><li>Basic materials science for selecting the right materials for mechanical systems.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to analyze forces and motion in mechanical systems.</li><li>The importance of
thermodynamics and energy efficiency in mechanical design.</li><li>How to use CAD software to create mechanical designs
and prototypes.</li><li>Principles of materials science and how materials impact design decisions.</li><li>Fundamental
techniques for testing and analyzing mechanical systems.</li></ul><p>This course provides you with the necessary
foundation to advance to more complex topics in mechanical engineering and prepares you to design and analyze mechanical
systems.</p><h6>Why this course?</h6><p>Mechanical engineering is a versatile field that offers numerous career
opportunities. By understanding the basics of mechanical systems and design, you’ll be prepared to embark on a rewarding
career in engineering.</p><p>Start your journey in mechanical engineering today. Enroll now and gain the essential
knowledge needed to succeed in this exciting field!</p>',
     '<ul><li>No prior knowledge required</li><li>A desire to understand mechanical systems</li></ul>', 60, 'BEGINNER',
     'DRAFT', 'userCourseImages/16/course_16_mechanical_eng.png'),

    -- Personal Development Courses
    (17, 9, 5, '2024-06-23 08:17:12.000000', '2024-06-23 08:17:12.000000', 'Leadership Skills Development',
     'Enhance your leadership skills for personal and professional growth.',
     '<p>Leadership is a critical skill in both personal and professional settings, and this course is designed to help
you develop and refine the leadership skills you need to inspire and motivate others. Whether you''re an aspiring leader
or looking to enhance your current abilities, this course offers valuable insights into the art of leadership.</p><p>In
this course, we will explore the key principles of effective leadership, from communication and decision-making to
problem-solving and team management. You''ll learn how to lead with confidence, foster collaboration, and create a positive,
productive environment for your team.</p><p>Here’s what this course covers:</p><ul><li>Key leadership traits and
qualities that define successful leaders.</li><li>Effective communication strategies for motivating and inspiring others.</li>
<li>Decision-making techniques to handle complex challenges with clarity.</li><li>Strategies for building and leading
high-performance teams.</li><li>Conflict resolution skills to maintain harmony within teams.</li></ul><h6>What You’ll Learn:</h6>
<ul><li>How to develop your own leadership style and adapt to different situations.</li><li>Techniques for clear and
persuasive communication in leadership roles.</li><li>How to make confident decisions that benefit both the team and organization.</li>
<li>Best practices for building strong, effective teams.</li><li>Methods for managing conflicts and resolving disputes within
teams.</li><li>How to inspire and motivate others to reach their full potential.</li></ul><p>By the end of this course,
you will have the tools to become a confident and capable leader, equipped with the skills necessary to drive success in
your team or organization.</p><h6>Why this course?</h6><p>Effective leadership is more than just giving orders—it’s about
inspiring others and guiding them toward success. This course empowers you to step into leadership roles with confidence
and competence, preparing you to tackle leadership challenges and lead with impact.</p><p>Take the next step in your
leadership journey. Enroll now and begin developing the skills that will make you a successful leader!</p>',
     '<ul><li>A desire to grow as a leader</li><li>Basic communication and interpersonal skills</li><li>An open mindset
for learning and self-reflection</li></ul>',
     60, 'INTERMEDIATE', 'PUBLISHED', 'userCourseImages/17/course_17_leadership.png'),
    (18, 9, 5, '2024-07-07 19:47:25.000000', '2024-07-07 19:47:25.000000', 'Time Management Techniques',
     'Learn effective time management techniques to boost productivity.',
     '<p>Time management is a crucial skill for achieving personal and professional success, and this course will teach
you the strategies and techniques necessary to manage your time more effectively. Whether you struggle with
procrastination or simply want to optimize your daily schedule, this course offers actionable tips to help you get
more done in less time.</p><p>In this course, you will learn how to prioritize tasks, set achievable goals, and stay
focused on what truly matters. You’ll discover how to break large projects into smaller tasks, organize your day, and
avoid distractions that waste your time.</p><p>Here’s what this course covers:</p><ul><li>Fundamental time management
techniques to help you take control of your schedule.</li><li>How to prioritize tasks using tools like the Eisenhower
Matrix and the ABC method.</li><li>How to break large projects into smaller, more manageable steps.</li><li>Techniques
to overcome procrastination and stay motivated.</li><li>How to balance work, study, and personal life effectively.</li>
</ul><h6>What You’ll Learn:</h6><ul><li>How to plan your day and week to maximize productivity.</li><li>The importance
of setting realistic goals and how to achieve them.</li><li>How to minimize distractions and stay focused on your
priorities.</li><li>Techniques for handling urgent vs. important tasks.</li><li>How to maintain balance and avoid burnout.
</li><li>Tools and apps that can help you stay organized and manage your time more effectively.</li></ul><p>By the end
of this course, you’ll be able to manage your time like a pro, making sure you get more done in less time while
maintaining balance in your life.</p><h6>Why this course?</h6><p>Time is our most valuable resource, and learning how to
manage it efficiently can drastically improve your productivity and overall well-being. This course provides practical
tips and techniques that can be applied immediately to improve your time management skills.</p><p>Start mastering your
time today. Enroll now and take control of your schedule!</p>',
     '<ul><li>No prior experience required</li><li>A willingness to improve productivity</li></ul>', 60, 'BEGINNER',
     'DRAFT', 'userCourseImages/18/course_18_time_management.png'),
    (19, 9, 5, '2024-07-30 10:09:50.000000', '2024-07-30 10:09:50.000000', 'Effective Communication Skills',
     'Develop communication skills for personal and professional success.',
     '<p>Effective communication is at the heart of all successful relationships, both personal and professional. This
course will teach you the key communication skills you need to express yourself clearly and confidently, while also
listening effectively and understanding others.</p><p>In this course, we will cover both verbal and non-verbal
communication techniques, helping you improve your speaking, listening, and writing skills. You’ll learn how to tailor
your communication style to different audiences and situations, as well as how to handle difficult conversations with
confidence.</p><p>Here’s what this course covers:</p><ul><li>Principles of effective communication and how to build
rapport with others.</li><li>How to improve your verbal communication skills for clarity and impact.</li><li>Non-verbal
communication techniques, including body language and facial expressions.</li><li>How to listen actively and
empathetically to understand others.</li><li>How to navigate and resolve conflicts using communication strategies.</li>
</ul><h6>What You’ll Learn:</h6><ul><li>How to develop your speaking skills to express your ideas clearly and
persuasively.</li><li>The art of active listening and how it improves your relationships.</li><li>How to use non-verbal
cues, such as body language and tone of voice, to communicate effectively.</li><li>Techniques for giving and receiving
constructive feedback.</li><li>How to manage and resolve conflicts through communication.</li><li>Effective communication
in professional settings, including presentations and meetings.</li></ul><p>By the end of this course, you’ll be equipped
with the communication skills necessary to express yourself clearly and build strong, productive relationships.</p>
<h6>Why this course?</h6><p>Whether you’re looking to improve your personal relationships or enhance your career
prospects, strong communication skills are key. This course helps you develop the tools you need to become a better
communicator and foster meaningful connections with others.</p><p>Start improving your communication skills today.
Enroll now and take your ability to connect with others to the next level!</p>',
     '<ul><li>A willingness to learn and practice communication techniques</li><li>No prior experience needed</li></ul>',
     60, 'INTERMEDIATE', 'DRAFT', 'userCourseImages/19/course_19_effective_comm.png'),
    (20, 9, 5, '2024-09-28 04:31:18.000000', '2024-09-28 04:31:18.000000', 'Stress Management Techniques',
     'Learn techniques to manage stress and improve mental health.', '<p>Stress is a natural part of life, but when left
unmanaged, it can have negative effects on both your mental and physical health. This course will teach you proven
techniques for managing stress effectively, helping you maintain balance and well-being in both personal and professional
settings.</p><p>In this course, you will learn how to identify the sources of stress in your life, how stress affects
your body and mind, and practical strategies to reduce its impact. Whether you''re facing a stressful job, personal
challenges, or general anxiety, this course provides you with tools to manage stress with confidence.</p><p>Here’s what
this course covers:</p><ul><li>The science of stress and its effects on the body and mind.</li><li>How to identify the
sources of stress in your life.</li><li>Techniques for relaxation and mindfulness to reduce stress.</li><li>How to use
time management and organization to avoid stress triggers.</li><li>How to build resilience and cope with challenging
situations.</li></ul><h6>What You’ll Learn:</h6><ul><li>How to recognize the signs and symptoms of stress before it
becomes overwhelming.</li><li>Practical relaxation techniques such as deep breathing and progressive muscle relaxation.
</li><li>The role of mindfulness and meditation in reducing stress.</li><li>How to manage your time effectively to
prevent unnecessary stress.</li><li>How to develop healthy habits and routines to reduce stress long-term.</li><li>How
to reframe your thinking to better cope with stress-inducing situations.</li></ul><p>By the end of this course, you’ll
have a comprehensive toolkit for managing stress and improving your overall well-being, helping you feel more in control
of your life.</p><h6>Why this course?</h6><p>Stress is inevitable, but with the right tools, you can prevent it from
controlling your life. This course provides you with the skills and techniques to handle stress effectively and maintain
a calm, clear mind no matter what challenges come your way.</p><p>Take the first step toward a less stressful life.
Enroll now and start managing your stress with confidence!</p>',
     '<ul><li>No prior experience required</li><li>An interest in improving mental health and well-being</li></ul>', 60,
     'BEGINNER', 'DRAFT', 'userCourseImages/20/course_20_stress_management.png'),

    -- Design Courses
    (21, 10, 6, '2024-10-22 07:07:27.000000', '2024-10-22 07:07:27.000000', 'Introduction to Graphic Design',
     'Discover the principles of graphic design and visual communication.', '<p>Graphic design is more than just making
things look pretty—it’s about communicating ideas visually and making information more accessible and engaging. This
course is an introduction to the world of graphic design, where you''ll learn the basic principles and techniques needed
to create stunning visuals.</p><p>In this course, we’ll cover the fundamentals of graphic design, from typography and
color theory to layout and composition. Whether you’re a beginner looking to break into graphic design or someone wanting
to enhance their skills, this course will provide you with the foundational knowledge you need to create effective and
eye-catching designs.</p><p>Here’s what this course covers:</p><ul><li>Introduction to the essential tools used in
graphic design.</li><li>How to use color theory and typography to create compelling designs.</li><li>Basic design
principles, including balance, contrast, and alignment.</li><li>How to design for different mediums, including digital
and print.</li><li>Techniques for designing logos, posters, and social media graphics.</li></ul><h6>What You’ll Learn:</h6>
<ul><li>How to use design software like Adobe Illustrator and Photoshop to create professional-grade designs.</li>
<li>The basics of typography, and how to choose the right fonts for your designs.</li><li>How to create color palettes
that evoke the right emotions and messages.</li><li>Techniques for creating logos and branding materials.</li><li>How to
design layouts for websites, brochures, and more.</li><li>How to create designs that work across both print and digital
platforms.</li></ul><p>By the end of this course, you’ll have the foundational skills to create visually appealing and
effective designs for a variety of applications, helping you get started in the exciting world of graphic design.</p>
<h6>Why this course?</h6><p>Whether you’re looking to pursue a career in graphic design or just want to improve your
design skills for personal projects, this course provides the knowledge you need to get started. With practical tips
and hands-on exercises, you’ll be able to create beautiful and functional designs from day one.</p><p>Start your graphic
design journey today. Enroll now and unlock your creative potential!</p>',
     '<ul><li>No prior knowledge required</li><li>An interest in creative design</li></ul>', 60, 'BEGINNER',
     'PUBLISHED', 'userCourseImages/21/course_21_graphics_design.png'),
    (22, 10, 6, '2024-11-09 11:10:28.000000', '2024-11-09 11:10:28.000000', 'UI/UX Design Fundamentals',
     'Learn the basics of user interface and user experience design.',
     '<p>UI/UX design is at the heart of creating engaging, user-friendly digital experiences. This course will teach
you the fundamental principles of UI (User Interface) and UX (User Experience) design, focusing on how to design
intuitive, aesthetically pleasing, and functional interfaces for websites and apps.</p><p>In this course, we will cover
the principles of user-centered design, wireframing, prototyping, and testing. You’ll learn how to create designs that
not only look good but also offer users a seamless, enjoyable experience.</p><p>Here’s what this course covers:</p><ul>
<li>The basics of UI and UX design, and how they work together.</li><li>How to create user personas to inform your design
decisions.</li><li>How to design wireframes and prototypes to test your ideas before building them.</li><li>The importance
of usability testing and how to conduct it.</li><li>Best practices for designing user interfaces for mobile and web
platforms.</li></ul><h6>What You’ll Learn:</h6><ul><li>How to apply user-centered design principles to create better
user experiences.</li><li>The key differences between UI and UX design and how they complement each other.</li><li>How
to create and refine wireframes and prototypes.</li><li>The role of usability testing and how to incorporate feedback
into your designs.</li><li>How to design for accessibility, ensuring your interfaces are inclusive for all users.</li>
<li>Techniques for creating responsive designs that work on both desktop and mobile devices.</li></ul><p>By the end of
this course, you will have the skills and knowledge to create intuitive, functional, and visually appealing interfaces
that enhance the user experience and meet the needs of your target audience.</p><h6>Why this course?</h6><p>UI/UX design
is a crucial skill for anyone looking to create engaging digital products. This course will equip you with the
fundamentals you need to start designing user-friendly interfaces that look great and function seamlessly.</p>
<p>Begin your journey into the world of UI/UX design today. Enroll now and learn how to create impactful user
experiences!</p>',
     '<ul><li>Basic understanding of design tools is helpful but not mandatory</li><li>A desire to create intuitive user experiences</li></ul>',
     60, 'INTERMEDIATE', 'PUBLISHED',
     'userCourseImages/22/course_22_ui_ux.png'),

    -- Health & Wellness Courses
    (23, 11, 7, '2024-11-10 10:44:27.000000', '2024-11-10 10:44:27.000000', 'Nutrition Basics for a Healthier Life',
     'Understand the fundamentals of nutrition for better health.', '<p>Good nutrition is essential for maintaining
overall health and well-being. This course will teach you the fundamentals of nutrition, helping you understand how
the food you eat impacts your body and how to make healthier choices that support a balanced lifestyle.</p><p>In this
course, we will cover the essential nutrients your body needs, how to read food labels, and how to plan balanced meals
that provide energy and promote health. Whether you''re looking to lose weight, improve your energy levels, or simply
eat better, this course will provide you with the knowledge you need to make informed nutrition choices.</p><p>Here’s
what this course covers:</p><ul><li>The importance of macronutrients (proteins, fats, and carbohydrates) and
micronutrients (vitamins and minerals).</li><li>How to read and understand food labels to make healthier choices.</li>
<li>How to plan balanced meals that provide all the necessary nutrients.</li><li>The role of hydration in maintaining
good health.</li><li>Strategies for developing healthy eating habits and avoiding common nutrition mistakes.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to create a healthy, balanced diet that suits your lifestyle and goals.</li>
<li>The essential nutrients your body needs and where to get them from food.</li><li>How to read food labels and
understand nutritional information.</li><li>How to manage portion sizes and prevent overeating.</li><li>Techniques for
staying hydrated and maintaining a healthy fluid balance.</li><li>How to make healthier food choices when dining out or
on the go.</li></ul><p>By the end of this course, you will have the knowledge to make better food choices that contribute
to your overall health and well-being.</p><h6>Why this course?</h6><p>Nutrition is the foundation of good health. This
course gives you the tools and knowledge to make healthier eating choices, supporting your body’s nutritional needs and
improving your quality of life.</p><p>Start your journey to better health today. Enroll now and take control of your
nutrition!</p>',
     '<ul><li>No prior experience required</li><li>An interest in healthy living</li></ul>', 60, 'BEGINNER',
     'PUBLISHED', 'userCourseImages/23/course_23_nutrition.png'),
    (24, 11, 7, '2024-12-03 16:40:22.000000', '2024-12-03 16:40:22.000000', 'Fitness Strategies for Wellness',
     'Explore effective fitness strategies to improve your well-being.', '<p>Physical fitness is a key component of overall
wellness, and this course will teach you the strategies and techniques needed to build a sustainable fitness routine that
works for your body and goals.</p><p>In this course, we will cover a variety of fitness topics, from strength training and
cardio to flexibility and recovery. You’ll learn how to design a balanced workout routine, how to stay motivated, and how
to prevent injury while working out. Whether you''re new to exercise or looking to optimize your fitness regimen, this
course will guide you every step of the way.</p><p>Here’s what this course covers:</p><ul><li>The basics of exercise
physiology and how your body responds to physical activity.</li><li>How to design a fitness routine that includes strength,
cardio, and flexibility exercises.</li><li>Techniques for proper form and injury prevention.</li><li>How to stay motivated
and consistent with your fitness goals.</li><li>The importance of recovery and rest in a fitness plan.</li></ul>
<h6>What You’ll Learn:</h6><ul><li>How to build a balanced workout routine tailored to your goals.</li>
<li>Exercises that improve strength, cardiovascular health, and flexibility.</li><li>Proper techniques to avoid injury
during your workouts.</li><li>How to stay motivated to work out regularly and track your progress.</li><li>The role of
rest and recovery in maintaining a healthy fitness routine.</li><li>How to adjust your fitness plan as you progress toward
your goals.</li></ul><p>By the end of this course, you’ll have the knowledge and confidence to create a personalized
fitness routine that supports your overall wellness and helps you achieve your health goals.</p><h6>Why this course?</h6>
<p>Fitness is a journey, not a destination. This course gives you the strategies and tools to build a sustainable and
effective fitness routine that will help you feel stronger, healthier, and more energetic.</p><p>Start your fitness journey
today. Enroll now and take the first step toward a healthier, fitter you!</p>',
     '<ul><li>A basic level of physical fitness</li><li>An eagerness to explore new workout strategies</li></ul>', 60,
     'INTERMEDIATE', 'DRAFT', 'userCourseImages/24/course_24_fitness.png');

INSERT INTO `lecture` (`id`, `course_id`, `sequence_number`, `title`, `description`, `assignment_task`,
                       `video_url`)
VALUES
    -- Lectures for Software Development Introduction course
    (1, 1, 1, 'Introduction to Programming', '<p>Explore the basics of programming, including key concepts like
variables, data types, and control structures.This foundational lecture will set the stage for your journey into the
world of software development.</p>', '<ul><li>Research and define key programming concepts: variables, data types, and
control structures.</li><li>Create a simple program in your chosen language to print "Hello, World!" to the console.</li>
<li>Submit a brief explanation of your code and its purpose.</li></ul>', 'https://www.youtube.com/watch?v=zOjov-2OZ0E'),
    (2, 1, 2, 'Software Development Life Cycle', '<p>Dive into the phases of the Software Development Life Cycle (SDLC),
from requirements analysis to maintenance, and understand its role in delivering successful software projects.</p>',
     '<ul><li>List the key phases of the SDLC and provide a brief description of each.</li><li>Identify examples of tasks
performed during the design and implementation phases.</li><li>Create a diagram illustrating the SDLC phases and their
sequence.</li></ul>', 'https://www.youtube.com/watch?v=Fi3_BjVzpqk'),
    (3, 1, 3, 'Debugging Techniques', '<p>Learn essential debugging techniques to identify, isolate, and resolve code
issues effectively. Gain practical skills to streamline troubleshooting in your programming journey.</p>', '<ul><li>
Describe three common debugging methods and when to use them.</li><li>Debug a provided faulty code snippet and submit
the corrected version.</li><li>Write a brief reflection on the challenges faced during debugging and how you overcame
them.</li></ul>', 'https://www.youtube.com/watch?v=Kmx_NL4_2Fk'),
    (4, 1, 4, 'Version Control with Git', '<p>Understand the fundamentals of version control with Git, including
repositories, branches, and commits. Master collaboration techniques for effective teamwork in software projects.</p>',
     '<ul><li>Install Git and set up a local repository on your computer.</li><li>Create a branch, make changes, and
commit your updates with clear messages.</li><li>Push your changes to a remote repository (if available) and document
the process.</li></ul>', 'https://www.youtube.com/watch?v=8JJ101D3knE'),

    -- Lectures for SOLID Principles course
    (5, 2, 1, 'Single Responsibility Principle', '<p>Discover the Single Responsibility Principle, a core concept in
clean code design. Learn how to ensure each class or module has a single, well-defined responsibility.</p>', '<ul><li>
Define the Single Responsibility Principle in your own words.</li><li>Identify and fix a provided code snippet that
violates this principle.</li><li>Submit your revised code along with an explanation of the changes.</li></ul>',
     'https://www.youtube.com/watch?v=5RwhyZnVRS8'),
    (6, 2, 2, 'Open Closed Principle', '<p>Learn about the Open Closed Principle, which promotes creating software
entities that are open for extension but closed for modification.</p>', '<ul><li>Explain the Open Closed Principle with
a real-world example.</li><li>Modify a provided code snippet to adhere to this principle.</li><li>Submit your updated
code and a brief explanation of your approach.</li></ul>', 'https://www.youtube.com/watch?v=VFlk43QGEgc'),
    (7, 2, 3, 'Liskov Substitution Principle', '<p>Explore the Liskov Substitution Principle, which ensures that derived
classes can seamlessly replace base classes without altering the program\'s behavior.</p>', '<ul><li>Define the Liskov
Substitution Principle and its significance in object-oriented programming.</li><li>Analyze a provided code example to
determine if it adheres to this principle.</li><li>Rewrite the code if needed and explain your modifications.</li></ul>',
     'https://www.youtube.com/watch?v=-3UXq2krhyw'),
    (8, 2, 4, 'Interface Segregation Principle', '<p>Understand the Interface Segregation Principle, which advocates for
creating specific and minimal interfaces to avoid implementing unnecessary methods.</p>', '<ul><li>Describe the Interface
Segregation Principle and its importance in reducing code complexity.</li><li>Refactor a provided code snippet to comply
with this principle.</li><li>Submit the refactored code and a short summary of your changes.</li></ul>',
     'https://www.youtube.com/watch?v=y1JiMGP51NE'),
    (9, 2, 5, 'Dependency Inversion Principle', '<p>Master the Dependency Inversion Principle, which emphasizes relying
on abstractions rather than concrete implementations for flexible and maintainable code.</p>', '<ul><li>Explain the
Dependency Inversion Principle using a practical scenario.</li><li>Refactor a provided code example to align with this
principle.</li><li>Submit the updated code along with a description of your approach.</li></ul>',
     'https://www.youtube.com/watch?v=NnZZMkwI6KI'),

    -- Lectures for Software Development Methodologies course DRAFT
    (10, 3, 1, 'What is Agile?', '<p>Understand Agile methodology, its core values, and principles that promote adaptive
planning, iterative development, and early delivery of high-quality software.</p>', '<ul><li>Explain Agile in your own
words and list its core values.</li><li>Identify scenarios where Agile would be an ideal methodology.</li><li>Create a
visual timeline of an Agile sprint.</li></ul>', 'https://www.youtube.com/watch?v=Z9QbYZh1YXY'),
    (11, 3, 2, 'What is SCRUM?', '<p>Explore SCRUM, a popular Agile framework that emphasizes teamwork, accountability,
and iterative progress toward a well-defined goal.</p>', '<ul><li>Describe the key roles in SCRUM: Product Owner, SCRUM
Master, and Development Team.</li><li>Create a mock SCRUM board with tasks for a sample project.</li><li>Write a short
summary of a typical sprint cycle.</li></ul>', 'https://www.youtube.com/watch?v=m5u0P1WPfvs'),
    (12, 3, 3, 'What is Kanban?', '<p>Learn Kanban, a workflow management method that visualizes work, limits
work-in-progress, and improves efficiency in delivering tasks.</p>', '<ul><li>Define Kanban and its primary elements,
such as boards, columns, and cards.</li><li>Create a Kanban board for a hypothetical project.</li><li>List the benefits
of using Kanban in software development.</li></ul>', 'https://www.youtube.com/watch?v=hCj1PPV9O10'),
    (13, 3, 4, 'What is Waterfall?', '<p>Understand the Waterfall model, a traditional linear approach to software
development with distinct sequential phases.</p>', '<ul><li>Outline the stages of the Waterfall model.</li><li>Discuss
the advantages and limitations of using Waterfall.</li><li>Analyze a case study where Waterfall would be an appropriate
methodology.</li></ul>', 'https://www.youtube.com/watch?v=bNLcRdrSQAU'),
    (14, 3, 5, 'Agile vs Waterfall: Choosing your methodology', '<p>Compare Agile and Waterfall methodologies,
highlighting their differences and guiding principles to help you choose the right approach for your project.</p>',
     '<ul><li>Create a comparison table of Agile vs Waterfall, focusing on phases, flexibility, and team involvement.
</li><li>Analyze a project scenario and justify your chosen methodology.</li><li>Write a short essay on the pros and
cons of Agile and Waterfall.</li></ul>', 'https://www.youtube.com/watch?v=5RocT_OdQcA'),

    -- Lectures for Docker and Kubernetes Basics course
    (15, 4, 1, 'What are Virtual Machines?', '<p>Discover Virtual Machines (VMs), software-based environments that
emulate physical computers, enabling multiple OS instances on a single machine.</p>', '<ul><li>Define Virtual Machines
and explain their benefits.</li><li>Set up a simple VM using a provided tutorial or tool.</li><li>Submit a screenshot of
your VM setup and a brief description of its configuration.</li></ul>', 'https://www.youtube.com/watch?v=wX75Z-4MEoM'),
    (16, 4, 2, 'Docker - Complete Tutorial', '<p>Master Docker, a platform for developing, shipping, and running
applications in isolated containers, ensuring consistency across environments.</p>', '<ul><li>Install Docker and set
up a sample container using a provided image.</li><li>Write and run a Dockerfile to build your custom container.</li>
<li>Submit a short report on your experience with Docker.</li></ul>',
     'https://www.youtube.com/watch?v=d-PPOS-VsC8&t=1438s'),
    (17, 4, 3, 'Kubernetes - Zero to Hero', '<p>Learn Kubernetes, a powerful container orchestration tool, from the
basics of clusters to advanced deployment and scaling techniques.</p>', '<ul><li>Define Kubernetes and its key
components: pods, nodes, and services.</li><li>Deploy a simple Kubernetes cluster using a provided tutorial.</li>
<li>Submit a diagram of your cluster and a summary of your deployment steps.</li></ul>',
     'https://www.youtube.com/watch?v=X48VuDVv0do'),

    -- Lectures for Become a DevOps Master course
    (18, 5, 1, 'Git Tutorial', '<p>Understand the basics of Git, a distributed version control system, and learn how to
manage code changes effectively in software development projects.</p>', '<ul><li>Set up Git and create a local repository.
</li><li>Practice common Git commands: add, commit, push, pull, and merge.</li><li>Submit a log of your Git activities
with brief explanations.</li></ul>', 'https://www.youtube.com/watch?v=8JJ101D3knE'),
    (19, 5, 2, 'Docker - Complete Tutorial', '<p>Master Docker, a platform for developing, shipping, and running
applications in isolated containers, ensuring consistency across environments.</p>', '<ul><li>Install Docker and set up
a sample container using a provided image.</li><li>Write and run a Dockerfile to build your custom container.</li><li>
Submit a short report on your experience with Docker.</li></ul>', 'https://www.youtube.com/watch?v=fqMOX6JJhGo'),
    (20, 5, 3, 'Jenkins Masterclass', '<p>Explore Jenkins, a leading automation server, to set up, build, and deploy
CI/CD pipelines for efficient and reliable software delivery.</p>', '<ul><li>Install Jenkins and configure a simple build
pipeline.</li><li>Integrate Jenkins with a version control system like Git.</li><li>Submit a report detailing your
pipeline configuration and outcomes.</li></ul>', 'https://www.youtube.com/watch?v=FX322RVNGj4&t=1s'),
    (21, 5, 4, 'Ansible - Zero to Hero', '<p>Learn Ansible, a powerful automation tool, to manage IT infrastructure,
streamline deployments, and simplify configuration management.</p>', '<ul><li>Install Ansible and create a basic playbook.
</li><li>Automate the deployment of a web server using Ansible.</li><li>Submit your playbook code and screenshots of the
deployment process.</li></ul>', 'https://www.youtube.com/watch?v=BS0GLQaSGPo'),
    (22, 5, 5, 'Master AWS', '<p>Master the core services of Amazon Web Services (AWS), from EC2 and S3 to advanced cloud
computing solutions for scalable applications.</p>', '<ul><li>Set up an AWS account and create an EC2 instance.</li><li>
Configure and launch a simple web application using S3 and EC2.</li><li>Submit a summary of your setup and screenshots of
your running application.</li></ul>', 'https://www.youtube.com/watch?v=HK_q1lH5x5M'),

    -- Lectures for Fundamentals of Physics course
    (23, 6, 1, 'Introduction to Physics', '<p>Delve into the foundational concepts of physics, including motion, forces,
and energy, to understand the principles that govern the natural world.</p>', '<ul><li>Write a brief explanation of
Newton’s three laws of motion.</li><li>Solve a set of basic physics problems provided in the lecture material.</li><li>
Submit your solutions and reasoning.</li></ul>', 'https://www.youtube.com/watch?v=b1t41Q3xRM8'),
    (24, 6, 2, 'Newton’s Laws of Motion', '<p>Learn Newton’s three laws of motion, which form the basis for understanding
the relationship between forces and the motion of objects.</p>', '<ul><li>Explain each of Newton’s laws with a real-world
example.</li><li>Analyze a scenario and identify which of Newton’s laws apply.</li><li>Submit a brief reflection on how
these laws relate to daily life.</li></ul>', 'https://www.youtube.com/watch?v=g550H4e5FCY'),
    (25, 6, 3, 'Energy Conservation', '<p>Understand the law of energy conservation, which states that energy cannot be
created or destroyed, only transferred or transformed.</p>', '<ul><li>Define energy conservation with practical examples.
</li><li>Calculate the energy transfer in a given physics problem.</li><li>Submit your calculations and explanations.
</li></ul>', 'https://www.youtube.com/watch?v=OTK9JrKC6EY'),
    (26, 6, 4, 'Thermodynamics Basics', '<p>Explore the fundamentals of thermodynamics, including concepts like heat,
work, and the laws governing energy transfer.</p>', '<ul><li>Write a summary of the first and second laws of thermodynamics.
</li><li>Solve a provided problem involving heat and work transfer.</li><li>Submit your answers with detailed steps.</li>
</ul>', 'https://www.youtube.com/watch?v=8N1BxHgsoOw'),
    (27, 6, 5, 'Waves and Sound', '<p>Learn about the properties of waves, including sound waves, and how they propagate
through different mediums.</p>', '<ul><li>Define the key properties of waves: wavelength, frequency, and amplitude.</li>
<li>Explain how sound travels through solids, liquids, and gases.</li><li>Submit a diagram illustrating wave propagation
and its components.</li></ul>', 'https://www.youtube.com/watch?v=s9wZkP64rAc'),

    -- Lectures for Astrophysics: Exploring the Universe course
    (28, 7, 1, 'Astrophysics Overview', '<p>Explore the field of astrophysics, focusing on the study of celestial bodies,
cosmic phenomena, and the universe’s fundamental properties.</p>', '<ul><li>Write a brief summary of key topics in
astrophysics.</li><li>Identify and describe a recent discovery in astrophysics.</li><li>Submit a short essay discussing
the significance of this discovery.</li></ul>', 'https://www.youtube.com/watch?v=TCrRs_OBN0E'),
    (29, 7, 2, 'Tidal Forces', '<p>Understand tidal forces, their impact on celestial bodies, and how they influence
phenomena like ocean tides and orbital interactions.</p>', '<ul><li>Explain the concept of tidal forces and their
effects.</li><li>Calculate the gravitational force in a given tidal scenario.</li><li>Submit your calculations and a
diagram illustrating tidal effects.</li></ul>', 'https://www.youtube.com/watch?v=N9Le2TavtX8'),
    (30, 7, 3, 'Black Holes', '<p>Dive into the mysteries of black holes, exploring their formation, properties, and the
role they play in the fabric of space-time.</p>', '<ul><li>Describe how black holes are formed.</li><li>Explain the
concept of event horizons and singularities.</li><li>Submit a diagram illustrating a black hole and its components.
</li></ul>', 'https://www.youtube.com/watch?v=r5pGFSEpBbQ'),

    -- Lectures for Quantum Mechanics Basics course DRAFT
    (31, 8, 1, 'What Is Quantum Mechanics?', '<p>Explore the fascinating world of quantum mechanics, focusing on its
fundamental principles and implications for understanding the universe.</p>', '<ul><li>Define quantum mechanics and list
its key principles.</li><li>Explain the concept of superposition with an example.</li><li>Submit a reflection on how
quantum mechanics differs from classical physics.</li></ul>', 'https://www.youtube.com/watch?v=7RmBH96QNyQ'),

    -- Lectures for Chemistry Fundamentals course DRAFT
    (32, 9, 1, 'General Chemistry explained', '<p>Understand the basics of general chemistry, including atomic structure,
chemical bonding, and reactions, to build a strong scientific foundation.</p>', '<ul><li>Write a summary of the periodic
table’s structure and significance.</li><li>Balance a set of provided chemical equations.</li><li>Submit your solutions
and a brief explanation of each step.</li></ul>', 'https://www.youtube.com/watch?v=5iTOphGnCtg'),

    -- Lectures for Entrepreneurship Essentials course
    (33, 10, 1, 'Starting Your Business', '<p>Learn the essential steps to starting a business, from idea validation to
registering your company and creating a strong foundation for success.</p>', '<ul><li>Define your business idea and target
audience.</li><li>Create a checklist of steps to register a business in your region.</li><li>Submit a draft of your
business mission statement.</li></ul>', 'https://www.youtube.com/watch?v=bXLZ8I7s8tw'),
    (34, 10, 2, 'Market Research Techniques', '<p>Discover market research techniques to identify customer needs, analyze
competition, and make data-driven business decisions.</p>', '<ul><li>List and explain three market research methods.</li>
<li>Conduct a brief survey for a hypothetical product idea.</li><li>Submit your survey results and insights.</li></ul>',
     'https://www.youtube.com/watch?v=mUlYuYooV5Y'),
    (35, 10, 3, 'Business Planning Essentials', '<p>Understand the key components of a business plan, including executive
summaries, marketing strategies, and financial forecasts.</p>', '<ul><li>Create an outline of a business plan for a fictional
company.</li><li>Describe the purpose of each section in a business plan.</li><li>Submit a draft of your company’s goals
and objectives.</li></ul>', 'https://www.youtube.com/watch?v=cqnsfLjeXtQ'),

    -- Lectures for Advanced Marketing Strategies course
    (36, 11, 1, 'Digital Marketing Fundamentals', '<p>Learn the basics of digital marketing, including SEO, social media,
and email campaigns, to grow your brand in the online world.</p>', '<ul><li>Define SEO and its importance in digital
marketing.</li><li>Create a basic social media marketing plan for a product.</li><li>Submit a short report on the benefits
of digital marketing.</li></ul>', 'https://www.youtube.com/watch?v=h95cQkEWBx0'),
    (37, 11, 2, 'Email Marketing Strategies', '<p>Explore effective email marketing strategies to build connections,
nurture leads, and drive conversions for your business.</p>', '<ul><li>Design an email marketing campaign for a product
or service.</li><li>Write a draft for a promotional email with a call-to-action.</li><li>Submit your email draft and a
strategy outline.</li></ul>', 'https://www.youtube.com/watch?v=PsC5IUiXMUs'),
    (38, 11, 3, 'Analyzing Marketing Metrics', '<p>Learn how to analyze key marketing metrics, such as conversion rates
and engagement levels, to optimize your campaigns.</p>', '<ul><li>List five important marketing metrics and their
significance.</li><li>Analyze a sample dataset to calculate a conversion rate.</li><li>Submit a report on your findings
and recommendations.</li></ul>', 'https://www.youtube.com/watch?v=eg4I-RU_vKU'),

    -- Lectures for Financial Management for Entrepreneurs course DRAFT
    (39, 12, 1, 'Digital Marketing Fundamentals', '<p>Learn the basics of digital marketing, including SEO, social media,
and email campaigns, to grow your brand in the online world.</p>', '<ul><li>Define SEO and its importance in digital
marketing.</li><li>Create a basic social media marketing plan for a product.</li><li>Submit a short report on the benefits
of digital marketing.</li></ul>', 'https://www.youtube.com/watch?v=e8wJBq6vOAI'),

    -- Lectures for Digital Marketing Strategies course
    (40, 13, 1, 'Effective Marketing Strategies', '<p>Discover effective marketing strategies to reach your audience,
build brand awareness, and drive sales for your business.</p>', '<ul><li>Define your target audience and outline a campaign
to reach them.</li><li>List three successful marketing campaigns and analyze their key elements.</li><li>Submit a
report on the strategy you would adopt for a given product.</li></ul>', 'https://www.youtube.com/watch?v=4ajmfzj9G1g'),
    (41, 13, 2, 'Psychological Marketing Triggers', '<p>Learn about psychological triggers in marketing that influence
consumer behavior and drive decision-making.</p>', '<ul><li>Identify and explain three psychological triggers in
marketing.</li><li>Create a mock advertisement using one of these triggers.</li><li>Submit your ad and a brief
explanation of the trigger used.</li></ul>', 'https://www.youtube.com/watch?v=hYZG8qnS2T4'),
    (42, 13, 3, 'Facebook Ads Tutorial', '<p>Master Facebook Ads to create and run effective ad campaigns that target
the right audience and achieve measurable results.</p>', '<ul><li>Set up a Facebook Ads account and create a basic
campaign.</li><li>Write an engaging ad copy for a sample product.</li><li>Submit your campaign setup and expected
outcomes.</li></ul>', 'https://www.youtube.com/watch?v=PRlzOTVM87Y'),

    -- Lectures for Electrical Engineering Basics course
    (43, 14, 1, 'Basics of Electrical Circuits', '<p>Understand the basics of electrical circuits, including components
like resistors, capacitors, and the principles of current and voltage.</p>', '<ul><li>Draw a simple electrical circuit
diagram with labeled components.</li><li>Calculate the resistance in a given circuit using Ohm’s Law.</li><li>Submit
your diagram and calculations.</li></ul>', 'https://www.youtube.com/watch?v=_asax7PmhcE'),
    (44, 14, 2, 'AC vs DC Current', '<p>Learn the difference between alternating current (AC) and direct current (DC),
their applications, and advantages in electrical systems.</p>', '<ul><li>Describe the key differences between AC and DC
current.</li><li>List three practical applications of AC and DC power.</li><li>Submit a comparison table of their
characteristics.</li></ul>', 'https://www.youtube.com/watch?v=vN9aR2wKv0U'),
    (45, 14, 3, 'Ohms Law', '<p>Explore Ohm’s Law, a fundamental principle in electronics, to understand the relationship
between voltage, current, and resistance.</p>', '<ul><li>Define Ohm’s Law and its formula.</li><li>Solve a set of problems
involving voltage, current, and resistance.</li><li>Submit your solutions with detailed steps.</li></ul>',
     'https://www.youtube.com/watch?v=HsLLq6Rm5tU'),

    -- Lectures for Advanced Topics in Civil Engineering course DRAFT
    (46, 15, 1, 'What is civil engineering?', '<p>Discover the field of civil engineering, focusing on designing,
constructing, and maintaining infrastructure like buildings, bridges, and roads.</p>', '<ul><li>Define civil
engineering and list its main disciplines.</li><li>Research and describe a famous civil engineering project.</li>
<li>Submit a short report on the project’s significance and challenges.</li></ul>',
     'https://www.youtube.com/watch?v=bFljMHTQ1QY'),

    -- Lectures for Introduction to Mechanical Engineering course DRAFT

    -- Lectures for Leadership Skills Development course
    (47, 17, 1, 'Goal Setting Techniques', '<p>Learn effective goal-setting techniques, including SMART goals, to
achieve personal and professional aspirations efficiently.</p>', '<ul><li>Create three SMART goals for yourself.</li>
<li>Outline the steps you will take to achieve one of the goals.</li><li>Submit a timeline for tracking your progress.
</li></ul>', 'https://www.youtube.com/watch?v=L4N1q4RNi9I'),
    (48, 17, 2, 'Building Confidence', '<p>Explore strategies to build self-confidence, including positive affirmations,
overcoming self-doubt, and practicing self-care.</p>', '<ul><li>Write down three areas where you want to build confidence.
</li><li>Create a daily routine to practice confidence-building activities.</li><li>Submit a reflection on how these
strategies impact your mindset.</li></ul>', 'https://www.youtube.com/watch?v=IitIl2C3Iy8'),
    (49, 17, 3, 'Guide to Leadership', '<p>Develop essential leadership skills, such as effective communication,
decision-making, and team management, to lead with confidence.</p>', '<ul><li>Identify three qualities of a successful
leader and explain why they are important.</li><li>Create a plan for developing one leadership skill.</li><li>Submit a
summary of your plan and progress.</li></ul>', 'https://www.youtube.com/watch?v=eXDNkwIeOqA'),

    -- Lectures for Time Management Techniques course DRAFT
    (50, 18, 1, 'Building Time Efficiency Habits', '<p>Learn how to build time-efficient habits, prioritize tasks, and
eliminate procrastination for better productivity and work-life balance.</p>', '<ul><li>Track your daily activities
for one week and identify time wasters.</li><li>Create a schedule to optimize your time management.</li><li>Submit a
before-and-after analysis of your productivity.</li></ul>', 'https://www.youtube.com/watch?v=iONDebHX9qk'),

    -- Lectures for Effective Communication Skills course DRAFT
    (51, 19, 1, 'The art of effective communication', '<p>Master the art of effective communication, including active
listening, clear articulation, and adapting messages for different audiences.</p>', '<ul><li>Describe three key
components of effective communication.</li><li>Practice active listening in a conversation and reflect on the
experience.</li><li>Submit your insights and strategies for improvement.</li></ul>',
     'https://www.youtube.com/watch?v=2Yw6dFQBklA'),

    -- Lectures for Stress Management Techniques course DRAFT

    -- Lectures for Introduction to Graphic Design course
    (52, 21, 1, 'Introduction to Graphic Design', '<p>Explore the fundamentals of graphic design, including principles
like balance, contrast, and hierarchy, to create visually appealing designs.</p>', '<ul><li>Design a simple poster using
a free graphic design tool.</li><li>Apply at least three design principles learned in this lecture.</li><li>Submit your
poster and a brief explanation of your design choices.</li></ul>', 'https://www.youtube.com/watch?v=GQS7wPujL2k'),
    (53, 21, 2, 'Introduction to Color Theory', '<p>Learn the basics of color theory, including the color wheel, harmony,
and psychological effects, to create compelling visual designs.</p>', '<ul><li>Design a color palette for a hypothetical
project.</li><li>Explain the mood and message conveyed by your chosen colors.</li><li>Submit your palette and a
description of its use case.</li></ul>', 'https://www.youtube.com/watch?v=2QTHs7QSR9o'),
    (54, 21, 3, 'Typography Basics', '<p>Understand typography basics, including font types, hierarchy, and spacing,
to create readable and aesthetically pleasing designs.</p>', '<ul><li>Select three fonts and describe their appropriate
use cases.</li><li>Create a mock design using these fonts with clear hierarchy.</li><li>Submit your design and a brief
explanation of your choices.</li></ul>', 'https://www.youtube.com/watch?v=yAuUDyUC-GM'),

    -- Lectures for UI/UX Design Fundamentals course
    (55, 22, 1, 'Introduction to UI/UX', '<p>Learn the basics of UI/UX design, focusing on user-centric principles and
practices to create intuitive and engaging interfaces.</p>', '<ul><li>Define UI and UX and explain their differences.</li>
<li>Analyze a popular app and identify three good UI/UX practices.</li><li>Submit a brief report on your analysis and
insights.</li></ul>', 'https://www.youtube.com/watch?v=55NvZjUZIO8'),
    (56, 22, 2, 'Deep dive into UI/UX', '<p>Explore advanced UI/UX concepts, including user research, wireframing, and
usability testing, for enhanced design strategies.</p>', '<ul><li>Create a wireframe for a simple application.</li><li>
Conduct usability testing with at least two participants.</li><li>Submit your wireframe and testing results.</li></ul>',
     'https://www.youtube.com/watch?v=cGQPMNilEQg'),
    (57, 22, 3, 'Top 10 UI/UX Tools', '<p>Discover the top tools for UI/UX design, such as Figma and Sketch, to
streamline your design process and collaboration.</p>', '<ul><li>Choose one UI/UX tool and explore its features.</li>
<li>Create a simple design using this tool.</li><li>Submit your design and a brief review of the tool.</li></ul>',
     'https://www.youtube.com/watch?v=dcPp_U-v3bI'),

    -- Lectures for Nutrition Basics for a Healthier Life course
    (58, 23, 1, 'Nutrition Fundamentals', '<p>Learn the basics of nutrition, including macronutrients and micronutrients,
to make informed dietary choices for a healthy lifestyle.</p>', '<ul><li>List the main macronutrients and their functions.
</li><li>Track your food intake for one day and categorize it into macronutrients.</li><li>Submit your food log and
analysis.</li></ul>', 'https://www.youtube.com/watch?v=uaFXMdTGV30'),
    (59, 23, 2, 'Healthy Eating Habits', '<p>Develop healthy eating habits by understanding portion control, balanced
diets, and mindful eating practices.</p>', '<ul><li>Plan a balanced meal for one day, including all food groups.</li>
<li>Research and share three tips for mindful eating.</li><li>Submit your meal plan and tips.</li></ul>',
     'https://www.youtube.com/watch?v=yTNN_0j5S2Q'),
    (60, 23, 3, 'How to track calories', '<p>Learn how to track your calorie intake using simple tools and techniques to
meet your dietary and fitness goals effectively.</p>', '<ul><li>Track your calorie intake for two days using an app or
manual log.</li><li>Compare your intake to your daily calorie requirements.</li><li>Submit your log and a reflection on
your findings.</li></ul>', 'https://www.youtube.com/watch?v=YwYa9UuEhqg');

INSERT INTO `user_enrolled_course` (`course_id`, `user_id`)
VALUES
    -- Enabled users enrolled courses
    (1, 12), (7, 12),
    (6, 13), (22, 13),
    (10, 14), (17, 14), (5, 14),
    (4, 15),
    (4, 16), (17, 16),
    (1, 17), (23, 17),
    (13, 18),
    (14, 19), (23, 19),
    (2, 20), (5, 20), (14, 20),
    (6, 21), (13, 21),
    (23, 22),
    (10, 23), (11, 23), (14, 23),
    (1, 25), (6, 25),
    (4, 26), (7, 26), (17, 26),
    (22, 27),
    (21, 28), (13, 28),
    (2, 30), (10, 30), (11, 30),

    -- Enrolled teachers
    (4, 5),
    (6, 5),
    (10, 5),
    (6, 4),
    (10, 4),
    (10, 6),
    (6, 7),
    (17, 7),
    (10, 9),
    (23, 9),
    (14, 10),
    (17, 11),
    (14, 11),
    (1, 11);

INSERT INTO `user_completed_course` (`course_id`, `user_id`, `completed_on`)
VALUES
    -- disabled users completed
       (1, 32, NOW()),
       (2, 32, NOW()),
       (10, 32, NOW()),
       (11, 32, NOW()),
       (13, 32, NOW()),
       (17, 32, NOW()),
       (1, 33, NOW()),
       (2, 33, NOW()),
       (10, 33, NOW()),
       (11, 33, NOW()),
       (13, 33, NOW()),
       (17, 33, NOW()),
       (1, 34, NOW()),
       (2, 34, NOW()),
       (10, 34, NOW()),
       (11, 34, NOW()),
       (13, 34, NOW()),
       (17, 34, NOW()),
       (1, 35, NOW()),
       (2, 35, NOW()),
       (10, 35, NOW()),
       (11, 35, NOW()),
       (13, 35, NOW()),
       (17, 35, NOW()),
       (1, 36, NOW()),
       (2, 36, NOW()),
       (10, 36, NOW()),
       (11, 36, NOW()),
       (13, 36, NOW()),
       (17, 36, NOW()),
       (1, 37, NOW()),
       (2, 37, NOW()),
       (10, 37, NOW()),
       (11, 37, NOW()),
       (13, 37, NOW()),
       (17, 37, NOW()),
       (1, 38, NOW()),
       (2, 38, NOW()),
       (10, 38, NOW()),
       (11, 38, NOW()),
       (13, 38, NOW()),
       (17, 38, NOW()),
       (4, 32, NOW()),
       (5, 32, NOW()),
       (4, 33, NOW()),
       (6, 33, NOW()),
       (23, 33, NOW()),
       (5, 34, NOW()),
       (6, 34, NOW()),
       (4, 35, NOW()),
       (5, 35, NOW()),
       (23, 35, NOW()),
       (6, 36, NOW()),
       (23, 36, NOW()),
       (4, 37, NOW()),
       (5, 37, NOW()),
       (6, 38, NOW()),
       (23, 38, NOW()),
       -- teachers completed courses
       (14, 5, NOW()),
       (23, 5, NOW()),
       (17, 4, NOW()),
       (23, 6, NOW()),
       (14, 7, NOW()),
       (1, 7, NOW()),
       (6, 9, NOW()),
       (10, 10, NOW()),
       (4, 10, NOW()),
       (10, 11, NOW()),
        -- enabled users completed courses
       (21, 12, NOW()),
       (22, 12, NOW()),
       (21, 13, NOW()),
       (22, 14, NOW()),
       (7, 15, NOW()),
       (22, 15, NOW()),
       (7, 16, NOW()),
       (21, 16, NOW()),
       (7, 17, NOW()),
       (7, 18, NOW()),
       (1, 20, NOW()),
       (1, 22, NOW()),
       (2, 25, NOW());

INSERT INTO `course_rating` (`id`, `course_id`, `user_id`, `rating`, `created`)
VALUES
        -- disabled users rating
       (1, 1, 32, 4, NOW()),
       (2, 2, 32, 5, NOW()),
       (3, 10, 32, 3, NOW()),
       (4, 11, 32, 4, NOW()),
       (5, 13, 32, 2, NOW()),
       (6, 17, 32, 5, NOW()),
       (7, 1, 33, 5, NOW()),
       (8, 2, 33, 4, NOW()),
       (9, 10, 33, 3, NOW()),
       (10, 11, 33, 5, NOW()),
       (11, 13, 33, 4, NOW()),
       (12, 17, 33, 2, NOW()),
       (13, 1, 34, 3, NOW()),
       (14, 2, 34, 5, NOW()),
       (15, 10, 34, 4, NOW()),
       (16, 11, 34, 3, NOW()),
       (17, 13, 34, 5, NOW()),
       (18, 17, 34, 4, NOW()),
       (19, 1, 35, 4, NOW()),
       (20, 2, 35, 5, NOW()),
       (21, 10, 35, 3, NOW()),
       (22, 11, 35, 2, NOW()),
       (23, 13, 35, 5, NOW()),
       (24, 17, 35, 3, NOW()),
       (25, 1, 36, 5, NOW()),
       (26, 2, 36, 4, NOW()),
       (27, 10, 36, 2, NOW()),
       (28, 11, 36, 4, NOW()),
       (29, 13, 36, 5, NOW()),
       (30, 17, 36, 3, NOW()),
       (31, 1, 37, 3, NOW()),
       (32, 2, 37, 5, NOW()),
       (33, 10, 37, 4, NOW()),
       (34, 11, 37, 3, NOW()),
       (35, 13, 37, 5, NOW()),
       (36, 17, 37, 4, NOW()),
       (37, 1, 38, 4, NOW()),
       (38, 2, 38, 5, NOW()),
       (39, 10, 38, 3, NOW()),
       (40, 11, 38, 5, NOW()),
       (41, 13, 38, 4, NOW()),
       (42, 17, 38, 2, NOW()),
       (43, 4, 32, 5, NOW()),
       (44, 5, 32, 4, NOW()),
       (45, 4, 33, 3, NOW()),
       (46, 6, 33, 5, NOW()),
       (47, 23, 33, 4, NOW()),
       (48, 5, 34, 2, NOW()),
       (49, 6, 34, 3, NOW()),
       (50, 4, 35, 4, NOW()),
       (51, 5, 35, 5, NOW()),
       (52, 23, 35, 2, NOW()),
       (53, 6, 36, 3, NOW()),
       (54, 23, 36, 4, NOW()),
       (55, 4, 37, 5, NOW()),
       (56, 5, 37, 3, NOW()),
       (57, 6, 38, 4, NOW()),
       (58, 23, 38, 2, NOW()),
       -- teachers graded courses
       (59, 14, 5, 5, NOW()),
       (60, 23, 5, 4, NOW()),
       (61, 17, 4, 4, NOW()),
       (62, 23, 6, 5, NOW()),
       (63, 14, 7, 5, NOW()),
       (64, 1, 7, 4, NOW()),
       (65, 6, 9, 4, NOW()),
       (66, 10, 10, 5, NOW()),
       (67, 4, 10, 4, NOW()),
       (68, 10, 11, 5, NOW()),
        -- enabled users graded courses
        (69, 21, 12, 4, NOW()),
        (70, 22, 12, 5, NOW()),
        (71, 21, 13, 4, NOW()),
        (72, 22, 14, 3, NOW()),
        (73, 7, 15, 2, NOW()),
        (74, 22, 15, 3, NOW()),
        (75, 7, 16, 1, NOW()),
        (76, 21, 16, 4, NOW()),
        (77, 7, 17, 4, NOW()),
        (78, 7, 18, 3, NOW()),
        (79, 1, 20, 2, NOW()),
        (80, 1, 22, 5, NOW()),
        (81, 2, 25, 5, NOW());

INSERT INTO `assignment_solution` (lecture_id, student_id, grade, retry_flag, submission_file_path, submission_status)
VALUES
    (5, 25, 92, 0, 'userAssignments/25/solution_U25_C2_L5.pdf', 'GRADED'),
    (6, 25, 88, 0, 'userAssignments/25/solution_U25_C2_L6.pdf', 'GRADED'),
    (7, 25, 95, 0, 'userAssignments/25/solution_U25_C2_L7.pdf', 'GRADED'),
    (8, 25, 73, 0, 'userAssignments/25/solution_U25_C2_L8.pdf', 'GRADED'),
    (9, 25, 85, 0, 'userAssignments/25/solution_U25_C2_L9.pdf', 'GRADED'),
    (15, 10, 79, 0, 'userAssignments/10/solution_U10_C4_L15.pdf', 'GRADED'),
    (16, 10, 94, 0, 'userAssignments/10/solution_U10_C4_L16.pdf', 'GRADED'),
    (17, 10, 87, 0, 'userAssignments/10/solution_U10_C4_L17.pdf', 'GRADED'),
    (23, 9, 91, 0, 'userAssignments/9/solution_U9_C6_L23.pdf', 'GRADED'),
    (24, 9, 76, 0, 'userAssignments/9/solution_U9_C6_L24.pdf', 'GRADED'),
    (25, 9, 89, 0, 'userAssignments/9/solution_U9_C6_L25.pdf', 'GRADED'),
    (26, 9, 93, 0, 'userAssignments/9/solution_U9_C6_L26.pdf', 'GRADED'),
    (27, 9, 82, 0, 'userAssignments/9/solution_U9_C6_L27.pdf', 'GRADED'),
    (28, 15, 97, 0, 'userAssignments/15/solution_U15_C7_L28.pdf', 'GRADED'),
    (29, 15, 84, 0, 'userAssignments/15/solution_U15_C7_L29.pdf', 'GRADED'),
    (30, 15, 90, 0, 'userAssignments/15/solution_U15_C7_L30.pdf', 'GRADED'),
    (28, 16, 88, 0, 'userAssignments/16/solution_U16_C7_L28.pdf', 'GRADED'),
    (29, 16, 75, 0, 'userAssignments/16/solution_U16_C7_L29.pdf', 'GRADED'),
    (30, 16, 96, 0, 'userAssignments/16/solution_U16_C7_L30.pdf', 'GRADED'),
    (28, 17, 83, 0, 'userAssignments/17/solution_U17_C7_L28.pdf', 'GRADED'),
    (29, 17, 99, 0, 'userAssignments/17/solution_U17_C7_L29.pdf', 'GRADED'),
    (30, 17, 86, 0, 'userAssignments/17/solution_U17_C7_L30.pdf', 'GRADED'),
    (28, 18, 92, 0, 'userAssignments/18/solution_U18_C7_L28.pdf', 'GRADED'),
    (29, 18, 77, 0, 'userAssignments/18/solution_U18_C7_L29.pdf', 'GRADED'),
    (30, 18, 95, 0, 'userAssignments/18/solution_U18_C7_L30.pdf', 'GRADED'),
    (33, 10, 81, 0, 'userAssignments/10/solution_U10_C10_L33.pdf', 'GRADED'),
    (34, 10, 98, 0, 'userAssignments/10/solution_U10_C10_L34.pdf', 'GRADED'),
    (35, 10, 87, 0, 'userAssignments/10/solution_U10_C10_L35.pdf', 'GRADED'),
    (33, 11, 74, 0, 'userAssignments/11/solution_U11_C10_L33.pdf', 'GRADED'),
    (34, 11, 93, 0, 'userAssignments/11/solution_U11_C10_L34.pdf', 'GRADED'),
    (35, 11, 89, 0, 'userAssignments/11/solution_U11_C10_L35.pdf', 'GRADED'),
    (43, 5, 85, 0, 'userAssignments/5/solution_U5_C14_L43.pdf', 'GRADED'),
    (44, 5, 91, 0, 'userAssignments/5/solution_U5_C14_L44.pdf', 'GRADED'),
    (45, 5, 78, 0, 'userAssignments/5/solution_U5_C14_L45.pdf', 'GRADED'),
    (43, 7, 96, 0, 'userAssignments/7/solution_U7_C14_L43.pdf', 'GRADED'),
    (44, 7, 83, 0, 'userAssignments/7/solution_U7_C14_L44.pdf', 'GRADED'),
    (45, 7, 90, 0, 'userAssignments/7/solution_U7_C14_L45.pdf', 'GRADED'),
    (47, 4, 72, 0, 'userAssignments/4/solution_U4_C17_L47.pdf', 'GRADED'),
    (48, 4, 94, 0, 'userAssignments/4/solution_U4_C17_L48.pdf', 'GRADED'),
    (49, 4, 88, 0, 'userAssignments/4/solution_U4_C17_L49.pdf', 'GRADED'),
    (52, 12, 86, 0, 'userAssignments/12/solution_U12_C21_L52.pdf', 'GRADED'),
    (53, 12, 97, 0, 'userAssignments/12/solution_U12_C21_L53.pdf', 'GRADED'),
    (54, 12, 81, 0, 'userAssignments/12/solution_U12_C21_L54.pdf', 'GRADED'),
    (52, 13, 93, 0, 'userAssignments/13/solution_U13_C21_L52.pdf', 'GRADED'),
    (53, 13, 75, 0, 'userAssignments/13/solution_U13_C21_L53.pdf', 'GRADED'),
    (54, 13, 89, 0, 'userAssignments/13/solution_U13_C21_L54.pdf', 'GRADED'),
    (52, 16, 95, 0, 'userAssignments/16/solution_U16_C21_L52.pdf', 'GRADED'),
    (53, 16, 84, 0, 'userAssignments/16/solution_U16_C21_L53.pdf', 'GRADED'),
    (54, 16, 92, 0, 'userAssignments/16/solution_U16_C21_L54.pdf', 'GRADED'),
    (55, 12, 77, 0, 'userAssignments/12/solution_U12_C22_L55.pdf', 'GRADED'),
    (56, 12, 98, 0, 'userAssignments/12/solution_U12_C22_L56.pdf', 'GRADED'),
    (57, 12, 87, 0, 'userAssignments/12/solution_U12_C22_L57.pdf', 'GRADED'),
    (55, 14, 91, 0, 'userAssignments/14/solution_U14_C22_L55.pdf', 'GRADED'),
    (56, 14, 76, 0, 'userAssignments/14/solution_U14_C22_L56.pdf', 'GRADED'),
    (57, 14, 94, 0, 'userAssignments/14/solution_U14_C22_L57.pdf', 'GRADED'),
    (55, 15, 85, 0, 'userAssignments/15/solution_U15_C22_L55.pdf', 'GRADED'),
    (56, 15, 99, 0, 'userAssignments/15/solution_U15_C22_L56.pdf', 'GRADED'),
    (57, 15, 82, 0, 'userAssignments/15/solution_U15_C22_L57.pdf', 'GRADED'),
    (58, 5, 96, 0, 'userAssignments/5/solution_U5_C23_L58.pdf', 'GRADED'),
    (59, 5, 88, 0, 'userAssignments/5/solution_U5_C23_L59.pdf', 'GRADED'),
    (60, 5, 93, 0, 'userAssignments/5/solution_U5_C23_L60.pdf', 'GRADED'),
    (58, 6, 79, 0, 'userAssignments/6/solution_U6_C23_L58.pdf', 'GRADED'),
    (59, 6, 95, 0, 'userAssignments/6/solution_U6_C23_L59.pdf', 'GRADED'),
    (60, 6, 84, 0, 'userAssignments/6/solution_U6_C23_L60.pdf', 'GRADED');
