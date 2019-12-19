CREATE TABLE
    user (
        id  VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        role VARCHAR(255) NOT NULL,
        created_at DATETIME DEFAULT NOW(),
        created_by VARCHAR(255) NOT NULL,
        updated_at DATETIME,
        updated_by VARCHAR(255),
        PRIMARY KEY (id)
    );

ALTER TABLE 
    user
    ADD CONSTRAINT UKob8kqyqqgmefl0aco34akdtpe UNIQUE(email);
