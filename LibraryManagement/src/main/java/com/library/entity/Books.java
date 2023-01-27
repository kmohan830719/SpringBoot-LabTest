//declaring the package
package com.library.entity;

//importing the package
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//declaring the entity class
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boook_id;
	private String title;
	private String auther;
	private int pages;
	private int price;

}
