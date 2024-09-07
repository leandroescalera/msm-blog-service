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
@Table(name = "blog_history")
public class BlogHistoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "content_above")
  private String contentAbove;
  @Basic
  @Column(name = "update_date")
  private Date updateDate;
  @Basic
  @Column(name = "allow_comments")
  private String allowComments;
  @ManyToOne
  @JoinColumn(name = "blog_id")
  private BlogEntity blogId;
  @ManyToOne
  @JoinColumn(name = "author_id")
  private AuthorEntity authorId;

}