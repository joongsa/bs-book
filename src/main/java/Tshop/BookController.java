package Tshop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService postsService;
    @GetMapping("/books/check")
    public String bookCheck(@RequestParam String bookId){
        return postsService.checkQuantityByBookId(bookId);
    }

}
