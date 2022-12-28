package jpashop.jpa_chan.domain.Item;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
//하위클래스에 선언한다.
@Getter
@Setter
//상속의 대표적인 형태다.
//부모의 메소드를 그대로 사용할 수 있으며 오버라이딩 할 필요없이 부모에 구현되어있는 것을 직접 사용가능하다.
public class Album extends Item{
    private String artist;
    private String etc;
}
