package bo.com.bancobisa.msas.blog.entities;



import lombok.Data;

import javax.persistence.JoinColumn;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author leandro.escalera
 */
@Data
@Entity
@Table(name = "comment")
public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "names_", length = 150)
  private String names;
  @Basic
  @Column(name = "mail", length = 250)
  private String mail;
  @Basic
  @Column(name = "country_residence", length = 100)
  private String countryResidence;
  @Basic
  @Column(name = "content", length = 250)
  private String content;
  @Basic
  @Column(name = "score")
  private Integer score;
  @Basic
  @Column(name = "creation_date")
  private Date creationDate;
  @ManyToOne
  @JoinColumn(name = "blog_id")
  private BlogEntity blogId;

}