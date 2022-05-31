package com.maiyeuem.hellospring.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String note;
    private LocalDateTime dob;
    private int status;
}
