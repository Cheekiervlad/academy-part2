CREATE TABLE IF NOT EXISTS project_news_test.user_role (
  u_role_id INT NOT NULL,
  u_role_name VARCHAR(10) NOT NULL,
  PRIMARY KEY (u_role_id)); 

CREATE TABLE IF NOT EXISTS project_news_test.user (
  u_id INT NOT NULL AUTO_INCREMENT,
  u_login VARCHAR(20) NOT NULL,
  u_password VARCHAR(64) NOT NULL,
  u_email VARCHAR(45) NOT NULL,
  u_role INT NOT NULL,
  PRIMARY KEY (u_id),
  FOREIGN KEY (u_role) REFERENCES project_news_test.user_role (u_role_id) ON DELETE RESTRICT); 

CREATE TABLE IF NOT EXISTS project_news_test.news_category (
  n_category_id INT NOT NULL,
  n_category_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (n_category_id)); 

CREATE TABLE IF NOT EXISTS project_news_test.news_status (
  n_status_id INT NOT NULL,
  n_status_name VARCHAR(15) NOT NULL,
  PRIMARY KEY (n_status_id)); 

CREATE TABLE IF NOT EXISTS project_news_test.news (
  n_id INT NOT NULL AUTO_INCREMENT,
  n_category INT NOT NULL,
  n_title VARCHAR(60) NOT NULL,
  n_brief VARCHAR(200) NOT NULL,
  n_content VARCHAR(20000) NOT NULL,
  n_date TIMESTAMP NOT NULL,
  n_author INT NOT NULL,
  n_status INT NOT NULL,
  PRIMARY KEY (n_id),
  FOREIGN KEY (n_author) REFERENCES project_news_test.user (u_id) ON DELETE RESTRICT,
  FOREIGN KEY (n_category) REFERENCES project_news_test.news_category (n_category_id) ON DELETE RESTRICT,
  FOREIGN KEY (n_status) REFERENCES project_news_test.news_status (n_status_id))