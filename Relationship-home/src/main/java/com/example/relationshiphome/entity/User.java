package com.example.relationshiphome.entity;

import com.example.relationshiphome.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity

@Table(name = "users")
public class User extends BaseEntity {
    @Id
    private String id;
    private String fullName;
    private String address;
    private String phone;
}
