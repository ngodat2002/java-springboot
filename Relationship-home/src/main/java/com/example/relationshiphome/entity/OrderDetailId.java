package com.example.relationshiphome.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "order_id", nullable = false)
    private String orderId;
    @Column(name = "product_id", nullable = false)
    private String productId;
}
