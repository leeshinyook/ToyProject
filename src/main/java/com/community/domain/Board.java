package com.community.domain;

import com.community.domain.enums.BoardType;
import com.community.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable; // 직렬화
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임한다., auto_increment
    private Long idx;

    @Column(name = "title")
    private String title;

    @Column(name = "subTitle")
    private String subTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "boardType")
    @Enumerated(EnumType.STRING) // enum의 이름을 디비에 저장
    private BoardType boardType;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.user = user;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
