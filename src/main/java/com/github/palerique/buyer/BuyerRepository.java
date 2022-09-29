package com.github.palerique.buyer;

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
public class BuyerRepository implements PanacheRepositoryBase<BuyerEntity, Integer> {

  public Uni<List<BuyerEntity>> listWithPaging(
      String sortBy, String orderBy, Integer page, Integer size) {
    return BuyerEntity.findAll(Sort.by(getSortBy(sortBy)).direction(getDirection(orderBy)))
        .page(getPage(page), getSize(size))
        .list();
  }

  public Uni<BuyerEntity> findByUsername(String username) {
    return find("username", username).firstResult();
  }
}
