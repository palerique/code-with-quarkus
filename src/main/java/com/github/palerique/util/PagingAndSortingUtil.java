package com.github.palerique.util;

import io.quarkus.panache.common.Sort.Direction;
import java.util.Objects;

public class PagingAndSortingUtil {

  public static final String DESC = "desc";
  public static final String ID = "id";

  public static Direction getDirection(String orderBy) {
    Direction direction = Direction.Ascending;
    if (Objects.equals(orderBy, DESC)) {
      direction = Direction.Descending;
    }
    return direction;
  }

  public static String getSortBy(String sortBy) {
    if (sortBy == null) {
      sortBy = ID;
    }
    return sortBy;
  }

  public static Integer getSize(Integer size) {
    if (size < 1) {
      size = 5;
    }
    return size;
  }

  public static Integer getPage(Integer page) {
    if (page < 1) {
      page = 1;
    }
    page = page - 1; // zero-based
    return page;
  }
}
