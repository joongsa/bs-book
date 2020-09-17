package Tshop;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

    //Optional<Book> findByBookId(Long bookId);
}