package com.mococo.core.account.vo;

import com.mococo.core.common.constants.ErrorCode;
import com.mococo.core.common.exception.BusinessException;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Access(AccessType.FIELD)
public class Address {

     @NotNull
     @Size(max = 50)
     @Column(name = "roadNameAddress", nullable = false, unique = true)
     private String value;

     public static Address create(String value) {
          if (StringUtils.isBlank(value)) {
               throw new BusinessException(ErrorCode.INVALID_ADDRESS_EXCEPTION);
          }

          final Address address = new Address();
          address.value = value;
          return address;
     }

}
