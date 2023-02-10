/////////////////////////////////
//
//
//
/////////////////////////////////
package dz.ich.jubaII.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author L KHERBICHE
 *
 */
@Table(name="TYPEMEDIA") 
@Entity
public class TypeMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	private String media;
	
	public TypeMedia() {}

	public long getId() {
		return id;
	}
	public String getMedia() {
		return media;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setMedia(String media) {
		this.media = media;
	}
}
