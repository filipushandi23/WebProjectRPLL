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
 * Seat generated by hbm2java
 */
@Entity
@Table(name = "seat", catalog = "threadther"
)
public class Seat implements java.io.Serializable {

    private SeatId id;
    private Studio studio;

    public Seat() {
    }

    public Seat(SeatId id, Studio studio) {
        this.id = id;
        this.studio = studio;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "seatPosition", column = @Column(name = "seat_position", nullable = false, length = 5)),
        @AttributeOverride(name = "studioNumber", column = @Column(name = "studio_number", nullable = false))})
    public SeatId getId() {
        return this.id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_number", nullable = false, insertable = false, updatable = false)
    public Studio getStudio() {
        return this.studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

}
