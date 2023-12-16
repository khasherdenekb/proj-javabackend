package com.blogweb.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogweb.backendjava.models.BlogModel;

public interface BlogRepository extends JpaRepository<BlogModel, Long> {

}
