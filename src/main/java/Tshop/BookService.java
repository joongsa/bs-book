package Tshop;

import Tshop.Book;
import Tshop.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public String checkQuantityByBookId(String bookId) {

        Optional<Book> optionalBook = bookRepository.findById(Long.parseLong(bookId));
        Book book = optionalBook.orElseGet(Book::new);
        // 상품이 없을경우 재고0으로 전달
        if(book.getQuantity() == null) book.setQuantity(0);
        // 상품재고가 있는 경우 재고 -1 하고 할당으로 이벤트 전달
        if( book.getQuantity() > 0 ){
            book.setQuantity(book.getQuantity()-1);
            bookRepository.save(book);
            //book.pulishQuantityChecked();
        }
        return book.getQuantity().toString() ;
    }
}
