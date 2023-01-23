package be.bstorm.akimts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailID implements Serializable {

    private static final long serialVersionID = 1L;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;

}
