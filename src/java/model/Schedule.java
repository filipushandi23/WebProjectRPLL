package model;
// Generated Mar 17, 2018 3:43:56 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Schedule generated by hbm2java
 */
@Entity
@Table(name="schedule"
    ,catalog="threadther"
)
public class Schedule  implements java.io.Serializable {


     private ScheduleId id;
     private Movie movie;
     private Studio studio;
     private Integer price;

    public Schedule() {
    }

	
    public Schedule(ScheduleId id, Studio studio) {
        this.id = id;
        this.studio = studio;
    }
    public Schedule(ScheduleId id, Movie movie, Studio studio, Integer price) {
       this.id = id;
       this.movie = movie;
       this.studio = studio;
       this.price = price;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="movieStart", column=@Column(name="movie_start", nullable=false, length=19) ), 
        @AttributeOverride(name="studioNumber", column=@Column(name="studio_number", nullable=false) ) } )
    public ScheduleId getId() {
        return this.id;
    }
    
    public void setId(ScheduleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return this.movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="studio_number", nullable=false, insertable=false, updatable=false)
    public Studio getStudio() {
        return this.studio;
    }
    
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    
    @Column(name="price")
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }




}


