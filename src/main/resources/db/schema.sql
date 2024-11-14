DROP TABLE IF EXISTS `user_enrolled_course`;
DROP TABLE IF EXISTS `user_completed_course`;
DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `lecture`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `enabled`                   bit(1)       NOT NULL,
    `created`                   datetime(6)                                                         DEFAULT NULL,
    `id`                        bigint       NOT NULL AUTO_INCREMENT,
    `last_password_change_date` datetime(6)                                                         DEFAULT NULL,
    `modified`                  datetime(6)                                                         DEFAULT NULL,
    `bio`                       varchar(255)                                                        DEFAULT NULL,
    `email`                     varchar(255) NOT NULL,
    `first_name`                varchar(255)                                                        DEFAULT NULL,
    `last_name`                 varchar(255)                                                        DEFAULT NULL,
    `linked_in_profile_url`     varchar(255)                                                        DEFAULT NULL,
    `password`                  varchar(255) NOT NULL,
    `profile_image_path`        varchar(255)                                                        DEFAULT NULL,
    `role`                      enum ('ROLE_ADMIN','ROLE_ROOT_ADMIN','ROLE_STUDENT','ROLE_TEACHER') DEFAULT NULL,
    `status`                    enum ('ACTIVE','INACTIVE','PENDING_APPROVAL')                       DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
);

CREATE TABLE `course`
(
    `author_id`        bigint                                      DEFAULT NULL,
    `created`          datetime(6)                                 DEFAULT NULL,
    `id`               bigint       NOT NULL AUTO_INCREMENT,
    `modified`         datetime(6)                                 DEFAULT NULL,
    `description`      text         NOT NULL,
    `title`            varchar(255) NOT NULL,
    `difficulty_level` enum ('ADVANCED','BEGINNER','INTERMEDIATE') DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKmaatvkqyrdpwoiq3opi1obk7b` (`author_id`),
    CONSTRAINT `FKmaatvkqyrdpwoiq3opi1obk7b` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `lecture`
(
    `sequence_number`   int    NOT NULL,
    `course_id`         bigint       DEFAULT NULL,
    `id`                bigint NOT NULL AUTO_INCREMENT,
    `full_description`  varchar(255) DEFAULT NULL,
    `short_description` varchar(255) DEFAULT NULL,
    `title`             varchar(255) DEFAULT NULL,
    `video_url`         varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKjoc9yetfohpygdvx5wv385vwb` (`course_id`),
    CONSTRAINT `FKjoc9yetfohpygdvx5wv385vwb` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
);

CREATE TABLE `notification`
(
    `is_read`    bit(1) NOT NULL,
    `created`    datetime(6)                                                                                                      DEFAULT NULL,
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `related_id` bigint                                                                                                           DEFAULT NULL,
    `updated`    datetime(6)                                                                                                      DEFAULT NULL,
    `user_id`    bigint                                                                                                           DEFAULT NULL,
    `message`    varchar(255)                                                                                                     DEFAULT NULL,
    `type`       enum ('ROLE_CHANGED','TEACHER_ACCESS_REQUEST','TEACHER_ACCESS_REQUEST_APPROVED','TEACHER_ACCESS_REQUEST_DENIED') DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user_completed_course`
(
    `completed_on` datetime(6) DEFAULT NULL,
    `course_id`    bigint NOT NULL,
    `user_id`      bigint NOT NULL,
    PRIMARY KEY (`course_id`, `user_id`),
    KEY `FKmbvb4dn2xmci9gfxib0gjwted` (`user_id`),
    CONSTRAINT `FKmbvb4dn2xmci9gfxib0gjwted` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FKqylteab8dn7gy387qp1ggcx4k` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
);

CREATE TABLE `user_enrolled_course`
(
    `course_id` bigint NOT NULL,
    `user_id`   bigint NOT NULL,
    PRIMARY KEY (`course_id`, `user_id`),
    KEY `FKod3fcoehdj59ru8wctvj652t5` (`user_id`),
    CONSTRAINT `FKd53skgi4vs7v7w9le9bob10fn` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    CONSTRAINT `FKod3fcoehdj59ru8wctvj652t5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);
