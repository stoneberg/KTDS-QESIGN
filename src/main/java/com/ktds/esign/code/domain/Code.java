package com.ktds.esign.code.domain;

import com.ktds.esign.common.audit.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@ToString(exclude = "groupCode")
@EqualsAndHashCode(callSuper = false, of = "codeId")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_code")
public class Code extends BaseEntity {

    @Id
    @Column(length = 20)
    private String codeId;

    @Column(length = 50, nullable = false)
    private String codeDesc;

    @Column(length = 10)
    private String displayOrder;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="group_code_id", foreignKey = @ForeignKey(name = "fk_tb_code_group_code_id"))
    private GroupCode groupCode;

}
