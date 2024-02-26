package com.learn.rest.webservices.restfulwebservices.repository;

import com.learn.rest.webservices.restfulwebservices.user.Post;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
