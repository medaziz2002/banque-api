package com.cloudmonstertunisia.banqueapi.exception;

import lombok.NoArgsConstructor;

public class OperationNonPermittedException extends RuntimeException {

  public OperationNonPermittedException(String message) {
    super(message);
  }
}
