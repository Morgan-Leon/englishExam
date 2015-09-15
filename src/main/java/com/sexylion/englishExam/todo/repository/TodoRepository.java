package com.sexylion.englishExam.todo.repository;

import com.sexylion.englishExam.todo.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Petri Kainulainen
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
