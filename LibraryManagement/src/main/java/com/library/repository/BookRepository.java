//declaring the package
package com.library.repository;

//importing the packages
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Books;

//declaring the repository interface
public interface BookRepository extends JpaRepository<Books, Integer> {
	public Books findById(int id);
}
