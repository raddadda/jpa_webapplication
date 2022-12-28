package jpashop.jpa_chan.domain.Item;

import jakarta.persistence.*;
import jpashop.jpa_chan.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//객체는 상속을 지원하지만, 데이터베이스에서는 상속을 지원하지 않으므로 논리 모델을 물리모델로
//구현할 방법이 필요하다.
@DiscriminatorColumn(name = "dtype")
//부모클래스에 선언한다. 하위 클래스를 구분하는 용도의 컬럼이다
@Getter
@Setter
public class Item{

    @Id @GeneratedValue
    @Column(name = "item_id")

   // @OneToMany
    //@Column(mappedBy= "order_item")
    private Long id;

    private String name;
    private int price;
    private int StockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();




}
