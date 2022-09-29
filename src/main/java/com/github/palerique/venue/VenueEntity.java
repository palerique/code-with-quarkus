package com.github.palerique.venue;

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
@Table(name = "venue", schema = "public", catalog = "tickit")
public class VenueEntity extends PanacheEntityBase {

  @Id
  @SequenceGenerator(
      name = "venueSeq",
      sequenceName = "venue_venue_id_seq",
      schema = "public",
      initialValue = 350,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venueSeq")
  @Column(name = "venueid", nullable = false)
  public int id;

  @Column(name = "venuename", nullable = false, length = 100)
  public String name;

  @Column(name = "venuecity", nullable = false, length = 30)
  public String city;

  @Column(name = "venuestate", nullable = false, length = 2)
  public String state;

  @Column(name = "venueseats", nullable = false)
  public int seats;
}
