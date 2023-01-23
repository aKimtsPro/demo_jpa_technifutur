package be.bstorm.akimts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer_demographics")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demographics {

    @Id
    @Column(name = "customer_type_id")
    private String id;

    @Column(name = "customer_desc")
    private String desc;

    @ManyToMany(mappedBy = "types")
    private List<Customer> customers;

}
