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
     'thomas@teacher.com', 'Thomas', 'Müller', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER',
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
    (1, 1, 1, 'Introduction to Programming', 'Basics of programming languages.',
     'This lecture covers the fundamentals of programming languages such as Python and Java. You will learn about syntax, variables, and control structures.',
     'https://www.youtube.com/watch?v=zOjov-2OZ0E'),
    (2, 1, 2, 'Software Development Life Cycle', 'Overview of SDLC phases.',
     'Learn about the different phases of the Software Development Life Cycle (SDLC) and how they contribute to successful project completion.',
     'https://www.youtube.com/watch?v=Fi3_BjVzpqk'),
    (3, 1, 3, 'Debugging Techniques', 'Effective debugging strategies.',
     'In this lecture, we will explore various debugging techniques that can help you identify and fix errors in your code efficiently.',
     'https://www.youtube.com/watch?v=Kmx_NL4_2Fk'),
    (4, 1, 4, 'Version Control with Git', 'Learn Git basics.',
     'Understand how to use Git for version control in software development. This lecture will cover repositories, commits, and branching.',
     'https://www.youtube.com/watch?v=8JJ101D3knE'),

    -- Lectures for SOLID Principles course
    (5, 2, 1, 'Single Responsibility Principle', 'Common design patterns in software.',
     'Explore common design patterns such as Singleton, Factory, and Observer that can improve your software architecture.',
     'https://www.youtube.com/watch?v=5RwhyZnVRS8'),
    (6, 2, 2, 'Open Closed Principle', 'How to refactor code effectively.',
     'Learn effective refactoring techniques that enhance code readability and maintainability without changing its behavior.',
     'https://www.youtube.com/watch?v=VFlk43QGEgc'),
    (7, 2, 3, 'Liskov Substitution Principle', 'Importance of testing in development.',
     'Understand various testing strategies including unit testing and integration testing to ensure software quality.',
     'https://www.youtube.com/watch?v=-3UXq2krhyw'),
    (8, 2, 4, 'Interface Segregation Principle', 'Importance of testing in development.',
     'Understand various testing strategies including unit testing and integration testing to ensure software quality.',
     'https://www.youtube.com/watch?v=y1JiMGP51NE'),
    (9, 2, 5, 'Dependency Inversion Principle', 'Importance of testing in development.',
     'Understand various testing strategies including unit testing and integration testing to ensure software quality.',
     'https://www.youtube.com/watch?v=NnZZMkwI6KI'),

    -- Lectures for Software Development Methodologies course DRAFT
    (10, 3, 1, 'What is Agile?', 'The need for docker and containerisation explained.',
     'This lecture introduces you to why and what for Docker and Containerization are used, using simple examples.',
     'https://www.youtube.com/watch?v=Z9QbYZh1YXY'),
    (11, 3, 2, 'What is SCRUM?',
     'The building blocks for Docker are Images and Containers.',
     'Explore the most important building blocks of Docker - Images and Containers. Here you will see real examples of how images are build and how containers are created on top of the images.',
     'https://www.youtube.com/watch?v=m5u0P1WPfvs'),
    (12, 3, 3, 'What is Kanban?',
     'The idea behind orchestration explained.',
     'Learn what orchestration is and deep dive into orchestrating your first application.',
     'https://www.youtube.com/watch?v=hCj1PPV9O10'),
    (13, 3, 4, 'What is Waterfall?',
     'The idea behind orchestration explained.',
     'Learn what orchestration is and deep dive into orchestrating your first application.',
     'https://www.youtube.com/watch?v=noE3pnRzQGI'),
    (14, 3, 5, 'Agile vs Waterfall: Choosing your methodology',
     'The idea behind orchestration explained.',
     'Learn what orchestration is and deep dive into orchestrating your first application.',
     'https://www.youtube.com/watch?v=5RocT_OdQcA'),

    -- Lectures for Docker and Kubernetes Basics course
    (15, 4, 1, 'What are Virtual Machines?',
     'Version control is a system that records changes to a file or set of files over time.',
     'We will begin by explaining some background on version control tools, then move on to how to get Git running on your system and finally how to get it set up to start working with.',
     'https://www.youtube.com/watch?v=wX75Z-4MEoM'),
    (16, 4, 2, 'Docker - Complete Tutorial',
     'The leading open source automation server - Jenkins. Support building, deploying and automating any project.',
     'This chapter contains topics for typical Jenkins users (of all skill levels) about Jenkins usage which is outside the scope of the core Jenkins features: Pipeline and Blue Ocean.',
     'https://www.youtube.com/watch?v=d-PPOS-VsC8&t=1438s'),
    (17, 4, 3, 'Kubernetes - Zero to Hero',
     'Cloud computing is the on-demand availability of computer system resources, especially data storage (cloud storage) and computing power.',
     'Simply put, cloud computing is the delivery of computing services—including servers, storage, databases, networking, software, analytics, and intelligence—over the internet.',
     'https://www.youtube.com/watch?v=X48VuDVv0do'),

    -- Lectures for Become a DevOps Master course
    (18, 5, 1, 'Git Tutorial',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=8JJ101D3knE'),
    (19, 5, 2, 'Docker - Complete Tutorial',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=fqMOX6JJhGo'),
    (20, 5, 3, 'Jenkins Masterclass',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=FX322RVNGj4&t=1s'),
    (21, 5, 4, 'Ansible - Zero to Hero',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=BS0GLQaSGPo'),
    (22, 5, 5, 'Master AWS',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=HK_q1lH5x5M'),

    -- Lectures for Fundamentals of Physics course
    (23, 6, 1, 'Introduction to Physics', 'Basic concepts of physics.',
     'This lecture covers fundamental concepts in physics including motion and forces. Perfect for beginners!',
     'https://www.youtube.com/watch?v=b1t41Q3xRM8'),
    (24, 6, 2, 'Newton’s Laws of Motion',
     'Understanding Newtons laws.',
     'Dive deep into Newtons three laws of motion and their applications in real-world scenarios.',
     'https://www.youtube.com/watch?v=g550H4e5FCY'),
    (25, 6, 3, 'Energy Conservation', 'Principles of energy conservation.',
     'Learn about the principle of conservation of energy and its significance in physics.',
     'https://www.youtube.com/watch?v=OTK9JrKC6EY'),
    (26, 6, 4, 'Thermodynamics Basics', 'Introduction to thermodynamics.',
     'Explore the basic principles of thermodynamics and their applications in various scientific fields.',
     'https://www.youtube.com/watch?v=8N1BxHgsoOw'),
    (27, 6, 5, 'Waves and Sound', 'Understanding waves in physics.',
     'This lecture covers the properties of waves and sound including frequency and amplitude.',
     'https://www.youtube.com/watch?v=s9wZkP64rAc'),

    -- Lectures for Astrophysics: Exploring the Universe course
    (28, 7, 1, 'Astrophysics Overview', 'Basics of astrophysics.',
     'Get an overview of astrophysics including stars and galaxies. A fascinating introduction!',
     'https://www.youtube.com/watch?v=TCrRs_OBN0E'),
    (29, 7, 2, 'Tidal Forces', 'Understanding black holes.',
     'This lecture explores black holes: their formation and significance in astrophysics.',
     'https://www.youtube.com/watch?v=N9Le2TavtX8'),
    (30, 7, 3, 'Black Holes', 'Understanding black holes.',
     'This lecture explores black holes: their formation and significance in astrophysics.',
     'https://www.youtube.com/watch?v=r5pGFSEpBbQ'),

    -- Lectures for Quantum Mechanics Basics course DRAFT
    (31, 8, 1, 'What Is Quantum Mechanics?', 'Understanding the quantum mechanics basics and how it is different from
classical mechanics.', 'Understanding the quantum mechanics basics and how it is different from classical mechanics.',
     'https://www.youtube.com/watch?v=7RmBH96QNyQ'),

    -- Lectures for Chemistry Fundamentals course DRAFT
    (32, 9, 1, 'General Chemistry explained', 'Understanding the chemistry basics',
     'Understanding the chemistry basics', 'https://www.youtube.com/watch?v=5iTOphGnCtg'),

    -- Lectures for Entrepreneurship Essentials course
    (33, 10, 1, 'Starting Your Business', 'Key steps to start a business.',
     'Learn the essential steps needed to start your own business successfully from idea generation to execution.',
     'https://www.youtube.com/watch?v=bXLZ8I7s8tw'),
    (34, 10, 2, 'Market Research Techniques', 'Understanding market research.',
     'Explore effective market research techniques that can help you understand your target audience better.',
     'https://www.youtube.com/watch?v=mUlYuYooV5Y'),
    (35, 10, 3, 'Business Planning Essentials', 'Creating a solid business plan.',
     'In this lecture we will cover how to create a comprehensive business plan that outlines your business goals and strategies.',
     'https://www.youtube.com/watch?v=cqnsfLjeXtQ'),

    -- Lectures for Advanced Marketing Strategies course
    (36, 11, 1, 'Digital Marketing Fundamentals', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=h95cQkEWBx0'),
    (37, 11, 2, 'Email Marketing Strategies', 'Effective email marketing tips.',
     'Learn how to create effective email marketing campaigns that engage your audience effectively.',
     'https://www.youtube.com/watch?v=PsC5IUiXMUs'),
    (38, 11, 3, 'Analyzing Marketing Metrics', 'Importance of metrics in marketing.',
     'Explore key marketing metrics that can help you measure campaign success effectively.',
     'https://www.youtube.com/watch?v=eg4I-RU_vKU'),

    -- Lectures for Financial Management for Entrepreneurs course DRAFT
    (39, 12, 1, 'Digital Marketing Fundamentals', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=e8wJBq6vOAI'),

    -- Lectures for Digital Marketing Strategies course
    (40, 13, 1, 'Effective Marketing Strategies', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=4ajmfzj9G1g'),
    (41, 13, 2, 'Psychological Marketing Triggers', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=hYZG8qnS2T4'),
    (42, 13, 3, 'Facebook Ads Tutorial', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=PRlzOTVM87Y'),

    -- Lectures for Electrical Engineering Basics course
    (43, 14, 1, 'Basics of Electrical Circuits', 'Understanding electrical circuits.',
     'This lecture introduces basic concepts related to electrical circuits including voltage and current.',
     'https://www.youtube.com/watch?v=_asax7PmhcE'),
    (44, 14, 2, 'AC vs DC Current', 'Differences between AC and DC.',
     'Learn about alternating current (AC) and direct current (DC) along with their applications.',
     'https://www.youtube.com/watch?v=vN9aR2wKv0U'),
    (45, 14, 3, 'Ohms Law', 'Understanding Ohms Law.',
     'Explore Ohms Law and its significance in electrical engineering.', 'https://www.youtube.com/watch?v=HsLLq6Rm5tU'),

    -- Lectures for Advanced Topics in Civil Engineering course DRAFT
    (46, 15, 1, 'What is civil engineering?', 'Understanding Ohms Law.',
     'Explore Ohms Law and its significance in electrical engineering.', 'https://www.youtube.com/watch?v=bFljMHTQ1QY'),

    -- Lectures for Introduction to Mechanical Engineering course DRAFT

    -- Lectures for Leadership Skills Development course
    (47, 17, 1, 'Goal Setting Techniques', 'Effective goal setting strategies.',
     'Learn effective techniques for setting personal goals that lead to success.',
     'https://www.youtube.com/watch?v=L4N1q4RNi9I'),
    (48, 17, 2, 'Building Confidence', 'Strategies to build self-confidence.',
     'This lecture covers practical strategies to enhance self-confidence in personal and professional settings.',
     'https://www.youtube.com/watch?v=IitIl2C3Iy8'),
    (49, 17, 3, 'Guide to Leadership', 'Guide to Leadership',
     'This lecture covers practical strategies to enhance self-confidence in personal and professional settings.',
     'https://www.youtube.com/watch?v=eXDNkwIeOqA'),

    -- Lectures for Time Management Techniques course DRAFT
    (50, 18, 1, 'Building Time Efficiency Habits', 'Strategies to build time efficiency habits.',
     'This lecture covers practical strategies to enhance your time management.',
     'https://www.youtube.com/watch?v=iONDebHX9qk'),

    -- Lectures for Effective Communication Skills course DRAFT
    (51, 19, 1, 'The art of effective communication', 'How to communicate more effective',
     'This lecture covers practical strategies to enhance your time management.',
     'https://www.youtube.com/watch?v=2Yw6dFQBklA'),

    -- Lectures for Stress Management Techniques course DRAFT

    -- Lectures for Introduction to Graphic Design course
    (52, 21, 1, 'Introduction to Graphic Design', 'Fundamentals of typography.',
     'Learn about typography principles essential for effective design communication.',
     'https://www.youtube.com/watch?v=GQS7wPujL2k'),
    (53, 21, 2, 'Introduction to Color Theory', 'Understanding color theory basics.',
     'Explore the basics of color theory and its application in graphic design.',
     'https://www.youtube.com/watch?v=2QTHs7QSR9o'),
    (54, 21, 3, 'Typography Basics', 'Fundamentals of typography.',
     'Learn about typography principles essential for effective design communication.',
     'https://www.youtube.com/watch?v=yAuUDyUC-GM'),

    -- Lectures for UI/UX Design Fundamentals course
    (55, 22, 1, 'Introduction to UI/UX', 'Understanding the UI/UX theory basics.',
     'Explore the basics of user interface and user experience theory and its application.',
     'https://www.youtube.com/watch?v=55NvZjUZIO8'),
    (56, 22, 2, 'Deep dive into UI/UX', 'Fundamentals of UI/UX.',
     'Learn about UI/UX principles essential for effective design and user interaction.',
     'https://www.youtube.com/watch?v=cGQPMNilEQg'),
    (57, 22, 3, 'Top 10 UI/UX Tools', 'Top 10 UI/UX Tools',
     'Learn about UI/UX principles essential for effective design and user interaction.',
     'https://www.youtube.com/watch?v=dcPp_U-v3bI'),

    -- Lectures for Nutrition Basics for a Healthier Life course
    (58, 23, 1, 'Nutrition Fundamentals', 'Basics of nutrition science.',
     'Understand fundamental concepts related to nutrition science that promote health.',
     'https://www.youtube.com/watch?v=uaFXMdTGV30'),
    (59, 23, 2, 'Healthy Eating Habits', 'Importance of healthy eating.',
     'Learn about healthy eating habits that can improve overall well-being.',
     'https://www.youtube.com/watch?v=yTNN_0j5S2Q'),
    (60, 23, 3, 'How to track calories', 'Importance of calories counting.',
    'Learn about healthy eating habits that can improve overall well-being.',
    'https://www.youtube.com/watch?v=YwYa9UuEhqg');

    -- Lectures for Fitness Strategies for Wellness course DRAFT

INSERT INTO `user_enrolled_course` (`course_id`, `user_id`)
VALUES (1, 12),
       (2, 12),
       (2, 13),
       (1, 14),
       (4, 14),
       (5, 14),
       (1, 15),
       (4, 15),
       (2, 16),
       (2, 19),
       (11, 19),
       (23, 20),
       (11, 21),
       (23, 21),
       (17, 22),
       (13, 22),
       (14, 22),
       (13, 23),
       (17, 24),
       (21, 25),
       (17, 26),
       (4, 5),
       (5, 5),
       (6, 5),
       (7, 5);

INSERT INTO `user_completed_course` (`course_id`, `user_id`, `completed_on`)
VALUES (1, 12, NOW()),
       (2, 12, NOW()),
       (2, 13, NOW()),
       (10, 5, NOW()),
       (11, 5, NOW());

INSERT INTO `course_rating` (`id`, `course_id`, `user_id`, `rating`, `created`)
VALUES (1, 1, 12, 4, NOW()),
       (2, 2, 12, 5, NOW()),
       (3, 2, 13, 2, NOW()),
       (4, 2, 14, 3, NOW());
