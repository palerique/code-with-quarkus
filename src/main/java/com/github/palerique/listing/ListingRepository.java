package com.github.palerique.listing;

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
public class ListingRepository implements PanacheRepositoryBase<ListingEntity, Integer> {

  public Uni<List<ListingEntity>> listWithPaging(
      String sortBy, String orderBy, Integer page, Integer size) {
    return ListingEntity.findAll(Sort.by(getSortBy(sortBy)).direction(getDirection(orderBy)))
        .page(getPage(page), getSize(size))
        .list();
  }

  public Uni<List<ListingEntity>> getByCategoryId(Integer id) {
    return ListingEntity.find("#ListingEntity.getByCategoryId", id).list();
  }

  public Uni<List<ListingEntity>> getByVenueId(Integer id) {
    return ListingEntity.find("#ListingEntity.getByVenueId", id).list();
  }
}
