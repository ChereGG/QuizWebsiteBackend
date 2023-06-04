CREATE TABLE `user` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`password_hash` VARCHAR(255) NOT NULL,
	`is_admin` BOOLEAN NOT NULL
);

CREATE TABLE `quiz` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`theory` MEDIUMTEXT NOT NULL
);

CREATE TABLE `question` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`quiz_id` BIGINT NOT NULL,
	`statement` TEXT NOT NULL,
    CONSTRAINT FK_QuestionQuiz FOREIGN KEY (`quiz_id`)
    REFERENCES `Quiz`(`id`)
);

CREATE TABLE `answer` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`statement` TEXT NOT NULL,
	`display_order` INT NOT NULL,
	`is_correct` BOOLEAN NOT NULL,
	`question_id` BIGINT NOT NULL,
	CONSTRAINT FK_AnswerQuestion FOREIGN KEY (`question_id`)
    REFERENCES `Question`(`id`)
);

CREATE TABLE `user_quiz_solution` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`quiz_id` BIGINT NOT NULL,
	`score` INT NOT NULL,
	`total` INT NOT NULL,
	CONSTRAINT FK_SolutionQuiz FOREIGN KEY (`quiz_id`)
    REFERENCES `Quiz`(`id`),
	CONSTRAINT FK_SolutionUser FOREIGN KEY (`user_id`)
    REFERENCES `User`(`id`)
);






