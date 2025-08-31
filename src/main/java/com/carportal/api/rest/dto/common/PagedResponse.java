package com.carportal.api.rest.dto.common;

import java.util.List;
import org.springframework.data.domain.Page;

public record PagedResponse<T>(
    List<T> data,
    PaginationMeta pagination
) {

  public static <T> PagedResponse<T> fromPage(Page<T> page) {
    return new PagedResponse<>(
        page.getContent(),
        new PaginationMeta(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.getSort().toString()
        )
    );
  }

  public record PaginationMeta(
      int page,
      int size,
      long totalElements,
      int totalPages,
      String sort
  ) {

  }
}
