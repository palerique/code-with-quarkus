package com.github.palerique.event;

import com.github.palerique.category.CategoryEntity;
import com.github.palerique.venue.VenueEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event", schema = "public", catalog = "tickit")
public class EventEntity extends PanacheEntityBase {

  @Id
  @SequenceGenerator(
      name = "eventSeq",
      sequenceName = "event_event_id_seq",
      schema = "public",
      initialValue = 10000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventSeq")
  @Column(name = "eventid", nullable = false)
  public int id;

  @Column(name = "eventname", nullable = false, length = 200)
  public String name;

  @Column(name = "starttime", nullable = false)
  public LocalDateTime startTime;

  @ManyToOne(optional = false)
  @JoinColumn(name = "venueid", referencedColumnName = "venueid", nullable = false)
  public VenueEntity venue;

  @ManyToOne(optional = false)
  @JoinColumn(name = "catid", referencedColumnName = "catid", nullable = false)
  public CategoryEntity category;
}
