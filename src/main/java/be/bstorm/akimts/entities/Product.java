package be.bstorm.akimts.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity_per_unit")
    private String qttPerUnit;

    @Column(name = "units_in_stock")
    private int stock;

    @Column(name = "units_on_order")
    private int onOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    private int discontinued;

}
