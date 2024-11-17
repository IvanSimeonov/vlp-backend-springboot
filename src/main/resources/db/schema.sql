DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `assignment_solution`;
DROP TABLE IF EXISTS `user_completed_course`;
DROP TABLE IF EXISTS `user_enrolled_course`;
DROP TABLE IF EXISTS `lecture`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `topic`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `enabled` BIT(1) NOT NULL,
    `created` DATETIME(6) NULL,
    `modified` DATETIME(6) NULL,
    `last_password_change_date` DATETIME(6) NULL DEFAULT NULL,
    `bio` VARCHAR(255) NULL DEFAULT NULL,
    `email` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NULL DEFAULT NULL,
    `last_name` VARCHAR(255) NULL DEFAULT NULL,
    `linked_in_profile_url` VARCHAR(255) NULL DEFAULT NULL,
    `password` VARCHAR(255) NOT NULL,
    `profile_image_path` VARCHAR(255) NULL DEFAULT NULL,
    `role` ENUM('ROLE_ROOT_ADMIN', 'ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_STUDENT') NOT NULL DEFAULT 'ROLE_STUDENT',
    `status` ENUM('ACTIVE', 'INACTIVE', 'PENDING_APPROVAL') NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UK_user_email` (`email` ASC)
);

CREATE TABLE `topic` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UK_topic_title` (`title` ASC)
);

CREATE TABLE `course` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `author_id` BIGINT NOT NULL,
    `topic_id` BIGINT NOT NULL,
    `created` DATETIME(6) NULL,
    `modified` DATETIME(6) NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `difficulty_level` ENUM('BEGINNER', 'INTERMEDIATE', 'ADVANCED') NOT NULL,
    `status` ENUM('DRAFT', 'PUBLISHED') NOT NULL DEFAULT 'DRAFT',
    PRIMARY KEY (`id`),
    INDEX `FK_course_author` (`author_id` ASC),
    INDEX `FK_course_topic` (`topic_id` ASC),
    CONSTRAINT `FK_course_author`
                      FOREIGN KEY (`author_id`)
                      REFERENCES `user` (`id`),
    CONSTRAINT `FK_course_topic`
                      FOREIGN KEY (`topic_id`)
                      REFERENCES `topic` (`id`)
);

CREATE TABLE `lecture` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `course_id` BIGINT NOT NULL,
    `sequence_number` INT NOT NULL,
    `title` VARCHAR(255) NULL DEFAULT NULL,
    `short_description` VARCHAR(255) NULL DEFAULT NULL,
    `full_description` VARCHAR(255) NULL DEFAULT NULL,
    `video_url` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_lecture_course` (`course_id` ASC),
    CONSTRAINT `FK_lecture_course`
                      FOREIGN KEY (`course_id`)
                      REFERENCES `course` (`id`),
    UNIQUE (`course_id`, `sequence_number`)
);

CREATE TABLE `assignment_solution` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `lecture_id` BIGINT NULL DEFAULT NULL,
    `student_id` BIGINT NULL DEFAULT NULL,
    `grade` INT NULL DEFAULT NULL CHECK ( `grade` >= 0 AND `grade` <= 100 ),
    `retry_flag` BIT(1) NOT NULL,
    `submission_file_path` VARCHAR(255) NULL DEFAULT NULL,
    `submission_status` ENUM('SUBMITTED', 'GRADED') NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_assignment_solution_lecture` (`lecture_id` ASC),
    INDEX `FK_assignment_solution_student` (`student_id` ASC),
    CONSTRAINT `FK_assignment_solution_lecture`
                                   FOREIGN KEY (`lecture_id`)
                                   REFERENCES `lecture` (`id`),
    CONSTRAINT `FK_assignment_solution_student`
                                   FOREIGN KEY (`student_id`)
                                   REFERENCES `user` (`id`)
);

CREATE TABLE `notification` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `user_id` BIGINT NULL DEFAULT NULL,
   `is_read` BIT(1) NOT NULL,
   `message` VARCHAR(255) NULL DEFAULT NULL,
   `related_id` BIGINT NULL DEFAULT NULL,
   `created` DATETIME(6) NULL,
   `modified` DATETIME(6) NULL,
   `type` ENUM('ROLE_CHANGED','TEACHER_ACCESS_REQUEST','TEACHER_ACCESS_REQUEST_APPROVED','TEACHER_ACCESS_REQUEST_DENIED') DEFAULT NULL,
   PRIMARY KEY (`id`)
);

CREATE TABLE `user_completed_course` (
   `course_id` BIGINT NOT NULL,
   `user_id` BIGINT NOT NULL,
   `completed_on` DATETIME(6) NULL DEFAULT NULL,
   PRIMARY KEY (`course_id`, `user_id`),
   INDEX `FK_user_completed_course` (`user_id` ASC),
   CONSTRAINT `FK_user_completed_course_user`
       FOREIGN KEY (`user_id`)
       REFERENCES `user` (`id`),
   CONSTRAINT `FK_user_completed_course_course`
       FOREIGN KEY (`course_id`)
       REFERENCES `course` (`id`)
);

CREATE TABLE `user_enrolled_course` (
   `course_id` BIGINT NOT NULL,
   `user_id` BIGINT NOT NULL,
   PRIMARY KEY (`course_id`, `user_id`),
   CONSTRAINT `FK_user_enrolled_course_user`
       FOREIGN KEY (`user_id`)
       REFERENCES `user` (`id`),
   CONSTRAINT `FK_user_enrolled_course_course`
       FOREIGN KEY (`course_id`)
       REFERENCES `course` (`id`)
);
