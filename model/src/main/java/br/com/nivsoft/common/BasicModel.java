package br.com.nivsoft.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta classe representa o objeto base de todos os outros objetos da
 * <a href="nivsoft.com">NivSoft</a>. Todo objeto entidade deve herdar os
 * atributos desta classe, mantendo sempre o padrão no ID, Data de criação,
 * Status de atividade, e Data de alteração. As Classes que herdarem deste
 * objeto não deverá implementar os métodos Hash, equals e get e set dos
 * atributos pai.
 * 
 * @author <a href="https://github.com/viniciosarodrigues">vinicios</a>
 * @since 11/07/2017
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BasicModel implements Serializable {

	private static final long serialVersionUID = -3643733244360910748L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DT_CREATION")
	@XmlElement
	private Date dhCreation;

	@Column(name = "ACTIVE")
	@XmlElement
	private Integer active;

	@Column(name = "DT_LAST_UPDATE")
	@XmlElement
	private Date lastUpdate;

	public BasicModel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDhCreation() {
		return dhCreation;
	}

	public void setDhCreation(Date dhCreation) {
		this.dhCreation = dhCreation;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BasicModel [id=" + id + ", dhCreation=" + dhCreation + ", active=" + active + ", lastUpdate="
				+ lastUpdate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicModel other = (BasicModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
