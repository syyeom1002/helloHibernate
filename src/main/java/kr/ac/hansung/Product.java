package kr.ac.hansung;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity//entitiy class->table
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="product_id")
    private int id;

    private String name;
    private int price;
    private String Description;
}
