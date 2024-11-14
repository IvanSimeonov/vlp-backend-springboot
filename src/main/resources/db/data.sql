-- Root Admin user
INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`)
VALUES (0,
        NOW(),
        NOW(),
        'root@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'Root',
        'Admin',
        'ROLE_ROOT_ADMIN');

-- Admin user
INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`)
VALUES (0,
        NOW(),
        NOW(),
        'admin@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'Regular',
        'Admin',
        'ROLE_ADMIN');

-- Teacher users
INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`,
                    `bio`,
                    `linked_in_profile_url`)
VALUES (0,
        NOW(),
        NOW(),
        'teacher1@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'John',
        'Smith',
        'ROLE_TEACHER',
        'Experienced Java developer with 10 years of teaching experience',
        'https://linkedin.com/in/john-smith');

INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`,
                    `bio`,
                    `linked_in_profile_url`)
VALUES (0,
        NOW(),
        NOW(),
        'teacher2@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'Sarah',
        'Johnson',
        'ROLE_TEACHER',
        'Full-stack developer specializing in web technologies',
        'https://linkedin.com/in/sarah-johnson');

-- Student users
INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`)
VALUES (0,
        NOW(),
        NOW(),
        'student1@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'Mike',
        'Brown',
        'ROLE_STUDENT');

INSERT INTO `user` (`enabled`,
                    `created`,
                    `modified`,
                    `email`,
                    `password`,
                    `first_name`,
                    `last_name`,
                    `role`)
VALUES (0,
        NOW(),
        NOW(),
        'student2@vlp.com',
        '$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u', -- 12345678
        'Emma',
        'Wilson',
        'ROLE_STUDENT');
