package com.github.palerique.buyer;

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

@Path("buyers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BuyerResource {

  @Inject BuyerRepository buyerRepository;

  @GET
  public Uni<List<BuyerEntity>> list(
      @QueryParam("sort_by") String sortBy,
      @QueryParam("order_by") String orderBy,
      @QueryParam("page") int page,
      @QueryParam("size") int size) {

    return buyerRepository.listWithPaging(sortBy, orderBy, page, size);
  }

  @GET
  @Path("{id}")
  public Uni<BuyerEntity> get(Integer id) {

    return BuyerEntity.findById(id);
  }

  @POST
  @ResponseStatus(201)
  @ReactiveTransactional
  public Uni<BuyerEntity> create(BuyerEntity buyer) {

    return BuyerEntity.persist(buyer).replaceWith(buyer);
  }

  @PUT
  @Path("{id}")
  @ReactiveTransactional
  public Uni<BuyerEntity> update(Integer id, BuyerEntity buyer) {

    return BuyerEntity.<BuyerEntity>findById(id)
        .onItem()
        .ifNotNull()
        .invoke(
            entity -> {
              entity.username = buyer.username;
              entity.firstName = buyer.firstName;
              entity.lastName = buyer.lastName;
              entity.city = buyer.city;
              entity.state = buyer.state;
              entity.email = buyer.email;
              entity.phone = buyer.phone;
              entity.likeSports = buyer.likeSports;
              entity.likeTheatre = buyer.likeTheatre;
              entity.likeConcerts = buyer.likeConcerts;
              entity.likeJazz = buyer.likeJazz;
              entity.likeClassical = buyer.likeClassical;
              entity.likeOpera = buyer.likeOpera;
              entity.likeRock = buyer.likeRock;
              entity.likeVegas = buyer.likeVegas;
              entity.likeBroadway = buyer.likeBroadway;
              entity.likeMusicals = buyer.likeMusicals;
            });
  }

  @DELETE
  @Path("{id}")
  @ReactiveTransactional
  public Uni<Void> delete(Integer id) {

    return BuyerEntity.deleteById(id).replaceWithVoid();
  }

  @GET
  @Path("/username/{username}")
  public Uni<List<BuyerEntity>> getByUsername(String username) {

    return BuyerEntity.list("username", username);
  }

  @GET
  @Path("/count")
  public Uni<Long> count() {

    return BuyerEntity.count();
  }
}
