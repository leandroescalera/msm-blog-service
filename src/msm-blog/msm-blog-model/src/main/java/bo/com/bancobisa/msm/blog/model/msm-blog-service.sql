USE bd_blog

CREATE TABLE author (
    id BIGINT IDENTITY NOT NULL,
    names_ VARCHAR(150),
    first_surname VARCHAR(150),
    second_surname VARCHAR(150),
    birth_date DATETIME,
    country_residence VARCHAR(100),
    mail VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE comment (
    id BIGINT IDENTITY NOT NULL,
    names_ VARCHAR(150),
    mail VARCHAR(250),
    country_residence VARCHAR(100),
    content VARCHAR(250),
    score VARCHAR(50),
    creation_date DATETIME,
    blog_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE blog_history (
    id BIGINT IDENTITY NOT NULL,
    content_above VARCHAR,
    update_date DATETIME,
    allow_comments VARCHAR,
    author_id BIGINT,
    blog_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE blog (
    id BIGINT IDENTITY NOT NULL,
    title VARCHAR(200),
    thema VARCHAR(200),
    content VARCHAR(200),
    periodicity VARCHAR(200),
    allow_comments BIT,
    creation_date DATETIME,
    update_date DATETIME,
    author_id BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE comment
ADD CONSTRAINT FK_comment_blog_id FOREIGN KEY (blog_id) REFERENCES blog (id);
ALTER TABLE blog_history
ADD CONSTRAINT FK_blog_history_blog_id FOREIGN KEY (blog_id) REFERENCES blog (id);
ALTER TABLE blog_history
ADD CONSTRAINT FK_blog_history_author_id FOREIGN KEY (author_id) REFERENCES author (id);
ALTER TABLE blog
ADD CONSTRAINT FK_blog_author_id FOREIGN KEY (author_id) REFERENCES author (id);
