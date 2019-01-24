package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

public class CompetitionHeader {

	private String id;
	private String competitionName;
	private String timeAndPlace;
	
	public CompetitionHeader() {
		// TODO Auto-generated constructor stub
	}
	
	public CompetitionHeader(String id, String name, String timeAndPlace) {
		this.id = id;
		this.competitionName = name;
		this.timeAndPlace = timeAndPlace;
	}

	public String getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id.toString();
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getTimeAndPlace() {
		return timeAndPlace;
	}

	public void setTimeAndPlace(String timeAndPlace) {
		this.timeAndPlace = timeAndPlace;
	}
}
