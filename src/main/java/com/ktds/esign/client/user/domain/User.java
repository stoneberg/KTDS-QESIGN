package com.ktds.esign.client.user.domain;

import com.ktds.esign.common.audit.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "roles")
@EqualsAndHashCode(callSuper = false, of = {"id", "empNo", "email"})
@NoArgsConstructor
@Entity
@Table(name = "tb_user",
        uniqueConstraints =
        @UniqueConstraint(name = "tb_user_unique", columnNames = {"empNo", "email"})
)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String empNo;

    @Column(length = 75, nullable = false)
    private String empName;

    @Column(length = 75)
    private String email;

    @Column(length = 75)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmpn_id", foreignKey = @ForeignKey(name = "fk_tb_company"))
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "fk_tb_department"))
    private Department department;

    @Column(length = 75)
    private String positionId;

    @Column(length = 75)
    private String positionName;

    // 서명 이미지 저장 경로
    @Column(length = 100)
    private String signFilePath;

    // 서명 이미지 이름
    @Column(length = 40)
    private String signFileName;

    // 협력사 여부
    @Column(columnDefinition = "boolean default false", nullable = false)
    private String partnerYn;

    // 삭제 여부
    @Column(columnDefinition = "boolean default false", nullable = false)
    private String deleteYn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_tb_user")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_tb_role")),
            foreignKey = @ForeignKey(name = "fk_tb_user"),
            inverseForeignKey = @ForeignKey(name = "fk_tb_role")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_notification",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_tb_user")),
            inverseJoinColumns = @JoinColumn(name = "notification_id", foreignKey = @ForeignKey(name = "fk_tb_notification")),
            foreignKey = @ForeignKey(name = "fk_tb_user"),
            inverseForeignKey = @ForeignKey(name = "fk_tb_notification")
    )
    private Set<Notification> notifications = new HashSet<>();

}
