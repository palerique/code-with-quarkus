package com.github.palerique.venue;

import static com.github.palerique.util.PagingAndSortingUtil.getDirection;
import static com.github.palerique.util.PagingAndSortingUtil.getPage;
import static com.github.palerique.util.PagingAndSortingUtil.getSize;
import static com.github.palerique.util.PagingAndSortingUtil.getSortBy;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VenueRepository implements PanacheRepositoryBase<VenueEntity, Integer> {

  public Uni<List<VenueEntity>> listWithPaging(
      String sortBy, String orderBy, Integer page, Integer size) {
    return VenueEntity.findAll(Sort.by(getSortBy(sortBy)).direction(getDirection(orderBy)))
        .page(getPage(page), getSize(size))
        .list();
  }
}
