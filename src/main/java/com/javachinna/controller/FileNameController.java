package com.javachinna.controller;

import com.javachinna.model.FileName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class FileNameController {
	
	@Autowired
	com.javachinna.repo.FileNameRepository fileNameRepository;

	@GetMapping("/getAllFileNames")
	public List<FileName> getAllFileNames()
	{
		return fileNameRepository.findAll();
	}
	
	@GetMapping("/getFileNameById/{id}")
	public Optional<FileName> getFileNameById(@PathVariable(value="id") Long id)
	{
		return fileNameRepository.findById(id);
	}

	@PostMapping("/addFileName")
	public FileName addFileName(@RequestBody FileName fileName)
	{
		return fileNameRepository.save(fileName);
	}

//	@PutMapping("/updateBook/{id}")
//	public Book updateBook(@PathVariable(value="id") Long id, @RequestBody Book bookDetails)
//	{
//		Optional<Book> book = bookRepository.findById(id);
//		Book book_new=book.get();
//		book_new.setAuthor_name(bookDetails.getAuthor_name());
//		book_new.setBook_name(bookDetails.getBook_name());
//		book_new.setIsbn(bookDetails.getIsbn());
//		return bookRepository.save(book_new);
//
//	}
	
	@DeleteMapping("/deleteFileName/{id}")
	public void deleteFileName(@PathVariable(value="id") Long id)
	{
		Optional<FileName> fileName=fileNameRepository.findById(id);
		FileName fileName_new=fileName.get();
		fileNameRepository.delete(fileName_new);
	}
	

}
