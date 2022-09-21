ALTER TABLE content
    ADD custom_answer VARCHAR(500);

ALTER TABLE content
    ALTER COLUMN custom_answer SET NOT NULL;