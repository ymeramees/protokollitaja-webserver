package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Competitor {

	private String id;
	private String firstName;
	private String lastName;
	private String birthYear;	// birth year is not given out to avoid any legal issues and save space for mobile view of results table
	private String club;
	private Series[] series;
	private String totalResult;
	private String innerTens;
	private String finals;
	private String remarks;
	
	public Competitor() {}
	
	public String getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id.toString();
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
	public Series[] getSeries() {
		return series;
	}
	public void setSeries(Series[] series) {
		this.series = series;
	}
	
	public String getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(String result) {
		this.totalResult = result;
	}
	
	public String getInnerTens() {
		return innerTens;
	}
	public void setInnerTens(String innerTens) {
		this.innerTens = innerTens;
	}
	
	public String getFinals() {
		return finals;
	}
	public void setFinals(String finals) {
		this.finals = finals;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
}
