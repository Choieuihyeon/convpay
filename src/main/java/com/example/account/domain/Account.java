package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)	// @CreatedDate 와 @LastModifiedDate 작동하게 해줌
public class Account extends BaseEntity {

	@ManyToOne
	private AccountUser accountUser;
	private String accountNumber;

	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	private Long balance;

	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;

	/**
	 * 금액을 변경하는 로직은 위험한 로직이기 때문에 Entity 안에서 만들어줘서 해결하는게 안전함
	 */
	public void useBalance(Long amount) {
		if (amount > balance) {
			throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
		}
		balance -= amount;
	}

	public void cancelBalance(Long amount) {
		if (amount < 0) {
			throw new AccountException(ErrorCode.INVALID_REQUEST);
		}
		balance += amount;
	}


}
