package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "competitions")
public class Competition {
	
	//@Id ObjectId databaseId;
	private String id;
	private String competitionName;
	private String timeAndPlace;
	private Event[] events;
	
	public Competition() {
		// TODO Auto-generated constructor stub
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
	public Event[] getEvents() {
		return events;
	}
	public void setEvents(Event[] events) {
		this.events = events;
	}
}
