package com.example.asginment.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "districts")
public class District {
    @Id
    private String id;
    private String name;
//    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Set<Street> streetSet;
    @CreationTimestamp
    private Date createdAt;
}
