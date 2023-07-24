package com.example.account.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)	// @CreatedDate 와 @LastModifiedDate 작동하게 해줌, 사용하려면 config쪽에 넣어줘야함
public class AccountUser extends BaseEntity {
	private String name;
}
