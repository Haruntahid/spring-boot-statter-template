package com.example.practice.utils.commons;

import org.springframework.http.ResponseEntity;

public interface CrudController<D> {
    public ResponseEntity<?> create(D dto);

    public ResponseEntity<?> update(Long id, D dto);

    public ResponseEntity<?> delete(Long id);

    public ResponseEntity<?> find(Long id);
}
