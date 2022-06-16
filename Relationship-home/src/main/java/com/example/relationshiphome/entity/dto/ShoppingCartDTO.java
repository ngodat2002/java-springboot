package com.example.relationshiphome.entity.dto;
import com.example.relationshiphome.entity.CartItem;
import com.example.relationshiphome.entity.ShoppingCart;
import lombok.*;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDTO {
    private String id;
    private String userId;
    private BigDecimal totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private Set<CartItemDTO> items;
    public ShoppingCart generateCart(){
        return new ShoppingCart();
    }
}
