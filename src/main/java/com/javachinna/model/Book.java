package com.javachinna.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {
	@Id
	private Long id;
	@Column
	private String book_name;
	@Column
	private String author_name;
	@Column
	private String isbn;
//	@OneToMany(mappedBy = "shelf_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<ShelfVsBook> shelfVsBooks;
}
