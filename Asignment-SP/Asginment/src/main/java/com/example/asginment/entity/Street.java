package com.example.asginment.entity;
import com.example.asginment.entity.enums.StreetSimpleStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "streets")
public class Street {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name ="district_id",updatable = false,insertable = false)
    private District district;
    private String name;
    @CreationTimestamp
    private Date createdAt;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private StreetSimpleStatus status;
}
