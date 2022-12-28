package jpashop.jpa_chan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;


    @OneToOne(mappedBy= "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    //각 Enum에 대응되는 상태 저장
    private DeliveryStatus status; //READY, COMP
}
