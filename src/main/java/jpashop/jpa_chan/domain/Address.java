package jpashop.jpa_chan.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
//@Setter를 제거하고 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자.

@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
//엔티티나 임베디드 타입은 자바 기본생성자를 public 또는 protected로 설정해야 한다.
    protected Address(){

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
