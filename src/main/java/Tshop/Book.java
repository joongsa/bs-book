package Tshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Book")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private Integer quantity;

    @PostUpdate
    public void pulishQuantityChecked(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }

/*    @PrePersist
    public void onPrePersist(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }*/

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}
