package com.github.palerique.category;

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
@Table(name = "category", schema = "public", catalog = "tickit")
public class CategoryEntity extends PanacheEntityBase {

  @Id
  @SequenceGenerator(
      name = "categorySeq",
      sequenceName = "category_cat_id_seq",
      schema = "public",
      initialValue = 15,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
  @Column(name = "catid", nullable = false)
  public int id;

  @Column(name = "catgroup", nullable = false, length = 10)
  public String group;

  @Column(name = "catname", nullable = false, length = 10)
  public String name;

  @Column(name = "catdesc", nullable = false, length = 50)
  public String description;
}
