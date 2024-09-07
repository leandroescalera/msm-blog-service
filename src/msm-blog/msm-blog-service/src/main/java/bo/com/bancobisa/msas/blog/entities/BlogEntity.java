package bo.com.bancobisa.msas.blog.entities;

import lombok.Data;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author leandro.escalera
 */
@Data
@Entity
@Table(name = "blog")
public class BlogEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "title", length = 200)
  private String title;
  @Basic
  @Column(name = "thema", length = 200)
  private String theme;
  @Basic
  @Column(name = "content", length = 200)
  private String content;
  @Basic
  @Column(name = "periodicity", length = 200)
  private String periodicity;
  @Basic
  @Column(name = "allow_comments")
  private Boolean allowComments;
  @Basic
  @Column(name = "creation_date")
  private Date creationDate;
  @Basic
  @Column(name = "update_date")
  private Date updateDate;
  @ManyToOne
  @JoinColumn(name = "author_id")
  private AuthorEntity authorId;

}