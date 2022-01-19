CREATE TABLE catalog
(
    calog_id INT NOT NULL AUTO_INCREMENT,
    catalog_name VARCHAR(255),
    parent_id INT,
    good_id INT,
    PRIMARY KEY (calog_id),
    FOREIGN KEY (good_id) REFERENCES good(good_id)
 )ENGINE=INNODB;