package com.github.palerique.category;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

  @Inject CategoryRepository categoryRepository;

  @GET
  public Uni<List<CategoryEntity>> list(
      @QueryParam("sort_by") String sortBy,
      @QueryParam("order_by") String orderBy,
      @QueryParam("page") int page,
      @QueryParam("size") int size) {

    return categoryRepository.listWithPaging(sortBy, orderBy, page, size);
  }

  @GET
  @Path("{id}")
  public Uni<CategoryEntity> get(Integer id) {

    return CategoryEntity.findById(id);
  }

  @POST
  @ResponseStatus(201)
  @ReactiveTransactional
  public Uni<CategoryEntity> create(CategoryEntity category) {

    return CategoryEntity.persist(category).replaceWith(category);
  }

  @PUT
  @ReactiveTransactional
  @Path("{id}")
  public Uni<CategoryEntity> update(Integer id, CategoryEntity category) {

    return CategoryEntity.<CategoryEntity>findById(id)
        .onItem()
        .ifNotNull()
        .invoke(
            entity -> {
              entity.group = category.group;
              entity.name = category.name;
              entity.description = category.description;
            });
  }

  @DELETE
  @ReactiveTransactional
  @Path("{id}")
  public Uni<Void> delete(Integer id) {

    return CategoryEntity.deleteById(id).replaceWithVoid();
  }

  @GET
  @Path("/count")
  public Uni<Long> count() {

    return CategoryEntity.count();
  }
}
