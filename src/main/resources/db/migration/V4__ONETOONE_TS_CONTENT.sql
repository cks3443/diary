ALTER TABLE content
    ADD translate_sentence_id BIGINT;

ALTER TABLE content
    ADD CONSTRAINT FK_CONTENT_ON_TRANSLATESENTENCE FOREIGN KEY (translate_sentence_id) REFERENCES translatesentence (id);