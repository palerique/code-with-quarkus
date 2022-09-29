package com.github.palerique.sale;

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
public class SaleRepository implements PanacheRepositoryBase<SaleEntity, Integer> {

  public Uni<List<SaleEntity>> listWithPaging(
      String sortBy, String orderBy, Integer page, Integer size) {
    return SaleEntity.findAll(Sort.by(getSortBy(sortBy)).direction(getDirection(orderBy)))
        .page(getPage(page), getSize(size))
        .list();
  }

  public Uni<List<SaleEntity>> getBySellerId(Integer id) {
    return SaleEntity.find("#SaleEntity.getBySellerId", id).list();
  }

  public Uni<List<SaleEntity>> getByEventId(Integer id) {
    return SaleEntity.find("#SaleEntity.getByEventId", id).list();
  }
}
