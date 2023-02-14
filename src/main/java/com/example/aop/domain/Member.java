package com.example.aop.domain;

import com.example.aop.dto.MemberModifyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String name;
    private Integer postCount;
    private Integer point;
    private short grade;

    @PrePersist
    void prePersist(){
        this.grade = 0;
    }

    @PreUpdate
    void preUpdate(){

        if (this.point <= 10){
            this.grade = 1;
        } else if (this.point <= 40) {
            this.grade = 2;
        } else if (this.point <= 60) {
            this.grade = 3;
        }
    }

    public void changeCountUp() {
        this.postCount++;
    }

    public void changePoint(int i) {
        this.point += i;
    }

    public void changeCountDown() {
        this.postCount--;
    }

    public void changeInfo(MemberModifyDto modifyDto) {
        this.name = modifyDto.getName();
    }
}
