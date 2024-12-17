INSERT INTO `user` (`id`, `enabled`, `created`, `modified`, `bio`, `email`, `first_name`, `last_name`, `password`,
                    `role`, `is_teacher_access_requested`)
VALUES
    -- Root Admin Users
    (1, 1, NOW(), NOW(), 'The Root Admin', 'root@admin.com', 'Root', 'Admin',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ROOT_ADMIN', 0),

    -- Regular Admin Users
    (2, 1, NOW(), NOW(), 'A Regular Admin', 'max@admin.com', 'Max', 'Mustermann',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0),
    (3, 1, NOW(), NOW(), 'A Regular Admin', 'erika@admin.com', 'Erika', 'Mustermann',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0),

    -- Teacher Users
    (4, 1, NOW(), NOW(), 'A DevOps engineer/teacher.', 'thomas@teacher.com', 'Thomas', 'Müller',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (5, 1, NOW(), NOW(), 'A software development teacher.', 'lina@teacher.com', 'Lina', 'Fischer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (6, 1, NOW(), NOW(), 'A science teacher focused on physics and astronomy', 'james@teacher.com', 'James',
     'Wilson', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (7, 1, NOW(), NOW(), 'A business teacher with expertise in entrepreneurship and marketing', 'david@teacher.com',
     'David', 'Brown', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (8, 1, NOW(), NOW(), 'An engineering teacher focused on mechanical and electrical engineering',
     'michael@teacher.com', 'Michael', 'Johnson', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u',
     'ROLE_TEACHER', 0),
    (9, 1, NOW(), NOW(), 'A personal development teacher specializing in leadership and communication',
     'anna@teacher.com', 'Anna', 'Taylor', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u',
     'ROLE_TEACHER', 0),
    (10, 1, NOW(), NOW(), 'A design teacher focused on UI/UX and graphic design', 'lucas@teacher.com', 'Lucas',
     'Kim', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (11, 1, NOW(), NOW(), 'A health & wellness teacher specializing in nutrition and fitness', 'marcus@teacher.com',
     'Marcus', 'Anderson', '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),

    -- Student Users
    (12, 1, NOW(), NOW(), NULL, 'hans@hofer.com', 'Hans', 'Hofer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (13, 1, NOW(), NOW(), NULL, 'sabine@mayer.com', 'Sabine', 'Mayer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (14, 1, NOW(0), NOW(), NULL, 'lukas@wagner.com', 'Lukas', 'Wagner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (15, 1, NOW(), NOW(), NULL, 'julia@bauer.com', 'Julia', 'Bauer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (16, 1, NOW(), NOW(), NULL, 'markus@gruber.com', 'Markus', 'Gruber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (17, 1, NOW(), NOW(), NULL, 'sophia@huber.com', 'Sophia', 'Huber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (18, 1, NOW(), NOW(), NULL, 'felix@steiner.com', 'Felix', 'Steiner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (19, 1, NOW(), NOW(), NULL, 'emma@berger.com', 'Emma', 'Berger',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (20, 1, NOW(), NOW(), NULL, 'paul@maier.com', 'Paul', 'Maier',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (21, 1, NOW(), NOW(), NULL, 'laura@wolf.com', 'Laura', 'Wolf',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (22, 1, NOW(), NOW(), NULL, 'simon@weber.com', 'Simon', 'Weber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (23, 1, NOW(), NOW(), NULL, 'anna@schmid.com', 'Anna', 'Schmid',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (24, 1, NOW(), NOW(), NULL, 'david@schwarz.com', 'David', 'Schwarz',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (25, 1, NOW(), NOW(), NULL, 'sarah@koch.com', 'Sarah', 'Koch',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (26, 1, NOW(), NOW(), NULL, 'max@binder.com', 'Max', 'Binder',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (27, 1, NOW(), NOW(), NULL, 'lisa@fuchs.com', 'Lisa', 'Fuchs',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (28, 1, NOW(), NOW(), NULL, 'thomas@auer.com', 'Thomas', 'Auer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (29, 1, NOW(), NOW(), NULL, 'nina@winkler.com', 'Nina', 'Winkler',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (30, 1, NOW(), NOW(), NULL, 'christian@moser.com', 'Christian', 'Moser',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (31, 1, NOW(), NOW(), NULL, 'marie@reiter.com', 'Marie', 'Reiter',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),

    -- Disabled Student Users
    (32, 0, NOW(), NOW(), NULL, 'katarina@berg.com', 'Katarina', 'Berg',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (33, 0, NOW(), NOW(), NULL, 'philipp@schneider.com', 'Philipp', 'Schneider',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 1),
    (34, 0, NOW(), NOW(), NULL, 'sebastian@lang.com', 'Sebastian', 'Lang',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),
    (35, 0, NOW(), NOW(), NULL, 'victoria@keller.com', 'Victoria', 'Keller',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_STUDENT', 0),

    -- Disabled Teacher Users
    (36, 0, NOW(), NOW(), 'A Mathematics Teacher', 'robert@teacher.com', 'Robert', 'Wagner',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (37, 0, NOW(), NOW(), 'A Literature Teacher', 'isabel@teacher.com', 'Isabel', 'Hoffmann',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),
    (38, 0, NOW(), NOW(), 'A Physics Teacher', 'klaus@teacher.com', 'Klaus', 'Schmidt',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_TEACHER', 0),

    -- Disabled Admin Users
    (39, 0, NOW(), NOW(), 'A Regular Admin', 'stefan@admin.com', 'Stefan', 'Bauer',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0),
    (40, 0, NOW(), NOW(), 'A Regular Admin', 'hannah@admin.com', 'Hannah', 'Weber',
     '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', 'ROLE_ADMIN', 0);

INSERT INTO `topic` (`id`, `title`, `description`)
VALUES (1, 'Software Development', 'Learn programming languages and tools to build efficient software solutions.'),
       (2, 'Science', 'Explore major scientific disciplines and discover how science explains our world.'),
       (3, 'Business', 'Master essential business skills from management to finance for organizational success.'),
       (4, 'Engineering', 'Study engineering principles and technologies across various engineering fields.'),
       (5, 'Personal Development', 'Develop life skills, productivity habits, and strategies for personal growth.'),
       (6, 'Design', 'Learn visual design principles and tools for creating compelling digital content.'),
       (7, 'Health & Wellness', 'Discover practices for improving physical and mental well-being.');

INSERT INTO `course` (`id`, `author_id`, `topic_id`, `created`, `modified`, `title`, `description`, `difficulty_level`,
                      `status`)
VALUES
    -- Software Development Courses
    (1, 5, 1, NOW(), NOW(), 'Introduction to Software Development',
     'Learn the basics of software development including programming languages and tools.', 'BEGINNER', 'PUBLISHED'),
    (2, 5, 1, NOW(), NOW(), 'SOLID Principles and Design Patterns',
     'Explore advanced techniques in software development and best practices.', 'ADVANCED', 'PUBLISHED'),
    (3, 5, 1, NOW(), NOW(), 'Software Development Methodologies',
     'Understand different methodologies like Agile and Waterfall in software development.', 'ADVANCED', 'DRAFT'),
    (4, 4, 1, NOW(), NOW(), 'Docker and Kubernetes Basics',
     'Learn the fundamentals of Docker and Kubernetes including Jenkins.', 'BEGINNER', 'PUBLISHED'),
    (5, 4, 1, NOW(), NOW(), 'Become a DevOos Master',
     'Become a DevOps Master learning Jenkins & integrations with powerful tools like Docker, Ansible, AWS, GIT & more!',
     'INTERMEDIATE', 'PUBLISHED'),

    -- Science Courses
    (6, 6, 2, NOW(), NOW(), 'Fundamentals of Physics',
     'An introductory course covering the basic principles of physics.',
     'BEGINNER', 'PUBLISHED'),
    (7, 6, 2, NOW(), NOW(), 'Astrophysics: Exploring the Universe',
     'Delve into astrophysics and learn about celestial phenomena.', 'INTERMEDIATE', 'PUBLISHED'),
    (8, 6, 2, NOW(), NOW(), 'Quantum Mechanics Basics',
     'A beginner-friendly introduction to the principles of quantum mechanics.', 'BEGINNER', 'DRAFT'),
    (9, 6, 2, NOW(), NOW(), 'Chemistry Fundamentals',
     'An introduction to the basic concepts of chemistry and its applications.', 'BEGINNER', 'DRAFT'),

    -- Business Courses
    (10, 7, 3, NOW(), NOW(), 'Entrepreneurship Essentials',
     'Learn the key skills needed to start and run a successful business.', 'BEGINNER', 'PUBLISHED'),
    (11, 7, 3, NOW(), NOW(), 'Advanced Marketing Strategies',
     'Explore advanced marketing strategies for business growth.',
     'ADVANCED', 'PUBLISHED'),
    (12, 7, 3, NOW(), NOW(), 'Financial Management for Entrepreneurs',
     'Understand financial management principles essential for entrepreneurs.', 'INTERMEDIATE', 'DRAFT'),
    (13, 7, 3, NOW(), NOW(), 'Digital Marketing Strategies',
     'Learn effective digital marketing strategies to enhance online presence.', 'INTERMEDIATE', 'PUBLISHED'),

    -- Engineering Courses
    (14, 8, 4, NOW(), NOW(), 'Electrical Engineering Basics',
     'An introductory course on electrical engineering concepts.',
     'BEGINNER', 'PUBLISHED'),
    (15, 8, 4, NOW(), NOW(), 'Advanced Topics in Civil Engineering',
     'Explore advanced topics in civil engineering and its applications.', 'ADVANCED', 'DRAFT'),
    (16, 8, 4, NOW(), NOW(), 'Introduction to Mechanical Engineering',
     'Learn about the fundamentals of mechanical engineering.', 'BEGINNER', 'DRAFT'),

    -- Personal Development Courses
    (17, 9, 5, NOW(), NOW(), 'Leadership Skills Development',
     'Enhance your leadership skills for personal and professional growth.', 'INTERMEDIATE', 'PUBLISHED'),
    (18, 9, 5, NOW(), NOW(), 'Time Management Techniques',
     'Learn effective time management techniques to boost productivity.', 'BEGINNER', 'DRAFT'),
    (19, 9, 5, NOW(), NOW(), 'Effective Communication Skills',
     'Develop communication skills for personal and professional success.', 'INTERMEDIATE', 'DRAFT'),
    (20, 9, 5, NOW(), NOW(), 'Stress Management Techniques',
     'Learn techniques to manage stress and improve mental health.', 'BEGINNER', 'DRAFT'),

    -- Design Courses
    (21, 10, 6, NOW(), NOW(), 'Introduction to Graphic Design',
     'Discover the principles of graphic design and visual communication.', 'BEGINNER', 'PUBLISHED'),
    (22, 10, 6, NOW(), NOW(), 'UI/UX Design Fundamentals',
     'Learn the basics of user interface and user experience design.',
     'INTERMEDIATE', 'PUBLISHED'),

    -- Health & Wellness Courses
    (23, 11, 7, NOW(), NOW(), 'Nutrition Basics for a Healthier Life',
     'Understand the fundamentals of nutrition for better health.', 'BEGINNER', 'PUBLISHED'),
    (24, 11, 7, NOW(), NOW(), 'Fitness Strategies for Wellness',
     'Explore effective fitness strategies to improve your well-being.', 'INTERMEDIATE', 'DRAFT');

INSERT INTO `lecture` (`id`, `course_id`, `sequence_number`, `title`, `short_description`, `full_description`,
                       `video_url`)
VALUES
    -- Lectures for Published Software Development Courses
    (1, 1, 1, 'Introduction to Programming', 'Basics of programming languages.',
     'This lecture covers the fundamentals of programming languages such as Python and Java. You will learn about syntax, variables, and control structures.',
     'https://www.youtube.com/watch?v=xyz123'),
    (2, 1, 2, 'Version Control with Git', 'Learn Git basics.',
     'Understand how to use Git for version control in software development. This lecture will cover repositories, commits, and branching.',
     'https://www.youtube.com/watch?v=abc456'),
    (3, 1, 3, 'Debugging Techniques', 'Effective debugging strategies.',
     'In this lecture, we will explore various debugging techniques that can help you identify and fix errors in your code efficiently.',
     'https://www.youtube.com/watch?v=def789'),
    (4, 1, 4, 'Software Development Life Cycle', 'Overview of SDLC phases.',
     'Learn about the different phases of the Software Development Life Cycle (SDLC) and how they contribute to successful project completion.',
     'https://www.youtube.com/watch?v=ghi012'),

    (5, 2, 1, 'Understanding SOLID Principles', 'Key SOLID principles explained.',
     'This lecture introduces you to the SOLID principles of object-oriented design that help create maintainable software systems.',
     'https://www.youtube.com/watch?v=jkl345'),
    (6, 2, 2, 'Design Patterns Overview', 'Common design patterns in software.',
     'Explore common design patterns such as Singleton, Factory, and Observer that can improve your software architecture.',
     'https://www.youtube.com/watch?v=mno678'),
    (7, 2, 3, 'Refactoring Techniques', 'How to refactor code effectively.',
     'Learn effective refactoring techniques that enhance code readability and maintainability without changing its behavior.',
     'https://www.youtube.com/watch?v=pqr901'),
    (8, 2, 4, 'Testing Strategies', 'Importance of testing in development.',
     'Understand various testing strategies including unit testing and integration testing to ensure software quality.',
     'https://www.youtube.com/watch?v=stu234'),

    (9, 4, 1, 'Why Docker and Containers?', 'The need for docker and containerisation explained.',
     'This lecture introduces you to why and what for Docker and Containerization are used, using simple examples.',
     'https://www.youtube.com/watch?v=jkl345'),
    (10, 4, 2, 'Docker Building Blocks - Images & Containers',
     'The building blocks for Docker are Images and Containers.',
     'Explore the most important building blocks of Docker - Images and Containers. Here you will see real examples of how images are build and how containers are created on top of the images.',
     'https://www.youtube.com/watch?v=mno678'),
    (11, 4, 3, 'Getting started with Kubernetes',
     'The idea behind orchestration explained.',
     'Learn what orchestration is and deep dive into orchestrating your first application.',
     'https://www.youtube.com/watch?v=pqr901'),

    (12, 5, 1, 'GIT - Version Control',
     'Version control is a system that records changes to a file or set of files over time.',
     'We will begin by explaining some background on version control tools, then move on to how to get Git running on your system and finally how to get it set up to start working with.',
     'https://www.youtube.com/watch?v=stu234'),
    (13, 5, 2, 'Build great things at any scale - Jenkins',
     'The leading open source automation server - Jenkins. Support building, deploying and automating any project.',
     'This chapter contains topics for typical Jenkins users (of all skill levels) about Jenkins usage which is outside the scope of the core Jenkins features: Pipeline and Blue Ocean.',
     'https://www.youtube.com/watch?v=jkl345'),
    (14, 5, 3, 'Introduction to the Cloud',
     'Cloud computing is the on-demand availability of computer system resources, especially data storage (cloud storage) and computing power.',
     'Simply put, cloud computing is the delivery of computing services—including servers, storage, databases, networking, software, analytics, and intelligence—over the internet.',
     'https://www.youtube.com/watch?v=mno678'),

    -- Lectures for Drafted Software Development Courses
    (15, 3, 1, 'What is Agile?',
     'Agile is a mindset informed by the Agile Manifesto’s values and principles',
     'Agile is the ability to create and respond to change. It is a way of dealing with, and ultimately succeeding in, an uncertain and turbulent environment.',
     'https://www.youtube.com/watch?v=stu234'),

    -- Lectures for Published Science Courses
    (16, 6, 1, 'Introduction to Physics', 'Basic concepts of physics.',
     'This lecture covers fundamental concepts in physics including motion and forces. Perfect for beginners!',
     'https://www.youtube.com/watch?v=vwx567'),
    (17, 6, 2, 'Newton’s Laws of Motion',
     'Understanding Newtons laws.',
     'Dive deep into Newtons three laws of motion and their applications in real-world scenarios.',
     'https://www.youtube.com/watch?v=yza890'),
    (18, 6, 3, 'Energy Conservation', 'Principles of energy conservation.',
     'Learn about the principle of conservation of energy and its significance in physics.',
     'https://www.youtube.com/watch?v=bcd123'),
    (19, 6, 4, 'Thermodynamics Basics', 'Introduction to thermodynamics.',
     'Explore the basic principles of thermodynamics and their applications in various scientific fields.',
     'https://www.youtube.com/watch?v=efg456'),
    (20, 6, 5, 'Waves and Sound', 'Understanding waves in physics.',
     'This lecture covers the properties of waves and sound including frequency and amplitude.',
     'https://www.youtube.com/watch?v=hij789'),

    (21, 7, 1, 'Astrophysics Overview', 'Basics of astrophysics.',
     'Get an overview of astrophysics including stars and galaxies. A fascinating introduction!',
     'https://www.youtube.com/watch?v=klm012'),
    (22, 7, 2, 'Black Holes', 'Understanding black holes.',
     'This lecture explores black holes: their formation and significance in astrophysics.',
     'https://www.youtube.com/watch?v=nop345'),

    -- Lectures for Drafted Science Courses

    -- Lectures for Published Business Courses
    (23, 10, 1, 'Starting Your Business', 'Key steps to start a business.',
     'Learn the essential steps needed to start your own business successfully from idea generation to execution.',
     'https://www.youtube.com/watch?v=qrs678'),
    (24, 10, 2, 'Market Research Techniques', 'Understanding market research.',
     'Explore effective market research techniques that can help you understand your target audience better.',
     'https://www.youtube.com/watch?v=tuv901'),
    (25, 10, 3, 'Business Planning Essentials', 'Creating a solid business plan.',
     'In this lecture we will cover how to create a comprehensive business plan that outlines your business goals and strategies.',
     'https://www.youtube.com/watch?v=wxy234'),
    (26, 10, 4, 'Funding Your Business', 'Options for business funding.',
     'Discover various funding options available for startups including loans and investors.',
     'https://www.youtube.com/watch?v=zab567'),

    (27, 11, 1, 'Digital Marketing Fundamentals', 'Basics of digital marketing.',
     'Understand the fundamentals of digital marketing including SEO and social media strategies.',
     'https://www.youtube.com/watch?v=cde890'),
    (28, 11, 2, 'Email Marketing Strategies', 'Effective email marketing tips.',
     'Learn how to create effective email marketing campaigns that engage your audience effectively.',
     'https://www.youtube.com/watch?v=fgh012'),
    (29, 11, 3, 'Analyzing Marketing Metrics', 'Importance of metrics in marketing.',
     'Explore key marketing metrics that can help you measure campaign success effectively.',
     'https://www.youtube.com/watch?v=jkl345'),

    -- Lectures for Drafted Business Courses

    -- Lectures for Published Engineering Courses
    (30, 14, 1, 'Basics of Electrical Circuits', 'Understanding electrical circuits.',
     'This lecture introduces basic concepts related to electrical circuits including voltage and current.',
     'https://www.youtube.com/watch?v=mno678'),
    (31, 14, 2, 'AC vs DC Current', 'Differences between AC and DC.',
     'Learn about alternating current (AC) and direct current (DC) along with their applications.',
     'https://www.youtube.com/watch?v=pqr901'),
    (32, 14, 3, 'Ohms Law', 'Understanding Ohms Law.',
     'Explore Ohms Law and its significance in electrical engineering.', 'https://www.youtube.com/watch?v=stu234'),

    -- Lectures for Drafted Engineering Course

    -- Lectures for Published Personal Development Courses
    (33, 17, 1, 'Goal Setting Techniques', 'Effective goal setting strategies.',
     'Learn effective techniques for setting personal goals that lead to success.',
     'https://www.youtube.com/watch?v=vwx567'),
    (34, 17, 2, 'Building Confidence', 'Strategies to build self-confidence.',
     'This lecture covers practical strategies to enhance self-confidence in personal and professional settings.',
     'https://www.youtube.com/watch?v=yza890'),
    (35, 18, 1, 'Building Time Efficiency Habits', 'Strategies to build time efficiency habits.',
     'This lecture covers practical strategies to enhance your time management.',
     'https://www.youtube.com/watch?v=yza890'),

    -- Lectures for Drafted Personal Development Course

    -- Lectures for Published Design Courses
    (36, 21, 1, 'Introduction to Color Theory', 'Understanding color theory basics.',
     'Explore the basics of color theory and its application in graphic design.',
     'https://www.youtube.com/watch?v=abc123'),
    (37, 21, 2, 'Typography Basics', 'Fundamentals of typography.',
     'Learn about typography principles essential for effective design communication.',
     'https://www.youtube.com/watch?v=def456'),

    (38, 22, 1, 'Introduction to UI/UX', 'Understanding the UI/UX theory basics.',
     'Explore the basics of user interface and user experience theory and its application.',
     'https://www.youtube.com/watch?v=abc123'),
    (39, 22, 2, 'Deep dive into UI/UX', 'Fundamentals of UI/UX.',
     'Learn about UI/UX principles essential for effective design and user interaction.',
     'https://www.youtube.com/watch?v=def456'),

    -- Lectures for Drafted Design Course

    -- Lectures for Published Health & Wellness Courses
    (40, 23, 1, 'Nutrition Fundamentals', 'Basics of nutrition science.',
     'Understand fundamental concepts related to nutrition science that promote health.',
     'https://www.youtube.com/watch?v=ghi789'),
    (41, 23, 2, 'Healthy Eating Habits', 'Importance of healthy eating.',
     'Learn about healthy eating habits that can improve overall well-being.',
     'https://www.youtube.com/watch?v=jkl012');

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
       (17, 26);

INSERT INTO `user_completed_course` (`course_id`, `user_id`, `completed_on`)
VALUES (1, 12, NOW()),
       (2, 12, NOW()),
       (2, 13, NOW());

INSERT INTO `course_rating` (`id`, `course_id`, `user_id`, `rating`, `created`)
VALUES (1, 1, 12, 4, NOW()),
       (2, 2, 12, 3, NOW())
