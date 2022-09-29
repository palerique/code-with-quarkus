package com.github.palerique.buyer;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buyer", schema = "public", catalog = "tickit")
public class BuyerEntity extends PanacheEntityBase {

  @Id
  @SequenceGenerator(
      name = "buyerSeq",
      sequenceName = "buyer_buyer_id_seq",
      schema = "public",
      initialValue = 50000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyerSeq")
  @Column(name = "buyerid", nullable = false)
  public int id;

  @Column(name = "username", nullable = false, length = 8)
  public String username;

  @Column(name = "firstname", nullable = false, length = 30)
  public String firstName;

  @Column(name = "lastname", nullable = false, length = 30)
  public String lastName;

  @Column(name = "city", nullable = false, length = 30)
  public String city;

  @Column(name = "state", nullable = false, length = 2)
  public String state;

  @Column(name = "email", nullable = false, length = 100)
  public String email;

  @Column(name = "phone", nullable = false, length = 14)
  public String phone;

  @Column(name = "likesports", nullable = false)
  public boolean likeSports = false;

  @Column(name = "liketheatre", nullable = false)
  public boolean likeTheatre = false;

  @Column(name = "likeconcerts", nullable = false)
  public boolean likeConcerts = false;

  @Column(name = "likejazz", nullable = false)
  public boolean likeJazz = false;

  @Column(name = "likeclassical", nullable = false)
  public boolean likeClassical = false;

  @Column(name = "likeopera", nullable = false)
  public boolean likeOpera;

  @Column(name = "likerock", nullable = false)
  public boolean likeRock = false;

  @Column(name = "likevegas", nullable = false)
  public boolean likeVegas = false;

  @Column(name = "likebroadway", nullable = false)
  public boolean likeBroadway = false;

  @Column(name = "likemusicals", nullable = false)
  public boolean likeMusicals = false;
}
